package com.app160806.app160806.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

/**
 * Created by 1027 on 2016-08-06.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String ADDR = "addr";

    public MemberDAO(Context context) {
        super(context, "hanbitdb", null, 1);
        this.getWritableDatabase();
        Log.d("DAO 진입 여부", "====OK !! =====");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // id, pw, name, phone, email, addr;
        // 테이블 생성 create table TEST (id TEXT, pw TEXT);
        // 테이블에 값 입력 sql : insert into TEST (ID, PW) values ('HONG', 1);
        // 테이블 삭제 sql : drop table if exists member;
        // 테이블 검색 sql : select ID, PW from TEST where ID = 'hong';
        db.execSQL("create table if not exists member(" +
                " id text primary key," +
                " pw text," +
                " name text," +
                " phone text," +
                " email text," +
                " addr text);");
        db.execSQL("insert into member(id, pw, name, phone, email, addr) " +
                " values ('hong', '1', 'gildong', '010-2216-3844', 'jiryu12@naver.com', " +
                "'37.5597680,126.9423080');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists member;");
        this.onCreate(db);
    }

    public MemberBean login(MemberBean member){
        Log.d("DAO: LOGIN -  ID 체크", member.getId());
        MemberBean result = new MemberBean();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id, pw from member " +
                " where id = '"+ member.getId()+"'", null);
        if(cursor.moveToNext()) {
            result.setId(cursor.getString(0));
            result.setPw(cursor.getString(1));
            Log.d("커서 내부 -  ID 체크", result.getId() );
        } else {
            result.setId("NONE");
            Log.d("커서 내부 -  ID 체크", "ID가 존재하지 않는다.");
        }
        return result;
    }

    public void join(MemberBean member){
        Log.d("DAO: LOGIN -  ID 체크", member.getId());
        String sql = "insert into " +
                String.format(" member('%s', '%s', '%s', '%s', '%s', '%s')"
                        ,ID, PW, NAME, PHONE, EMAIL, ADDR) +
                String.format(" values ('%s', '%s', '%s', '%s', '%s', '%s');"
                , member.getId(), member.getPw(), member.getName(), member.getPhone(), member.getEmail(), member.getAddr());

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public MemberBean findById(String id) {
        String sql = "select " +
                String.format(" '%s', '%s', '%s', '%s', '%s', '%s')",ID, PW, NAME, PHONE, EMAIL, ADDR) +
                String.format(" where id = '%s';", id);
        SQLiteDatabase db = this.getReadableDatabase();
        MemberBean result = new MemberBean();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()){
            result.setId(cursor.getString(0));
            result.setPw(cursor.getString(1));
            result.setName(cursor.getString(2));
            result.setPhone(cursor.getString(3));
            result.setEmail(cursor.getString(4));
            result.setAddr(cursor.getString(5));
        }
        else {
            result.setId("NONE");
        }

        return result;
    }  // ID 존재여부

    public int count() {
        return 0;
    }  // 회원 수
    public List<MemberBean> list() {
        return null;
    }  // 전체목록
    public List<MemberBean> findByName(String name) {
        return null;
    }  // 이름으로 검색
    // UPDATE
    public  void update(MemberBean member) {}

    // DELETE
    public void deleter(String id) {}

}
