package com.example.exceldemo.mapper;

import com.example.exceldemo.entity.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LZW
 * @since 2022-09-26
 */
public interface ExamMapper extends BaseMapper<Exam> {


    /**
     * 动态写入题目信息(纯文本)
     *
     * @param exam
     * @return
     */
    int insertExamInfo(Exam exam);

}
