package com.codestates.member.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * V2
 *  - 메서드 구현
 *  - DI 적용
 */
@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        // TODO should business logic
        verifyExistsEmail(member.getEmail());

        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        // TODO should business logic
        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable(member.getName()).ifPresent(name->findMember.setName(name));
        Optional.ofNullable(member.getPhone()).ifPresent(phone->findMember.setPhone(phone));

        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId) {
        // TODO should business logic
        Member member = findVerifiedMember(memberId);

        return member;
    }

    public List<Member> findMembers() {
        // TODO should business logic
//        List<Member> members = (List<Member>) memberRepository.findAll();
//        return members;
        return (List<Member>) memberRepository.findAll();

    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);

//        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Member findVerifiedMember(long memberId){
        Optional<Member> optionalMember = memberRepository.findById(memberId);
//        if(optionalMember.isPresent()){
//            Member findMember = optionalMember.get();
//        }else{
//            throw  new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
//        }
        Member findMember = optionalMember.orElseThrow(()->new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return findMember;
    }

    private void verifyExistsEmail(String email){
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent()){
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }
}
