package com.example.a30259.nighteen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.util.Log.d;

public class FirstActivity extends AppCompatActivity {
    int num = 10000;
    String name = "Harry" +
            "aaa" +
            "aaa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button save = (Button)findViewById(R.id.save);
        Button load = (Button)findViewById(R.id.load);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream out = null;
                BufferedWriter writer = null;
                try{
                    out = openFileOutput("dataa", Context.MODE_APPEND);
                    writer = new BufferedWriter(new OutputStreamWriter(out));
                    writer.write(name+num+"");
                    num++;
                    Log.d("FirstActivity","successful");
                }catch(IOException EX){
                    Log.d("FirstActivity",EX.toString());
                }finally {
                    try{
                        if(writer!=null){
                            writer.close();
                        }
                    }catch (IOException ex){
                        Log.d("FirstActivity",ex.toString());
                    }
                }
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream in = null;
                BufferedReader reader = null;
                StringBuilder content = new StringBuilder();
                try{
                    in = openFileInput("dataa");
                    reader = new BufferedReader(new InputStreamReader(in));
                    String line = "";
                    while((line = reader.readLine())!=null){
                        content.append(line);
                        Log.d("FirstActivity","line");
                    }
                    Log.d("FirstActivity",content.toString());
                }catch(IOException ex){
                    Log.d("FirstActivity",ex.toString());
                }finally {
                    if(reader!=null){
                        try{
                            reader.close();
                        }catch (IOException ex){
                            Log.d("FirstActivity",ex.toString());
                        }
                    }
                }
            }
        });

    }
}
