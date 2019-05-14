package cn.aitechlab.oes.model;

import lombok.Data;

@Data
public class Examinee {

    //考生主键

    private Integer id;

    //考生学号

    private String examineeId;

    //考生名字

    private String examineeName;

   //考生身份证号

    private String identityNum;


    //用户类型

    private Byte userType;

    public Examinee() {}


    public Examinee(String examineeId, String examineeName, String identityNum, Byte userType) {
        this.examineeId = examineeId;
        this.examineeName = examineeName;
        this.identityNum = identityNum;
        this.userType = userType;
    }
}