package net.Omkar.journalApp.Contoller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.Omkar.journalApp.Services.JournalEntryServices;
import net.Omkar.journalApp.entity.JournalEntry;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {

    @Autowired
    private JournalEntryServices journalEntryServices;

    // Get All Journals
    @GetMapping
    public List<JournalEntry> getJournalEntries() {
        return journalEntryServices.getAll();
    }

    // Create Journal
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {

        journalEntryServices.saveEntry(myEntry);

        return myEntry;
    }

    // Get Journal By Id
    @GetMapping("/id/{myId}")
    public JournalEntry getJournalById(
            @PathVariable ObjectId myId) {

        return journalEntryServices.findById(myId).orElseThrow(null);
    }

    // Delete Journal
    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalById(
            @PathVariable ObjectId myId) {

        journalEntryServices.deleteById(myId);

        return true;
    }
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(
            @PathVariable ObjectId id,
            @RequestBody JournalEntry newEntry) {

        JournalEntry old =
                journalEntryServices.findById(id).orElse(null);

        if (old != null) {

            old.setName(
                    newEntry.getName() != null &&
                    !newEntry.getName().equals("")
                            ? newEntry.getName()
                            : old.getName());

            old.setContent(
                    newEntry.getContent() != null &&
                    !newEntry.getContent().equals("")
                            ? newEntry.getContent()
                            : old.getContent());

          
            journalEntryServices.saveEntry(old);
        }

        return old;
    }

}