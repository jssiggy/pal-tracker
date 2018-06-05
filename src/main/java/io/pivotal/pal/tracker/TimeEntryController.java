package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping(path="/time-entries", consumes="application/json")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        return new ResponseEntity<>(timeEntryRepository.create(timeEntry), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(timeEntry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(timeEntry, HttpStatus.OK);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry entry) {
        TimeEntry timeEntry = timeEntryRepository.update(id, entry);
        if(timeEntry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(timeEntry, HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        return new ResponseEntity<>(timeEntryRepository.delete(id), HttpStatus.NO_CONTENT);
    }
}
