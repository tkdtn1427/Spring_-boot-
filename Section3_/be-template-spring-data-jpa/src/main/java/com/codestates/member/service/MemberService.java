package com.codestates.member.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    public Member createMember(Member member) {
        verifiyExistsEmail(member.getEmail());
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable(member.getName()).ifPresent(name->findMember.setName(name));
        Optional.ofNullable(member.getPhone()).ifPresent(phone->findMember.setPhone(phone));
        Optional.ofNullable(member.getMemberStatus()).ifPresent(memberStatus
                ->findMember.setMemberStatus(memberStatus));

        findMember.setModifiedAt(LocalDateTime.now());
        return findMember;
    }

    public Member findMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);

        return findMember;
    }

    public Page<Member> findMembers(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("memberId").descending());
        Page<Member> resultPage = memberRepository.findAll(pageRequest);
        return resultPage;
    }

    public void deleteMember(long memberId) {
        Member result = findVerifiedMember(memberId);
        memberRepository.delete(result);
    }

    public Member findVerifiedMember(long memberId){
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return findMember;
    }

    public void verifiyExistsEmail(String email){
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isPresent()){
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }
}
