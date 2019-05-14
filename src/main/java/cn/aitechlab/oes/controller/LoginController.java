package cn.aitechlab.oes.controller;

import cn.aitechlab.oes.dto.LoginDTO;
import cn.aitechlab.oes.service.AdminService;
import cn.aitechlab.oes.service.ExamineeService;
import cn.aitechlab.oes.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 登陆Controller
 * @Author: 王鹏伟
 * @Date: Created on 2019/4/24
 */
@RestController
public class LoginController {

    private static final int USER = 1;

    @Autowired
    ExamineeService examineeService;

    @Autowired
    AdminService adminService;

    @PostMapping("/user/login")

    public LoginVO login(@RequestBody LoginDTO loginDTO) {

        Integer userType = loginDTO.userType;

        if(userType == USER){
            LoginVO loginVO = examineeService.examineeLogin(loginDTO);

            return loginVO;
        }else{
            LoginVO loginVO = adminService.adminLogin(loginDTO);

            return loginVO;
        }
    }


}
