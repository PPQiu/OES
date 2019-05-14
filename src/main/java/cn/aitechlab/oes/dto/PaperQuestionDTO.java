package cn.aitechlab.oes.dto;

import lombok.Data;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/4/22 9:05
 */

@Data
public class PaperQuestionDTO {

    //题目序号

    private Integer number;

    //题干

    private String content;

    //选项A

    private String optionA;

    //选项B

    private String optionB;

    //选项C

    private String optionC;

    //选项D

    private String optionD;

    //选项D

    private String optionE;

    //选项E

    private String optionF;

    //选项F

    private Integer score;

    //占分


}
