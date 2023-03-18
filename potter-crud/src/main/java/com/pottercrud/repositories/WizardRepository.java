package com.pottercrud.repositories;

import com.pottercrud.entities.Wizard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WizardRepository extends MongoRepository<Wizard, String> {
}
