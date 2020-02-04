package com.example.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost host = getTabHost();
        //첫번째 탭
        TabHost.TabSpec tabSpecSong =host.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);
        host.addTab(tabSpecSong);
        //두번째 탭
        TabHost.TabSpec tabSpecArtist =host.newTabSpec("Artist").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        host.addTab(tabSpecArtist);
        //세번째 탭
        TabHost.TabSpec tabSpecAlbum =host.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        host.addTab(tabSpecAlbum);
        //처음에 보이는 탭 ,정의 안해도 됨 ,
        host.setCurrentTab(0); //이렇게하면 실행할 때 첫번재 탭이 나옴 1은 2번째
    }
}
