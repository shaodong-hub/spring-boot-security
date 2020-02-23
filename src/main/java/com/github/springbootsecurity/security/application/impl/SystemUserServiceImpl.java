//package com.github.springbootsecurity.security.application.impl;
//
//import com.github.springbootsecurity.security.doo.SystemUserDO;
//import com.github.springbootsecurity.security.repository.ISystemUserJpaRepository;
//import com.github.springbootsecurity.security.application.ISystemUserService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * <p>
// * 创建时间为 上午11:45 2019/10/18
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@Service
//public class SystemUserServiceImpl implements ISystemUserService {
//
//    @Resource
//    private ISystemUserJpaRepository userJpaRepository;
//
//    @Override
//    public Page<SystemUserDO> findAllUsers(Pageable pageable) {
//        return userJpaRepository.findAll(pageable);
//    }
//
//}