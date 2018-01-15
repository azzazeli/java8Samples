package oca.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Student> theClass = Arrays.asList(
                new Student("Fred", "Jones", 2.3F, 19),
                new Student("Jim", "Smith", 3.2F, 21),
                new Student("Sheila", "Hopper", 3.9F, 22),
                new Student("Andrea", "Gust", 4.0F, 18)
        );
        v3(theClass);
    }

    private static void v3(List<Student> theClass) {
        System.out.println("All students:\n " + theClass);
        System.out.println("=========================");
        System.out.println("21+ students:\n " + getMatching(theClass, (student) -> {
            return student.getAge() >= 21;
        }));
        System.out.println("=========================");
        System.out.println("First half students:\n " + getMatching(theClass, new StudentFirstHalfPredicate()));
    }

    private static void v2(List<Student> theClass){
        System.out.println("All students:\n " + theClass);
        System.out.println("=========================");
        System.out.println("21+ students:\n " + getMatching(theClass, new Student21PlusPredicate()));
        System.out.println("=========================");
        System.out.println("First half students:\n " + getMatching(theClass, new StudentFirstHalfPredicate()));
    }

    private static void v1(List<Student> theClass) {
        System.out.println("All students: " + theClass);
        System.out.println("=========================");
        System.out.println("21+ students: " + get21Plus(theClass));
        System.out.println("=========================");
        System.out.println("First half students: " + getFirstHalfAlphabet(theClass));
    }

    private static List<Student> getMatching(List<Student> theClass, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        for (Student student : theClass) {
            if (predicate.test(student)) result.add(student);
        }
        return result;
    }

    private static List<Student> getFirstHalfAlphabet(List<Student> theClass) {
        List<Student> result = new ArrayList<>();
        for (Student student : theClass) {
            if (Character.toLowerCase(student.getLastName().charAt(0)) <= 'm') result.add(student);
        }
        return result;
    }

    private static List<Student> get21Plus(List<Student> theClass) {
        List<Student> result = new ArrayList<>();
        for (Student student : theClass) {
            if (student.getAge() >= 21) result.add(student);
        }
        return result;
    }
}
