package oca.predicate;

import java.util.function.Predicate;

public class Student21PlusPredicate implements Predicate<Student> {
    @Override
    public boolean test(Student student) {
        return student.getAge() >= 21;
    }
}
