package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PopupTest extends AppCompatActivity {
    PopupMenu pm;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_test);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pm=new PopupMenu(PopupTest.this,b1);
                pm.getMenuInflater().inflate(R.menu.optionmenutest,pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(PopupTest.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                pm.show();


            }
        });
    }
}
