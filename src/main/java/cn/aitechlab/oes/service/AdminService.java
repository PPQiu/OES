package cn.aitechlab.oes.service;


import cn.aitechlab.oes.dto.LoginDTO;
import cn.aitechlab.oes.vo.LoginVO;

/**
 * @Description: 管理员登陆接口
 * @Author: 王鹏伟
 * @Date: Created on 2019/4/24
 */

public interface AdminService {
    /**
     * 管理员登陆 adminLogin
     *
     * @param loginDTO 登陆用户DTO
     * @return LoginVO
     */
    LoginVO adminLogin(LoginDTO loginDTO);
}
