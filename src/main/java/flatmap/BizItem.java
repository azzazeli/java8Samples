package flatmap;

import java.util.List;

public class BizItem {
    private List<Event> events;

    public BizItem(List<Event> events) {
        this.events = events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
