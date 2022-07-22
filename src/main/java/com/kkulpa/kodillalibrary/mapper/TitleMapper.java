package com.kkulpa.kodillalibrary.mapper;

import com.kkulpa.kodillalibrary.domain.Title;
import com.kkulpa.kodillalibrary.domain.TitleDto;
import org.springframework.stereotype.Service;

@Service
public class TitleMapper {

    public Title mapToTitle(TitleDto titleDto){
        return new Title(0,
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getReleaseDate()
                );


    }


}
