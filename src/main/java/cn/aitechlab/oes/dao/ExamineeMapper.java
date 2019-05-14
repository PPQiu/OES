package cn.aitechlab.oes.dao;

import cn.aitechlab.oes.dto.ExamineeDTO;
import cn.aitechlab.oes.model.Examinee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamineeMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Examinee record);


    int insertSelective(Examinee record);


    Examinee selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Examinee record);


    int updateByPrimaryKey(Examinee record);

    ExamineeDTO getExamineeByExamineeInfo(@Param("examineeId") String examineeId,
                                          @Param("examineeName") String examineeName,
                                          @Param("identityNum") String identityNum);

    @Insert({"insert into examinee(examinee_id,examinee_name,identity_num,user_type) values(#{examineeId},#{examineeName},#{identityNum},#{userType})"})
    int uploadExamineeFile(Examinee examinee);

    List<Examinee> selectall();

    Examinee selectExamineeByExamineeName(@Param("examineeName") String examineeName);



}