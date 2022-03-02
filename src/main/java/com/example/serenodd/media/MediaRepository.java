package com.example.serenodd.media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

    @Query("SELECT s FROM Media s WHERE s.name = ?1")
    Optional<Media> findMediaByName(String name);

}
