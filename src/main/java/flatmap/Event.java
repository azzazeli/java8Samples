package flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Event {
    List<Error> error = new ArrayList<>();


    public Event(List<Error> error) {
        this.error = error;

    }

    public List<Error> getError() {
        return error;
    }

    public void setError(List<Error> error) {
        this.error = error;
    }
}
