package cn.aitechlab.oes.dao;

import cn.aitechlab.oes.dto.ExamineeScoreDTO;
import cn.aitechlab.oes.model.AnswerPaper;
import cn.aitechlab.oes.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AnswerPaperMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(AnswerPaper record);


    int insertSelective(AnswerPaper record);


    AnswerPaper selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(AnswerPaper record);


    int updateByPrimaryKey(AnswerPaper record);


    int updateByPaperIdSelective(AnswerPaper record);

    @Insert({"insert into answer_paper(id,paper_id,answer_time,examinee_id,finish,total_score) " +
            "values(#{id},#{paperId},#{answerTime},#{examineeId},#{finish},#{totalScore})"})
    int insertAnswerPaper(AnswerPaper answerPaper);

    List<ExamineeScoreDTO> selectScoreByExamineeId(@Param("examineeId") String examineeId);

    List<ExamineeScoreDTO> selectScoreByExamineeName(@Param("examineeName") String examineeName);

    List<ExamineeScoreDTO> selectScoreByPaperName(@Param("paperName") String paperName);



}