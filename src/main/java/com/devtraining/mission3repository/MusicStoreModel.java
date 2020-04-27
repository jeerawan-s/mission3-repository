package com.devtraining.mission3repository;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class MusicStoreModel {
    private String id;
    private String song;
    private String artist;
    private String album;

}