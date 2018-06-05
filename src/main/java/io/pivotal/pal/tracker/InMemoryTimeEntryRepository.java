package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    static long currentId = 1;

    Map<Long, TimeEntry> timeEntries = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry entry) {
        Long id = generateId();
        TimeEntry timeEntry = new TimeEntry(id, entry);
        timeEntries.put(id, timeEntry);
        return timeEntry;
    }

    private Long generateId() {
        return timeEntries.size() + 1L;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry entry) {
        TimeEntry newEntry = new TimeEntry(id, entry);
        timeEntries.put(id, newEntry);
        return newEntry;
    }

    @Override
    public void delete(long id) {
        TimeEntry timeEntry = timeEntries.get(id);
        timeEntries.remove(id);
    }
}
