package cn.aitechlab.oes.model;

import lombok.Data;

import java.util.List;

@Data
public class AnswerPaper {

    //考卷主键

    private String id;

    //试卷主键

    private Integer paperId;

    //提交时间

    private String answerTime;


    //考生学号

    private String examineeId;


    //是否完成

    private String finish;


    //总成绩

    private Integer totalScore;


    private List<Question> questionList;


    private List<AnswerQuestion> answerQuestionList;

    }