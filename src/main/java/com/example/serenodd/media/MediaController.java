package com.example.serenodd.media;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/media")
@AllArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @GetMapping
    public List<Media> getAllMedias() {
        return mediaService.getAllMedias();
    }

    @GetMapping("{mediaId}")
    public Optional<Media> getMediaById(
            @PathVariable("mediaId") Long mediaId) {
        return mediaService.getMediaById(mediaId);
    }

    @PostMapping
    public void addMedia(@RequestBody Media media) {
        //check if title is taken
        mediaService.addMedia(media);
    }

    @PutMapping("{mediaId}")
    public ResponseEntity updateMedia(@PathVariable("mediaId") Long mediaId,
                                      @RequestBody Media mediaInput
    ) {
        return mediaService.updateMedia(mediaId, mediaInput);
    }

    @PatchMapping("/{mediaId}")
    public ResponseEntity patchMedia(@PathVariable long mediaId, @RequestBody Map<String, Object> changes) {
        return mediaService.patchMedia(mediaId, changes);
    }

    @DeleteMapping(path = "{mediaId}")
    public void deleteMedia(@PathVariable("mediaId") Long mediaId) {
        mediaService.deleteMedia(mediaId);
    }


}
