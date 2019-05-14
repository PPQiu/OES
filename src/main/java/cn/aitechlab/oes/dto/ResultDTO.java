package cn.aitechlab.oes.dto;

import lombok.Data;


/**
 * 考试结果DTO类
 *
 */
@Data
public class ResultDTO {

    /*分数*/

    private Integer score;

    /*正确题目数*/

    private Double right;

    /*错误题目数*/

    private Double wrong;

    /*正确率*/

    private Double correctRate;

   }
