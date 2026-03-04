/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.song;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.song.SongService;;
import com.example.song.Song;

@RestController
class SongController {
    SongService songService = new SongService();

    @GetMapping("/songs")
    public List<Song> getSongs() {
        return songService.getPlayLists();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongsById(@PathVariable("songId") int songId) {
        return songService.getSongsById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSongsById(@PathVariable("songId") int songId, @RequestBody Song song) {
        return songService.updateSongsById(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSongsById(@PathVariable("songId") int songId) {
        songService.deleteSongsById(songId);
    }
}