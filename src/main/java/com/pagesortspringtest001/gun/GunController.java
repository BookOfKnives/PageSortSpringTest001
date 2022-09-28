package com.pagesortspringtest001.gun;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //restcontroller-annotation så SpringBoot kan finde den
@RequestMapping("/gun") //denne controller kigger imod /gun
public class GunController {
    private final GunRepository gunRepo;
    private final GunService gunService; //denne klasse skla have både en repo og en service
 //repo'en er repository'et, som giver og tager fra databasen. Servicen tager sig af "business-logic"

    public GunController(GunRepository repository, GunService gunService) {
        this.gunRepo = repository; //dette er konstruktøren, den skal have repo og service
        this.gunService = gunService;
    }

    @GetMapping("/all") //GETs til /all,viser alle guns
    public @ResponseBody Iterable<GunModel> showAllGuns() {

        return gunRepo.findAll();
    }

    @GetMapping("/someguns") //someguns tager imod nogle parametre (pageNo, f.eks) og viser data ud fra dét
    public ResponseEntity<List<GunModel>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "idNumber") String sortBy) {
        List<GunModel> list = gunService.getAllGuns(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<GunModel>>(list, new HttpHeaders(), HttpStatus.OK);
        //den returner et ResponseEntitty, som er en html-pakke.
    }

}
