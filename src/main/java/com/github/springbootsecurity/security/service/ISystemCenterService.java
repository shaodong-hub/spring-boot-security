package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.dto.PayDTO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;

/**
 * <p>
 * 创建时间为 下午4:08 2020/3/3
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemCenterService {

    void pay(PayDTO pay, SystemUserDO authentication);

}
