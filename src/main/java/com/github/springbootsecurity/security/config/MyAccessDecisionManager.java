package com.github.springbootsecurity.security.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * <p>
 * 创建时间为 上午10:57 2019/12/5
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class MyAccessDecisionManager implements AccessDecisionManager {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void decide(Authentication authentication, Object object, @NotNull Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        for (ConfigAttribute ca : configAttributes) {
            String needRole = ca.getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (antPathMatcher.match(needRole,ga.getAuthority())) {
                    //匹配到有对应角色,则允许通过
                    return;
                }
            }
        }
        //该url有配置权限,但是当然登录用户没有匹配到对应权限,则禁止访问
        throw new AccessDeniedException("not allow");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}