package com.app160806.app160806.member;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by 1027 on 2016-08-06.
 */
public class MemberServiceImpl implements MemberService{
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }

    @Override
    public MemberBean login(MemberBean member) {
        Log.d("서비스: LOGIN -  ID 체크", member.getId());
        return dao.login(member);
    }

    @Override
    public MemberBean findById(String id) {
        Log.d("서비스:JOIN - ID 체크", id);
        return dao.findById(id);
    }


    @Override
    public int count() {
        Log.d("서비스:JOIN count", "진입");
        return dao.count();
    }

    @Override
    public List<MemberBean> list() {
        Log.d("서비스:JOIN List", "진입");
        return dao.list();
    }

    @Override
    public List<MemberBean> findByName(String name) {
        Log.d("서비스:JOIN findByName", name);
        return dao.findByName(name);
    }

    @Override
    public void update(MemberBean member) {
        Log.d("서비스:JOIN update", "진입");
        dao.update(member);
    }

    @Override
    public void deleter(String id) {
        Log.d("서비스:JOIN deleter", id);
        dao.deleter(id);
    }

    @Override
    public void join(MemberBean member) {
        Log.d("서비스: JOIN 체크", member.getId());
        dao.join(member);;
    }
}
