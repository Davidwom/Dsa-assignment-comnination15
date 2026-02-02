# Emergency Dispatch System (Queue, Stack & DLL Integration) 🚨

## 📌 Overview

This project is a Java-based Emergency Dispatch System that demonstrates the practical use of core data structures:

- **Queue** – for logging incoming emergency calls
- **Stack** – for tracking action history (CALL, DISPATCH, ESCALATE)
- **Doubly Linked List (DLL)** – for managing active emergency units
- **Priority Queue (Heap)** – for dispatching calls based on severity and arrival time

The system simulates how emergency calls are received, prioritized, escalated, and dispatched.

---

## 🧱 Data Structures Used

### 1. Queue (Call Log)
- Implements FIFO (First In, First Out)
- Stores incoming call severities
- Operations:
  - `enqueue(double data)`
  - `dequeue()`
  - `display()`

### 2. Stack (Action History)
- Implements LIFO (Last In, First Out)
- Tracks system actions:
  - `1 → CALL`
  - `2 → DISPATCH`
  - `3 → ESCALATE`
- Operations:
  - `push(double data)`
  - `pop()`
  - `display()`

### 3. Doubly Linked List (DLL – Emergency Units)
- Stores active emergency unit IDs
- Allows forward and backward traversal
- Operations:
  - `insert(double data)`
  - `display()`

### 4. Priority Queue (Heap)
- Automatically prioritizes calls
- Sorting rules:
  - Lower severity value = higher priority
  - If severity is equal, earlier arrival time is prioritized

---

> 💡 This README summarizes the core concepts and operations implemented in the repository. For usage examples and build instructions, see the Java source files (`Queue.java`, `Stack.java`, `DLL.java`, `DispatchController.java`, `main.java`).
