# 🚀 Automated Web Testing Framework (Java & Selenium)

A high-performance, modular, and enterprise-grade browser automation framework designed for scalability and efficiency. This framework implements a **lean test architecture** using modern Java practices, Selenium WebDriver 4, and industry-standard design patterns to deliver fast and reliable quality assurance.

---

## 📖 Project Description

This project provides a comprehensive browser automation solution built on an enterprise-grade architecture. It is designed to be highly maintainable, minimizing boilerplate code while maximizing execution flexibility across different environments and browsers.

### Key Capabilities:
- **Modular Architecture**: Decoupled Page Objects, Business Workflows, and Infrastructure management.
- **Flexible Execution**: Toggle between local browsers, Dockerized Selenium Grid, and ephemeral containers via simple configuration.
- **Parallel Testing**: Native support for parallel test execution to significantly reduce regression time.
- **Actionable Reporting**: Integrated reporting system that provides visual tracing, detailed logs, and failure screenshots.
- **Dynamic Test Data**: Automated data generation to ensure tests are isolated and don't depend on static datasets.

---

## 🛠️ Project Requirements

### Prerequisites & Required Versions
Before running the automation framework locally, ensure that the following software and tools are installed on your system.

| Component | Required Version | Purpose |
| :--- | :--- | :--- |
| **Java** | Java 17 or higher | Required to compile and run the automation framework |
| **Maven** | 3.9 or higher | Used for dependency management and test execution |
| **Google Chrome** | Latest version | Browser used for Selenium automation |
| **ChromeDriver** | Compatible with Chrome version | Enables Selenium to control the Chrome browser |
| **Allure** | Latest version | Generates detailed test execution reports |

**To verify the installation, run the following commands in your terminal:**
```bash
java -version
mvn -version
```
---

## 🚀 How to Run the Project Locally

### 1. Navigate to the Project Directory
Open your terminal or command prompt and navigate to the project directory:
```bash
cd "/path/to/selenium-java-lean-test-architecture"
```
*Note: This directory contains the Selenium automation framework along with the test workflows and configuration files.*

### 2. Clean and Execute Automation Tests
To run all the automated workflows in the project, execute the following command:
```bash
mvn clean test -Pweb-execution
```

**What This Command Does:**
1. Cleans the previous build artifacts by deleting the `target/` directory.
2. Compiles the automation framework source code.
3. Runs all workflow-based automated test cases.
4. Executes Selenium WebDriver automation on the Chrome browser.
5. Collects test execution results.
6. Generates Allure result files inside `target/allure-results`.

**Expected Console Output:**
After successful execution, the terminal will display a summary similar to the following:
```text
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0 
BUILD SUCCESS
```

---

## 📊 Generate the Allure Test Report

### Option A – Generate and View the Report (Recommended)
Run the following command:
```bash
mvn allure:serve
```
**This command will:**
1. Generate the Allure HTML report.
2. Start a local web server and automatically open the report in your browser.
3. The report will be available at: `http://127.0.0.1:XXXXX`
*The server will continue running until manually stopped using `Ctrl + C`.*

### Option B – Generate a Static Report
If you prefer to generate a report without starting a server, run:
```bash
mvn allure:allure
```
The generated report will be stored at: `target/site/allure-maven-plugin/index.html`. Open this file in a browser to view the report.

---

## 🔍 Viewing the Allure Report
Once the report is opened, it provides a comprehensive dashboard containing detailed test execution information across several sections:

- **Overview**: Displays total tests executed, passed, failed, and execution statistics.
- **Suites**: Shows all test workflows organized into structured suites.
- **Categories**: Classifies test failures based on predefined categories.
- **Graphs**: Provides visual statistics of test results.
- **Timeline**: Displays execution timing of test cases.
- **Behaviors**: Groups tests based on features and stories.

---

## 🧪 Test Workflows Executed
The automation framework executes the following specialized workflows:
- **Booking Validation Workflow**
- **Complete Booking Workflow**
- **Browser Initialization Workflow**
- **Room Booking Workflow**
- **Room Search Workflow**
- **User Login Workflow**
- **User Logout Workflow**
- **User Registration Workflow**

*Each workflow validates different functionalities of the hotel booking system.*

---

## 🎯 Running Specific Test Workflows
If you need to execute only a specific workflow, you can use the `-Dtest` parameter.

**Example: Running the Booking Workflow**
```bash
mvn clean test -Pweb-execution -Dtest=BookingWorkflow
```

**Example: Running the User Login Workflow**
```bash
mvn clean test -Pweb-execution -Dtest=UserLoginWorkflow
```

**Example: Running the Room Booking Workflow**
```bash
mvn clean test -Pweb-execution -Dtest=RoomBookingWorkflow
```


