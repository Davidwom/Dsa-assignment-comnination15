# Dsa-assignment-30
# Interview Scheduling Optimizer (Problem 30)

 Problem Description
This project implements an **Interview Scheduling Optimizer** for a company’s interview process.

Candidates have availability windows and priority scores, while interviewers have available time slots and a limited number of interviews they can conduct per day.  
The goal is to **maximize the number of scheduled interviews** while respecting all constraints.

System Rules

# Candidates
Each candidate has:
- Candidate ID
- Priority Score (higher priority is scheduled first)
- Availability Windows (time ranges)

# Interviewers
Each interviewer has:
- Interviewer ID
- Available Time Slots
- Maximum Interviews Per Day

# Scheduling Logic
- Candidates are processed in **descending order of priority**
- An interview lasts **exactly 1 hour**
- A candidate is matched with an interviewer if their time windows overlap
- If multiple interviewers are available, the interviewer with the **highest remaining capacity** is selected
- Once scheduled, the time slot is **consumed** and cannot be reused

#Data Structures Used
- **Max Heap (PriorityQueue)** – to process candidates by priority
- **ArrayList & LinkedList** – to manage availability intervals
- **HashMap** – to store interviewers efficiently

#Features Implemented
- Add candidates with priority and availability windows
- Add interviewers with available slots and daily capacity
- Automatically schedule interviews based on constraints
- Generate a report of:
  - Scheduled interviews
  - Unscheduled candidates
 # VIP Restaurant Manager (Problem 31)
## Project Overview
This project implements **Problem 31 – The VIP Restaurant Manager** from the Data Structures and Algorithms assignment.
The system manages a restaurant waiting line where:
- VIP customers are given higher priority
- Regular customers join at the back
- Any customer can leave the line at any time
- The host always seats the customer at the front
The goal is to efficiently manage arrivals, departures, and seating using appropriate data structures.
## Data Structures Used
### 1. Doubly Linked List
- Maintains the order of customers in the waiting line
- Allows:
  - O(1) insertion at the front (VIPs)
  - O(1) insertion at the back (Regular customers)
  - O(1) removal from the middle (when a customer leaves)
### 2. HashMap `<String, Node>`
- Maps customer names to their corresponding linked list nodes
- Enables O(1) lookup for the `LEAVE <name>` operation
## Project Structure
- `Node.java` → Represents a customer in the waiting line
- `VIPRestaurantManager.java` → Contains all business logic
- `Main.java` → Entry point and testing
## How to Run
1. Open the project in **VS Code**
2. Open `Main.java`
3. Click **Run ▶** or right-click → **Run Java**
