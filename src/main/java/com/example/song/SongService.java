
package com.example.song;

import java.util.*;

import org.springframework.http.HttpStatus;
import com.example.song.Song;
import com.example.song.SongRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    int uniqueId = 6;

    
    @Override
    public List<Song> getPlayLists() {
        Collection<Song> colSongs = playlist.values();
        List<Song> list = new ArrayList<>(colSongs);
        return list;
    }

    @Override
    public Song getSongsById(int id) {
        Song exist = playlist.get(id);
        if (exist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return exist;
    }

    @Override
    public void deleteSongsById(int id) {
        Song exist = playlist.get(id);
        if (exist != null) {
            playlist.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song) {
        song.setSongId(uniqueId);
        playlist.put(uniqueId, song);
        uniqueId++;
        return song;
    }

    @Override
    public Song updateSongsById(int id, Song song) {
        Song exist = playlist.get(id);
             if (exist == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            if (song.getSongName() != null) {
                exist.setSongName(song.getSongName());
            }
            if (song.getLyricist() != null) {
                exist.setLyricist(song.getLyricist());
            }
            if (song.getSinger() != null) {
                exist.setSinger(song.getSinger());
            }
            if (song.getMusicDirector() != null) {
                exist.setMusicDirector(song.getMusicDirector());
            }

            return exist;

    }

}