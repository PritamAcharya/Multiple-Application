package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteTest extends AppCompatActivity {
    MultiAutoCompleteTextView mactc;
    AutoCompleteTextView actv;
    String country[]={"INDIA","INDONASIA","IRAQ","USA","UK","CHINA","CHILI"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_test);
        mactc=(MultiAutoCompleteTextView)findViewById(R.id.mactc);
        actv=(AutoCompleteTextView)findViewById(R.id.actv);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,country);
        actv.setAdapter(adapter);
        mactc.setAdapter(adapter);
        mactc.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
