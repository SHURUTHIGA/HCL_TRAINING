# 🏧 ATM Simulator (Day 3 Task)

A console-based Java application that simulates a standard Automated Teller Machine (ATM) banking system. This project was developed as part of the training program[cite: 1] to practice core Java programming, control structures, and input validation.

---

## 🚀 Features

* **PIN Authentication:** Secure entry point requiring user verification.
* **Check Balance:** View the current account balance in real-time.
* **Deposit Money:** Add funds to the account with instant balance updates.
* **Withdraw Money:** Securely withdraw funds with validation checks (e.g., sufficient balance).
* **Mini Statement:** View recent transaction histories.
* **Interactive Menu:** User-friendly command-line loop allowing multiple operations in a single session.

---

## 🛠️ Technologies Used

* **Language:** Java (JDK 11 or higher recommended)
* **Build Tool:** Maven (`pom.xml`)
* **Environment:** Visual Studio Code[cite: 2] / Command Line

---

## 📦 Project Structure

```text
day-3-atm-simulator/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── atm/
│                       └── AtmSimulator.java   # Main application logic
├── target/
│   └── day-3-atm-simulator-1.0.0.jar           # Executable JAR file[cite: 2]
└── pom.xml                                     # Maven configuration file[cite: 2]

