package il.ac.huji.tipcalculator;

import il.ac.huji.tipcalculator.R;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	private static final double TIP_PRECENT = 0.12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        Button culcButton = (Button) findViewById(R.id.btnCalculate);
        final TextView tipRes = (TextView) findViewById(R.id.txtTipResult);
        final CheckBox shouldRound = (CheckBox) findViewById(R.id.chkRound);
        final EditText ammountText = (EditText) findViewById(R.id.edtBillAmount);
        culcButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String ammountStr = ammountText.getText().toString();
				double ammount = 0.0;
				if(!(ammountStr == null || ammountStr.isEmpty())) {
					ammount = TIP_PRECENT * Double.parseDouble(ammountStr);
				}
				if(shouldRound.isChecked()){
					int tip = (int) Math.round(ammount);
					tipRes.setText("Tip: $" + Integer.toString(tip));	
				}else{
					DecimalFormat noRoundFormat = new DecimalFormat("0.00");
					tipRes.setText("Tip: $" + noRoundFormat.format(ammount));
				}
				
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
}
