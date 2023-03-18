package com.pottercrud.services;

import com.pottercrud.entities.Wizard;
import com.pottercrud.repositories.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WizardService {

    @Autowired
    private WizardRepository repository;

    public List<Wizard> findAll(){
        return repository.findAll();
    }

    public String save(Wizard wizard){
        repository.save(wizard);
        return "Created wizard with id " + wizard.getId();
    }

    public Wizard findById(String id) throws Exception {
        Optional<Wizard> wizard = repository.findById(id);
        return wizard.orElseThrow(() -> new Exception("Not founded wizard"));
    }

    public String delete(String id){
        repository.deleteById(id);
        return "Deleted wizard with id: " + id;
    }

    public Wizard update(Wizard wizard) throws Exception {
        Wizard findedOnDB = findById(wizard.getId());
        updateData(findedOnDB, wizard);
        return repository.save(findedOnDB);
    }

    public void updateData(Wizard findedOnDB, Wizard wizard) {
        findedOnDB.setName(wizard.getName());
        findedOnDB.setHouse(wizard.getHouse());
        findedOnDB.setPatronum(wizard.getPatronum());
        findedOnDB.setPet(wizard.getPet());
        findedOnDB.setWand(wizard.getWand());
    }



}
