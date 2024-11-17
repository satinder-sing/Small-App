package com.example.smallapp.main.basic;

import android.app.Dialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smallapp.databinding.ActivityKillNoteRecyclerBinding;

import com.example.smallapp.R;

import java.util.ArrayList;
import java.util.List;

public class KillNoteRecyclerActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityKillNoteRecyclerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kill_note_recycler);
        RecyclerView recyclerView = findViewById(R.id.kill_note_recycler);
        FloatingActionButton fltButton = findViewById(R.id.custom_fab);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<KillNoteModel> hitList = new ArrayList<>();

        hitList.add(new KillNoteModel("", "RamPal", "Super Dumb"));
        hitList.add(new KillNoteModel("", "Janwar", "Super Ugly"));
        hitList.add(new KillNoteModel("", "Ishu", "Super short"));
        hitList.add(new KillNoteModel("", "Gur", "Super Black"));
        hitList.add(new KillNoteModel("", "Neelu", "Super Annoying"));
        hitList.add(new KillNoteModel("", "Ishu", "Super short"));


        KillNoteRecylerAdapter killNoteRecylerAdapter = new KillNoteRecylerAdapter(this, hitList);
        recyclerView.setAdapter(killNoteRecylerAdapter);

        fltButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(KillNoteRecyclerActivity.this);
                dialog.setContentView(R.layout.custom_dialouge_layout);
                EditText nameTxt = dialog.findViewById(R.id.name);
                EditText reasonTxt = dialog.findViewById(R.id.reason);
                Button buttonSubmit = dialog.findViewById(R.id.submit_button);
                dialog.show();
                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "";
                        name = nameTxt.getText().toString();
                        String reason = "";
                        reason = reasonTxt.getText().toString();
                        if (name.equalsIgnoreCase("")) {
                            Toast.makeText(KillNoteRecyclerActivity.this, "Enter name", Toast.LENGTH_SHORT);

                        }
                        else {
                            hitList.add(new KillNoteModel("",name,reason));
                            killNoteRecylerAdapter.notifyItemInserted(hitList.size()-1);
                            recyclerView.scrollToPosition(hitList.size()-1);
                            dialog.dismiss();
                        }
                    }
                });
            }
        });

    }


}