package com.firesoul.fixmyhome10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.h);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_desbordamiento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.perfil):
                Intent i = new Intent().setClass(Main4Activity.this, Main5Activity.class);
                startActivity(i);
                Toast.makeText(this, "presionaste perfil", Toast.LENGTH_SHORT).show();
                break;
            case (R.id.cerrars):
                Intent c = new Intent().setClass(Main4Activity.this, Main2Activity.class);
                startActivity(c);
                Toast.makeText(this, "presionaste cerrar sesion", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
