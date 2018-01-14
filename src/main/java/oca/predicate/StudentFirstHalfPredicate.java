package oca.predicate;

import java.util.function.Predicate;

public class StudentFirstHalfPredicate implements Predicate<Student> {
    @Override
    public boolean test(Student student) {
        return Character.toLowerCase(student.getLastName().charAt(0)) <= 'm';
    }
}
