package com.example.exceldemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.exceldemo.entity.Exam;
import com.example.exceldemo.entity.Result;
import com.example.exceldemo.mapper.ExamMapper;
import com.example.exceldemo.service.ExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exceldemo.utils.ExcelUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LZW
 * @since 2022-09-26
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {

    @Resource
    ExamMapper examMapper;

    /**
     * Excel 导入
     *
     * @param file
     * @return
     */
    @Override
    public Result importExcel(MultipartFile file) {
        List<Exam> exam = null;
        try {
            exam = ExcelUtils.readMultipartFile(file, Exam.class);
            String[] options;
            JSONObject optionsJSON = new JSONObject();
            String[] optionsArr = {"A", "B", "C", "D"};
            for (Exam examData : exam) {
                examData.setYear(examData.getYear().trim());
                options = examData.getOptions().split("@");
                for (int i = 0; i < options.length; i++) {
                    optionsJSON.put(optionsArr[i], options[i]);
                    examData.setOptions(optionsJSON.toJSONString());
                }
                insertExamInfo(examData);
            }
            return Result.buildSuccessMsg("数据导入成功...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" =======================  Exam Import 导入数据失败  =======================  ");
            return Result.buildFailMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(), "数据导入失败...");
        }
    }


    /**
     * 动态写入题目信息(纯文本)
     *
     * @param exam
     * @return
     */
    @Override
    public boolean insertExamInfo(Exam exam) {
        if (examMapper.insertExamInfo(exam) > 0) {
            return true;
        }
        return false;
    }

}
