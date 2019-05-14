package cn.aitechlab.oes.service;


import cn.aitechlab.oes.dto.LoginDTO;
import cn.aitechlab.oes.model.Examinee;
import cn.aitechlab.oes.vo.LoginVO;
import cn.aitechlab.oes.vo.UploadVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description: 用户登陆接口
 * @Author: 王鹏伟
 * @Date: Created on 2019/4/24
 */

public interface ExamineeService {
    /**
     * 用户登陆 examineeLogin
     *
     * @param loginDTO 登陆用户DTO
     * @return LoginVO
     */
    LoginVO examineeLogin(LoginDTO loginDTO);

    UploadVO uploadExamineeFile(MultipartFile file);

    List<Examinee> getall();

    Examinee getExamineeByExamineeName(String examineeName);

    int insert(Examinee examinee);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Examinee examinee);
}
