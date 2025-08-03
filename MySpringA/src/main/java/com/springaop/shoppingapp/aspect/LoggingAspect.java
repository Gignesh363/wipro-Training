package com.springaop.shoppingapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.springaop.shoppingapp.service.ShoppingService.*(..))")
    public void logBefore() {
        System.out.println("[LOG] Before method execution");
    }

    @AfterReturning("execution(* com.springaop.shoppingapp.service.ShoppingService.*(..))")
    public void logAfterReturning() {
        System.out.println("[LOG] After successful method execution");
    }

    @AfterThrowing("execution(* com.springaop.shoppingapp.service.ShoppingService.*(..))")
    public void logAfterThrowing() {
        System.out.println("[LOG] Exception thrown during method execution");
    }

    @Around("execution(* com.springaop.shoppingapp.service.ShoppingService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("[LOG] Execution time: " + (end - start) + " ms");
        return result;
    }
}
