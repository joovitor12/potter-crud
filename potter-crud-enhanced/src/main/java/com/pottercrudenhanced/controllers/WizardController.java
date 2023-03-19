package com.pottercrudenhanced.controllers;

import com.pottercrudenhanced.entities.Wizard;
import com.pottercrudenhanced.exceptions.WizardException;
import com.pottercrudenhanced.services.WizardService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WizardController {

    @Autowired
    private WizardService service;

    @GetMapping(value = "/find-all")
    public ResponseEntity<List<Wizard>> findAll(){
        List<Wizard> wizards = service.findAll();
        return ResponseEntity.ok().body(wizards);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody Wizard wizard){
        String result = service.save(wizard);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Wizard> findById(@RequestParam String id) {
        Wizard wizard = service.findById(id);
        return ResponseEntity.ok().body(wizard);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam String id){
        String result = service.delete(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Wizard> update(@RequestBody Wizard wizard, @RequestParam String id, @RequestParam String password) {
        wizard.setId(id);
        Wizard updated = service.update(wizard, password);
        return ResponseEntity.ok().body(updated);
    }
}
