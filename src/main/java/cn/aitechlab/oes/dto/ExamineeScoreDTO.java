package cn.aitechlab.oes.dto;

import lombok.Data;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/5/13 0:04
 */
@Data
public class ExamineeScoreDTO {


    private String examineeId;

    private String examineeName;

    private Integer paperId;

    private String paperName;

    private Integer totalScore;

    private String examDate;

    private String subjectName;


}
