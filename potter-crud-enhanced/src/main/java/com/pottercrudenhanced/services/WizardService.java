package com.pottercrudenhanced.services;

import com.pottercrudenhanced.entities.Wizard;
import com.pottercrudenhanced.exceptions.WizardException;
import com.pottercrudenhanced.repositories.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class WizardService {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private WizardRepository wizardRepository;

    public List<Wizard> findAll(){
        return wizardRepository.findAll();
    }

    public String save(Wizard wizard){
        wizard.setPassword(bCryptPasswordEncoder().encode(wizard.getPassword()));
        wizardRepository.save(wizard);
        return "Created wizard with id " + wizard.getId();
    }

    public Wizard findById(String id) {
        Optional<Wizard> wizard = wizardRepository.findById(id);
        return wizard.orElseThrow(() -> new WizardException("Not founded wizard with id: " + id ));
    }

    public String delete(String id){
        wizardRepository.deleteById(id);
        return "Deleted wizard with id " + id;
    }

    public Wizard update(Wizard wizard, String password) {
        boolean result = validatePassword(wizard.getId(), password);
        if(result == false ) {
            throw new WizardException("Invalid password!");
        } else {
            Wizard findedOnDB = findById(wizard.getId());
            updateData(findedOnDB, wizard);
            return wizardRepository.save(findedOnDB);
        }
    }

    public void updateData(Wizard findedOnDB, Wizard wizard){
        findedOnDB.setName(wizard.getName());
        findedOnDB.setPassword(bCryptPasswordEncoder().encode(wizard.getPassword()));
        findedOnDB.setHouse(wizard.getHouse());
        findedOnDB.setPatronum(wizard.getPatronum());
        findedOnDB.setPet(wizard.getPet());
    }

    public Boolean validatePassword(String id, String password){
        Optional<Wizard> wizard = wizardRepository.findById(id);
        if(wizard.isEmpty()) {
            return false;
        } else {
            Wizard wizardOriginal = wizard.get();
            boolean valid = bCryptPasswordEncoder().matches(password, wizardOriginal.getPassword());
            return valid;

        }
    }




}
