package cn.aitechlab.oes.dao;

import cn.aitechlab.oes.model.AnswerQuestion;

public interface AnswerQuestionMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(AnswerQuestion record);


    int insertSelective(AnswerQuestion record);


    AnswerQuestion selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(AnswerQuestion record);


    int updateByPrimaryKey(AnswerQuestion record);


}