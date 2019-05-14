package cn.aitechlab.oes.controller;

import cn.aitechlab.oes.dto.PaperAndQuestionDTO;
import cn.aitechlab.oes.model.Paper;
import cn.aitechlab.oes.model.Question;
import cn.aitechlab.oes.service.PaperService;
import cn.aitechlab.oes.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/5/13 10:29
 */
@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    @Autowired
    QuestionService questionService;

    //教师创建考试信息------仅仅对该场考试的信息

    @PostMapping("/insert")
    public int insert(@RequestBody Paper paper) {
        return paperService.insert(paper);
    }

    //根据paper的ID查找试题

    @GetMapping("/getQuestionByPaperId")
    public List<Question> getQuestionById(@Param("id") Integer id){
        return questionService.getQuestionByPaperId(id);
    }

    //添加试题

    @PostMapping("/insertQuestion")
    public int insert(@RequestBody Question question){
        return questionService.insert(question);

    }


    //教师查看所有考试信息

    @GetMapping("/getAllPaperInfo")
    public List<Paper> getAllPaperInfo() {
        return paperService.getAllPaperInfo();

    }

    //修改考试信息,publish的状态也在此修改

    @PostMapping("/edit")
    public int updateByPrimaryKeySelective(@RequestBody Paper paper) {
        return paperService.updateByPrimaryKeySelective(paper);
    }

    //考生查看考试信息，只有发布了的考试信息才能看到,publish=true

    @GetMapping("/getPaperInfo")
    public List<Paper> getPaperInfoIsPublish() {
        return paperService.getPaperInfoIsPublish();
    }
/**
    //创建考试信息及试题

    @PostMapping("/insertPaperAndQuestionDTO")
    public void insert(@RequestBody PaperAndQuestionDTO paperAndQuestionDTO) {

        //获取到的相关试卷信息存入数据库
        paperService.insert(paperAndQuestionDTO.getPaper());
        //根据paperName查找id
        int id = paperService.getIdByPaperName(paperAndQuestionDTO.getPaper().getPaperName());

        //查找题库中的paperId,与id作比较，如果存在，则将试题信息查找出来
        //如果不存在，就创建试题或者导入试题

        List<Question> questionList = questionService.getPaperId();

        for (Question question : questionList) {
            if (question.getPaperId().equals(id)) {
                questionService.getQuestionByPaperId(question.getPaperId());
            } else {
                //创建新的题目或者批量上传题目
                questionService.insertSelective(question);
            }

        }

    }

    */
}
