package ajr.mapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ALMONTE on 24/12/2014.
 */
public class Cajon extends ActionBarActivity implements View.OnClickListener {

    EditText nFactorizacion;
    EditText nPrimo;
    EditText nPot2;
    EditText nDB;
    EditText nBD;
    EditText nA;
    EditText nB;

    TextView sFactorizar;
    TextView sPrimo;
    TextView sPot2;
    TextView sDB;
    TextView sBD;
    TextView sAleatorio;

    Button factorizar;
    Button primo;
    Button pot2;
    Button DB;
    Button BD;
    Button aleatorio;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cajon);

        this.nFactorizacion=(EditText) findViewById(R.id.numberFactorizacion);
        this.nPrimo=(EditText) findViewById(R.id.numberPrimo);
        this.nPot2=(EditText) findViewById(R.id.numberpot2);
        this.nDB=(EditText) findViewById(R.id.numberDB);
        this.nBD=(EditText) findViewById(R.id.numberBD);
        this.nA=(EditText) findViewById(R.id.numberA);
        this.nB=(EditText) findViewById(R.id.numberB);

        this.sFactorizar=(TextView) findViewById(R.id.factorizacion);
        this.sPrimo=(TextView) findViewById(R.id.primalidad);
        this.sPot2=(TextView) findViewById(R.id.solpot2);
        this.sDB=(TextView) findViewById(R.id.solDB);
        this.sBD=(TextView) findViewById(R.id.solBD);
        this.sAleatorio=(TextView) findViewById(R.id.solAleatorio);

        this.factorizar=(Button) findViewById(R.id.factorizar);
        this.primo=(Button) findViewById(R.id.esPrimo);
        this.pot2=(Button) findViewById(R.id.pot2);
        this.DB=(Button) findViewById(R.id.DB);
        this.BD=(Button) findViewById(R.id.BD);
        this.aleatorio=(Button) findViewById(R.id.aleatorio);

        factorizar.setOnClickListener(this);
        primo.setOnClickListener(this);
        pot2.setOnClickListener(this);
        DB.setOnClickListener(this);
        BD.setOnClickListener(this);
        aleatorio.setOnClickListener(this);


    }


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.factorizar:

                if(this.nFactorizacion.getText().toString().matches("")) {
                    Toast.makeText(this, "Añada un número a factorizar", Toast.LENGTH_SHORT).show();
                } else {

                    Integer nF=new Integer(this.nFactorizacion.getText().toString());

                    if(nF.toString().length()>=10) {
                        Toast.makeText(this, "Número demasiado grande", Toast.LENGTH_SHORT).show();
                    } else {
                        List<Integer> lFact = Util.factorizacion(nF);
                        this.sFactorizar.setText(lFact.toString());
                    }
                }

                break;

            case R.id.esPrimo:

                if(this.nPrimo.getText().toString().matches("")) {
                    Toast.makeText(this, "Añada un número a calcular si es primo", Toast.LENGTH_SHORT).show();
                } else {

                    Integer nP=new Integer(this.nPrimo.getText().toString());

                    if(nP.toString().length()>=10) {
                        Toast.makeText(this, "Número demasiado grande", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean bPrimo = Util.esPrimo(nP);
                        this.sPrimo.setText(bPrimo.toString());
                    }
                }

                break;

            case R.id.pot2:

                if(this.nPot2.getText().toString().matches("")) {
                    Toast.makeText(this, "Añada un número a calcular su potencia de 2", Toast.LENGTH_SHORT).show();
                } else {

                    Integer nP2=new Integer(this.nPot2.getText().toString());

                    if(nP2.toString().length()>=10) {
                        Toast.makeText(this, "Número demasiado grande", Toast.LENGTH_SHORT).show();
                    } else {
                        Integer iPot2 = Util.pot2(nP2);
                        this.sPot2.setText(iPot2.toString());
                    }
                }

                break;

            case R.id.DB:

                if(this.nDB.getText().toString().matches("")) {
                    Toast.makeText(this, "Añada un binario para pasarlo a decimal", Toast.LENGTH_SHORT).show();
                } else {
                    Integer binario = new Integer(this.nDB.getText().toString());

                    if (!Util.esBinario(binario.toString())) {
                        Toast.makeText(this, "El número no es binario", Toast.LENGTH_SHORT).show();
                    } else if(binario.toString().length()>=11) {
                        Toast.makeText(this, "Número demasiado grande", Toast.LENGTH_SHORT).show();
                    }else {
                        Integer iDB=Util.binarioADecimal(binario);
                        this.sDB.setText(iDB.toString());
                    }
                }

                break;

            case R.id.BD:

                if(this.nBD.getText().toString().matches("")) {
                    Toast.makeText(this, "Añada un decimal para pasarlo a binario", Toast.LENGTH_SHORT).show();
                } else {

                    Integer nD=new Integer(this.nBD.getText().toString());

                    if(nD>=1024) {
                        Toast.makeText(this, "Número demasiado grande", Toast.LENGTH_SHORT).show();
                    } else {
                        Integer iBD = Util.decimalABinario(nD);
                        this.sBD.setText(iBD.toString());
                    }
                }

                break;

            case R.id.aleatorio:

                if(this.nA.getText().toString().matches("") || this.nB.getText().toString().matches("")) {
                    Toast.makeText(this, "Añada los rangos del intervalo de aleatoriedad", Toast.LENGTH_SHORT).show();
                } else {

                    Integer a = new Integer(this.nA.getText().toString()), b = new Integer(this.nB.getText().toString());

                    if (a.toString().length() > 5 || b.toString().length() > 5) {
                        Toast.makeText(this, "Números demasiado grande", Toast.LENGTH_SHORT).show();
                    } else if(a>=b) {
                        Toast.makeText(this, "El extremo inferior no puede ser mayor o igual que el superior", Toast.LENGTH_SHORT).show();
                    }else {
                        Integer iA = Util.numeroAleatorio(a, b);
                        this.sAleatorio.setText(iA.toString());
                    }
                }

                break;
        }
    }
}
