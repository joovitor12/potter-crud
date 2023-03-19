package com.pottercrudenhanced.entities;

import com.pottercrudenhanced.enums.HouseEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "wizard")
public class Wizard {



    @Id
    private String id;
    private String name;
    private String password;
    private HouseEnum house;
    private String pet;
    private String patronum;


    public Wizard (String name){
        this.name = name;
    }

    public Wizard (String name, String password, HouseEnum house, String pet, String patronum){
        this.name = name;
        this.password = password;
        this.house = house;
        this.pet = pet;
        this.patronum = patronum;
    }



}
