package com.example.serenodd.media;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
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

    private Long id;
    private String name;
    private String description;
    private String source;
    private String audio;
    private String image;
    private String title;
    private Integer likes;
    private Integer dislikes;
    private Type type;
}
