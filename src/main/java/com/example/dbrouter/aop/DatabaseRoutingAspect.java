package com.example.dbrouter.aop;

import com.example.dbrouter.context.DatabaseContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatabaseRoutingAspect {

    @Around("@within(UsingDb) || @annotation(UsingDb)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        UsingDb usingDb = signature.getMethod().getAnnotation(UsingDb.class);

        if (usingDb == null) {
            usingDb = joinPoint.getTarget().getClass().getAnnotation(UsingDb.class);
            if (usingDb != null) {
                System.out.println("Class-level aspect applied. Enum value: " + usingDb.value());
            }
        } else {
            System.out.println("Method-level aspect applied. Enum value: " + usingDb.value());
        }

        DatabaseContextHolder.set(usingDb != null ? usingDb.value() : null);
        try {
            return joinPoint.proceed();
        } finally {
            DatabaseContextHolder.clear();
        }
    }
}
