package com.example.actionbartab2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    MyTabFragment MyFrags[]=new MyTabFragment[4];
    ActionBar.Tab petTabs[]=new ActionBar.Tab[4];
   static Integer iconIDs[]={R.drawable.icon_dog, R.drawable.icon_cat, R.drawable.icon_rabbit, R.drawable.icon_horse};
   static Integer imageIDs[]={R.drawable.dog, R.drawable.cat, R.drawable.rabbit, R.drawable.horse};
   static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar=getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for(int i=0; i<petTabs.length; i++){
            petTabs[i]=bar.newTab();
            petTabs[i].setIcon(iconIDs[i]);
            petTabs[i].setTabListener(this);
            bar.addTab(petTabs[i]);
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFragment=null;
        int index=tab.getPosition();
        position=index;
        if(MyFrags[index]==null) {
            myTabFragment = new MyTabFragment();
            Bundle data = new Bundle();
            data.putInt("iconID", iconIDs[index]);
            myTabFragment.setArguments(data);
            MyFrags[index] = myTabFragment;
        }else{
            myTabFragment=MyFrags[tab.getPosition()];
        }
        ft.replace(android.R.id.content,myTabFragment);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
   public static class MyTabFragment extends Fragment {
        int iconID;
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            iconID=data.getInt("iconID");


        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View myView=inflater.inflate(R.layout.fragment,null);
            ImageView ivFragPet=(ImageView)myView.findViewById(R.id.ivFragPet);
            if(iconID==iconIDs[position]){
                ivFragPet.setImageResource(imageIDs[position]);
            }


            return myView;
        }
    }
}
