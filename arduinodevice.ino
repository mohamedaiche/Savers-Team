int nivo=A0;
int nivo1=A1;
int nivo2=A2;
int nivo3=A3;
int nivo4=A4;
int Oxygene=A5;
int TDS=A6;
int PH=A7;
int a;
int z;
int e;
int r;
int t;
int OxygeneValue;
int TDSValue;
int PHValue;
int lastState = -1;
int RedLED= 8;
int YellowLED=9;
int GreenLED =10;
int buzzer= 11;
int sound = 500;
void setup(){
  Serial.begin(9600);
}
void loop(){
  a=analogRead(nivo);
  z=analogRead(nivo1);
  e=analogRead(nivo2);
  r=analogRead(nivo3);
  t=analogRead(nivo4);
  pinMode(GreenLED, OUTPUT);
  pinMode(RedLED, OUTPUT);
  pinMode(YellowLED, OUTPUT);
  pinMode(buzzer, OUTPUT);
  if(t>800)
  { if(lastState != 5){
     lastState = 5;
     Serial.println("Weter Level 100%");
     Serial.println("Oxygene PPM");
    Serial.println(OxygeneValue);
    Serial.println("TDS PPM");
    Serial.println(TDSValue);
    Serial.println("PH");
    Serial.println(PHValue);
     digitalWrite(RedLED, HIGH);
     digitalWrite(YellowLED, LOW);
     digitalWrite(GreenLED, LOW);
     sound = 1000;
     tone(buzzer, sound);
     delay(1000);
  }
  }
  else if(r>800)
  {
    if(lastState != 4){
      lastState = 4;
    Serial.println("Weter Level 80%");
    Serial.println("Oxygene PPM");
    Serial.println(OxygeneValue);
    Serial.println("TDS PPM");
    Serial.println(TDSValue);
    Serial.println("PH");
    Serial.println(PHValue);
    digitalWrite(RedLED, HIGH);
     digitalWrite(YellowLED, LOW);
     digitalWrite(GreenLED, LOW);
     noTone(buzzer);
     delay(1000);
    }
  }
   else if(e>800)
  {
    if(lastState != 3){
      lastState = 3;
    Serial.println("Weter Level 60%");
    Serial.println("Oxygene PPM");
    Serial.println(OxygeneValue);
    Serial.println("TDS PPM");
    Serial.println(TDSValue);
    Serial.println("PH");
    Serial.println(PHValue);
    digitalWrite(RedLED, LOW);
     digitalWrite(YellowLED, HIGH);
     digitalWrite(GreenLED, LOW);
     noTone(buzzer);
     delay(1000);
    }
  }
  else if(z>800)
  {
    if(lastState != 2){
      lastState = 2;
    Serial.println("Weter Level 40%");
    Serial.println("Oxygene PPM");
    Serial.println(OxygeneValue);
    Serial.println("TDS PPM");
    Serial.println(TDSValue);
    Serial.println("PH");
    Serial.println(PHValue);
    digitalWrite(RedLED, LOW);
     digitalWrite(YellowLED, LOW);
     digitalWrite(GreenLED, HIGH);
     noTone(buzzer);
     delay(1000);
    }
  }
  else if(a>800)
  {
    if(lastState != 1){
      lastState = 1;
    Serial.println("Weter Level 20%");
    Serial.println("Oxygene PPM");
    Serial.println(OxygeneValue);
    Serial.println("TDS PPM");
    Serial.println(TDSValue);
    Serial.println("PH");
    Serial.println(PHValue);
    digitalWrite(RedLED, LOW);
     digitalWrite(YellowLED, LOW);
     digitalWrite(GreenLED, HIGH);
     noTone(buzzer);
     delay(1000);
    }
  }
}
