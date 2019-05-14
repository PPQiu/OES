package cn.aitechlab.oes.dao;

import cn.aitechlab.oes.dto.AnswerDTO;
import cn.aitechlab.oes.dto.PaperQuestionDTO;
import cn.aitechlab.oes.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Question record);


    int insertSelective(Question record);


    Question selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Question record);


    int updateByPrimaryKey(Question record);


    @Insert({"insert into question(paper_id,number,type,level,content,option_a,option_b,option_c,option_d,option_e,option_f,answer,score,analysis) " +
            "values(#{paperId},#{number},#{type},#{level},#{content},#{optionA},#{optionB},#{optionC},#{optionD},#{optionE},#{optionF},#{answer},#{score},#{analysis})"})
    int uploadQuestionFile(Question question);


    List<PaperQuestionDTO> selectPaperQuestionByPaperName(@Param("paperName") String paperName);

    List<AnswerDTO> selectAnswerByPaperId(@Param("paperId") Integer paperId);

    List<Question>  selectAllQuestion();

    List<Question> selectPaperId();

    List<Question> selectQuestionByPaperId(@Param("paperId") Integer paperId);

    List<Question> selectQuestionByPaperName(@Param("paperName") String paperName);







}