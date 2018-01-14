package oca.predicate;

public class Student {
    private String firstName;
    private String lastName;
    private float average;
    private int age;

    public Student(String firstName, String lastName, float average, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", average=" + average +
                ", age=" + age +
                "}\n";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getAverage() {
        return average;
    }

    public int getAge() {
        return age;
    }
}
