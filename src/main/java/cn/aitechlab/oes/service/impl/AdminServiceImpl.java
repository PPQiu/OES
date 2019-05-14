package cn.aitechlab.oes.service.impl;

import cn.aitechlab.oes.dao.AdminMapper;
import cn.aitechlab.oes.dto.AdminDTO;
import cn.aitechlab.oes.dto.LoginDTO;
import cn.aitechlab.oes.service.AdminService;
import cn.aitechlab.oes.vo.AdminVO;
import cn.aitechlab.oes.vo.LoginVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 管理员登陆接口实现
 * @Author: 王鹏伟
 * @Date: Created on 2019/4/24
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public LoginVO adminLogin(LoginDTO loginDTO) {
        LoginVO loginVO = new LoginVO();
        AdminVO adminVO = new AdminVO();
        String adminId = loginDTO.adminId;
        String password = loginDTO.password;


        AdminDTO adminDTO = adminMapper.getAdminByAdminInfo(adminId, password);
        if (adminDTO == null) {
            loginVO.setSuccess(false);
            loginVO.setMsg("账号或密码错误");
            return loginVO;
        }

        loginVO.setSuccess(true);
        loginVO.setMsg("登陆成功");
        BeanUtils.copyProperties(adminDTO, adminVO);
        loginVO.setAdminInfo(adminVO);

        return loginVO;
    }


}
