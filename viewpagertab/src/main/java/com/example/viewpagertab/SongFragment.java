package com.example.viewpagertab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;


public class SongFragment extends Fragment {

    public SongFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fsView=inflater.inflate(R.layout.fragment_song,container,false);
        RadioButton fsrdoDog=(RadioButton)fsView.findViewById(R.id.fsrdoDog);
        RadioButton fsrdoRabbit=(RadioButton)fsView.findViewById(R.id.fsrdoRabbit);
        RadioButton fsrdoCat=(RadioButton)fsView.findViewById(R.id.fsrdoCat);
        final ImageView fsivPet=(ImageView)fsView.findViewById(R.id.fsivPet);
        fsrdoDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsivPet.setImageResource(R.drawable.dog);
            }
        });
        fsrdoCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsivPet.setImageResource(R.drawable.cat);

            }
        });
        fsrdoRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsivPet.setImageResource(R.drawable.rabbit);
            }
        });
        return fsView;
    }


}