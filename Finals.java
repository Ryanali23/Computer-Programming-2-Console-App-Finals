
import java.util.HashMap;
import java.util.ArrayList;

class Finals{

    public static void main(String[] args) {
        
       
        Database <Employee> employeeDatabase = new Database<>();
           //Employee emp = new Employee();
        //emp.set(1,"Claud","Bereber",20);
        //employeeDb.store(emp);


     
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
    }
  
}
///database class
class Database <Type extends Object> implements DatabaseMethods<Type>{
    
    private HashMap <Integer,Type> storage = new HashMap<Integer,Type>();
    int numberofRecords = 0;

    public void store(Type object){
        numberofRecords = numberofRecords + 1;
        storage.put(numberofRecords, object);
        
    }
    public void store(Integer Id,Type object){
        try{
        if(storage.containsKey(Id)) {

         throw new UniqueIdException();
        }
            storage.put(Id, object);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Type> find(){
        ArrayList<Type> fetchedData = new ArrayList<>();
        for(HashMap.Entry<Integer,Type> data  : storage.entrySet()){
            fetchedData.add(data.getValue());
        }
        return fetchedData;
    }
    public void delete(Integer id){
        storage.remove(id);
    }
    public void update(Integer id,Type obj,boolean isUpsert){
        
        if(storage.containsKey(id) && isUpsert == false){
            storage.replace(id,obj);
        }
        if(!storage.containsKey(id) && isUpsert == true){

            storage.put(id,obj);
        }
    }

}
interface DatabaseMethods<Type>{
    public void store(Type object);
    public void store(Integer Id,Type object);
    public ArrayList<Type> find();
    public void delete(Integer id);
    public void update(Integer id,Type obj,boolean isUpsert);
}
//models
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
//models
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
