package cn.aitechlab.oes.service;

import cn.aitechlab.oes.dto.AnswerDTO;
import cn.aitechlab.oes.dto.PaperQuestionDTO;
import cn.aitechlab.oes.model.Question;
import cn.aitechlab.oes.vo.UploadVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/4/25 12:15
 */
public interface QuestionService {

    UploadVO uploadQuestionFile(MultipartFile file);

    List<PaperQuestionDTO> getPaperQuestionByPaperName(String paperName);

    List<AnswerDTO> getAnswerByPaperId(Integer paperId);

    List<Question> getAllQuestion();

    List<Question> getPaperId();

    List<Question> getQuestionByPaperId(Integer paperId);

    int insertSelective(Question question);

    int insert(Question question);

    List<Question> getQuestionByPaperName(String paperName);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question question);



}
