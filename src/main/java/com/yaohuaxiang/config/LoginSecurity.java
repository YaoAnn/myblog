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
                .antMatchers("/*").permitAll()//所有人可以访问
                .antMatchers("/manager/*").hasRole("manager");     // mnanager目录下必须有manager权限

        //开启登录页，没有权限默认跳转
        http.formLogin().loginPage("/manager").successForwardUrl("/manager/index.html");

    }

    //认证,用于数据库，失败
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
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

