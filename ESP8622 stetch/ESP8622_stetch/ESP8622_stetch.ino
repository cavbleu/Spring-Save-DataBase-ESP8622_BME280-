#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

#include <Wire.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>

const char* ssid = "YOUR_WIFI";
const char* password = "YOUR_PASSWORD";

const char* serverName = "http://YOUR_SERVER:8189/saveDataSensor";

Adafruit_BME280 bme;
float temperature;
float humidity;
float pressure;
String jsonRequestData;

int cnt=10*60;//Timer for count seconds

void setup() {
  Serial.begin(115200);
  
  if (!bme.begin(0x76)) {
    Serial.println("Could not find a valid BME280 sensor, check wiring!");
    while (1);
  }  
  
  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());
  sendDB();
  Serial.println("Timer set to 1 minute (timerDelay variable), it will take 1 minute before publishing the first reading.");
}

void sendDB()
{
  temperature = bme.readTemperature();
    humidity = bme.readHumidity();
    pressure = bme.readPressure()/100.0F;

    //Check WiFi connection status
    if(WiFi.status()== WL_CONNECTED){
      WiFiClient client;
      HTTPClient http;
      
      // Your Domain name with URL path or IP address with path
      http.begin(client, serverName);

      http.addHeader("Content-Type", "application/json");
      jsonRequestData = "{\"idsen\":\"";
      jsonRequestData += "1";
      jsonRequestData += "\",\"temperature\":\"";
      jsonRequestData += String(temperature, 2);
      jsonRequestData += "\",\"humidity\":\"";
      jsonRequestData += String(humidity,2);
      jsonRequestData += "\",\"pressure\":\"";
      jsonRequestData += String(pressure,2);
      jsonRequestData += "\",\"co\":\"";
      jsonRequestData += "0\"}";
      int httpResponseCode = http.POST(jsonRequestData);
     
      Serial.print("HTTP Response code: ");
      Serial.println(httpResponseCode);
        
      // Free resources
      http.end();
      jsonRequestData = "";
    }
    else {
      Serial.println("WiFi Disconnected");
    }
}

void loop() {
      Serial.println(cnt);
 
  if(cnt==0){
    Serial.println("Reset..");
    ESP.restart();
  }
 
  cnt--;
  delay(1000);
}
