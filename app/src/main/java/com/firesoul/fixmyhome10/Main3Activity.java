package com.firesoul.fixmyhome10;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;


public class Main3Activity extends AppCompatActivity {
    EditText fecha, editText, editText2, editText3, editText4, T1;
    RadioButton radioButton1, radioButton2;
    Button b;
    String  sexo, pass1, pass2, name, email, city;
    int mYear, mMonth, mDay;
    Spinner Ciudad;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.h);




        fecha = findViewById(R.id.fecha);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ciudades, android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Ciudad = findViewById(R.id.spinner);
        Ciudad.setAdapter(adapter);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR); // current year
                mMonth = c.get(Calendar.MONTH); // current month
                mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                // date picker dialog
                datePickerDialog = new DatePickerDialog(Main3Activity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                mYear = year;
                                mDay = dayOfMonth;
                                mMonth = monthOfYear;
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }


    public void onRadioButtonClicked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.radioButton1:
                if (radioButton1.isChecked()) {
                    sexo = "Mujer";
                }
                break;
            case R.id.radioButton2:
                if (radioButton2.isChecked()) {
                    sexo = "Hombre";
                }
                break;
        }

    }




    public void onButtonClicked(View view) {
        pass1 = editText2.getText().toString();
        pass2 = editText3.getText().toString();
        if (!Objects.equals(pass1, pass2)) {
            Toast.makeText(this, "Las Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            editText2.getText().clear();
            editText3.getText().clear();
        } else if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresa el nombre",
                    Toast.LENGTH_SHORT).show();
        } else if (editText2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresa una contraseña",
                    Toast.LENGTH_SHORT).show();
        } else if (editText4.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresa un correo electronico",
                    Toast.LENGTH_SHORT).show();
        } else if (mDay == 0) {
            Toast.makeText(this, "Selecciona tu fecha de Nacimieto",
                    Toast.LENGTH_SHORT).show();
        } else {
            name = editText.getText().toString();
            city = Ciudad.getSelectedItem().toString();
            email = editText4.getText().toString();
            b.setEnabled(true);
            Intent i=new Intent();
            i.putExtra("nombre",editText.getText().toString());
            i.putExtra("contrasena",editText2.getText().toString());
            i.putExtra("email",editText4.getText().toString());
            i.putExtra("ciudad",Ciudad.getSelectedItem().toString());
            i.putExtra("sexo",sexo);
            i.putExtra("fecha",  mDay +  mMonth +   mYear  );
            setResult(RESULT_OK, i);
            finish();
            //   T1.setText("Nombre: " + name + "\n" + "correo: " + email + "\n" + "Sexo: " + sexo + "\n"
           //         + "Fecha de Nacimiento: " + mDay + "/" + mMonth + "/" + mYear + "\n"
             //       + "Lugar de Nacimiento: " + city + "\n");
        }
    }
}
