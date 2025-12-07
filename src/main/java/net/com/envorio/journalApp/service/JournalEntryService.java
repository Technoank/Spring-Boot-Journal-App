package net.com.envorio.journalApp.service;

import net.com.envorio.journalApp.entity.JournalEntry;
import net.com.envorio.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.jar.JarOutputStream;

@Component
public class JournalEntryService {

    // Class Business logic to create an entry in database
    @Autowired
    private JournalEntryRepository journalEntryRepository;


    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findByID(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteByID(ObjectId id){
        journalEntryRepository.deleteById(id);
    }


}
