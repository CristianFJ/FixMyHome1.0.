package com.firesoul.fixmyhome10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.h);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_desbordamiento2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.principal):
                Toast.makeText(this, "presionaste PRINCIPAL", Toast.LENGTH_SHORT).show();
            break;
            case (R.id.cerrars2):
                Intent i=new Intent().setClass(Main5Activity.this,Main2Activity.class);
                startActivity(i);
                Toast.makeText(this, "presionaste cerrar sesion2", Toast.LENGTH_SHORT).show();
             break;
        }
        return true;
    }
}
