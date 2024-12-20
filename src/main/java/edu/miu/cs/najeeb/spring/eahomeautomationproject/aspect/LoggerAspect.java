package edu.miu.cs.najeeb.spring.eahomeautomationproject.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("execution( * edu.miu.cs.najeeb.spring.eahomeautomationproject.controller.*.*(..))")
    public void apiLoggingPointCut() {
    }

    @Around("apiLoggingPointCut()")
    public Object apiLoggingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        LOGGER.info("Incoming request for {}.{} with arguments: {}", className, methodName, Arrays.toString(methodArgs));
        Object response;
        response = joinPoint.proceed();
        LOGGER.info("Response from {}.{} is: {}", className, methodName, response);
        return response;
    }

}
