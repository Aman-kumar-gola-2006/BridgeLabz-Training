package com.cjc.payroll.aspect;

import org.aspectj.lang.JoinPoint;
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

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Pointcut("execution(* com.cjc.payroll.controller..*(..))")
    public void controllerPointcut() {
    }

    @Pointcut("execution(* com.cjc.payroll.service..*(..))")
    public void servicePointcut() {
    }
    
    @Pointcut("execution(* com.cjc.payroll.repository..*(..))")
    public void repositoryPointcut() {
    }

  
    @Pointcut("controllerPointcut() || servicePointcut() || repositoryPointcut()")
    public void applicationPointcut() {
    }
    
    @Around("applicationPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument(s) = {}", className, methodName, Arrays.toString(args));
        } else {
            log.info("Enter: {}.{}()", className, methodName);
        }

        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;

            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {} (Execution time: {} ms)", className, methodName, result, elapsedTime);
            } else {
                log.info("Exit: {}.{}() (Execution time: {} ms)", className, methodName, elapsedTime);
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(args), className, methodName);
            throw e;
        }
    }


    @AfterThrowing(pointcut = "applicationPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        log.error("Exception in {}.{}() with cause = '{}' and message = '{}'",
                className, methodName, e.getCause() != null ? e.getCause() : "NULL", e.getMessage());
    }
}
