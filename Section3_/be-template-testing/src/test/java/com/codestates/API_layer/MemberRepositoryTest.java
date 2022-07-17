package com.codestates.API_layer;

import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.constraints.NotNull;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@DataJpaTest
public class MemberRepositoryTest {
    private Member member;
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void toAll(){
        member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");
    }


    @Test
    public void saveMemberTest(){
        Member savedMember = memberRepository.save(member);

        assertThat(savedMember, is(notNullValue()));
        assertThat(savedMember.getEmail(), is(equalTo(member.getEmail())));
        assertThat(savedMember.getName(), is(equalTo(member.getName())));
        assertThat(savedMember.getPhone(), is(equalTo(member.getPhone())));
    }

    @Test
    public void findByEmailTest(){
        memberRepository.save(member);
        Optional<Member> findMember =
                memberRepository.findByEmail(member.getEmail());

        assertThat(findMember.isPresent(),is(equalTo(true)));
        assertThat(findMember.get().getEmail(), is(equalTo(member.getEmail())));
    }
}
