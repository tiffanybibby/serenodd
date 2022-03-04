package com.example.serenodd.media;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    public List<Media> getAllMedias() {
        return mediaRepository.findAll();
    }

    public Optional<Media> getMediaById(Long mediaId) {
        return mediaRepository.findById(mediaId);
    }

    public void addMedia(Media media) {
//        check if title is taken
        mediaRepository.save(media);
    }

//    @Transactional
//    public void updateMediaDetails(Long mediaId, String name) {
//        boolean exists = mediaRepository.existsById(mediaId);
//        if (!exists) {
//            throw new IllegalStateException(
//                    "media with id " + mediaId + " does not exist"
//            );
//        }
//        mediaRepository.updateName(name, mediaId);
////        mediaRepository.updateDescription(description, mediaId);
//    }

    @Transactional
    public ResponseEntity updateMedia(long mediaId, Media mediaInput){
        boolean exists = mediaRepository.existsById(mediaId);
        if (!exists) {
            throw new IllegalStateException(
                    "media with id " + mediaId + " does not exist"
            );
        }

        Media media = mediaRepository.findById(mediaId).get();
        media.setName(mediaInput.getName());
        media.setDescription(mediaInput.getDescription());
        media.setSource(mediaInput.getSource());
        media.setAudio(mediaInput.getAudio());
        media.setImage(mediaInput.getImage());
        media.setTitle(mediaInput.getTitle());
        media.setLikes(mediaInput.getLikes());
        media.setDislikes(mediaInput.getDislikes());
        media.setType(mediaInput.getType());


        mediaRepository.save(media);
        return ResponseEntity.ok(media);
    }




    public void deleteMedia(Long mediaId) {
        boolean exists = mediaRepository.existsById(mediaId);
        if (!exists) {
            throw new IllegalStateException(
                    "media with id " + mediaId + " does not exist"
            );
        }
        mediaRepository.deleteMediaById(mediaId);
    }

    @Transactional
    public ResponseEntity patchMedia(long mediaId, Map<String, Object> changes) {
        Media media = mediaRepository.findById(mediaId).get();

        changes.forEach(
                (change, value) -> {
                    switch (change) {
                        case "name" -> media.setName((String) value);
                        case "description" -> media.setDescription((String) value);
                        case "source" -> media.setSource((String) value);
                        case "audio" -> media.setAudio((String) value);
                        case "image" -> media.setImage((String) value);
                        case "title" -> media.setTitle((String) value);
                        case "likes" -> media.setLikes((Integer) value);
                        case "dislikes" -> media.setDislikes((Integer) value);
                        case "type" -> media.setType((Type) value);
                    }
                }
        );
        mediaRepository.save(media);
        return ResponseEntity.ok(media);
    }
}
