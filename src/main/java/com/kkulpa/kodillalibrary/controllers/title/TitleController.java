package com.kkulpa.kodillalibrary.controllers.title;


import com.kkulpa.kodillalibrary.domain.Title;
import com.kkulpa.kodillalibrary.domain.TitleDto;
import com.kkulpa.kodillalibrary.domain.User;
import com.kkulpa.kodillalibrary.domain.UserDTO;
import com.kkulpa.kodillalibrary.mapper.TitleMapper;
import com.kkulpa.kodillalibrary.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/title")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TitleController {

    private final TitleDbService titleDbService;
    private final TitleMapper titleMapper;

    @GetMapping
    public ResponseEntity<List<Title>> getTitles(){
        return ResponseEntity.ok(titleDbService.getAllTitles());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTitle (@RequestBody TitleDto titleDto){
        Title title = titleMapper.mapToTitle(titleDto);
        titleDbService.saveTitle(title);
        return ResponseEntity.ok().build();
    }

}
