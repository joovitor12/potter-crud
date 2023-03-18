package com.pottercrud.controllers;

import com.pottercrud.entities.Wizard;
import com.pottercrud.services.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WizardController {

    @Autowired
    private WizardService service;

    @GetMapping(value = "/hello")
    public String helloWorld(){
        return "Hello World!";
    }

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

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Wizard> findById(@PathVariable String id) throws Exception {
        Wizard finded = service.findById(id);
        return ResponseEntity.ok().body(finded);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Wizard> update(@RequestBody Wizard wizard, @PathVariable String id) throws Exception {
        wizard.setId(id);
        Wizard updated = service.update(wizard);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        String result = service.delete(id);
        return ResponseEntity.ok().body(result);
    }

}
