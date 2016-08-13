package com.app160806.app160806.member;

import android.content.Context;
import android.util.Log;

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
        MemberBean result = dao.login(member);
        return result;
    }

    @Override
    public void join(MemberBean member) {
        Log.d("서비스: JOIN - ID 체크", member.getId());
        dao.join(member);;
    }
}
