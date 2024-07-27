# dbs2400005R Demo Project

## Overview

This project is contain solution to Q1 and Q2 provided.

### Prerequisites

Ensure you have the following software installed:

- Java 17
- Maven
- Postman Client

### Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/tljbranch/dbs2400005R.git
2. **Switch to project directory**  
   cd [project-directory]
3. **Install Application**  
   mvn install

### To test solution for Q1
1. Open your IDE
2. Nagivate to the following class - /demo/src/main/java/q1/GetOdd.java
3. Execute the file.
4. View Console for result.

### To test solution for Q2  
1. **Run Application in cmd**  
  mvn spring-boot:run  
2. **Import Testing Script to Postman**  
Open Postman->Menu->File->Import  
  Testing script can be found in /demo/src/test/resources/dbs2400005R.postman_collection.json
3. **Testing Different Scenario**  
  8 Success Path and 5 Error Path scenario had been loaded  
  _Note: Pagination starts from Page-0_
4. **Alternative**  
The instructions assume that `localhost` and port `8080` are used. Alternatively, you can modify the URL and test it with your preferred tool.
```sh
localhost:8080/dbs2400005R/api/customers?page=0&pageSize=20&sortBy=name&sortOrder=asc
