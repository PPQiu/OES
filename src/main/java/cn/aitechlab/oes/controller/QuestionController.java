package cn.aitechlab.oes.controller;

import cn.aitechlab.oes.model.Question;
import cn.aitechlab.oes.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 题库管理
 * @Author: PPQiu
 * @CreateDate: 2019/5/13 1:29
 */

@RestController
@RequestMapping("/exam")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    //获取所有试题

    @GetMapping("allquestion")
    public List<Question> getAllQuestion(){
        List<Question> questionList = questionService.getAllQuestion();
        return questionList;
    }

    //查看某张试卷的所有试题

    @GetMapping("getQuestionBypaperName")
    public List<Question> getQuestionByPaperName(@Param("paperName") String paperName){
        return questionService.getQuestionByPaperName(paperName);
    }

    //删除某个题目

    @GetMapping("delectQuestionById")
    public int deleteByPrimaryKey(@Param("id") Integer id){
        return questionService.deleteByPrimaryKey(id);
    }

    //修改某个题目

    @PostMapping("editQuestionById")
    public int updateByPrimaryKeySelective(@RequestBody Question question){
        return questionService.updateByPrimaryKeySelective(question);

    }




}
