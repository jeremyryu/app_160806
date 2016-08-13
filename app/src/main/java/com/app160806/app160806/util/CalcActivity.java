package com.app160806.app160806.util;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app160806.app160806.R;

public class CalcActivity extends Activity implements View.OnClickListener{
    EditText et_num1,et_num2;
    Button bt_plus,bt_minus,bt_divid,bt_remainder, bt_multi, bt_equal;
    TextView tv_result;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        et_num1 = (EditText) findViewById(R.id.et_num1);
        et_num2 = (EditText) findViewById(R.id.et_num2);
        bt_plus = (Button) findViewById(R.id.bt_plus);
        bt_minus = (Button) findViewById(R.id.bt_minus);
        bt_multi = (Button) findViewById(R.id.bt_multi);
        bt_divid = (Button) findViewById(R.id.bt_divid);
        bt_remainder = (Button) findViewById(R.id.bt_remainder);
        bt_equal = (Button) findViewById(R.id.bt_equal);
        tv_result = (TextView) findViewById(R.id.tv_result);

        bt_plus.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_multi.setOnClickListener(this);
        bt_divid.setOnClickListener(this);
        bt_remainder.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(et_num1.getText().toString());
        int num2 = Integer.parseInt(et_num2.getText().toString());

        switch (v.getId()){
            case R.id.bt_plus :
                result = num1 + num2;
                break;
            case R.id.bt_minus :
                result = num1 - num2;
                break;
            case R.id.bt_multi :
                result = num1 * num2;
                break;
            case R.id.bt_divid :
                result = num1 / num2;
                break;
            case R.id.bt_remainder :
                break;
            case R.id.bt_equal :
                tv_result.setText("RESULT : " + result);
                break;
        }

    }
}
