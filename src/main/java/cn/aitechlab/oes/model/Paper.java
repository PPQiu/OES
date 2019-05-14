package cn.aitechlab.oes.model;


import lombok.Data;

import java.util.List;

@Data
public class Paper {

    //试卷主键

    private Integer id;

    //试卷号

    private String paperName;

    //科目名称

    private String subjectName;

    //创建时间

    private String createTime;

    //考试日期

    private String examDate;

    //考试开始时间

    private String startTime;

    //考试结束时间

    private String endTime;

    //参与人数

    private Integer peoples;

    //备注

    private String remark;

    //是否发布

    private String publish;


    }