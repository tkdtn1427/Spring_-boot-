package com.codestates.API_layer;

import com.codestates.exception.BusinessLogicException;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import com.codestates.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
//@Transactional
//@AutoConfigureMockMvc
//@SpringBootTest
public class MemberServiceMockTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void createMemberTest(){
        Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");

        given(memberRepository.findByEmail(member.getEmail())).willReturn(Optional.of(member));

        assertThrows(BusinessLogicException.class, ()-> memberService.createMember(member));
    }
}
