#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266WebServer.h>
#include <ESP8266mDNS.h>

const char* ssid = "Kowula";
const char* password = "n1ckname";

ESP8266WebServer server(80);


const int pin1 = LED_BUILTIN;
boolean state = 0;
void handleRoot() {
 
  server.send(200, "text/plain", "hello from esp8266!");
  delay(100);
  
}

//void handleNotFound() {
//  //digitalWrite(led, 1);
//  String message = "File Not Found\n\n";
//  message += "URI: ";
//  message += server.uri();
//  message += "\nMethod: ";
//  message += (server.method() == HTTP_GET) ? "GET" : "POST";
//  message += "\nArguments: ";
//  message += server.args();
//  message += "\n";
//  for (uint8_t i = 0; i < server.args(); i++) {
//    message += " " + server.argName(i) + ": " + server.arg(i) + "\n";
//  }
//  server.send(404, "text/plain", message);
//  Serial.print(message);
//  //digitalWrite(led, 0);
//}

void setup(void) {
//  pinMode(led, OUTPUT);
  pinMode(pin1, OUTPUT);
 // digitalWrite(led, LOW);
  digitalWrite(pin1, state);
  Serial.begin(115200);
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  Serial.println("");

  // Wait for connection
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to ");
  Serial.println(ssid);
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());

  if (MDNS.begin("esp8266")) {
    Serial.println("MDNS responder started");
  }

  server.on("/", handleRoot);
  //---Swicch LED
  server.on("/on", []() {
      server.send(200, "text/plain", "HIGH");
      state=1;
      digitalWrite(pin1,state);
      delay(50);
  });


  server.on("/off", []() {
      server.send(200, "text/plain", "LOW");
      state=0;
      digitalWrite(pin1,state);
      delay(50);
  });

  
  server.on("/status", []() {
    if(state==0){
      //digitalWrite(pin1,HIGH);
      server.send(200, "text/plain", "LOW");
     // state=1;
    }else{
      //digitalWrite(pin1,LOW);
      server.send(200, "text/plain", "HIGH");
      //state=0;
    }
    
    
  });

//  server.onNotFound(handleNotFound);

  server.begin();
  Serial.println("HTTP server started");
}

void loop(void) {
  server.handleClient();
}
