package cn.aitechlab.oes.controller;


import cn.aitechlab.oes.model.Examinee;
import cn.aitechlab.oes.service.ExamineeService;
import cn.aitechlab.oes.service.QuestionService;
import cn.aitechlab.oes.vo.UploadVO;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @Description: 作用描述
 * @Author: PPQiu
 * @CreateDate: 2019/4/25 14:27
 */
@RestController
@RequestMapping("/exam")
public class UploadFileController {

    @Autowired
    QuestionService questionService;

    @Autowired
    ExamineeService examineeService;

    @PostMapping("/upload/question")
    public UploadVO uploadQuestion(@RequestParam MultipartFile file) {
        UploadVO uploadVO = null;
        uploadVO = questionService.uploadQuestionFile(file);
        return uploadVO;
    }

    @PostMapping("/upload/examinee")
    public UploadVO uploadExaminee(@RequestParam MultipartFile file) {
        UploadVO uploadVO = null;
        uploadVO = examineeService.uploadExamineeFile(file);
        return uploadVO;
    }


    //下载考生信息------

    @GetMapping("/exportExamineeInfo")
    public void export(HttpServletResponse response) throws IOException {

        List<Examinee> examinees = examineeService.getall();

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取excel测试表格");

        HSSFRow row = null;

        row = sheet.createRow(0);
        row.setHeight((short) (26.25 * 20));

        row.createCell(0).setCellValue("用户信息列表");

        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 3);
        sheet.addMergedRegion(rowRegion);

        row = sheet.createRow(1);
        //设置行高
        row.setHeight((short) (22.50 * 20));
        //为第一个单元格设值
        row.createCell(0).setCellValue("考生学号");
        //为第二个单元格设值
        row.createCell(1).setCellValue("考生姓名");
        //为第三个单元格设值
        row.createCell(2).setCellValue("考生身份证号");

        row.createCell(3).setCellValue("考生类型");

      for (int i = 0; i < examinees.size(); i++) {
            row = sheet.createRow(i + 3);
            Examinee examinee = examinees.get(i);
            row.createCell(0).setCellValue(examinee.getExamineeId());
            row.createCell(1).setCellValue(examinee.getExamineeName());
            row.createCell(2).setCellValue(examinee.getIdentityNum());
            row.createCell(3).setCellValue(examinee.getUserType());
        }

        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        //默认Excel名称
        response.setHeader("Content-disposition", "attachment;filename=examinee.xls");
        wb.write(os);
        os.flush();
        os.close();
    }


    //下载考生信息模板

    @GetMapping("/exportExamineeDemo")
    public void exportExamineeDemo(HttpServletResponse response) throws IOException {


        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取考生excel表格模板");

        HSSFRow row = null;

        row = sheet.createRow(0);
        row.setHeight((short) (26.25 * 20));

        row.createCell(0).setCellValue("用户信息列表");

        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 3);
        sheet.addMergedRegion(rowRegion);

        row = sheet.createRow(1);
        //设置行高
        row.setHeight((short) (22.50 * 20));
        //为第一个单元格设值
        row.createCell(0).setCellValue("考生学号");
        //为第二个单元格设值
        row.createCell(1).setCellValue("考生姓名");
        //为第三个单元格设值
        row.createCell(2).setCellValue("考生身份证号");

        row.createCell(3).setCellValue("考生类型");


        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        //默认Excel名称
        response.setHeader("Content-disposition", "attachment;filename=examinee.xls");
        wb.write(os);
        os.flush();
        os.close();
    }

    //下载试题信息模板

    @GetMapping("/exportQuestionDemo")
    public void exportQuestionDemo(HttpServletResponse response) throws IOException {


        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取试题excel表格模板");

        HSSFRow row = null;

        row = sheet.createRow(0);
        row.setHeight((short) (26.25 * 20));

        row.createCell(0).setCellValue("题目信息列表");

        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 13);
        sheet.addMergedRegion(rowRegion);

        row = sheet.createRow(1);
        //设置行高
        row.setHeight((short) (22.50 * 20));
        //为第一个单元格设值
        row.createCell(0).setCellValue("试卷号");
        //为第二个单元格设值
        row.createCell(1).setCellValue("题目号");
        //为第三个单元格设值
        row.createCell(2).setCellValue("题目类型");
        row.createCell(3).setCellValue("题目难度");
        row.createCell(4).setCellValue("题干内容");
        row.createCell(5).setCellValue("选项A");
        row.createCell(6).setCellValue("选项B");
        row.createCell(7).setCellValue("选项C");
        row.createCell(8).setCellValue("选项D");
        row.createCell(9).setCellValue("选项E");
        row.createCell(10).setCellValue("选项F");
        row.createCell(11).setCellValue("题目答案");
        row.createCell(12).setCellValue("题目分值");
        row.createCell(13).setCellValue("题目分析");


        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 30; i++) {
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        //默认Excel名称
        response.setHeader("Content-disposition", "attachment;filename=question.xls");
        wb.write(os);
        os.flush();
        os.close();
    }


}


