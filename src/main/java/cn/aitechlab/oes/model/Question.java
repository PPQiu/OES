package cn.aitechlab.oes.model;

import lombok.Data;

@Data
public class Question {

    private Integer id;


    private Integer paperId;


    private Integer number;


    private Integer type;


    private Integer level;


    private String content;


    private String optionA;

    private String optionB;


    private String optionC;


    private String optionD;

    private String optionE;


    private String optionF;


    private String answer;


    private Integer score;


    private String analysis;


    public Question(){}

    public Question(Integer paperId, Integer number, Integer type, Integer level, String content, String optionA, String optionB, String optionC, String optionD, String optionE, String optionF, String answer, Integer score, String analysis) {
        this.paperId = paperId;
        this.number = number;
        this.type = type;
        this.level = level;
        this.content = content;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionE = optionE;
        this.optionF = optionF;
        this.answer = answer;
        this.score = score;
        this.analysis = analysis;
    }
}