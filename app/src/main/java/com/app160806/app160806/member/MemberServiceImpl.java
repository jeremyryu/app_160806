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
        return dao.count();
    }

    @Override
    public List<MemberBean> list() {
        return dao.list();
    }

    @Override
    public List<MemberBean> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public void update(MemberBean member) {
        dao.update(member);
    }

    @Override
    public void deleter(String id) {
        dao.deleter(id);
    }

    @Override
    public void join(MemberBean member) {
        Log.d("서비스: JOIN - ID 체크", member.getId());
        dao.join(member);;
    }
}
