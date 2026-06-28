package net.Omkar.journalApp.Contoller;

import net.Omkar.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    private Map<Integer, JournalEntry> jornalentries=new HashMap<>();

    public List<JournalEntry> getAll(){
        return new ArrayList<>(jornalentries.values());
    }

//    public boolean createEntry(@RequestBody JournalEntry myentry){
//        jornalentries.put(myentry.getId(),myentry);
//        return true;

//    }//

}
