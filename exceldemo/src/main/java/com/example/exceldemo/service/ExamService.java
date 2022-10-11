package com.example.exceldemo.service;

import com.example.exceldemo.entity.Exam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exceldemo.entity.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LZW
 * @since 2022-09-26
 */
public interface ExamService extends IService<Exam> {

    Result importExcel(MultipartFile file) throws Exception;


    /**
     * 动态写入题目信息（纯文本）
     *
     * @param exam
     * @return
     */
    boolean insertExamInfo(Exam exam);

}
