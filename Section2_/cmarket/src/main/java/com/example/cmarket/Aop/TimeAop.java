package com.example.cmarket.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAop {

    @Around("execution(* com.example.cmarket..*(..))")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        String name = proceedingJoinPoint.toString();
        try {
            return proceedingJoinPoint.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            long callTime = startTime-endTime;

            System.out.println(name + " = " + callTime);
        }
    }
}

//실습내용