package com.pottercrudenhanced.repositories;

import com.pottercrudenhanced.entities.Wizard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WizardRepository extends MongoRepository<Wizard, String> {
}
