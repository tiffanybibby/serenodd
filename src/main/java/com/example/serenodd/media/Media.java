package com.example.serenodd.media;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Media")
@Table(
        name = "media",
        uniqueConstraints = {
                @UniqueConstraint(name = "title_unique", columnNames = "title")
        }
)
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Media {

    @Id
    @SequenceGenerator(
            name = "media_sequence",
            sequenceName = "media_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "media_sequence"
    )
    @Column(
            updatable = false)
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "TEXT")
    private String name;

    @Column(
            columnDefinition = "TEXT")
//    @Column(length = 500)
    private String description;
    @Column(
            columnDefinition = "TEXT")
    private String source;
    @Column(
            columnDefinition = "TEXT")
    private String audio;
    @Column(
            columnDefinition = "TEXT")
    private String image;
    @Column(
            nullable = false,
            columnDefinition = "TEXT")
    private String title;
    @Column(
    )
    private Integer likes;
    @Column(
    )
    private Integer dislikes;
    @Column(
            nullable = false,
            columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private Type type;

    public Media(String name, String description, String source, String audio, String image, String title, Integer likes, Integer dislikes, Type type) {
        this.name = name;
        this.description = description;
        this.source = source;
        this.audio = audio;
        this.image = image;
        this.title = title;
        this.likes = likes;
        this.dislikes = dislikes;
        this.type = type;
    }
}
