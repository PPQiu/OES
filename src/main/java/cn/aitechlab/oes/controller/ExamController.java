package cn.aitechlab.oes.controller;

import cn.aitechlab.oes.dto.AnswerDTO;
import cn.aitechlab.oes.dto.AnswerPaperInfoDTO;
import cn.aitechlab.oes.dto.PaperQuestionDTO;
import cn.aitechlab.oes.dto.ResultDTO;
import cn.aitechlab.oes.model.AnswerPaper;
import cn.aitechlab.oes.model.AnswerQuestion;
import cn.aitechlab.oes.model.Paper;
import cn.aitechlab.oes.service.AnswerPaperService;
import cn.aitechlab.oes.service.QuestionService;
import cn.aitechlab.oes.utils.IdGen;
import cn.aitechlab.oes.vo.ExamInfoVO;
import cn.aitechlab.oes.vo.SubmitVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/4/27 1:47
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerPaperService answerPaperService;


    //学生根据paperName获取试题信息

    @GetMapping("/questionlist")
    public ExamInfoVO showExamQuestions(@Param("paperName") String paperName) {
        ExamInfoVO examInfoVO = new ExamInfoVO();
        List<PaperQuestionDTO> paperQuestionDTOList = questionService.getPaperQuestionByPaperName(paperName);
        AnswerPaper answerPaper = new AnswerPaper();
        answerPaper.setId(IdGen.uuid());
        examInfoVO.setAnswerPaper(answerPaper);
        examInfoVO.setPaperQuestionVO(paperQuestionDTOList);
        return examInfoVO;
    }


    //提交改卷试卷

    @PostMapping("/submit")
    public SubmitVO submit(@RequestBody AnswerPaperInfoDTO answerPaperInfoDTO,
                           @RequestParam(required = false) String examineeId) {

        SubmitVO submitVO = new SubmitVO();
        Paper paper = answerPaperInfoDTO.getPaper();
        AnswerPaper answerPaper = answerPaperInfoDTO.getAnswerPaper();
        /**
         * 更改试卷状态，finished:true
         */
        if (answerPaper.getId() != null) {
            answerPaper.setId(answerPaper.getId());
            answerPaper.setPaperId(paper.getId());
            answerPaper.setAnswerTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            answerPaper.setExamineeId(examineeId);
            answerPaper.setFinish("true");
            answerPaper.setTotalScore(answerPaper.getTotalScore());
            answerPaperService.saveAnswerpaper(answerPaper);

        int score = 0;

        //正确题目数
        double right = 0.0;

        //错误题目数
        double wrong = 0.0;

        double correctRate = 0.0;

        List<AnswerDTO> answerDTOList = questionService.getAnswerByPaperId(Integer.valueOf(paper.getId()));

        List<AnswerQuestion> answerQuestionList = answerPaper.getAnswerQuestionList();

        //遍历提交的试卷的题目
        for(AnswerDTO answerDTO : answerDTOList) {

            //遍历学生答卷
            for(AnswerQuestion answerQuestion : answerQuestionList) {
                /**
                 * 1.题目序号相同
                 * 2.结果与答案相同
                 */
                if(answerQuestion.getNumber().equals(answerDTO.getNumber())) {
                    if(answerQuestion.getSelectAnswer().equals(answerDTO.getAnswer())) {
                        /*累计得分*/
                        score += answerDTO.getScore();
                        right ++;
                    }else {
                        wrong ++;

                    }
                }
            }
        }
        //计算正确率
        correctRate = (right/(right + wrong)) * 100;

        ResultDTO result = new ResultDTO();
        result.setScore(score);
        result.setRight(right);
        result.setWrong(wrong);
        result.setCorrectRate(correctRate);

        answerPaper.setTotalScore(result.getScore());
        answerPaperService.updateAnswerPaper(answerPaper);

        submitVO.setSuccess(true);
        submitVO.setMsg("提交成功");
        return submitVO;



    }else {

            submitVO.setSuccess(false);
            submitVO.setMsg("提交失败");
            return submitVO;

        }

    }


}







