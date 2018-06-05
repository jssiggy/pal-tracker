package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry entry);

    TimeEntry find(long l);

    List<TimeEntry> list();

    TimeEntry update(long id, TimeEntry entry);

    TimeEntry delete(long id);
}
