package my.learning.javarush.st3.testingframework;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;

    private static Map<Integer,User> allUsers = new HashMap<>();
    private static int count_id=0;

    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if(o==null || this.getClass()!=o.getClass()){
            return false;
        }
        User user = (User) o;

        return user.age==this.age && user.sex==this.sex && this.name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age,sex);
    }



    public User(String name, int age, Sex sex){

        this.name = name;
        this.age = age;
        this.sex = sex;

        if(!hasUser()){
            count_id++;
            allUsers.put(count_id,this);
        }
    }
    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }
    public static List<User> getAllUsers(Sex sex){
        List<User> result = new ArrayList<>();
        for (User u:allUsers.values()){
            if(u.sex==sex){
                result.add(u);
            }
        }
        return result;
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }
    public static int getHowManyUsers(Sex sex){
        return getAllUsers(sex).size();
    }
    public static int getAllAgeUsers(){
        int count =0;
        for (User u: allUsers.values()){
            count+=u.age;
        }
        return count;
    }
    public static int getAllAgeUsers(Sex sex){
        int countAge = 0;
        for (User user : getAllUsers(sex)){
            countAge += user.age;
        }
        return countAge;
    }
    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex){
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }






    private boolean hasUser(){
        for (User us: allUsers.values()){
            if (us.equals(this) && us.hashCode()==this.hashCode() ){
                return true;
            }

        } return false;
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
