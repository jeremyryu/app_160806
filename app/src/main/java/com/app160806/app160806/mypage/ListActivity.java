package com.app160806.app160806.mypage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.app160806.app160806.R;
import com.app160806.app160806.member.MemberBean;
import com.app160806.app160806.member.MemberService;
import com.app160806.app160806.member.MemberServiceImpl;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

//import android.app.AlertDialog;

public class ListActivity extends Activity implements View.OnClickListener {
    EditText et_search;
    Button bt_mypage, bt_findByName, bt_findById, bt_add;
    MemberService service;
    ListView lv_memberlist;
    int gi;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ListActivity onCreate", "aa");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        service = new MemberServiceImpl(this.getApplicationContext());
        ArrayList<MemberBean> list = service.list();

        et_search = (EditText) findViewById(R.id.et_search);
        bt_mypage = (Button) findViewById(R.id.bt_mypage);
        bt_findByName = (Button) findViewById(R.id.bt_findByName);
        bt_findById = (Button) findViewById(R.id.bt_findById);
        lv_memberlist = (ListView) findViewById(R.id.lv_memeberlist);
        bt_add = (Button) findViewById(R.id.bt_add);

        lv_memberlist.setAdapter(new MemberAdapter(this, list));
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lv_memberlist.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
            }
        });
        lv_memberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                gi = i;
                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("DELETE ?")
                        .setMessage("정말 삭제하시겠읍니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Object o = lv_memberlist.getItemAtPosition(gi);
                                MemberBean member = (MemberBean) o;
                                service.deleter(member.getId());

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;
            }
        });

        bt_mypage.setOnClickListener(this);
        bt_findById.setOnClickListener(this);
        bt_findByName.setOnClickListener(this);
        bt_findById.setOnClickListener(this);
        bt_add.setOnClickListener(this);

        Log.d("ListActivity onCreate", "cc");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        Log.d("ListActivity onClick", "bb1111");
        String keyword = et_search.getText().toString();

        switch (v.getId()) {
            case R.id.bt_mypage:
                Log.d("ListActivity onClick", "bb2222");
                String id = getIntent().getStringExtra("id");
                Intent intent = new Intent(this.getApplicationContext(), MyPageActivity.class);
                intent.putExtra("id", id);
                Log.d("로그인시 넘어온 ID", id);
                startActivity(intent);
                break;
            case R.id.bt_findByName:
                if (keyword.equals("")) {
                    Toast.makeText(ListActivity.this, "검색어를 먼저 입력하세요", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ListActivity.this, "검색어 : " + keyword, Toast.LENGTH_LONG).show();
                    Intent intent3 = new Intent(this.getApplicationContext(), SearchActivity.class);
                    intent3.putExtra("keyword", keyword);
                    startActivity(intent3);
                }

                break;
            case R.id.bt_findById:
                if (keyword.equals("")) {
                    Toast.makeText(ListActivity.this, "검색어를 먼저 입력하세요", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ListActivity.this, "검색어 : " + keyword, Toast.LENGTH_LONG).show();
                    MemberBean member = service.findById(keyword);
                    if (member.getId().equals("NONE")) {
                        Toast.makeText(ListActivity.this, "해당 ID가 존재하지 않습니다.", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent2 = new Intent(this.getApplicationContext(), DetailActivity.class);
                        intent2.putExtra("id", member.getId());
                        startActivity(intent2);
                    }

                }
                break;
            case R.id.bt_add:
                startActivity(new Intent(this.getApplicationContext(), AddActivity.class));
                break;
        }

    }

}
