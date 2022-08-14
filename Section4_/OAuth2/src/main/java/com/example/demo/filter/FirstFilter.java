package com.example.demo.filter;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;
import java.util.Optional;

public class FirstFilter implements Filter {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("FirstFilter 생성");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("========First 필터 시작========");
        chain.doFilter(request, response);
        System.out.println("========First 필터 종료========");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter 사라짐");
        Filter.super.destroy();
    }
}
