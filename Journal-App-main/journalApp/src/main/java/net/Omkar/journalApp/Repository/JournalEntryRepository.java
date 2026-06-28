package net.Omkar.journalApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.Omkar.journalApp.entity.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, Object> {

}
