# Student-Management-System
*Overview*
>* The Student Management System is a comprehensive web application designed to manage student records efficiently. It incorporates modern technologies to provide a robust and scalable solution. The system supports user authentication and offers CRUD operations (Create, Read, Update, Delete) on student records. The project uses core Java, Spring Boot, RESTful APIs, microservices, Hibernate, JDBC, MySQL, HTML, CSS, JavaScript, and Angular for a full-stack development approach.

## Key Features
* 1. User Authentication:*
* Secure login functionality.
* Validation of user credentials to ensure that only authorized users can access the system.
  
*2. Student Management:*
* **View Students:** Fetch and display all student records from the database.
* **Add Student:** Provide a form to input new student details and save them to the database.
* **Edit Student:** Update existing student information.
* **Delete Student:** Remove student records from the system.

##Technologies Used
*Backend:*
* **Core Java:** Serves as the backbone of the application, handling business logic.
* **Spring Boot:** Facilitates the creation of stand-alone, production-grade Spring-based applications.
* **RESTful APIs:** Enables communication between the frontend and backend services.
* **Microservices:** Separates the application into independent services, improving scalability and maintainability.
* **Hibernate:** Simplifies database interactions by mapping Java objects to database tables.
* **JDBC:** Provides a standard method for accessing databases.
* **MySQL:** Stores user and student data securely.

*Frontend:*
* **HTML:** Structures the content of the web pages.
* **CSS:** Styles the web pages for an appealing visual presentation.
* **JavaScript:** Adds interactivity to the web pages.
* **Angular:** Provides a framework for building a dynamic and responsive user interface.

*Database Design*
* **User Database** `(Your_Name_User):`
   * **Table:**  User
      *  `User_Id (int)`
      * `User_Name (varchar)`
      * `Password (varchar)`

* **Student Database** `(Your_Name_Student):`
   * **Table:**  Student
      * `Student_Id (int)`
      * `Name (varchar)`
      * `Admission_No (varchar)`
      * `Class_Id (FK) (int)`
      * `Section_Id (int)`
      * `Joining_Date (DateTime)`
   * **Table:**  Class
      * `Class_Id (int)`
      * `Class_Name (varchar)`
   * **Table:**  Section
      * `Section_Id (int)`
      * `Section_Name (varchar)`
      * `Class_Id (FK) (int)`

 




