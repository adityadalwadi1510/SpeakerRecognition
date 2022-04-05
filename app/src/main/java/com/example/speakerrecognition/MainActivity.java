package com.example.speakerrecognition;

import static android.Manifest.permission.RECORD_AUDIO;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    EditText editText;
    Button button, btnStart, btnStop;
    ArrayList<String> list;
    private MediaRecorder rec;
    String TAG="Main";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btnStart = findViewById(R.id.start);
//        btnStop = findViewById(R.id.stop);
        editText = findViewById(R.id.num);
        button = findViewById(R.id.sub);

        recyclerView = findViewById(R.id.rec);

        String file_path = getApplicationContext().getFilesDir().getPath();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{RECORD_AUDIO},20);
        }
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new Adapter(getApplicationContext(), list,this);
        rec=new MediaRecorder();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString().trim();
                Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();

                Integer n = Integer.parseInt(s);
                Toast.makeText(MainActivity.this, ""+n, Toast.LENGTH_SHORT).show();
                list.clear();
                for (int i = 0; i < n; i++) {
                    list.add("" + i);
                }
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


        File mydir = getDir("mydir", Context.MODE_PRIVATE); //Creating an internal dir;
        File fileWithinMyDir = new File(mydir, "myfile");
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                 //Getting a file within the dir.
//
//                rec.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
//                rec.setAudioChannels(1);
//                rec.setAudioSamplingRate(8000);
//                rec.setAudioEncodingBitRate(44100);
//                rec.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//                rec.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//                if (!fileWithinMyDir.exists()) {
//                    fileWithinMyDir .mkdirs();
//                }
//
//                String file_name = fileWithinMyDir + "/" + "hello" + ".wav";
//                Log.d(TAG, "onCreate: "+file_name);
//                rec.setOutputFile(file_name);
//                try {
//                    rec.prepare();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Toast.makeText(MainActivity.this,"Sorry! file creation failed!"+e.getMessage(),Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                rec.start();
//
//            }
//        });
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rec.stop();
//                rec.reset();
//                String path = fileWithinMyDir + "/" + "hello" + ".wav";
//                MediaPlayer player = new MediaPlayer();
//
//                try {
//                    player.setDataSource(path);
//                    player.prepare();
//                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    System.out.println("Exception of type : " + e.toString());
//                    e.printStackTrace();
//                }
//
//                player.start();
//            }
//        });
    }

    public void writeFile() throws IOException {



    }
}