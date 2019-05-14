package cn.aitechlab.oes.vo;


import cn.aitechlab.oes.annotation.Comment;
import lombok.Data;

/**
 * @Description: 获取用户信息VO对象
 * @Author: 王鹏伟
 * @Date: Created on 2019/4/24
 */
@Data
public class ExamineeVO {

    @Comment("考生学号")
    public String examineeId;

    @Comment("考生名字")
    public String examineeName;

    @Comment("身份证号")
    public String identityNum;

    @Comment("用户类型")
    public Integer userType;
}
