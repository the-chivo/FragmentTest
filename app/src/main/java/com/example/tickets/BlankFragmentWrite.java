package com.example.tickets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tickets.Model.Ticket;

import java.util.List;

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

            MainActivity mainActivity = ((MainActivity) getActivity());
            LinearLayout btnLayout = (LinearLayout) mainActivity.findViewById(R.id.linearLayout);
            createTicketBtn(btnLayout, mainActivity);
            createTicketBtn(btnLayout, mainActivity);
        }
    }

    public static void setTicketList(List<Ticket> listaTickets){

        for (int i = 0; i <= listaTickets.size(); i++){

        }
    }

    public static void createTicketBtn( LinearLayout btnLayout, MainActivity mainActivity){

        Button boton = new Button(mainActivity);
        boton.setText("a");
        btnLayout.addView(boton);
    }
}