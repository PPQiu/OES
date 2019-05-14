package cn.aitechlab.oes.controller;

import cn.aitechlab.oes.model.Examinee;
import cn.aitechlab.oes.service.ExamineeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/5/14 0:45
 */
@RestController
public class ExamineeController {

    @Autowired
    ExamineeService examineeService;

    //根据考生名字查看考生信息

    @GetMapping("/getExamineeByExamineeName")
    public Examinee getExamineeByExamineeName(@Param("examineeName") String examineeName){
        return examineeService.getExamineeByExamineeName(examineeName);
    }

   //添加考生

    @PostMapping("/insertExaminee")
    public int insert(@RequestBody Examinee examinee){
        return examineeService.insert(examinee);
    }

    //删除考生

    @GetMapping("/delectExaminee")
    public int deleteByPrimaryKey(@Param("id") Integer id){
        return examineeService.deleteByPrimaryKey(id);
    }


    //更改考生信息

    @PostMapping("/editExamineeInfo")
    public int updateByPrimaryKeySelective(@RequestBody Examinee examinee){
        return examineeService.updateByPrimaryKeySelective(examinee);
    }


}
