# Dsa-assignment-30
# Interview Scheduling Optimizer (Problem 30)

## 📌 Problem Description
This project implements an **Interview Scheduling Optimizer** for a company’s interview process.

Candidates have availability windows and priority scores, while interviewers have available time slots and a limited number of interviews they can conduct per day.  
The goal is to **maximize the number of scheduled interviews** while respecting all constraints.

---

## ⚙️ System Rules

### Candidates
Each candidate has:
- Candidate ID
- Priority Score (higher priority is scheduled first)
- Availability Windows (time ranges)

### Interviewers
Each interviewer has:
- Interviewer ID
- Available Time Slots
- Maximum Interviews Per Day

### Scheduling Logic
- Candidates are processed in **descending order of priority**
- An interview lasts **exactly 1 hour**
- A candidate is matched with an interviewer if their time windows overlap
- If multiple interviewers are available, the interviewer with the **highest remaining capacity** is selected
- Once scheduled, the time slot is **consumed** and cannot be reused

---

## 🧠 Data Structures Used
- **Max Heap (PriorityQueue)** – to process candidates by priority
- **ArrayList & LinkedList** – to manage availability intervals
- **HashMap** – to store interviewers efficiently
- **Queue/List** – to store scheduled and unscheduled results

---

## 🛠️ Features Implemented
- Add candidates with priority and availability windows
- Add interviewers with available slots and daily capacity
- Automatically schedule interviews based on constraints
- Generate a report of:
  - Scheduled interviews
  - Unscheduled candidates

---

## ▶️ How to Run the Program

### 1. Compile the program
```bash
javac InterviewSchedulingOptimizer.java
