package cn.aitechlab.oes.dao;

import cn.aitechlab.oes.dto.AdminDTO;
import cn.aitechlab.oes.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Admin record);


    int insertSelective(Admin record);


    Admin selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Admin record);


    int updateByPrimaryKey(Admin record);

    AdminDTO getAdminByAdminInfo(@Param("adminId") String adminId,
                                 @Param("password") String password);
}


