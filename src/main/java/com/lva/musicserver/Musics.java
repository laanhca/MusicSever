package com.lva.musicserver;

import lombok.Data;
import org.springframework.stereotype.Component;


public class Musics {
    public String linkImage;
    public String songName;
    public String artistName;
    public String linkSong;


    public Musics(String linkImage, String songName, String artistName, String linkSong ) {
        this.linkImage = linkImage;
        this.songName = songName;
        this.artistName = artistName;
        this.linkSong = linkSong;
       ;
    }
}
