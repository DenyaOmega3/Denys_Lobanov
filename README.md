# Home Task: Selenium

## Used tools
The code is written on _Java JDK-17_ in _IDE Intellij IDEA_
<br>
Used dependencies:
- selenium-server-4.1.0.jar
- testng-7.4.0.jar (TestNG)
Used browser: Microsoft Edge Version: 96.0.1054.43


## How to launch
- make sure you have this version Java or later
- if you have installed Intellij IDEA, you can clone the whole content from Java_tasks branch directly
- download selenium server and testNG to your PC
- install browser driver (Chrome, Edge etc.) based on your browser's version
- for Intellij users, go to File->Project Structure->Modules. Select + sign and then 1 JARs or Directories. Find your selenium server and teting jar files. Then apply
- choose class WebDriverConfiguration. You need to change variable **projectPath** to your own path to browser driver
- in case you don't use Edge (I hope so), you need to change variable **driver** into **new yourBrowserDriver()**
- run all tests
