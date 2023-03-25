package com.example.test_nikitina;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class RemoteConfig {
    public String URl;
    public String Key;
    private FirebaseRemoteConfig mfirebaseRemoteConfig;

    public RemoteConfig(String key) {
        Key = key;
    }

    public void getFireBaseUrlConnection(){
        //подключение к FireBase
        mfirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mfirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mfirebaseRemoteConfig.setDefaultsAsync(R.xml.url_values);
    }

    /*

     public void getURLStr(){
        mfirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if(task.isSuccessful()){
                            boolean updated = task.getResult();
                            Log.i("Fire", String.valueOf(task.getResult()));
                            if(task.getResult()) {
                                url_FB = mfirebaseRemoteConfig.getString("key_URL");
                                System.out.println(url_FB + "-_-_-_---_-_-_-------_-------_-_---_--_____---");
                            }else{
                                Toast.makeText(MainActivity.this,"String is clear", Toast.LENGTH_SHORT).show();
                                url_FB ="";
                                System.out.println(url_FB + "-_-_-_---_-_-_-------_-------_-_---_--_____---");
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Failed", Toast.LENGTH_SHORT).show();
                            url_FB ="";
                        }
                    }
                });
    }

    public String getURLStr(Context context){
        mfirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if(task.isSuccessful()){
                            String url = task.getResult();
                            Log.i("Fire", task.getResult());
                                URl = mfirebaseRemoteConfig.getString("key_URL");
                                System.out.println(URl + "-_-_-_---_-_-_-------_-------_-_---_--_____---");

                                //Toast.makeText(context,"String is clear", Toast.LENGTH_SHORT).show();

                                System.out.println(URl + "-_-_-_---_-_-_-------_-------_-_---_--_____---");
                            }
                        else {
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                            URl = "";
                        }
                    }
                });
    }*/
}
