package com.example.actionbartab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong, tabArtist, tabAlbum;
    MyTabFragment myFrags[]=new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //xml 사용안함
        ActionBar bar =getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //첫번째탭
        tabSong=bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);//탭누를때마다 작동
        bar.addTab(tabSong);

        //두번째 탭
        tabArtist=bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);//탭누를때마다 작동
        bar.addTab(tabArtist);
        //세번째 탭
        tabAlbum=bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);//탭누를때마다 작동
        bar.addTab(tabAlbum);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag=null;
        if(myFrags[tab.getPosition()]==null) {
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle(); //번들은 키와 값을 전달하기위해 만듬
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;

        } else {
            myTabFrag=myFrags[tab.getPosition()];
        }
        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
    public static class MyTabFragment extends Fragment {
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            tabName=data.getString("tabName");

        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout=new LinearLayout(super .getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);
            if(tabName.equals("음악별")) {
                baseLayout.setBackgroundColor(Color.YELLOW);

            } else if(tabName.equals("가수별")){
                baseLayout.setBackgroundColor(Color.GREEN);

            } else if(tabName.equals("앨범별")){
                baseLayout.setBackgroundColor(Color.BLUE);
            }
            return baseLayout;
        }
    }
}
