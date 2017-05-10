package com.cc.configuration.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@SuppressWarnings("all")
public class ServiceMonitor {

    @AfterReturning("execution(* com.cc..*Service.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass;
        try {
            targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
