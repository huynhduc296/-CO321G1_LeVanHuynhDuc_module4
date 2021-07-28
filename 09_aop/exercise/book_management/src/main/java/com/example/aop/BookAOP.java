package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BookAOP {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private int view = 0;

    @AfterThrowing("execution(* com.example.controller.*.*(..))")
    public void logAfterMethodReturn(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.error("Ten phuong thuc : " + nameMethod);
        logger.error("Tham so : " + args);
    }

    @Pointcut("execution(* com.example.controller.BookController.*(..))")
    public void viewCount() {
    }
    @Before("viewCount()")
    public void count() {
        view += 1;
        System.err.println("Total views " + view);
    }
}
