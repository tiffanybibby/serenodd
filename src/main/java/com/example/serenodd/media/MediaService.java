package com.example.serenodd.media;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    public List<Media> getAllMedias() {
        return mediaRepository.findAll();
    }

}
