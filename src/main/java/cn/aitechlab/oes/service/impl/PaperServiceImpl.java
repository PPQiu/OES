package cn.aitechlab.oes.service.impl;

import cn.aitechlab.oes.dao.PaperMapper;
import cn.aitechlab.oes.model.Paper;
import cn.aitechlab.oes.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/5/13 10:32
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;

    @Override
    public int insert(Paper paper) {
        return paperMapper.insert(paper);

    }

    @Override
    public int updateByPrimaryKeySelective(Paper paper){
        return paperMapper.updateByPrimaryKeySelective(paper);
    }

    @Override
    public List<Paper> getPaperInfoIsPublish(){
        return paperMapper.selectPaperInfoIsPublish();
    }

    @Override
    public List<Paper> getAllPaperInfo(){
        return paperMapper.selectAllPaperInfo();
    }

    @Override
    public int getIdByPaperName(@RequestParam("paperName") String paperName){
        return paperMapper.selectIdByPaperName(paperName);
    }

}
