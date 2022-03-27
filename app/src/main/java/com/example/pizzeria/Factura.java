package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        RecibirDatos();

    }

    public void RecibirDatos(){
        Bundle extras = getIntent().getExtras();
        String d1 =  extras.getString("Dato01");
        String d2 = extras.getString("Dato02");

        TextView factura = findViewById(R.id.txtFactura);
        factura.setText("$"+d1);
        TextView nombre = findViewById(R.id.textView9);
        nombre.setText(d2);

        Button regresar = findViewById(R.id.btn_regresar);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent back = new Intent(Factura.this, MainActivity.class);


                startActivity(back);
            }
        });

    }
}