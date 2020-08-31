package com.example.demo.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Pointcut("@annotation(com.example.demo.annotation.Log)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        System.out.println("前置消息");
        //执行方法
        Object result = point.proceed();

        System.out.println("后置消息");
        return result;
    }

    @Before("logPointCut()")
    public void before(JoinPoint point) throws Throwable {
        System.out.println("before");
    }
    @After("logPointCut()")
    public void after(JoinPoint point) throws Throwable {
        System.out.println("after");
    }

    /**
     * 返回通知通知（返回通知）
     */
    @AfterReturning(returning = "str",pointcut = "logPointCut()")
    public void doAfterReturningGame(String  str){

        System.out.println("***********返回通知**************: " + str);
    }
}
