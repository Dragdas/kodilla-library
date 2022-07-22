package com.kkulpa.kodillalibrary.service;

import com.kkulpa.kodillalibrary.controllers.title.TitleNotFoundException;
import com.kkulpa.kodillalibrary.domain.Title;
import com.kkulpa.kodillalibrary.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TitleDbService {

    private final TitleRepository titleRepository;

    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    public List<Title> getAllTitles(){
        return titleRepository.findAll();
    }

    public Title getTitle(long titleId) throws TitleNotFoundException{

        return titleRepository.findById(titleId).orElseThrow(TitleNotFoundException::new);
    }

}
