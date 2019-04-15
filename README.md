# EbayMobileAutomationFramework
Instruction for Mobile Automation Framework

Creating Small Framework for Mobile Automation 
I covered below feature to create a effective Mobile Automation framework - 

1.Create A Wrapper class for all Locator and Actions 
2.Fetch All Locators from Properties File
3.Fetch Keywords from Excel Sheet with Apache POI 
4.Fetch Device name and Appium server details from Properties file.
5.Create a Reusable method for Mobile Automation Framework - Like - (Tap,Long Press , Scroll , Drag and drop , Touch Action ,MultiAction)
6.Stored  Xpath , ID , Locators , Linktext , UIAutomator in Varaible (Not Hard coded)
7.Used TestNG to controll the execution of the flow
8.Used Maven and POM.xml to remove the dependency of jar file 

Arcitecture of Framework

In this framework we create maven project to remove the dependcy of jar - Directly download from git and import as maven project

 POM.xml is calling TestNG.xml 
 TestNG.xml call Test Suite
 Test suite is divided in to Three part - It is calling Test base class , Reusable method class , Wrapper Class 
 Test Base - Invoked with desired capabilities and call to XLS_Reader with Apache POI.

Instruction To Import Framework

 Clone from git Repository from URL :- https://github.com/mansari1187/EbayMobileAutomationFramework
 Import this project as maven in eclipse

Prerequisite for this framework :- 

 Jave should be available in system.
 Maven should be available in System
 Run Appium Server Manually.
 Make Sure Device/Emulator should be connected properly - check command  adb devices in command prompt 
 Change Device name Accordingly in config.properties - no need to change in code level (C:\EbayApp\src\main\resources\config.properties)






