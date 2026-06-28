package net.Omkar.journalApp.Services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.Omkar.journalApp.Repository.JournalEntryRepository;
import net.Omkar.journalApp.entity.JournalEntry;

@Service
public class JournalEntryServices {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    // Save Journal
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    // Get All Journals
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    // Get Journal By Id
    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    // Delete Journal By Id
    public void deleteById(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }

	
}