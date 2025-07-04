package com.library.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.library.service.*.*(..))")
    public void logExecution(ProceedingJoinPoint joinPoint) throws Throwable{

        String methodName = joinPoint.getSignature().toShortString();

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - startTime;

        System.out.println("Log\n----------------------------------------");
        System.out.println("Method: " + methodName);
        System.out.println("Duration: " + duration + "ms");
        System.out.println("----------------------------------------");

    }
}
