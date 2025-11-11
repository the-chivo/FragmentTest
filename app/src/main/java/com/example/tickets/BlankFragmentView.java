package com.example.tickets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class BlankFragmentView extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank_view, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(getActivity() instanceof MainActivity){

            ((MainActivity) getActivity()).test();   //obtienes acceso a la main activity
        }
    }
}