package com.example.tickets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class BlankFragmentView extends Fragment {

    public int a;


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

            MainActivity mainActivity = ((MainActivity) getActivity());
            Button sendBtn = (Button) mainActivity.findViewById(R.id.sendTicketBtn);
            Spinner spinner = (Spinner) mainActivity.findViewById(R.id.spinner);
            EditText nameEditText = (EditText) mainActivity.findViewById(R.id.nameEditText);
            EditText descriptionEditText = (EditText) mainActivity.findViewById(R.id.descriptionEditText);
            EditText stepsEditText = (EditText) mainActivity.findViewById(R.id.stepsEditText);

            String name = nameEditText.getText().toString();
            String description = descriptionEditText.getText().toString();
            String steps = stepsEditText.getText().toString();

            sendBtn.setOnClickListener(v -> {
                try {
                    if(name.equals("")|| description.equals("") ){

                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}