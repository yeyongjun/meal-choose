package com.develop.meal.dao.aspect;

import com.sinafenqi.commons.BaseAspectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoAspect {

    @Around("execution(public * com.develop.meal.dao.dao.*Dao.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return BaseAspectUtils.logAround(joinPoint, 300L);
    }
}