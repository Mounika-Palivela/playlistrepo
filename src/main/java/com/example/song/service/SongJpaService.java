package com.example.song.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.song.repository.SongRepository;
import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import com.example.song.repository.SongJpaRepository;
import  com.example.song.model.Song;
import java.util.*;

@Service
public class SongJpaService implements SongRepository{

    @Autowired
    private SongJpaRepository songJpaRepository;

    @Override
    public void deleteSong(int songId){
        try{
            songJpaRepository.deleteById(songId);
        }
         catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Song updateSong(int songId,Song song){
        try{
            Song tobeupdated = songJpaRepository.findById(songId).get();
            if(song.getsongName() != null){
                tobeupdated.setsongName(song.getsongName());
            }
            if(song.getlyricist() != null){
                tobeupdated.setlyricist(song.getlyricist());
            }
            if(song.getsinger() != null){
                tobeupdated.setsinger(song.getsinger());
            }
            if(song.getmusicDirector() != null){
                tobeupdated.setmusicDirector(song.getmusicDirector());
            }
            songJpaRepository.save(tobeupdated);
            return tobeupdated;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public Song getSong(int songId){
        try{
            Song song = songJpaRepository.findById(songId).get();
            return song;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ArrayList<Song> getallsongs(){
        List<Song> songslist = songJpaRepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(songslist);
        return songs;
        
    }

    @Override
    public Song addSong(Song song){
        songJpaRepository.save(song);
        return song;
    }
    
}

















