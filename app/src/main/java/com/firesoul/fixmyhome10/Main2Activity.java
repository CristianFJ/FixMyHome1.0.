package com.firesoul.fixmyhome10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {
    EditText nombre, contraseña;
    String n, c;
    private static final int ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.h);

        nombre = findViewById(R.id.editText);
        contraseña = findViewById(R.id.editText2);

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        if (resultCode == RESULT_OK && requestCode == ID) {
            String Usuario = getIntent().getStringExtra("nombre");
            String Contraseña = getIntent().getStringExtra("contrasena");


        }

    }
    public void onButtonClick(View view) {
        String Usuario = getIntent().getStringExtra("nombre");
        String Contraseña = getIntent().getStringExtra("contrasena");
        n = nombre.getText().toString();
        c = contraseña.getText().toString();
        if ((Objects.equals(Usuario, n)) && (Objects.equals(Contraseña, c))) {
            Intent j = new Intent().setClass(Main2Activity.this, Main4Activity.class);
            startActivityForResult(j, ID);

        } else {

            Toast.makeText(this, Usuario , Toast.LENGTH_SHORT).show();
            nombre.getText().clear();
            contraseña.getText().clear();


        }


    }

    public void onButtonClicked(View view) {
        Intent i = new Intent().setClass(Main2Activity.this, Main3Activity.class);
        startActivity(i);
    }
}
