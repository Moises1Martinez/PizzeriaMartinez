package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton masa_alta = findViewById(R.id.rbtn_alta);
        RadioButton masa_delgada = findViewById(R.id.rbtn_delgada);
        RadioButton peperoni = findViewById(R.id.rbtn_peperoni);
        RadioButton jamon = findViewById(R.id.rbtn_jamon);
        RadioButton tocino = findViewById(R.id.rbtn_tocino);
        RadioButton carne = findViewById(R.id.rbtn_carne);
        RadioButton pollo = findViewById(R.id.rbtn_pollo);
        RadioButton quesos = findViewById(R.id.rbtn_queso);
        RadioButton hongos = findViewById(R.id.rbtn_hongos);
        TextView message = findViewById(R.id.txtMessage);
        TextView message2 = findViewById(R.id.txt_message2);
        TextView ingrediente = findViewById(R.id.txtIngrediente);
        EditText nombre = findViewById(R.id.tb_name);
        Button orden =findViewById(R.id.button);

        RadioButton normal =findViewById(R.id.rbtn_normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (normal.isChecked()) {
                    peperoni.setVisibility(View.VISIBLE);
                    jamon.setVisibility(View.VISIBLE);
                    tocino.setVisibility(View.VISIBLE);
                    carne.setVisibility(View.VISIBLE);
                    message.setVisibility(View.VISIBLE);
                    ingrediente.setVisibility(View.VISIBLE);
                    pollo.setVisibility(View.GONE);
                    quesos.setVisibility(View.GONE);
                    hongos.setVisibility(View.GONE);
                    message2.setVisibility(View.GONE);
                }
            }
        });

        RadioButton especialidad =findViewById(R.id.rbtn_especialidad);
especialidad.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (especialidad.isChecked()){

            peperoni.setVisibility(View.GONE);
            jamon.setVisibility(View.GONE);
            tocino.setVisibility(View.GONE);
            carne.setVisibility(View.GONE);
            message.setVisibility(View.GONE);
            ingrediente.setVisibility(View.VISIBLE);
            pollo.setVisibility(View.VISIBLE);
            quesos.setVisibility(View.VISIBLE);
            hongos.setVisibility(View.VISIBLE);
            message2.setVisibility(View.VISIBLE);
        }
    }
});


        orden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(normal.isChecked()) {

                    if (masa_alta.isChecked()) {
                        double pricemasa = 1.50;
                        if (peperoni.isChecked() || jamon.isChecked() || carne.isChecked() || tocino.isChecked()) {

                            double pricepizza = 6.00;
                            double total = pricepizza + pricemasa;

                            Intent facturas = new Intent(MainActivity.this, Factura.class);
                            facturas.putExtra("Dato01", Double.toString(total));
                            facturas.putExtra("Dato02", String.valueOf(nombre.getText()));


                            startActivity(facturas);

                        }
                    } else if (masa_delgada.isChecked()) {
                        double pricemasa = 2.25;
                        if (peperoni.isChecked() || jamon.isChecked() || carne.isChecked() || tocino.isChecked()) {

                            double pricepizza = 9.00;
                            double total = pricepizza + pricemasa;

                            Intent facturas = new Intent(MainActivity.this, Factura.class);
                            facturas.putExtra("Dato01", Double.toString(total));
                            facturas.putExtra("Dato02", String.valueOf(nombre.getText()));

                            startActivity(facturas);

                        }
                    }
                }
                else if(especialidad.isChecked()){
                    if (masa_alta.isChecked()) {
                        double pricemasa = 1.50;
                        if (pollo.isChecked()|| quesos.isChecked()||hongos.isChecked()) {

                            double pricepizza = 9.00;
                            double total = pricepizza + pricemasa;

                            Intent facturas = new Intent(MainActivity.this, Factura.class);
                            facturas.putExtra("Dato01", Double.toString(total));
                            facturas.putExtra("Dato02", String.valueOf(nombre.getText()));


                            startActivity(facturas);

                        }
                    } else if (masa_delgada.isChecked()) {
                        double pricemasa = 2.25;
                        if (pollo.isChecked()|| quesos.isChecked()||hongos.isChecked()) {

                            double pricepizza = 9.00;
                            double total = pricepizza + pricemasa;

                            Intent facturas = new Intent(MainActivity.this, Factura.class);
                            facturas.putExtra("Dato01", Double.toString(total));
                            facturas.putExtra("Dato02", String.valueOf(nombre.getText()));

                            startActivity(facturas);

                        }
                    }


                }




            }




        });









    }
}