package cn.aitechlab.oes.service;

import cn.aitechlab.oes.model.Paper;

import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/5/13 10:31
 */
public interface PaperService {

    int insert(Paper paper);

    int updateByPrimaryKeySelective(Paper paper);

    List<Paper> getPaperInfoIsPublish();

    List<Paper> getAllPaperInfo();

    int getIdByPaperName(String paperName);
}
