package net.com.envorio.journalApp.controller;


import net.com.envorio.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();


    @GetMapping("")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

}
