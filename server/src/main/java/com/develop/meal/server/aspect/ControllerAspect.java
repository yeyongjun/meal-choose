package com.develop.meal.server.aspect;

import com.sinafenqi.commons.BaseAspectUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ControllerAspect {
    @Around("execution(public * com.develop.meal.server.controller.*Controller.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return BaseAspectUtils.logAround(joinPoint, 500L);
    }
}
