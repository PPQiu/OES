package cn.aitechlab.oes.vo;

import cn.aitechlab.oes.dto.PaperQuestionDTO;
import cn.aitechlab.oes.model.AnswerPaper;
import lombok.Data;

import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/4/27 2:03
 */
@Data
public class ExamInfoVO {

    private List<PaperQuestionDTO> PaperQuestionVO;

    private AnswerPaper answerPaper;


}
