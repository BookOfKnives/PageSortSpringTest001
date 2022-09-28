package com.pagesortspringtest001.gun;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//helt enkel GunModel. Det er min idiosynkrasi -- jeg kalder det "-Model" ogikke bare "-"
@Entity
@NoArgsConstructor
@Getter
@Setter //Lombok- og JPA annotationer
public class GunModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idNumber; //id'et bruges af JPA og skal aldrig udfyldes af java-programmet

    private String coolGunName; //et navn -- rart til at se forskel på kolonnerne i databasen.

    public GunModel(String name){
        this.coolGunName = name;
    } //en specifik konstruktør som jeg bruger manuelt i commandline-
    //runner'en i main.
}
