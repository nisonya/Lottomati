package com.example.test_nikitina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.test_nikitina.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    private static final String FILE_NAME="MY_FILE_NAME";
    private static final String URL_STRING="URL_STRING";
    String url_str;
    SharedPreferences sPref;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sPref = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        url_str = sPref.getString(URL_STRING,"");
        if(url_str=="") {
            ed = sPref.edit();
            ed.putString(URL_STRING, "dsdf");
            ed.apply();
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            txt = (TextView) findViewById(R.id.textView);
//recycler
            musclesList = findViewById(R.id.RecyclerMuscles);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            musclesList.setLayoutManager(layoutManager);
//recycler listener
            MusclesAdapter.OnMusclesClickListener onMusclesClickListener = new MusclesAdapter.OnMusclesClickListener() {
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
            musclesAdapter = new MusclesAdapter(muscles, onMusclesClickListener);
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
            binding.bottomNavigationView.setOnItemSelectedListener(item -> {

                switch (item.getItemId()) {
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
        }else{
            browse();
        }
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

    private boolean checkIsEmu() {
        if (BuildConfig.DEBUG) return false;
        String phoneModel = Build.MODEL;
        String buildProduct = Build.PRODUCT;
        String buildHardware = Build.HARDWARE;
        String brand = Build.BRAND;
        return (Build.FINGERPRINT.startsWith("generic")
                || phoneModel.contains("google_sdk")
                || phoneModel.toLowerCase(Locale.getDefault()).contains("droid4x")
                || phoneModel.contains("Emulator")
                || phoneModel.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || buildHardware.equals("goldfish")
                || brand.contains("google")
                || buildHardware.equals("vbox86")
                || buildProduct.equals("sdk")
                || buildProduct.equals("google_sdk")
                || buildProduct.equals("sdk_x86")
                || buildProduct.equals("vbox86p")
                || Build.BOARD.toLowerCase(Locale.getDefault()).contains("nox")
                || Build.BOOTLOADER.toLowerCase(Locale.getDefault()).contains("nox")
                || buildHardware.toLowerCase(Locale.getDefault()).contains("nox")
                || buildProduct.toLowerCase(Locale.getDefault()).contains("nox"))
                || (brand.startsWith("generic") && Build.DEVICE.startsWith("generic"));
    }

    public void goToBroswer(View view) {
        browse();
    }
    public void browse(){
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);
    }
    public static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        return false;
    }
}