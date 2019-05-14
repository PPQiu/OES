package cn.aitechlab.oes.service.impl;

import cn.aitechlab.oes.dao.AnswerPaperMapper;
import cn.aitechlab.oes.dto.ExamineeScoreDTO;
import cn.aitechlab.oes.model.AnswerPaper;
import cn.aitechlab.oes.service.AnswerPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/4/27 4:18
 */
@Service
public class AnswerPaperServiceImpl implements AnswerPaperService {

    @Autowired
    AnswerPaperMapper answerPaperMapper;

    @Override
    public int saveAnswerpaper(AnswerPaper answerPaper) {
        return answerPaperMapper.insertAnswerPaper(answerPaper);
    }

    @Override
    public int updateAnswerPaper(AnswerPaper answerPaper) {
        return answerPaperMapper.updateByPaperIdSelective(answerPaper);
    }

    @Override
    public List<ExamineeScoreDTO> getScoreByExamineeId(@RequestParam("examineeId") String examineeId){
        List<ExamineeScoreDTO> examineeScoreDTOList = answerPaperMapper.selectScoreByExamineeId(examineeId);
        return examineeScoreDTOList;
    }

    @Override
    public List<ExamineeScoreDTO> getScoreByExamineeName(@RequestParam("examineeName") String examineeName){
        List<ExamineeScoreDTO> examineeScoreDTOList = answerPaperMapper.selectScoreByExamineeName(examineeName);
        return examineeScoreDTOList;
    }

    @Override
    public List<ExamineeScoreDTO> getScoreByPaperName(@RequestParam("paperName") String paperName){
        List<ExamineeScoreDTO> examineeScoreDTOList = answerPaperMapper.selectScoreByPaperName(paperName);
        return examineeScoreDTOList;
    }
}
