package com.app160806.app160806.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app160806.app160806.R;
import com.app160806.app160806.mypage.ListActivity;

public class LoginActivity extends Activity implements View.OnClickListener {
    EditText et_id, et_pw;
    Button bt_login, bt_join;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button) findViewById(R.id.bt_join);

        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Log.d("LoginActivity id OK 이전2222", "aa");
        Intent intent = new Intent(this.getApplicationContext(), ListActivity.class);
        switch (v.getId()){
            case R.id.bt_login :
                Log.d("LoginActivity id OK 이전111", "bb");
                String id = et_id.getText().toString();
                String pw = et_pw.getText().toString();
                Toast.makeText(LoginActivity.this, "ID : "+ id + "PW : " + pw, Toast.LENGTH_LONG).show();
                MemberBean temp = new MemberBean();
                temp.setId(id);
                temp.setPw(pw);
                MemberBean result = service.login(temp);
                Log.d("LoginActivity id OK 이전", "dd");
                if(result.getId().equals("NONE")){
                    Toast.makeText(LoginActivity.this, "입력하신 : "+ id + "존재하지 않습니다.", Toast.LENGTH_LONG).show();
                }
                else{
                    if(pw.equals(result.getPw())){
                        Log.d("LoginActivity id OK", "cc");
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "입력하신 : "+ pw + "존재하지 않습니다.", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.bt_join :
                startActivity(new Intent(this.getApplicationContext(), JoinActivity.class));
                break;
        }
    }
}
