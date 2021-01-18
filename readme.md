# Console Application Database  Created Using Generics and HashMap
## Computer Programming 2 : Project for Finals

### How to Run:
1. Run `git clone https://github.com/Ryanali23/Computer-Programming-2-Console-App-Finals.git ` or dowload it as ZIP.
2. After cloning, Run the Finals.java :
`javac Finals.java`
`java Finals`

3. Enjoy and Explore :heart:

You can edit the file by opening the Finals.java with your favorite text editor.

## Model
Model is the design of the object the you will store in your database. For instance, consider  the following models : 
#### Student Class model
Simple student model with public fields with no getter and setter.
```java
class Student{
    public int id; 
    public String firstName; 
    public String  lastName; 
    public int age; 

    Student(int id, String firstName, String lastName,int age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}
```
#### Employee Class Model
Simple employee model with private fields and with getter and setters
```java
class Employee{
    private int id; 
    private String firstName; 
    private String  lastName; 
    private int age; 

    public void set(int id, String firstName,String lastName,int age ){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
}
```
## Creating Database 
In order to create a database, We need to create a model and pass it as type to database class. For example :

#### Using Student and Employee  model
```java
Database <Student> studentDatabase  = new Database<>();
Database <Employee> employeeDatabase = new Database<>();
```
## Basic CRUD Operation

The database has  4 methods the **Store, Find, Update, Delete**

### Store()

Store operation can be done using the following : 

```java
Database <Student> studentDatabase  = new Database<>()
 studentDatabase.store(new Student(1,"Ryan","Ali",20));
```
By default,  the store operation **primary-key**  runs on auto-increment and it should be integer only, but you can define your own key by passing another argument to **store** method. consider the following: 
```java
studentDatabase.store(2,new Student(2,"Ryan","Ali",20));
```
You can also do this: 
```java
Database <Employee> employeeDatabase = new Database<>()
Employee emp = new Employee();
emp.set(1,"Claud","Bereber",20);
employeeDatabase.store(emp);
```
#### Create Operation Exception
There are only two ways  to implement **Primary-key  by:  Implementing on your own** or **stick to auto-increment**. You should choose only one because if id that  has been pass is not unique, it will throw an UniqueIdException. Consider the following example: 

```java
Database <Student> studentDatabase  = new Database<>();
studentDatabase.store(new Student(1,"Ryan","Ali",20));
studentDatabase.store(1,new Student(2,"Faisal","Ali",90));
```
In this example, It will throw an exception because, when you run the default store operation the database primary key will increment. Then, you passed another  argument, the value **1** which is equal to auto-increment value and it is already existed. That is why recommended to use only one implementation.

### Find()
Find method will return an arraylist. You can extract the data by using the following:
```java
Database <Student> studentDatabase  = new Database<>();
studentDatabase.store(new Student(1,"Ryan","Ali",20));
studentDatabase.store(new Student(2,"Faisal","Ali",90));
        
for(int i = 0; i < studentDatabase.find().size(); i++){
   System.out.println(studentDatabase.find().get(i).firstName);
   }
```
**Output**
`Ryan`
`Faisal`

### Update()
Update method has 3 arguments  which is the **Id, new data, upsert = true or false**. This can be operation can be done using the following: 
```java
Database <Student> studentDatabase  = new Database<>();
studentDatabase.store(new Student(1,"Ryan","Ali",20));
 studentDatabase.store(new Student(2,"Faisal","Ali",90));

for(int i = 0; i < studentDatabase.find().size(); i++){
         System.out.println(studentDatabase.find().get(i).firstName);
     
    studentDatabase.update(1,new Student(1,"Ryan Aringino","Ali",20),false);

for(int i = 0; i < studentDatabase.find().size(); i++){
          System.out.println(studentDatabase.find().get(i).firstName);
  }
```
**Output**
`Ryan`
`Faisal`
`Ryan Aringino`
`Faisal`

In this example you will see, that it updates first record which has an Id of 1. now let us try using upsert. **Upsert** means writing data if it does not exist. Consider the following : 
```java
Database <Student> studentDatabase  = new Database<>();
studentDatabase.store(new Student(1,"Ryan","Ali",20));
studentDatabase.store(new Student(2,"Faisal","Ali",90));

for(int i = 0; i < studentDatabase.find().size(); i++){ System.out.println(studentDatabase.find().get(i).firstName);
 }
 studentDatabase.update(3,new Student(3,"Claud","Bereber",20),true);

for(int i = 0; i < studentDatabase.find().size(); i++){
  System.out.println(studentDatabase.find().get(i).firstName);
  }
```
**Output**
`Ryan`
`Faisal`
`Ryan`
`Faisal`
`Claud`

With this example, we update the value of id **3** but, it does not exist and our upsert is true, that is why, it still stores in the database.

### Delete()
Delete method take only one arguments which is the Id of the user. For example : 
```java
Database <Student> studentDatabase  = new Database<>(); 
studentDatabase.store(new Student(1,"Ryan","Ali",20));
studentDatabase.store(new Student(2,"Faisal","Ali",90));

for(int i = 0; i < studentDatabase.find().size(); i++){
  System.out.println(studentDatabase.find().get(i).firstName);
 }
 
studentDatabase.update(3,new Student(3,"Claud","Bereber",20),true);

for(int i = 0; i < studentDatabase.find().size(); i++){
  System.out.println(studentDatabase.find().get(i).firstName);
   }

  studentDatabase.delete(3);

for(int i = 0; i < studentDatabase.find().size(); i++){
    System.out.println(studentDatabase.find().get(i).firstName);
    }
```
**Output**
`Ryan`
`Faisal`
`Ryan`
`Faisal`
`Claud`
`Ryan`
`Faisal`

In this example, The data has been deleted with id of **3**.


