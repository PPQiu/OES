package cn.aitechlab.oes.service.impl;


import cn.aitechlab.oes.dao.ExamineeMapper;
import cn.aitechlab.oes.dto.ExamineeDTO;
import cn.aitechlab.oes.dto.LoginDTO;
import cn.aitechlab.oes.model.Examinee;
import cn.aitechlab.oes.model.Question;
import cn.aitechlab.oes.service.ExamineeService;
import cn.aitechlab.oes.utils.FileUtil;
import cn.aitechlab.oes.vo.ExamineeVO;
import cn.aitechlab.oes.vo.LoginVO;
import cn.aitechlab.oes.vo.UploadVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用户登陆接口实现
 * @Author: 王鹏伟
 * @Date: Created on 2019/4/24
 */
@Service
public class ExamineeServiceImpl implements ExamineeService {

    @Autowired
    ExamineeMapper examineeMapper;

    //考生登录

    @Override
    public LoginVO examineeLogin(LoginDTO loginDTO) {

        LoginVO loginVO = new LoginVO();
        ExamineeVO examineeVO = new ExamineeVO();

        String examineeId = loginDTO.examineeId;
        String examineeName = loginDTO.examineeName;
        String identityNum = loginDTO.identityNum;


        ExamineeDTO examineeDTO = examineeMapper.getExamineeByExamineeInfo(examineeId, examineeName, identityNum);
        if (examineeDTO == null) {
            loginVO.setSuccess(false);
            loginVO.setMsg("用户不存在或密码错误或身份证号错误");

            return loginVO;
        }

        loginVO.setSuccess(true);
        loginVO.setMsg("登录成功");
        BeanUtils.copyProperties(examineeDTO, examineeVO);
        loginVO.setExamineeInfo(examineeVO);

        return loginVO;
    }


    //上传考生信息

    @Override
    public UploadVO uploadExamineeFile(MultipartFile file) {

        UploadVO uploadVO = new UploadVO();
        //总行记录
        List<ArrayList<String>> readResult = null;
        //判断文件是否为空
        if (file.isEmpty()) {
            uploadVO.setSuccess(false);
            uploadVO.setMsg("上传文件为空");
            return uploadVO;
        }
        //判断文件大小
        long size = file.getSize();
        String name = file.getOriginalFilename();
        if (StringUtils.isBlank(name) || size == 0) {
            uploadVO.setSuccess(false);
            uploadVO.setMsg("上传文件为空");
            return uploadVO;
        }
        //获取文件后缀
        String postfix = FileUtil.getPostfix(name);

        //读取文件内容
        if (StringUtils.equals("xlsx", postfix)) {
            readResult = FileUtil.readXlsx(file);
        } else if (StringUtils.equals("xls", postfix)) {
            readResult = FileUtil.readXls(file);
        } else {
            uploadVO.setSuccess(false);
            uploadVO.setMsg("文件类型错误");
            return uploadVO;
        }

        if (readResult == null || readResult.size() == 0) {
            uploadVO.setSuccess(false);
            uploadVO.setMsg("文件解析失败");
            return uploadVO;

        }

//        for (ArrayList<String> arr : readResult) {
//            Examinee examinee=new Examinee(arr.get(0),arr.get(1),arr.get(2), Byte.valueOf(arr.get(3)));
//

        for(int i = 2; i < readResult.size(); i++ ){
            Examinee examinee=new Examinee(readResult.get(i).get(0),readResult.get(i).get(1),readResult.get(i).get(2),Byte.valueOf(readResult.get(i).get(3)));


            examineeMapper.uploadExamineeFile(examinee);
        }
        uploadVO.setSuccess(true);
        uploadVO.setMsg("上传成功");
        return uploadVO;
    }

    @Override
    public List<Examinee> getall(){
        return examineeMapper.selectall();
    }

    @Override
    public Examinee getExamineeByExamineeName(@RequestParam("examineeName") String examineeName){
        return examineeMapper.selectExamineeByExamineeName(examineeName);

    }

    @Override
    public int insert(Examinee examinee){
        return examineeMapper.insert(examinee);
    }

    @Override
    public int deleteByPrimaryKey(Integer id){
        return examineeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Examinee examinee){
        return examineeMapper.updateByPrimaryKeySelective(examinee);
    }



}
