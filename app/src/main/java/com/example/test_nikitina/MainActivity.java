package com.example.test_nikitina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.test_nikitina.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextView txt;
    MusclesAdapter musclesAdapter;
    ExersiseAdapter exersiseAdapter;
    RecyclerView musclesList, exersiseList;
    ArrayList<Muscles> muscles;
    ArrayList<Exersise> exersises;
    List<Integer> id_grp= Base.getId_group();
    List<Integer> id_musle= Base.getId_musle();
    List<String> names= Base.getName_muscle();
    List<String> name_exer= Base.getName_exer();
    List<String> photo= Base.getPhoto();
    List<Integer> descr= Base.getDescr();
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        txt = (TextView) findViewById(R.id.textView);
//recycler
        musclesList = findViewById(R.id.RecyclerMuscles);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        musclesList.setLayoutManager(layoutManager);
//recycler listener
        MusclesAdapter.OnMusclesClickListener onMusclesClickListener  = new MusclesAdapter.OnMusclesClickListener() {
            @Override
            public void onMusclesClick(Muscles muslesItem) {
                Toast.makeText(getApplicationContext(), String.valueOf(muslesItem.getId()),
                        Toast.LENGTH_SHORT).show();
            }
        };

        //add muscles data
        muscles = new ArrayList<>();
        getMuscleForGroup(1);
        // recycler adapter
        musclesAdapter = new MusclesAdapter(muscles,onMusclesClickListener);
        musclesList.setAdapter(musclesAdapter);



        //recycler for Exersise
        exersiseList = findViewById(R.id.RecyclerExersise);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        exersiseList.setLayoutManager(layoutManager2);
        //add muscles data
        exersises = new ArrayList<>();
        getExForMuscles(1);
        // recycler adapter
        exersiseAdapter = new ExersiseAdapter(exersises);
        exersiseList.setAdapter(exersiseAdapter);



//bottom navigation
        binding.bottomNavigationView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){
                case R.id.chest:
                    txt.setText("Chest + triceps");
                    getMuscleForGroup(2);
                    musclesList.setAdapter(musclesAdapter);
                    break;
                case R.id.legs:
                    txt.setText("Legs + shoulders");
                    getMuscleForGroup(1);
                    musclesList.setAdapter(musclesAdapter);
                    break;
                case R.id.biceps:
                    txt.setText("Biceps + back");
                    getMuscleForGroup(3);
                    musclesList.setAdapter(musclesAdapter);
                    break;
            }
            return true;
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        //myDBManeger.openDB();
    }
    public void getMuscleForGroup(int id_group){
        muscles.clear();
        for(int i = 0; i<12; i++){
            if(id_grp.get(i)==id_group){
                Muscles mMuscle = new Muscles(i+1,id_grp.get(i),names.get(i));
                muscles.add(mMuscle);
            }
        }
    }
    public void getExForMuscles(int id_muscle){
        exersises.clear();
        for(int i = 0;i < id_musle.size(); i++){
            if(id_musle.get(i)==id_muscle){
                Exersise mExersise= new Exersise(i+1,id_musle.get(i),name_exer.get(i), photo.get(i), descr.get(i));
                exersises.add(mExersise);
            }
        }
    }

    public void muscleRV(){

    }
}