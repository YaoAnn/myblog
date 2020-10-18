package com.yaohuaxiang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author yaohuaxiang
 * @create 2020/10/15 - 14:29
 */
@Configuration
@EnableWebSecurity
public class LoginSecurity extends WebSecurityConfigurerAdapter {
    //使用BCrypt加密密码
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //设置不加密,过时
    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Autowired
    DataSource dataSource;

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()     // 对请求进行验证
                .antMatchers("/*").permitAll()//所有人可以访问,包含登录页面/manager
                //.antMatchers("/manager").permitAll()//登录页面所有人可以访问
                //.antMatchers("/manager/login.html").permitAll()//登录页面所有人可以访问
                .antMatchers("/manager/*").hasRole("manager");     // mnanager目录下必须有manager权限

        //开启登录页，没有权限默认跳转
        http.formLogin().loginPage("/manager")//指定登录页面，登录页面表单默认action=/login，method=post
                .loginProcessingUrl("/manager/index.html")//修改登录界面表单默认action,可以不写，表单不要action属性，默认登录成功，执行defaultSuccessUrl，推荐不写
                .defaultSuccessUrl("/manager/index.html");//指定登录成功跳转页面

        //关闭csrf功能
        http.csrf().disable();
        //登出
        http.logout().logoutUrl("/manager/logout")//设置登出的请求路径
                .logoutSuccessUrl("/manager");//设置登出成功后的页面,返回登陆页面

        //开启记住我,自定义remember参数
        http.rememberMe().rememberMeParameter("remember");

    }

    //认证,用于数据库，失败
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()).withDefaultSchema()
                .usersByUsernameQuery("select username,password,enable from manager where username = ?")
                .authoritiesByUsernameQuery("select username,role from manager where username = ?");
    }*/

    //认证,用于内存
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
                withUser("yaohuaxiang").password(passwordEncoder().encode("yhx5407582588")).roles("manager");
    }
}

