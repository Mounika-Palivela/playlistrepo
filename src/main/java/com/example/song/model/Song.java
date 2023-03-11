package com.example.song.model;

 import javax.persistence.*;
 
@Entity
@Table(name="playlist")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "songid")
    private int songId;

    @Column(name = "songname")
    private String songName;

    @Column(name = "lyricist")
    private String lyricist; 

    @Column(name = "singer")
    private String singer;

    @Column(name = "musicdirector")
    private String musicDirector;

    public Song(){}

    public int getsongId(){
        return songId;
    }
    public void setsongId(int songId){
        this.songId=songId;
    }
    public String getsongName(){
        return songName;
    }
    public void setsongName(String songName){
        this.songName = songName;
    }
    public String getlyricist(){
        return lyricist;
    }
    public void setlyricist(String lyricist){
        this.lyricist = lyricist;
    }
    public String getsinger(){
        return singer;
    }
    public void setsinger(String singer){
        this.singer = singer;
    } 
    public String getmusicDirector(){
        return musicDirector;
    }
    public void setmusicDirector(String musicDirector){
        this.musicDirector = musicDirector;
    }




}
