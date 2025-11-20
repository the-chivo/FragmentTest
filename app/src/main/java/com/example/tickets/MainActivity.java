package com.example.tickets;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tickets.Model.GestorTickets;
import com.example.tickets.Model.Ticket;
import com.example.tickets.Model.ticketsEstados;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    BlankFragmentView fragmentView;
    BlankFragmentWrite fragmentWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
        startActivity(intent);




        Button fragmentViewBtn = (Button) findViewById(R.id.button);
        Button fragmentWriteBtn = (Button) findViewById(R.id.button1);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transact = fragmentManager.beginTransaction();

        fragmentView = new BlankFragmentView();
        fragmentWrite = new BlankFragmentWrite();
        transact.replace(R.id.fragmentContainer, fragmentView);
        transact.commit();

        fragmentWriteBtn.setOnClickListener(v -> {

            try {
                FragmentTransaction writeTransact = fragmentManager.beginTransaction();
                writeTransact.replace(R.id.fragmentContainer, fragmentWrite);
                writeTransact.commit();

            } catch (Exception e) {
                System.out.println(e);
            }
        });

        fragmentViewBtn.setOnClickListener(v -> {

            try {
                FragmentTransaction viewTransact = fragmentManager.beginTransaction();
                viewTransact.replace(R.id.fragmentContainer, fragmentView);
                viewTransact.commit();
            } catch (Exception e) {
                System.out.println(e);
            }
        });



    }

    public void test(){

    }


}