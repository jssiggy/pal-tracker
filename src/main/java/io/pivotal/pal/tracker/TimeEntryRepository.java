package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry entry);

    TimeEntry find(long l);

    List<TimeEntry> list();

    TimeEntry update(long id, TimeEntry entry);

    ResponseEntity<TimeEntry> delete(long id);
}
