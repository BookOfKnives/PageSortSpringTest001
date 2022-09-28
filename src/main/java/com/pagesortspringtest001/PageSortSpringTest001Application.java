package com.pagesortspringtest001;

import com.pagesortspringtest001.gun.GunModel;
import com.pagesortspringtest001.gun.GunRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PageSortSpringTest001Application {
//2609 2022 Lavet dette for at teste Paging og Sorting i REST.
// Dette projekt har Lombok, Spring Boot DevTools, Spring Web, Spring Data JPA og H2 DB.

    //h2 consol og db lookup virker, kan se gunsne.
    public static void main(String[] args) {
        SpringApplication.run(PageSortSpringTest001Application.class, args);
    }
    @Bean//importData giver os noget data i vores database.
    public CommandLineRunner importData(GunRepository gunRepo) { // den skal bruge et repo

        return (args) -> {

            final List<GunModel> guns = new ArrayList<>(); //en liste
            guns.add(new GunModel("JacBauer")); //vi tilføjer til liste
            guns.add(new GunModel("jaque"));
            guns.add(new GunModel("jAAAaque"));
            guns.add(new GunModel("NIIaque"));
            guns.add(new GunModel("AA"));
            guns.add(new GunModel("aa"));
            guns.add(new GunModel("bbbb"));
            guns.add(new GunModel("optimus"));
            guns.add(new GunModel("græskar"));

            gunRepo.saveAll(guns); //vi sender listen til vores repo

        };
    }
}
 //det  er alt hvad der sker i denne klasse.