# Mobile Device Management (MDM) System

## Overview
This project simulates a Mobile Device Management system that allows devices to register, receive software updates, and report installation status. The system logs update activities for monitoring and auditing.

---

## Features

- Device Registration  
- Update Scheduling (Admin)  
- Update Check API  
- Update Status Reporting  
- Audit Logging  
- REST API endpoints  
- H2 Database Integration  

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

---

## How It Works

- Device registers with server  
- Admin schedules update  
- Device checks if update available  
- Device installs update  
- Device reports status  
- System logs update activity  

---

## API Endpoints

### Register Device
POST `/register?id=D1&version=1.0&region=Delhi`

---

### Schedule Update
POST `/schedule?version=2.0&region=Delhi`

---

### Check Update
GET `/check-update?id=D1`

---

### Update Status
POST `/update-status?deviceId=D1&status=installed`

---

### View Logs
GET `/logs`

---

## Database Tables

- DEVICE
- UPDATE_SCHEDULE
- AUDIT_LOG
- APP_VERSION

---

## Run the Project

```bash
git clone <repo-link>
cd mdm-system
./mvnw spring-boot:run

Open:

http://localhost:8080

H2 Console:

http://localhost:8080/h2-console

JDBC URL:

jdbc:h2:mem:mdmdb