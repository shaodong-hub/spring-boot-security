package com.github.springbootsecurity.security.controller.user;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.dto.PasswordRetrieveDTO;
import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.service.ISystemMaintainService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午1:51 2020/2/26
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
@PreAuthorize("permitAll()")
public class SystemMaintainController {

    @Resource
    private ISystemMaintainService service;

    @PostMapping("register")
    public ResultDTO<String> register(@RequestBody UserRegisterDTO userRegister) {
        String result = service.register(userRegister);
        return ResultDTO.success(result);
    }

    @GetMapping("/password/forget/{mode}/{username}")
    public ResultDTO<String> forget(@PathVariable String mode, @PathVariable String username) {
        String result = service.forget(mode, username);
        return ResultDTO.success(result);
    }

    @PostMapping("/password/retrieve/{random}")
    public ResultDTO<String> retrieve(@PathVariable String random, @RequestBody PasswordRetrieveDTO retrieve) {
        String result = service.retrieve(random, retrieve);
        return ResultDTO.success(result);
    }

}
