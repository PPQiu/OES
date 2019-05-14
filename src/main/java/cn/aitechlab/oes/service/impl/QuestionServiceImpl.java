package cn.aitechlab.oes.service.impl;

import cn.aitechlab.oes.dao.QuestionMapper;
import cn.aitechlab.oes.dto.AnswerDTO;
import cn.aitechlab.oes.dto.PaperQuestionDTO;
import cn.aitechlab.oes.model.Question;
import cn.aitechlab.oes.service.QuestionService;
import cn.aitechlab.oes.utils.FileUtil;
import cn.aitechlab.oes.vo.UploadVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/4/25 12:15
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public UploadVO uploadQuestionFile(MultipartFile file) {
        UploadVO uploadVO = new UploadVO();
        //总行记录
        List<ArrayList<String>> readResult = null;
        //判断文件是否为空
        if (file.isEmpty()) {
            uploadVO.setSuccess(false);
            uploadVO.setMsg("上传文件为空");
            return uploadVO;
        }
        //判断文件大小
        long size = file.getSize();
        String name = file.getOriginalFilename();
        if (StringUtils.isBlank(name) || size == 0) {
            uploadVO.setSuccess(false);
            uploadVO.setMsg("上传文件为空");
            return uploadVO;
        }
        //获取文件后缀
        String postfix = FileUtil.getPostfix(name);

        //读取文件内容

        if (StringUtils.equals("xlsx", postfix)) {
            readResult = FileUtil.readXlsx(file);
        } else if (StringUtils.equals("xls", postfix)) {
            readResult = FileUtil.readXls(file);
        } else {
            uploadVO.setSuccess(false);
            uploadVO.setMsg("文件类型错误");
            return uploadVO;
        }

        if (readResult == null || readResult.size() == 0) {
            uploadVO.setSuccess(false);
            uploadVO.setMsg("文件解析失败");
            return uploadVO;

        }

//       for (ArrayList<String> arr : readResult) {
//         Question question=new Question(Integer.valueOf(arr.get(0)),Integer.valueOf(arr.get(1)),Integer.valueOf(arr.get(2)),
//                    Integer.valueOf(arr.get(3)),arr.get(4),arr.get(5),arr.get(6),arr.get(7),arr.get(8),
//                    arr.get(9),arr.get(10),arr.get(11),Integer.valueOf(arr.get(12)),arr.get(13));
//
         for(int i = 2; i < readResult.size(); i++ ){

             Question question=new Question(Integer.valueOf(readResult.get(i).get(0)),Integer.valueOf(readResult.get(i).get(1)),
                     Integer.valueOf(readResult.get(i).get(2)),Integer.valueOf(readResult.get(i).get(3)),
                     readResult.get(i).get(4),readResult.get(i).get(5),readResult.get(i).get(6),readResult.get(i).get(7),
                     readResult.get(i).get(8),readResult.get(i).get(9),readResult.get(i).get(10),readResult.get(i).get(11),
                     Integer.valueOf(readResult.get(i).get(12)),readResult.get(i).get(13));

                    questionMapper.uploadQuestionFile(question);
        }
        uploadVO.setSuccess(true);
        uploadVO.setMsg("上传成功");
        return uploadVO;
    }




    @Override
    public List<PaperQuestionDTO> getPaperQuestionByPaperName(@RequestParam("paperName") String paperName){
        List<PaperQuestionDTO> paperQuestionDTOList =questionMapper.selectPaperQuestionByPaperName(paperName);
        return paperQuestionDTOList;
    }

    @Override
    public List<AnswerDTO> getAnswerByPaperId(@RequestParam("paperId") Integer paperId){
        List<AnswerDTO> answerDTOList = questionMapper.selectAnswerByPaperId(paperId);
        return answerDTOList;
    }

    @Override
    public List<Question> getAllQuestion() {
        List<Question> questionList = questionMapper.selectAllQuestion();
        return questionList;
    }

    @Override
    public List<Question> getPaperId() {
        List<Question> questionList = questionMapper.selectPaperId();
        return questionList;
    }

    @Override
    public List<Question> getQuestionByPaperId(@RequestParam("paperId") Integer paperId) {
        List<Question> questionList = questionMapper.selectQuestionByPaperId(paperId);
        return questionList;
    }

    @Override
    public int insertSelective(Question question){
        return questionMapper.insertSelective(question);
    }

    @Override
    public int insert(Question question){
        return questionMapper.insert(question);
    }


    @Override
    public List<Question> getQuestionByPaperName(@RequestParam("paperName") String paperName){
        return questionMapper.selectQuestionByPaperName(paperName);
    }

    @Override
    public int deleteByPrimaryKey(@RequestParam("id") Integer id){
        return questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Question question){
        return questionMapper.updateByPrimaryKeySelective(question);
    }




}
