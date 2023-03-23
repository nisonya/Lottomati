package com.example.test_nikitina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.example.test_nikitina.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextView txt;
    MusclesAdapter musclesAdapter;
    RecyclerView musclesList;
    ArrayList<Muscles> muscles;
    List<Integer> id_grp= Base.getId_group();
    List<String> names= Base.getName_muscle();

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
//bottom navigation
        binding.bottomNavigationView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){
                case R.id.chest:
                    txt.setText("Chest + triceps");
                    getMuscleForGroup(2);

                    musclesAdapter = new MusclesAdapter(muscles,onMusclesClickListener);
                    musclesList.setAdapter(musclesAdapter);
                    break;
                case R.id.legs:
                    txt.setText("Legs + shoulders");
                    getMuscleForGroup(1);
                    musclesAdapter = new MusclesAdapter(muscles,onMusclesClickListener);
                    musclesList.setAdapter(musclesAdapter);
                    break;
                case R.id.biceps:
                    txt.setText("Biceps + back");
                    getMuscleForGroup(3);
                    musclesAdapter = new MusclesAdapter(muscles,onMusclesClickListener);
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

    public void muscleRV(){

    }
}