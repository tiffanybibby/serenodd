package com.example.serenodd.media;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/media")
@AllArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @GetMapping
    public List<Media> getAllMedias() {
        return mediaService.getAllMedias();
    }

}
