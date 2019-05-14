package cn.aitechlab.oes.dto;

import cn.aitechlab.oes.model.Paper;
import cn.aitechlab.oes.model.Question;
import lombok.Data;

/**
 * @Description: 创建试卷用
 * @Author: PPQiu
 * @CreateDate: 2019/5/13 13:24
 */
@Data
public class PaperAndQuestionDTO {

    private Paper paper;

    private Question question;
}
