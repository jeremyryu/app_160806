package com.app160806.app160806.member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-08-06.
 */
public interface MemberService {
    // CREATE
    public void join(MemberBean member);  // 회원가입

    // READ
    public MemberBean login(MemberBean member); // 로그인
    public MemberBean findById(String id);  // ID 존재여부
    public int count();  // 회원 수

    public ArrayList<MemberBean> list();  // 전체목록
    public ArrayList<MemberBean> findByName(String name);  // 이름으로 검색

    // UPDATE
    public  void update(MemberBean member);

    // DELETE
    public void deleter(String id);
}
