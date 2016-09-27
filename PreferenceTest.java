package com.example.my.pritam;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class PreferenceTest extends AppCompatActivity {
    SharedPreferences sp;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_test);
        ed1=(EditText)findViewById(R.id.editText);
        sp=getSharedPreferences("mypref",MODE_PRIVATE);
        ed1.setText(sp.getString("str"," "));
    }

    @Override
    protected void onStop() {
        super.onStop();
        String st=ed1.getText().toString();
        SharedPreferences.Editor se=sp.edit();
        se.putString("str",st);
        se.commit();
    }
}
