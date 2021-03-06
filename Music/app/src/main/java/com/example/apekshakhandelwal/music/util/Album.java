package com.example.apekshakhandelwal.music.util;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class Album {
    private String mAlbumName;
    private Song[] mSongs;

    public Album(String albumName, Song[] songs) {
        mAlbumName= albumName;
        mSongs = songs;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public void setAlbumName(String albumName) {
        mAlbumName = albumName;
    }

    public Song[] getSongs() {
        return mSongs;
    }

    public void setSongs(Song[] songs) {
        mSongs = songs;
    }

    public String[] getSongNames() {
        int len = mSongs.length;
        String[] songNames = new String[len];
        for(int i=0; i<len; i++) {
            songNames[i] = mSongs[i].getName();
        }
        return songNames;
    }

    @Override
    public String toString() {
        return mAlbumName;
    }
}
