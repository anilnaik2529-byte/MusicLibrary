
package com.example.song;

class Song {
    private int songId;
    private String songName;
    private String lyricist;
    private String singer;
    private String musicDirector;

    Song(int id, String name, String lyricist, String singer, String musicDirector) {
        this.songId = id;
        this.songName = name;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getLyricist() {
        return lyricist;
    }

    public String getSinger() {
        return singer;
    }

    public String getMusicDirector() {
        return musicDirector;
    }

    public void setSongId(int id) {
        this.songId = id;
    }

    public void setSongName(String name) {
        this.songName = name;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setMusicDirector(String director) {
        this.musicDirector = director;
    }

}