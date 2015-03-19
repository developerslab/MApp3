package ajr.mapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;

/**
 * Created by ALMONTE on 24/12/2014.
 */
public class Algebra extends ActionBarActivity implements OnClickListener {

    final Integer NUMER_LENGTH=6;

    EditText xCubo;
    EditText xCuadrado;
    EditText x;
    EditText n;
    EditText punto;

    PolynomialFunction p;

    TextView ecuacion;
    TextView derivada;
    TextView solucion;

    Button resolver;
    Button derivar;
    Button Fx;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algebra);

        this.xCubo=(EditText) findViewById(R.id.xCubo);
        this.xCuadrado=(EditText) findViewById(R.id.xCuadrado);
        this.x=(EditText) findViewById(R.id.x);
        this.n=(EditText) findViewById(R.id.number);
        this.punto=(EditText) findViewById(R.id.punto);

        this.ecuacion=(TextView) findViewById(R.id.factorizacion);
        this.derivada=(TextView) findViewById(R.id.derivada);
        this.solucion=(TextView) findViewById(R.id.solucion);

        this.resolver=(Button) findViewById(R.id.factorizar);
        this.derivar=(Button) findViewById(R.id.esPrimo);
        this.Fx=(Button) findViewById(R.id.pot2);

        resolver.setOnClickListener(this);
        derivar.setOnClickListener(this);
        Fx.setOnClickListener(this);


    }
    @SuppressLint("UseValueOf")
    public void onClick(View v) {
        if(this.xCubo.getText().toString().matches("")
                || this.xCuadrado.getText().toString().matches("")
                || this.x.getText().toString().matches("")
                || this.n.getText().toString().matches("")) {
            Toast t=Toast.makeText(this, "Añada los argumentos", Toast.LENGTH_SHORT);
            t.show();
        } else {

            Double x3=new Double(this.xCubo.getText().toString());
            Double x2=new Double(this.xCuadrado.getText().toString());
            Double x1=new Double(this.x.getText().toString());
            Double n1=new Double(this.n.getText().toString());

            double[] coeficientes={n1,x1,x2,x3};
            p=new PolynomialFunction(coeficientes);
            PolynomialFunction d=p.polynomialDerivative();

            if(x3.toString().length()>NUMER_LENGTH || x2.toString().length()>NUMER_LENGTH ||
                    x1.toString().length()>NUMER_LENGTH || n1.toString().length()>NUMER_LENGTH) {
                Toast.makeText(this, "Numeros demasiado grandes", Toast.LENGTH_SHORT).show();
            } else{

                switch (v.getId()) {
                    case R.id.factorizar:
                        NewtonRaphsonSolver sol = new NewtonRaphsonSolver();
                        double r = sol.solve(Integer.MAX_VALUE, p, 0);

                        this.ecuacion.setText(r + "");

                        break;

                    case R.id.esPrimo:
                        this.derivada.setText(d.toString());

                        break;

                    case R.id.pot2:
                        if (this.punto.getText().toString().matches("")) {
                            Toast t = Toast.makeText(this, "Añada 'x'", Toast.LENGTH_SHORT);
                            t.show();
                        } else {
                            Double point = new Double(this.punto.getText().toString());
                            Double res = p.value(point);
                            this.solucion.setText(res.toString());
                        }

                        break;
                }
            }
        }
    }
}
