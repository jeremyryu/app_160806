package com.app160806.app160806.mypage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app160806.app160806.R;
import com.app160806.app160806.member.MemberBean;
import com.app160806.app160806.member.MemberService;
import com.app160806.app160806.member.MemberServiceImpl;

public class UpdateActivity extends Activity implements View.OnClickListener {
    Button bt_confirm, bt_cancel;
    EditText et_pass, et_email, et_addr;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        service = new MemberServiceImpl(this.getApplicationContext());
//        Intent intent = new Intent(this.getApplicationContext(), MyPageActivity.class);
//        String id = intent.getStringExtra("id");
        member = service.findById(getIntent().getStringExtra("id"));
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_email = (EditText) findViewById(R.id.et_email);
        et_addr = (EditText) findViewById(R.id.et_addr);
        bt_confirm = (Button) findViewById(R.id.bt_confirm);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);


//        bt_call.findViewById(R.id.bt_call);
//        bt_map.setOnClickListener(this);
        bt_confirm.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_confirm:
                if(et_email.getText().toString().equals(""))
                {
                }
                else
                {
                    member.setEmail(et_email.getText().toString());
                }
                if(et_addr.getText().toString().equals(""))
                {
                }
                else
                {
                    member.setAddr(et_addr.getText().toString());
                }
                if(et_pass.getText().toString().equals(""))
                {
                }
                else
                {
                    member.setPw(et_pass.getText().toString());
                }

                Log.d("update act", "update");
                service.update(member);
                Intent intent = new Intent(UpdateActivity.this, MyPageActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
                break;
            case R.id.bt_cancel:
                Intent intent2 = new Intent(UpdateActivity.this, MyPageActivity.class);
                intent2.putExtra("id", member.getId());
                startActivity(intent2);
                break;
        }

    }
}
