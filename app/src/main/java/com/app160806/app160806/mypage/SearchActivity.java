package com.app160806.app160806.mypage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.app160806.app160806.R;
import com.app160806.app160806.member.MemberBean;
import com.app160806.app160806.member.MemberService;
import com.app160806.app160806.member.MemberServiceImpl;

import java.util.ArrayList;

public class SearchActivity extends Activity implements View.OnClickListener{
    Button bt_list;
    MemberService service;
    ListView lv_memberlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("SearchActivity onCreate", "aa");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        service = new MemberServiceImpl(this.getApplicationContext());
        ArrayList<MemberBean> list = service.findByName(getIntent().getStringExtra("keyword"));

        bt_list = (Button) findViewById(R.id.bt_list);

        lv_memberlist = (ListView) findViewById(R.id.lv_memeberlist);
        lv_memberlist.setAdapter(new MemberAdapter(this, list));
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lv_memberlist.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
            }
        });

        bt_list.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(SearchActivity.this, ListActivity.class));
    }
}
