//package com.codestates.member;
//
//import org.mapstruct.Mapper;
//import org.springframework.stereotype.Component;
//
//import com.codestates.member.*;
//
//@Component
//public class MemberMapper {
//    //1). Post_Dto -> (Memeber)Entity 객체
//    public Member memberPostDtoToMember(MemberPostDto memberPostDto){
//        return new Member(0L,
//                memberPostDto.getEmail(),
//                memberPostDto.getName(),
//                memberPostDto.getPhone()
//        );
//    }
//
//    //2). Patch_Dto -> Entity(Memeber) 객체
//    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto){
//        return new Member(
//                memberPatchDto.getMemberId(),
//                null,
//                memberPatchDto.getName(),
//                memberPatchDto.getPhone()
//        );
//    }
//
//    //3). Entity(Memeber)객체 -> Response_Dto 객체
//    public MemberResponseDto memberToMemeberResponseDto(Member member){
//        return new MemberResponseDto(member.getMemberId(),
//                member.getEmail(),
//                member.getName(),
//                member.getPhone());
//    }
//}
//
