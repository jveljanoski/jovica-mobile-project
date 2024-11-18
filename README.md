
# Mobile Test Automation Project

This project is a mobile test automation framework built using **Page Object Model (POM)**, **Appium**, **Selenium**, **TestNG**, and integrated with **Allure** for reporting. It supports testing on Android

## Project Summary  

This project demonstrates how to use the **Page Object Model (POM)** to build a scalable test automation framework. The framework includes:  
- **Form interactions**, **validations**, and **swiping actions** in the application.  
- Examples of **hard** and **soft assertions** to showcase their use in daily testing activities.  
- A comprehensive **Regression Suite** to execute multiple tests across different classes with a single click.  

The `RegressionSuite.xml` file is designed to be easily integrated with CI tools, enabling seamless automation workflows.  

Additionally, one test is intentionally designed to fail, showcasing how **Allure Reporting** effectively represents failures with screenshots. Allure Reports provide clear and client-friendly results, making it easier to share insights and outcomes.


## Prerequisites

Ensure the following are installed on your system:

1. **Java JDK 11 or higher**: Download and install from [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.org/).
2. **Maven 3.6 or higher**:
   - Check if Maven is installed:
     ```bash
     mvn -v
     ```
   - If not installed, follow the [Maven installation guide](https://maven.apache.org/install.html).
3. **Node.js** (for Appium server): Download from [Node.js official site](https://nodejs.org/).
4. **Android SDK** (for Android testing): Install via [Android Studio](https://developer.android.com/studio).
6. **Allure**:
   - Install Allure command-line tool:
     ```bash
     npm install -g allure-commandline --save-dev  # Windows
     ```

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/jveljanoski/jovica-mobile-project.git
   cd jovica-mobile-project
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

3. Set up Appium:
   - Install Appium globally:
     ```bash
     npm install -g appium
     ```

## Running Tests

To execute all tests in the regression suite, use the following command (example):

```bash
mvn test -DsuiteXmlFile="C:\Users\your_account\Documents\Automation\jovica-mobile-project\src\RegressionSuite.xml"
```

After running the tests, you can generate and open the Allure report to view the results. Follow these steps:

**Navigate to the project directory**  
   Open a terminal or command prompt and go to the project directory (example):
```bash
   cd C:\Users\your_account\Documents\Automation\qa-mobile-project
```
   

## Key Technologies Used

- **Appium (v7.0.0)**: Mobile automation framework.
- **Selenium (v3.141.59)**: WebDriver for browser automation.
- **TestNG (v6.14.3)**: Testing framework for managing test execution.
- **Allure (v2.13.7)**: Test reporting framework.

## Configurations

Following class `src/test/java/com/companyname/app/utils/AppiumConfiguration.java` update with the values as per your environment 

- **deviceName**: Emulator name
- **platformVersion**: Emulator version

and `src/test/java/com/companyname/app/utils/AppiumDriver.java` update the the values as per your environment

- **NodeExePath**: Your system nodejs path 
- **AppiumPath**: Your system appium path
- **ANDROID_HOME**: Your system sdk path
- **JAVA_HOME**: Your system java path