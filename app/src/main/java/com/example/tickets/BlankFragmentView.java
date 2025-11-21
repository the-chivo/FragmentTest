package com.example.tickets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tickets.Model.GestorTickets;
import com.example.tickets.Model.Ticket;


public class BlankFragmentView extends Fragment {

    Button sendBtn;
    Spinner spinner;
    EditText nameEditText;
    EditText descriptionEditText;
    EditText stepsEditText;

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

            System.out.println(1);
            MainActivity mainActivity = ((MainActivity) getActivity());
            sendBtn = (Button) mainActivity.findViewById(R.id.sendTicketBtn);
            spinner = (Spinner) mainActivity.findViewById(R.id.spinnerView);
            nameEditText = (EditText) mainActivity.findViewById(R.id.nameEditText);
            descriptionEditText = (EditText) mainActivity.findViewById(R.id.descriptionEditText);
            stepsEditText = (EditText) mainActivity.findViewById(R.id.stepsEditText);


            sendBtn.setOnClickListener(v -> {

                String name = nameEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String steps = stepsEditText.getText().toString();
                String spinnerPosition = getSpinnerString(spinner.getSelectedItemPosition());
                System.out.println(spinnerPosition);

                try {
                    if(name.equals("")|| description.equals("") || steps.equals("")){
                        Toast.makeText(mainActivity, "No puede haber campos vacios", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        GestorTickets.getTicketInfo(name, description, steps, spinnerPosition);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private  String getSpinnerString(int itemPosition){
        String spinerstring = "";
        switch (itemPosition){

            case 0:
                spinerstring = "Nuevo";
                break;
            case 1:
                spinerstring = "Abierto";
                break;
            case 2:
                spinerstring = "Pendiente";
                break;
            case 3:
                spinerstring = "Resuelto";
                break;
            case 4:
                spinerstring = "Cerrado";
                break;
        }

        return spinerstring;
    }

    public void setTicketView(Ticket ticket){

        System.out.println(2);
        String a = ticket.getName();
        nameEditText.setText(ticket.getName());
        System.out.println(nameEditText.getText());
        descriptionEditText.setText(ticket.getDescription());

    }


}