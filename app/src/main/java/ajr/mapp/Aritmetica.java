package ajr.mapp;

import java.util.*;
import android.annotation.SuppressLint;
import android.app.*;
import android.os.*;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.view.View.*;
import android.widget.*;

/**
 * Created by ALMONTE on 24/12/2014.
 */
public class Aritmetica extends ActionBarActivity implements View.OnClickListener {

    TextView resultado;

    EditText primerMiembro;
    EditText segundoMiembro;

    Button suma;
    Button resta;
    Button mult;
    Button div;

    ListView lista;
    List<String> ll;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aritmetica);


//        Bundle b=this.getIntent().getExtras();
//        Toast t=Toast.makeText(this, "Bienvenido "+b.getString("nombre"), Toast.LENGTH_LONG);
//        t.show();

        this.resultado=(TextView) findViewById(R.id.Resultado);
        this.primerMiembro=(EditText) findViewById(R.id.PrimerMiembro);
        this.segundoMiembro=(EditText) findViewById(R.id.SegundoMiembro);
        this.suma=(Button) findViewById(R.id.Suma);
        this.resta=(Button) findViewById(R.id.Resta);
        this.mult=(Button) findViewById(R.id.Mult);
        this.div=(Button) findViewById(R.id.Div);
        this.lista=(ListView) findViewById(R.id.Lista);
        this.ll=new ArrayList<String>();

        ListAdapter aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,this.ll);
        this.lista.setAdapter(aa);

        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);



    }
    @SuppressLint("UseValueOf")
    public void onClick(View v) {
        Double d=0d;

        if(this.primerMiembro.getText().toString().matches("") ||
                this.segundoMiembro.getText().toString().matches("")) {
            Toast t=Toast.makeText(this, "Añada los argumentos", Toast.LENGTH_SHORT);
            t.show();
        } else {

            Double p=new Double(this.primerMiembro.getText().toString());
            Double s=new Double(this.segundoMiembro.getText().toString());

            switch(v.getId()) {
                case R.id.Suma:		d=p+s;

                    this.ll.add(p+" + "+s+" = "+d);

                    break;
                case R.id.Resta:	d=p-s;

                    this.ll.add(p+" - "+s+" = "+d);

                    break;
                case R.id.Mult:		d=p*s;;

                    this.ll.add(p+" * "+s+" = "+d);

                    break;
                case R.id.Div:		d=p/s;


                    this.ll.add(p+" / "+s+" = "+d);

                    break;
            }
        }

        this.resultado.setText(d+"");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // ID del boton
                finish(); // con finish terminamos el activity actual, con lo que volvemos
                // al activity anterior (si el anterior no ha sido cerrado)
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
