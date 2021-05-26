package com.example.demo.controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;


public class authentication {
    SimpleAccountRealm simpleAccountRealm =new SimpleAccountRealm();
    public  void addUser(){
        simpleAccountRealm.addAccount("wmyskxz", "123456");
    }

    public void testAuthentication(){
        DefaultSecurityManager defaultSecurityManager =new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject =SecurityUtils.getSubject();

        UsernamePasswordToken token =new UsernamePasswordToken("wmyskxz", "123456");
        subject.login(token);

        System.out.print("isAuthenticated:"+subject.isAuthenticated());

        subject.logout();

        System.out.print("isAuthenticated:"+subject.isAuthenticated());
    }
}
