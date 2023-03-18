package com.pottercrud.entities;

import com.pottercrud.utils.HouseEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "wizard")
public class Wizard {
    @Id
    private String id;
    private String name;
    private HouseEnum house;
    private String patronum;
    private String pet;
    private Wand wand;



}
