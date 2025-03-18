
# PetStore API Automation🐈

This repo contains a flexible automation framework based on RESTAssured to automate, execute and report API tests for REST endpoints.





## Structure 🏗️
**endpoints**: package containing classes modeling REST endpoints.

**payloads**: package containing classes modeling POST request bodies.

**ConfigurationLoader**: loads configuration.properties file

**configuration.properties**: Allows flexibility in setting base host domain and API version
```
📦 
.gitignore
build.gradle.kts
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
gradlew
gradlew.bat
├─ settings.gradle.kts
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ petstore
   │  │        ├─ ConfigurationLoader.java
   │  │        ├─ endpoints
   │  │        │  ├─ BaseEndpoint.java
   │  │        │  ├─ EndpointFactory.java
   │  │        │  └─ StoreEndpoint.java
   │  │        └─ payloads
   │  │           └─ StoreOrderPayload.java
   │  └─ resources
   │     └─ configuration.properties
   └─ test
      ├─ java
      │  └─ StoreTest.java
      └─ resources
         └─ allure.properties
```
©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)
## Scalability 📈
Scalability has been achieved by ensuring code reusability and extensibility through decoupling the testing logic from the modeling of endpoints and payloads.

Selecting `RESTAssured` to automate API tests and `JUnit5` to execute tests provides a powerful reusable framework that enables Scalability of test implementation and execution.

Additionally, using a build tool `gradle` ensures a seamless integration with any `CI/CD` platform available and removes the hassle of dependency managment and provides the ability to automate various tasks in the development pipeline.


## Run Tests Locally 🏃

Clone the project

```bash
  git clone https://github.com/Amr-Shah33n/amr-shaheen-api.git
```

Go to the project directory

```bash
  cd amr-shaheen-api
```

Build project

```bash
  ./gradlew clean build
```

Run Tests
```bash
 ./gradlew test
```


## Tech Stack 💻

**API Automation:** RESTAssured

**Test Orchestration:** JUnit 5, Hamcrest Matchers

**Build tool:** Gradle

**Reporting:** Allure
