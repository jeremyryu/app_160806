package com.app160806.app160806.mypage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app160806.app160806.R;
import com.app160806.app160806.member.MemberBean;
import com.app160806.app160806.member.MemberService;
import com.app160806.app160806.member.MemberServiceImpl;

public class MyPageActivity extends Activity implements View.OnClickListener {
    ImageView iv_profile;
    TextView tv_id, tv_name, tv_phone, tv_email, tv_addr;
    Button bt_call, bt_map, bt_update;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        service = new MemberServiceImpl(this.getApplicationContext());
//        Intent intent = new Intent(this.getApplicationContext(), MyPageActivity.class);
//        String id = intent.getStringExtra("id");
        MemberBean member = service.findById(getIntent().getStringExtra("id"));
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_name = (TextView) findViewById(R.id.tv_name);
        iv_profile = (ImageView) findViewById(R.id.iv_profile);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_addr = (TextView) findViewById(R.id.tv_addr);
        bt_call = (Button) findViewById(R.id.bt_call);
        bt_map = (Button) findViewById(R.id.bt_map);
        bt_update = (Button) findViewById(R.id.bt_update);

        tv_id.setText(member.getId());
        tv_name.setText(member.getName());
        tv_phone.setText(member.getPhone());
        tv_email.setText(member.getEmail());
        tv_addr.setText(member.getAddr());
        bt_call.setText(member.getPhone());
        bt_map.setText(member.getAddr());

//        bt_call.findViewById(R.id.bt_call);
//        bt_map.setOnClickListener(this);
        bt_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_call:
                break;
            case R.id.bt_map:
                break;
            case R.id.bt_update:
                Intent intent = new Intent(MyPageActivity.this, UpdateActivity.class);
                intent.putExtra("id", tv_id.getText().toString());
                startActivity(intent);
                break;
        }

    }
}
