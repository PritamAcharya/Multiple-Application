package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionMenuTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu_test);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenutest,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(OptionMenuTest.this, "You Have Selected "+item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
