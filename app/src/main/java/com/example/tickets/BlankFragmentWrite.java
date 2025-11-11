package com.example.tickets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragmentWrite extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_write, container, false);
    }

    public void onStart() {
        super.onStart();
        if(getActivity() instanceof MainActivity){

            ((MainActivity) getActivity()).test();
        }
    }
}