package cn.aitechlab.oes.controller;

import cn.aitechlab.oes.dto.ExamineeScoreDTO;
import cn.aitechlab.oes.service.AnswerPaperService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 成绩控制层
 * @Author: PPQiu
 * @CreateDate: 2019/5/12 23:30
 */
@RestController
@RequestMapping("/exam")
public class ScoreController {
    @Autowired
    AnswerPaperService answerPaperService;

    //根据考生学号获取所有成绩  -----学生查看自己所有成绩

    @GetMapping("allscore1")
    public List<ExamineeScoreDTO> getScoreByExamineeId(@Param("examineeId") String examineeId) {
        List<ExamineeScoreDTO> examineeScoreDTOList = answerPaperService.getScoreByExamineeId(examineeId);
        return examineeScoreDTOList;

    }


    //根据考生名字查看该学生所有成绩 ---- 老师查看学生成绩

    @GetMapping("allscore2")
    public List<ExamineeScoreDTO> getScoreByExamineeName(@Param("examineeName") String examineeName) {
        List<ExamineeScoreDTO> examineeScoreDTOList = answerPaperService.getScoreByExamineeName(examineeName);
        return examineeScoreDTOList;

    }


    //根据考试名称查看参与某场考试的所有学生成绩 ---- 老师查看某场考试所有学生成绩

    @GetMapping("allscore3")
    public List<ExamineeScoreDTO> getScoreByPaperName(@Param("paperName") String paperName) {
        List<ExamineeScoreDTO> examineeScoreDTOList = answerPaperService.getScoreByPaperName(paperName);
        return examineeScoreDTOList;

    }




}
