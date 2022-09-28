package com.pagesortspringtest001.gun;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GunService {
//service-klasse. den håndterer businesslogik
    GunRepository gunRepository;

    public GunService(GunRepository gunRepo) {
        this.gunRepository = gunRepo;
    }

    public List<GunModel> getAllGuns(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<GunModel> pagedResult = gunRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

        }

