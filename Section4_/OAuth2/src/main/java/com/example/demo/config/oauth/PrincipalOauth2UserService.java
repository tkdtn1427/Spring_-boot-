package com.example.demo.config.oauth;

import com.example.demo.config.PrincipalDetails;
import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{

        OAuth2User oAuth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getClientId();
        String providerId = oAuth2User.getAttribute("sub");
        String username = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");
        String role = "ROSE_USER";

        Member memberEntity = memberRepository.findByUsername(username);

        if(memberEntity == null){
            memberEntity = Member.builder()
                    .username(username)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            memberRepository.save(memberEntity);

//            Member temp = new Member(username,email,role,provider,providerId);
//            memberEntity = temp;
//            memberRepository.save(memberEntity);
        }

        return new PrincipalDetails(memberEntity, oAuth2User.getAttributes());
    }
}