package com.inheritance.singleinheritence.smarthomedevice;

//Superclass
class Device {

 String deviceId;
 boolean status; // true = ON, false = OFF

 // Constructor
 Device(String deviceId, boolean status) {
     this.deviceId = deviceId;
     this.status = status;
 }

 // Method to display device status
 void displayStatus() {
     System.out.println("Device ID : " + deviceId);
     System.out.println("Status    : " + (status ? "ON" : "OFF"));
 }
}