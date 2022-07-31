package spring.security.JWT.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spring.security.JWT.model.Member;
import spring.security.JWT.repository.MemberRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/home")
    public String home() {
        return "<h1>home</h1>";
    }

    @PostMapping("/token")
    public String token(){
        return "<h1>token</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
        return "회원 가입 완료";
       }

    @GetMapping("/api/v1/user")
    public String user() {
        return "user";
    }
    // 추가
    @GetMapping("/api/v1/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/api/v1/manager")
    public String manager() {
        return "manager";
    }


//    @PatchMapping("/update")
//    public String patch(){
//        Optional<Member> optionalMember = memberRepository.findById(1L);
//        if(optionalMember.isPresent()){
//            Member member = optionalMember.orElseThrow(() -> new RuntimeException());
//            member.setRoles("ROLE_ADMIN");
//            memberRepository.save(member);
//        }
//
//        return "변경완료";
//    }

}