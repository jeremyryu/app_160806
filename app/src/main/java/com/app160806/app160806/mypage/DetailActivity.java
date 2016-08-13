package com.app160806.app160806.mypage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app160806.app160806.R;
import com.app160806.app160806.member.MemberBean;
import com.app160806.app160806.member.MemberService;
import com.app160806.app160806.member.MemberServiceImpl;

public class DetailActivity extends Activity implements View.OnClickListener{
    ImageView iv_profile;
    TextView tv_id, tv_name, tv_phone, tv_email, tv_addr;
    Button bt_call, bt_map;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
//        Intent intent = getIntent();
//        String id = intent.getStringExtra("id");
        MemberBean member = service.findById(getIntent().getStringExtra("id"));

        iv_profile = (ImageView) findViewById(R.id.iv_profile);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_addr = (TextView) findViewById(R.id.tv_addr);
        bt_call = (Button) findViewById(R.id.bt_call);
        bt_map = (Button) findViewById(R.id.bt_map);

        tv_name.setText(member.getName());
        tv_id.setText(member.getId());
        tv_phone.setText(member.getPhone());
        tv_email.setText(member.getEmail());
        tv_addr.setText(member.getAddr());

        bt_call.setOnClickListener(this);
        bt_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_call: break;
            case R.id.bt_map : break;
        }

    }
}
