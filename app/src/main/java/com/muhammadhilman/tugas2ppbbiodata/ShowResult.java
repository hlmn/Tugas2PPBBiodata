package com.muhammadhilman.tugas2ppbbiodata;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        List<String> test;
        String resultNama;
        TextView nama = (TextView) findViewById(R.id.resultNama);
        TextView nationality = (TextView) findViewById(R.id.resultNationality);
        TextView dateOfBirth = (TextView) findViewById(R.id.resultDateOfBirth);
        TextView agama = (TextView) findViewById(R.id.resultAgama);
        TextView hobby = (TextView) findViewById(R.id.resultHobby);




        test = getIntent().getStringArrayListExtra("hobby");
        if(test != null) {
            StringBuffer resultHobby = new StringBuffer();
            for (int i = 0;i<test.size();i++){
                if(i == 0) resultHobby.append(test.get(i));
                else resultHobby.append("\n" + test.get(i));
            }
            hobby.setText(resultHobby.toString());
        }
        resultNama = getIntent().getStringExtra("hasil_nama_depan")+" "+getIntent().getStringExtra("hasil_nama_belakang");
        nama.setText(resultNama);
        nationality.setText(getIntent().getStringExtra("nationality"));
        dateOfBirth.setText(getIntent().getStringExtra("dateOfBirth"));
        agama.setText(getIntent().getStringExtra("agama"));







    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.layout.activity_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
