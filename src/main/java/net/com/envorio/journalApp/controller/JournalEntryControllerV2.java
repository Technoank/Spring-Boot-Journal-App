package net.com.envorio.journalApp.controller;

import net.com.envorio.journalApp.entity.JournalEntry;
import net.com.envorio.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.JobStoreType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
       return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myID}")
    public JournalEntry getJournalEntryByID(@PathVariable ObjectId myID){
        return journalEntryService.findByID(myID).orElse( null) ;

    }

    @DeleteMapping("{myID}")
    public boolean deleteJournalEntryByID(@PathVariable ObjectId myID){
        journalEntryService.deleteByID(myID);
        return true;
    }

    @PutMapping("{id}")
    public JournalEntry updateJournalEntryByID(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){
        JournalEntry old  = journalEntryService.findByID(id).orElse(null);
        if (old != null)
        {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }



}
