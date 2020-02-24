package com.github.springbootsecurity.security.core;

import com.github.springbootsecurity.security.pojo.SystemResourceDO;
import com.github.springbootsecurity.security.pojo.SystemRoleDO;
import com.github.springbootsecurity.security.service.ISystemResourceService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午9:41 2020/2/24
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class SystemFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private ISystemResourceService service;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        String method = fi.getRequest().getMethod();
        SystemResourceDO resource = service.findOneByUrlAndMethod(url, method);
        Set<String> set = resource.getSystemRoles().stream().map(SystemRoleDO::getRoleName).collect(Collectors.toSet());
        String[] array = new String[set.size()];
        set.toArray(array);
        return SecurityConfig.createList(array);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}