package com.example.act1_aplicaciobbasica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] Opcio=new String[] {"", "Segons", "Minuts", "Hores", "Anys"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //carreguem desplegable
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Opcio);
        Spinner spinner = (Spinner) findViewById(R.id.Opcions);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //recuperem valor del quadre de text
        EditText Valor = (EditText) findViewById(R.id.Valor);
        int numeroTotal = Integer.parseInt(Valor.getText().toString());

        //recuperem valor desplegable
        String opcio_triada= spinner.getSelectedItem().toString();

        calcul(opcio_triada, numeroTotal);

        }

    public void calcul(String opcio, int numTotal){
        //opcions
        double sTotals=0;
        double mTotals=0;
        double hTotals=0;
        double aTotals=0;
        TextView segons_total = (TextView) findViewById(R.id.segons_total);
        TextView minuts_total = (TextView) findViewById(R.id.minuts_total);
        TextView hores_total = (TextView) findViewById(R.id.hores_total);
        TextView anys_total = (TextView) findViewById(R.id.anys_total);

        if (opcio == "Segons"){
            sTotals = numTotal;
            mTotals = (double)numTotal*0.01;
            hTotals = (double)numTotal/0.0002779*100;
            aTotals = (double)numTotal*0.0000003169;
        } else if (opcio == "Minuts"){
            sTotals = (double)numTotal*60.0;
            mTotals = numTotal;
            hTotals = (double)numTotal*0.0167;
            aTotals = (double)numTotal*60.0;

        } else if (opcio == "Hores"){
            sTotals = (double)numTotal*70.0;
            mTotals = (double)numTotal*70.0;
            hTotals = numTotal;
            aTotals = (double)numTotal*70.0;

        } else if (opcio == "Anys"){
            sTotals = (double)numTotal*80.0;
            mTotals = (double)numTotal*80.0;
            hTotals = (double)numTotal*80.0;
            aTotals = numTotal;
        }
        segons_total.setText(String.valueOf(sTotals));
        minuts_total.setText(String.valueOf(mTotals));
        hores_total.setText(String.valueOf(hTotals));
        anys_total.setText(String.valueOf(aTotals));
    }

    //veure canvi desplegable
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicio, long l) {
        EditText Valor = (EditText) findViewById(R.id.Valor);
        int numeroTotal = Integer.parseInt(Valor.getText().toString());

        //recuperem valors desplegable
        Spinner spinner = (Spinner) findViewById(R.id.Opcions);
        String opcio_triada=spinner.getSelectedItem().toString();

        calcul(opcio_triada, numeroTotal);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}