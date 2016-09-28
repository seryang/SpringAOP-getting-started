package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Seryang on 2016-08-11.
 */
@Component
@Aspect
public class LoggingAop {

    @Pointcut("within(com.example.controller..*)")
    public void logging() {
    }

    @Pointcut("within(com.example.controller..*)")
    public void authentification() {}

    @Around("logging()")
    public String before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("* Around *");
        Map<String, Object> map;
        Object[] obList  = proceedingJoinPoint.getArgs();
        Model model = null;
        String page = (String) proceedingJoinPoint.proceed();

        System.out.println(page);
        for(Object ob : obList){
            if (ob instanceof Model) {
                model = (Model) ob;
            }
        }
        if( model != null ){
            map = model.asMap();
        }else{
            map = new HashMap<>();
        }
        System.out.println(map);
        System.out.println(proceedingJoinPoint);
        return page;
    }

    @Before("logging()")
    public void before(JoinPoint proceedingJoinPoint) {
        System.out.println("* before *");
        Map<String, Object> map;
        Object[] obList  = proceedingJoinPoint.getArgs();
        Model model = null;
        for(Object ob : obList){
            if (ob instanceof Model) {
                model = (Model) ob;
            }
        }
        if( model != null ){
            map = model.asMap();
        }else{
            map = new HashMap<>();
        }
        System.out.println(map);
        System.out.println(proceedingJoinPoint);
    }

    @After("authentification()")
    public void after(JoinPoint proceedingJoinPoint) {
        System.out.println("* after *");
        Map<String, Object> map;
        Object[] obList  = proceedingJoinPoint.getArgs();
        Model model = null;
        for(Object ob : obList){
            if (ob instanceof Model) {
                model = (Model) ob;
            }
        }
        if( model != null ){
            map = model.asMap();
        }else{
            map = new HashMap<>();
        }
        System.out.println(map);
        System.out.println(proceedingJoinPoint);
    }
}