package ajr.mapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Inicio extends ActionBarActivity implements View.OnClickListener {

    Button ecuacion;
    Button aritmetica;
    Button sastre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);


        this.aritmetica=(Button) findViewById(R.id.Calculus);
        this.ecuacion=(Button) findViewById(R.id.Ecuationis);
        this.sastre=(Button) findViewById(R.id.Sastre);

        this.aritmetica.setOnClickListener(this);
        this.ecuacion.setOnClickListener(this);
        this.sastre.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i4=new Intent("ajr.About");
            startActivity(i4);
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.Calculus:

                Intent i1=new Intent("ajr.Aritmetica");

                //Bundle b=new Bundle();
                //b.putString("nombre", this.usuario.getText().toString());
                //i.putExtras(b);
                startActivity(i1);

                Toast t1=Toast.makeText(this, "Abriendo centro de cáculo", Toast.LENGTH_SHORT);
                t1.show();

                break;

            case R.id.Ecuationis:

                Intent i2=new Intent("ajr.Algebra");
                startActivity(i2);
                Toast t2=Toast.makeText(this, "Abriendo centro de álgebra", Toast.LENGTH_SHORT);
                t2.show();
                break;

            case R.id.Sastre:

                Intent i3=new Intent("ajr.Cajon");
                startActivity(i3);
                Toast t3=Toast.makeText(this, "Abriendo utilidades matemáticas", Toast.LENGTH_SHORT);
                t3.show();
                break;
        }

    }

}
