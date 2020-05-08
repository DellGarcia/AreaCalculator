package br.com.dellgarcia.areacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtA;
    private EditText edtB;
    private EditText edtC;

    private Button button;

    private TextView square;
    private TextView circle;
    private TextView rectangle;
    private TextView triangle;
    private TextView trapeze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instanciate();

        button.setOnClickListener(calculate());

    }


    private View.OnClickListener calculate() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {
                        DecimalFormat df  =new DecimalFormat("0.000");

                        double n1 = Double.parseDouble(edtA.getText().toString()),
                            n2 = Double.parseDouble(edtB.getText().toString()),
                            n3 = Double.parseDouble(edtC.getText().toString());

                        double tri = n1 * n3 / 2;
                        double squ = n2 * n2;
                        double cir = 3.14159 * (n3 * n3);
                        double tra = (n1 + n2)/2 * n3;
                        double rec = n1 * n2;

                        triangle.setText(df.format(tri));
                        square.setText(df.format(squ));
                        circle.setText(df.format(cir));
                        trapeze.setText(df.format(tra));
                        rectangle.setText(df.format(rec));


                    } catch(NumberFormatException err) {
                    Toast.makeText(MainActivity.this,"Preencha os tres campos", Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    private void instanciate() {
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);

        button = findViewById(R.id.btnCalc);

        triangle = findViewById(R.id.edtValTriangle);
        circle = findViewById(R.id.edtValCircle);
        trapeze = findViewById(R.id.edtValTrapeze);
        rectangle = findViewById(R.id.edtValRectangle);
        square = findViewById(R.id.edtValSquare);
    }
}
