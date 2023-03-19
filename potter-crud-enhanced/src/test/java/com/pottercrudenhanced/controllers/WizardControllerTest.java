package com.pottercrudenhanced.controllers;
import com.pottercrudenhanced.entities.Wizard;
import com.pottercrudenhanced.services.WizardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WizardControllerTest {

    @Mock
    private WizardService service;

    @InjectMocks
    private WizardController controller;

    @Test
    public void testFindAll() {
        // Setup
        List<Wizard> wizards = new ArrayList<>();
        wizards.add(new Wizard("Harry Potter"));
        wizards.add(new Wizard("Hermione Granger"));
        wizards.add(new Wizard("Ron Weasley"));
        when(service.findAll()).thenReturn(wizards);

        // Exercise
        ResponseEntity<List<Wizard>> response = controller.findAll();

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(wizards, response.getBody());
    }

    @Test
    public void testSave(){
        //Setup
        Wizard wizard = new Wizard("Harry Potter");
        when(service.save(wizard)).thenReturn("Saved successfully");

        //Exercise
        ResponseEntity<String> response = controller.save(wizard);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Saved successfully", response.getBody());
    }

    @Test
    public void testFindById() {
        // Setup
        String wizardId = "123";
        Wizard wizard = new Wizard("Harry Potter");
        when(service.findById(wizardId)).thenReturn(wizard);

        // Exercise
        ResponseEntity<Wizard> response = controller.findById(wizardId);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(wizard, response.getBody());
    }

    @Test
    public void testDelete() {
        // Setup
        String wizardId = "123";
        when(service.delete(wizardId)).thenReturn("Deleted successfully");

        // Exercise
        ResponseEntity<String> response = controller.delete(wizardId);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted successfully", response.getBody());
    }

    @Test
    public void testUpdate() {
        // Setup
        String wizardId = "123";
        String password = "secret";
        Wizard wizard = new Wizard("Harry Potter");
        wizard.setId(wizardId);
        when(service.update(wizard, password)).thenReturn(wizard);

        // Exercise
        ResponseEntity<Wizard> response = controller.update(wizard, wizardId, password);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(wizard, response.getBody());
    }






}
