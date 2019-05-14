package cn.aitechlab.oes.model;

import lombok.Data;

@Data
public class AnswerQuestion {

    //答卷信息主键

    private Integer id;

    private Integer number;

    //考生答案

    private String selectAnswer;

    //考生每题成绩

    private Integer markScore;

   }