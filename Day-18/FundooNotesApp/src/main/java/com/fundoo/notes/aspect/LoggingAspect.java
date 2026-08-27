package com.fundoo.notes.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut targeting all methods in controller and service packages
    @Pointcut("execution(* com.fundoo.notes.controller..*(..)) || execution(* com.fundoo.notes.service..*(..))")
    public void applicationPackagePointcut() {
    }

    @Around("applicationPackagePointcut()")
    public Object logExecutionTimeAndDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("[AOP LOG] Entering: {}.{}() with arguments: {}", className, methodName, Arrays.toString(args));

        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("[AOP LOG] Exception in {}.{}(): {}", className, methodName, throwable.getMessage());
            throw throwable;
        }
        long duration = System.currentTimeMillis() - startTime;

        logger.info("[AOP LOG] Exiting: {}.{}() | Execution Time: {} ms", className, methodName, duration);

        return result;
    }
}
