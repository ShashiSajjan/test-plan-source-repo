# Plan Source Platform

## 📘 Project Description

This project is a **BDD (Behavior-Driven Development) automation framework** built using **Java**, **Selenium**, **Cucumber**, and **JUnit**. It is designed to automate test scenarios for the **Plan Source product platform**.

---

## 🧰 Tech Stack

- **Java**
- **Selenium WebDriver**
- **Cucumber (Gherkin)**
- **JUnit**
- **Maven**

---

## ✅ Prerequisites

Ensure the following are installed on your machine before running the tests:

- **JDK** (Java Development Kit)
- **Maven** (for build and dependency management)
- **Browser Driver** (e.g., ChromeDriver for Google Chrome)

---

## 📂 Project Structure Overview

project-root/
│
├── src/
│ ├── test/
│ │ ├── java/
│ │ │ └── AutomationCucumberTest/
│ │ │ ├── testrunner/
│ │ │ ├── stepdefinition/
│ │ │ └── commonstepdefinition/
│ │ └── resources/
│ │ ├── Features/
│ │ └── JSON Payload/
│
├── pom.xml
└── README.md

markdown
Copy
Edit

- **Java Folder**: Contains the core automation logic, step definitions, common steps, and the test runner.
- **Resources Folder**:
  - `Features/`: Contains all `.feature` files written in Gherkin.
  - `JSON Payload/`: Contains API payloads used in backend tests.

---

## 🚀 Running the Tests

1. Navigate to:
src/test/java/AutomationCucumberTest/testrunner/

yaml
Copy
Edit
2. Open the test runner class.
3. Update the following:
- **Feature file path** (if needed)
- **Tag name** to target specific tests
- **Glue** to match the correct step definitions
4. Run the test as a **JUnit Test**.

> Based on the tag provided in the runner class, the corresponding test cases will be executed.

---

## 📈 Reports

- HTML and JUnit reports will be generated in the `target/` directory after test execution:
- `target/HtmlReports/report.html`
- `target/JunitReport/report.xml`

Note:Issues Observed while Automating
--> Faced some much of intermittent issue.
--> Old Data Retaining on the screen while adding new employee details.
--> Getting default warning message
--> Getting 500 error While adding Benifits via Api
--> Same Type of fields are developed with different Tags so created seperate methods, if in case same fields has same Tag name than we can Still customize and create common reusable methods.

## 👤 Author

**Shashikumar Sajjanar**

---

Feel free to modify this README as the project evolves.
