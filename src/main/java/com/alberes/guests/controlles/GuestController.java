package com.alberes.guests.controlles;

import com.alberes.guests.domains.Guest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/guests")
@CrossOrigin("*")
public class GuestController {

    private static final Map<String, Guest> guestsCache = new HashMap<String, Guest>();

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Guest guest){

        guestsCache.put(guest.legalEntityNumber(), guest);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Guest>> guests(){
        if(guestsCache.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guestsCache.values());
    }

    @DeleteMapping("/{legalEntityNumber}")
    public ResponseEntity<Object> delete(@PathVariable String legalEntityNumber){
        Guest guest = guestsCache.get(legalEntityNumber);
        if(guest == null){
            return ResponseEntity.notFound().build();
        }
        guestsCache.remove(legalEntityNumber);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{legalEntityNumber}")
    public ResponseEntity<Void> update(@PathVariable String legalEntityNumber, @RequestBody Guest guest){
        Guest guestCache = guestsCache.get(legalEntityNumber);
        if(guestCache == null){
            return ResponseEntity.notFound().build();
        }
        guestsCache.remove(legalEntityNumber);
        guestsCache.put(legalEntityNumber, new Guest(guest.name(), legalEntityNumber));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{legalEntityNumber}")
    public ResponseEntity<Guest> guest(@PathVariable String legalEntityNumber){
        Guest guest = guestsCache.get(legalEntityNumber);
        if(guest == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guest);
    }
}
