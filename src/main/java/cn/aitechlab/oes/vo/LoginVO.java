package cn.aitechlab.oes.vo;

import lombok.Data;

/**
 * @Description: 获取登陆信息VO对象
 * @Author: 王鹏伟
 * @Date: Created on 2019/4/24
 */
@Data
public class LoginVO {

    // 登录状态

    public Boolean success;

    // 返回信息

    public String msg;

    //用户信息

    ExamineeVO examineeInfo;

    //管理员信息

    AdminVO adminInfo;

}
