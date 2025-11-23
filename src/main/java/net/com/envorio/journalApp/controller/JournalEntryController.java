package net.com.envorio.journalApp.controller;

import net.com.envorio.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myID}")
    public JournalEntry getJournalEntryByID(@PathVariable Long myID){
        return journalEntries.get(myID);
    }

    @DeleteMapping("{myID}")
    public JournalEntry deleteJournalEntryByID(@PathVariable Long myID){
        return journalEntries.remove(myID);
    }

    @PutMapping("{id}")
    public JournalEntry updateJournalEntryByID(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }


}
