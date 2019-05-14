package cn.aitechlab.oes.service;

import cn.aitechlab.oes.dto.ExamineeScoreDTO;
import cn.aitechlab.oes.model.AnswerPaper;

import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/4/27 4:23
 */
public interface AnswerPaperService {

    int updateAnswerPaper(AnswerPaper answerPaper);


    int saveAnswerpaper(AnswerPaper answerPaper);

    List<ExamineeScoreDTO> getScoreByExamineeId(String examineeId);

    List<ExamineeScoreDTO> getScoreByExamineeName(String examineeName);

    List<ExamineeScoreDTO> getScoreByPaperName(String paperName);







}
