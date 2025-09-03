# RideHailing-API

This is a simple implemention of a Ride Sharing Service that allows riders to request rides, drivers to accept trips, and the system to manage trip assignments, payments, and trip status.

---

## 🚀 Getting Started

### 1. Generate Project with Spring Initializr

1. Go to [Spring Initializr](https://start.spring.io/).
2. Fill in the details:
    - Project: Maven
    - Language: Java
    - Spring Boot Version: (latest stable, e.g., 3.x.x)
    - Group: ridehailingservice
    - Artifact:
    - Name: ridehailingservice
    - Packaging: Jar
    - Java: 17 (or your installed version)
3. Add dependencies:
    - Spring Web
    - Lombook
4. Click Generate, and extract the downloaded project.

---

### 2. Open in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Import the project by selecting the extracted folder.
3. Wait until Maven builds the project and dependencies are downloaded.

---

### 3. Run the Application

1. Locate the main class:
src/main/java/ridehailingservice.java
2. Right-click and select Run 'Application'.
3. The application will start on [http://localhost:8080](http://localhost:8080/) by default.

---

### 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Maven
- REST API

Perfect 👍 Based on your **`RideSharingService`** class, here’s a **README-style API documentation** with all endpoints and short descriptions.

---

# 🚖 Ride Hailing Service – API Endpoints

This service provides APIs for a **ride-hailing system** (like Uber/Ola) where riders can request rides, drivers can accept, and trips can be tracked.

---

## ✅ API Endpoints

### 1. Register Rider

**Request:**

```
POST /api/ride/riders?name=Alice&contact=1234-56789
```

**Description:** Registers a new rider with name and contact details.
<img width="1366" height="768" alt="Screenshot (419)" src="https://github.com/user-attachments/assets/6bfe17f6-ce0e-4744-a9b6-c65e1e1570ba" />

---

### 2. Register Driver

**Request:**

```
POST /api/ride/drivers
location": { "lat": 12.9716, "lng": 77.5946 }
}
```

**Description:** Registers a new driver with vehicle details and initial location.
<img width="1366" height="768" alt="Screenshot (420)" src="https://github.com/user-attachments/assets/0f20a223-a460-48de-9bf4-df70a949f216" />

---

### 3. Request Ride

**Request:**

```
POST /api/ride/request?riderId=R1

```

**Description:** Rider requests a new trip. The system finds nearby drivers, estimates fare, and creates a trip.
<img width="1366" height="768" alt="Screenshot (421)" src="https://github.com/user-attachments/assets/7e830d86-22fb-4595-82a5-639ff7af6039" />

---

### 4. Accept Ride

**Request:**

```
POST /api/ride/{tripId}/accept?driverId=D1
```

**Description:** A driver accepts a ride request. The trip gets assigned to the driver.
<img width="1366" height="768" alt="Screenshot (422)" src="https://github.com/user-attachments/assets/2bfa2354-dad0-403c-bcc6-210f8cc37b53" />

---

### 5. Start Trip

**Request:**

```
POST /api/ride/{tripId}/start
```

**Description:** Marks the trip as started.

---

### 6. End Trip

**Request:**

```
POST /api/ride/{tripId}/end
```

**Description:** Ends the trip, updates driver status back to **ONLINE**, updates driver location, and adds the trip to both driver and rider history.
<img width="1366" height="768" alt="Screenshot (423)" src="https://github.com/user-attachments/assets/df720b21-c729-48d0-a94f-7a7666516b79" />

---

## ⚡ Workflow Example

1. Rider registers → `/riders`
2. Driver registers → `/drivers`
3. Rider requests ride → `/request`
4. Driver accepts ride → `/accept`
5. Trip starts → `/start`
6. Trip ends → `/end`
