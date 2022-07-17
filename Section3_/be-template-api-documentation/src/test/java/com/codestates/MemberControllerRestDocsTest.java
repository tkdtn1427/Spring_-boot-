//package com.codestates;
//
//import com.codestates.member.mapper.MemberMapper;
//import com.codestates.member.service.MemberService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//@WebMvcTest(MemberController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class MemberControllerRestDocsTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private MemberService memberService;
//
//    @MockBean
//    private MemberMapper mapper;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    public void postMemberTest() throws Exception {
//        // given
//        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com",
//                "홍길동",
//                "010-1234-5678");
//        String content = gson.toJson(post);
//
//        MemberDto.response responseDto =
//                new MemberDto.response(1L,
//                        "hgd@gmail.com",
//                        "홍길동",
//                        "010-1234-5678",
//                        Member.MemberStatus.MEMBER_ACTIVE,
//                        new Stamp());
//
//        // willReturn()이 최소 null은 아니어야 한다.
//        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class)))
//                .willReturn(new Member());
//
//        given(memberService.createMember(Mockito.any(Member.class)))
//                .willReturn(new Member());
//
//        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/v11/members")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
//                .andExpect(jsonPath("$.data.name").value(post.getName()))
//                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
//                .andDo(document("post-member",    // =========== (1) API 문서화 관련 코드 시작 ========
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
//                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태"),
//                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
//                                )
//                        )
//                ));   // =========== (2) API 문서화 관련 코드 끝========
//    }
//}