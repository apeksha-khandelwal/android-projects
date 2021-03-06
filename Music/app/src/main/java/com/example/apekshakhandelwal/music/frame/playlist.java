package com.example.apekshakhandelwal.music.frame;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.apekshakhandelwal.music.R;
import com.example.apekshakhandelwal.music.Viewer;
import com.example.apekshakhandelwal.music.albums;

import java.util.ArrayList;

import com.example.apekshakhandelwal.music.util.Album;
import com.example.apekshakhandelwal.music.util.Playlist;
import com.example.apekshakhandelwal.music.util.Song;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class playlist extends Fragment {
    ArrayAdapter<Playlist> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View playlist = inflater.inflate(R.layout.f_playlist, container, false);
        ListView listView = (ListView) playlist.findViewById(R.id.listView);

        final ArrayList<Playlist> items = new ArrayList<Playlist>();
        Song song1 = new Song(getString(R.string.song_1),getString(R.string.artist_1),getString(R.string.album_1));
        Song song2 = new Song(getString(R.string.song_2), getString(R.string.artist_2), getString(R.string.album_2));
        Song song3 = new Song(getString(R.string.song_3), getString(R.string.artist_1), getString(R.string.album_1));
        Song song4 = new Song(getString(R.string.song_4), getString(R.string.artist_2), getString(R.string.album_2));
        Album album1 = new Album(getString(R.string.album_1), new Song[]{song1, song3});
        Album album2 = new Album(getString(R.string.album_2), new Song[]{song2, song4});
        Playlist playlist1 = new Playlist(getString(R.string.playlist_1), new Song[]{song3, song4});
        Playlist playlist2 = new Playlist(getString(R.string.playlist_2), new Song[]{song2, song4});
        song2.setPlaylist(new Playlist[]{playlist2});
        song3.setPlaylist(new Playlist[]{playlist1});
        song4.setPlaylist(new Playlist[]{playlist1, playlist2});
        items.add(playlist1);
        items.add(playlist2);

        mAdapter = new ArrayAdapter<Playlist>(getActivity(), R.layout.f_playlist, items);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                        {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                Intent intent = new Intent(getActivity(), Viewer.class);
                                                intent.putExtra("playlist", items.get(position).getPlaylistName());
                                                intent.putExtra("songs", items.get(position).getSongNames());
                                                Log.v("playlist songs", items.get(position).getSongNames()[0]);
                                                intent.putExtra("fragment", "Playlist");
                                                startActivity(intent);
                                            }
                                        }
        );
        return playlist;
    }
}

