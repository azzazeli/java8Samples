package flatmap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TestFlatMap {
    public static void main(String[] args) {
        List<Error> errors1 = Arrays.asList(new Error("error11"), new Error("error12"));
        List<Error> errors2 = Arrays.asList(new Error("error21"), new Error("error22"));
        List<Event> events = Arrays.asList(new Event(errors1), new Event(errors2));
        List<BizItem> bizItems = Arrays.asList(new BizItem(events));

        List<Error> test = events.stream().map(Event::getError).flatMap(Collection::stream).collect(Collectors.toList());
        List<Error> all = bizItems.stream().map(BizItem::getEvents).flatMap(Collection::stream).map(Event::getError).flatMap(Collection::stream).collect(Collectors.toList());
        for (Error err: all) {
            System.out.println(err);
        }
    }
}
