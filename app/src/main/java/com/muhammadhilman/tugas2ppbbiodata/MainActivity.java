package com.muhammadhilman.tugas2ppbbiodata;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox hobby1,hobby2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);



    }

    @Override
    public void onClick(View v)
    {
        sendResult();
    }
    public void sendResult()
    {

        List <String> hobby = new ArrayList<>();
        Intent intent = new Intent(this, ShowResult.class);
        EditText namaDepan = (EditText) findViewById(R.id.nama_depan);
        EditText namaBelakang = (EditText) findViewById(R.id.nama_belakang);

        hobby1=(CheckBox)findViewById(R.id.bola);
        hobby2=(CheckBox)findViewById(R.id.basket);

        Log.d("debugoi", namaDepan.getText().toString());


        intent.putExtra("namaDepan", namaDepan.getText());
        intent.putExtra("namaBelakang", namaBelakang.getText());

        if(hobby1.isChecked()){
            hobby.add(hobby1.getText().toString());
        }
        if(hobby2.isChecked()){
            hobby.add(hobby2.getText().toString());
        }

        intent.putStringArrayListExtra("hobby", (ArrayList<String>) hobby);

        RadioGroup agama = (RadioGroup) findViewById(R.id.groupAgama);

        int selectedId = agama.getCheckedRadioButtonId();
        RadioButton buttonAgama = (RadioButton) findViewById(selectedId);

        intent.putExtra("agama", buttonAgama.getText());


        startActivity(intent);
    }
}
