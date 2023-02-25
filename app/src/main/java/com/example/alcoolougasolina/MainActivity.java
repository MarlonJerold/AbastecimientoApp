package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGas;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGas        = findViewById(R.id.editPrecoGas);
        textResultado       = findViewById(R.id.textResultado);

    }

    public Boolean validarCampos(String precoAlcool, String precoGas) {
        Boolean camposValidados = true;

        if(precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false;
        } else if (precoGas == null || precoGas.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
    public void calcularPreco(View view) {
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGas = editPrecoGas.getText().toString();

        Boolean resultadoValidacao = validarCampos(precoAlcool, precoGas);
        if(resultadoValidacao) {
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGas = Double.parseDouble(precoGas);
            Double resultado = valorAlcool / valorGas;

            if(resultado >= 0.7) {
                textResultado.setText("Melhor comprar a Gasolina");
            }else {
                textResultado.setText("Melhor comprar o Ácool");
            }

        }else {
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

}