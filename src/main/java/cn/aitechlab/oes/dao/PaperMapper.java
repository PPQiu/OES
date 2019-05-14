package cn.aitechlab.oes.dao;

import cn.aitechlab.oes.model.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Paper record);


    int insertSelective(Paper record);


    Paper selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    List<Paper> selectPaperInfoIsPublish();

    List<Paper> selectAllPaperInfo();

    int selectIdByPaperName(@Param("paperName") String paperName);
}