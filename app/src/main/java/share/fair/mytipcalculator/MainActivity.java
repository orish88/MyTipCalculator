package share.fair.mytipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int TIP_PERCENTAGE = 12;
    EditText etBillAmount;
    Button btCalculate;
    TextView tvTip;
    CheckBox cbRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_calculator);
        etBillAmount = (EditText) findViewById(R.id.etBillAmount);
        btCalculate =(Button) findViewById(R.id.btCalculate);
        cbRound =(CheckBox) findViewById(R.id.cbRound);
        tvTip = (TextView) findViewById(R.id.tvTipResult);
        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String billAmountStr = etBillAmount.getText().toString();
                if (billAmountStr.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter bill amount to calculate!", Toast.LENGTH_LONG).show();
                    Log.d("notes","Enter bill amount to calculate!");
                } else {
                    double tipAmount = (Double.parseDouble(billAmountStr) * TIP_PERCENTAGE) / 100;
                    if (cbRound.isChecked()) {
                        tipAmount = Math.round(tipAmount);
                    }
                    tvTip.setText("Tip: " + String.format("%.2f",tipAmount) + "$");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
