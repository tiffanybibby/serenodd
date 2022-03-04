package com.example.serenodd.media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    @Query("SELECT m FROM Media m WHERE m.name = ?1")
    Optional<Media> findMediaByName(String name);

    @Query("SELECT m FROM Media m WHERE m.title = ?1")
    Optional<Media> findMediaByTitle(String title);

    @Query("SELECT m FROM Media m WHERE m.name = ?1 AND m.title = ?2")
    List<Media> findMediaByNameEqualsAndTitleEquals(String name, String title);

    @Transactional
    @Modifying
    @Query("UPDATE Media m SET m.name = ?1 WHERE m.id = ?2")
    int updateName(String name, Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Media m WHERE m.id = ?1")
    int deleteMediaById(Long id);

}
