package net.springdemo.personapp.model;

public class Person {
    private int id;
    private int age;
    private String firstName;
    private String lastName;

    // Default constructor (required by Spring and some frameworks)
    public Person() {
    }

    // Parameterized constructor
    public Person(int id, int age, String firstName, String lastName) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Optional: for printing person info
    @Override
    public String toString() {
        return "Person{id=" + id + ", age=" + age +
               ", firstName='" + firstName + "', lastName='" + lastName + "'}";
    }
}
