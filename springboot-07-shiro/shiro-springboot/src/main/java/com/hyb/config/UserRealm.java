package com.hyb.config;

import com.hyb.pojo.User;
import com.hyb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的UserRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权=》doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addStringPermission("user:add");

        //拿到当前登录的这个对象
//        Subject subject = SecurityUtils.getSubject();
//        User currentUser = (User)subject.getPrincipal();//拿到user对象
        //设置当前用户的权限,数据库中的权限(从数据库中读的)
//        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证=》doGetAuthenticationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

//        // 虚拟用户
//        String name = "root";
//        String password = "123456";
//        if (!userToken.getUsername().equals(name)) {
//            return null;//抛出异常 UnknownAccountException
//        }

        //真实数据库
        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null) {//没有这个人
            return null;//UnknownAccountException
        }

        //首页
        //Subject currentSubject = SecurityUtils.getSubject();
        //Session session = currentSubject.getSession();
        //session.setAttribute("loginUser",user);

        // 密码认证，shiro做
//        return new SimpleAuthenticationInfo("user",password,"");
        //System.out.println(user);
        return new SimpleAuthenticationInfo(user,user.getAddress(),"");//数据库没有密码，暂用地址代替
    }
}
