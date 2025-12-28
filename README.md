# 🏦 Secure Banking System with Fraud Detection (Java)

A **console-based Secure Banking System** developed using **Core Java** that simulates real-world banking operations with **built-in fraud detection logic**.  
The system ensures secure transactions, detects suspicious activities, and blocks accounts automatically to prevent misuse.

---

## 📌 Features

- 🔐 PIN-based user authentication  
- ❌ Account lock after **3 wrong PIN attempts**  
- 💰 Check account balance  
- ➕ Deposit money  
- ➖ Withdraw money  
- 🚨 Fraud detection for:
  - Large withdrawal attempts (> ₹50,000)
  - Multiple failed login attempts  
- 🔒 Automatic account blocking on suspicious activity  

---

## 🧠 Fraud Detection Logic

The system detects fraud in the following cases:

- More than **3 incorrect PIN attempts**
- **Single large withdrawal** exceeding ₹50,000
- Attempt to withdraw more than available balance

Once fraud is detected:
- The account is **blocked immediately**
- Further transactions are denied
- User is informed about suspicious activity

---

## 🛠️ Technologies Used

- Java (Core Java)
- OOP Concepts
- Exception Handling
- Scanner Class (Console Input)


