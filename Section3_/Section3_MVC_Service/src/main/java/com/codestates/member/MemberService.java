package com.codestates.member;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {
    public Member createMember(Member member){

        Member createMember = member;
        return createMember;
    }

    public Member updateMember(Member member){

        Member updateMember = member;
        return updateMember;
    }

    public Member findMember(long memberId){

        Member member = new Member(memberId,"hgd@gmail.com","홍길동","010-1234-5678");
        return member;
    }

    public List<Member> findMembers(){

        List<Member> members = List.of(new Member(1, "hgd@gmail.com", "홍길동", "010-1234-5678"),
                new Member(2, "lml@gmail.com", "이몽룡", "010-1111-2222"));
        return members;
    }

    public void deleteMember(long memberId){

    }

}
