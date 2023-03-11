package com.example.song.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import  com.example.song.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.song.repository.SongRepository;
import com.example.song.service.SongJpaService;

@RestController
public class SongController{

    @Autowired
    private SongJpaService songJpaService;

    @GetMapping("/songs")
    public ArrayList<Song> getallsongs(){
        return songJpaService.getallsongs();
    }
    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable("songId") int songId){
        return songJpaService.getSong(songId);
    }
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songJpaService.addSong(song);
    }
    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song){
        return songJpaService.updateSong(songId,song);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
        songJpaService.deleteSong(songId);
    }
}
 