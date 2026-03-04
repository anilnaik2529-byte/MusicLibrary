// Write your code here
package com.example.song;

import com.example.song.Song;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository {

    List<Song> getPlayLists();

    Song addSong(Song song);

    Song getSongsById(int id);

    Song updateSongsById(int id, Song song);

    void deleteSongsById(int id);
}