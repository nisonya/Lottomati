package com.example.test_nikitina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test_nikitina.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextView txt;
    ArrayList<Muscles> muscles;
    MusclesAdapter musclesAdapter;
    RecyclerView musclesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txt = (TextView) findViewById(R.id.textView);
//recycler
        musclesList = findViewById(R.id.RecyclerMuscles);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        musclesList.setLayoutManager(layoutManager);
//recycler listener
        MusclesAdapter.OnMusclesClickListener onMusclesClickListener  = new MusclesAdapter.OnMusclesClickListener() {
            @Override
            public void onMusclesClick(Muscles muslesItem) {
                Toast.makeText(getApplicationContext(), String.valueOf(muslesItem.getId()),
                        Toast.LENGTH_SHORT).show();
            }
        };

        //create database
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Muscles (id Integer PRIMARY KEY, id_group Integer NOT NULL, name TEXT NOT NULL, photo Text NOT NULL);");

        //add muscles data
        ArrayList<Muscles> muscles = new ArrayList<Muscles>(5);
        Muscles mMuscles = new Muscles(1,1,"first", "asd");
        muscles.add(mMuscles);
        mMuscles = new Muscles(2,1,"second","asd");
        muscles.add(mMuscles);
        mMuscles = new Muscles(3,1,"third","asd");
        muscles.add(mMuscles);
        mMuscles = new Muscles(4,1,"forth","asd");
        muscles.add(mMuscles);
        mMuscles = new Muscles(5,1,"fitf","asd");
        muscles.add(mMuscles);
        //recycler adapter
        musclesAdapter = new MusclesAdapter(muscles,onMusclesClickListener);
        musclesList.setAdapter(musclesAdapter);
//bottom navigation
        binding.bottomNavigationView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){
                case R.id.chest:
                    txt.setText("Chest + triceps");
                    break;
                case R.id.legs:
                    txt.setText("Legs + shoulders");
                    break;
                case R.id.biceps:
                    txt.setText("Biceps + back");
                    break;
            }
            return true;
        });
    }
}