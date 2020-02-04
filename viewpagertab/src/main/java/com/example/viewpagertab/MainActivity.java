package com.example.viewpagertab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabs;
    ViewPager viewPager;
    RadioButton rdoCat,rdoRabbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabs=(TabLayout)findViewById(R.id.tabs);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabs.addTab(tabs.newTab().setText("동물선택"));
        tabs.addTab(tabs.newTab().setText("토스트"));
        tabs.addTab(tabs.newTab().setText("사진회전"));
        tabs.setTabGravity(tabs.GRAVITY_FILL);
        MypagerAdapter adapter=new MypagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(adapter);
        // 탭 메뉴를 클릭하면 해당 프레그먼트를 변경하는 명령어
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        //뷰페이저를 밀면 탭메뉴를 변경
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        rdoCat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(true){

                }
            }
        });

    }
    public class MypagerAdapter extends FragmentPagerAdapter {
        int mNumOfTabs; //tab의 개수

        public MypagerAdapter(FragmentManager fm, int mNumOfTabs) {
            super(fm);
            this.mNumOfTabs = mNumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    SongFragment songTab = new SongFragment();

                    return songTab;
                case 1:
                    ArtistFragment artistTab = new ArtistFragment();
                    return artistTab;
                case 2:
                    AlbumFragment albumTab = new AlbumFragment();
                    return albumTab;


            }
            return null;
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
