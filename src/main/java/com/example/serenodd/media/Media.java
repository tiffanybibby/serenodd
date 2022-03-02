package com.example.serenodd.media;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Media {
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
