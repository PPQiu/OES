package cn.aitechlab.oes.dto;


import cn.aitechlab.oes.annotation.Comment;
import lombok.Data;

/**
 * @Description: 获取管理员信息DTO对象
 * @Author: 王鹏伟
 * @Date: Created on 2019/4/24
 */
@Data
public class AdminDTO {

    @Comment("管理员账号")
    public String adminId;

    @Comment("管理员密码")
    public String password;

    @Comment("用户类型")
    public Integer userType;
}
