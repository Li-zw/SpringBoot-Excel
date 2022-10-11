package com.example.exceldemo.entity;


import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.exceldemo.utils.ExcelImport;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author LZW
 * @since 2022-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cqnu_study_exam")
@ApiModel(value = "Exam对象", description = "")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    private int rowNum;

    @ApiModelProperty(value = "题目编号")
    @ExcelImport("题目编号")
    @TableId(value = "qid", type = IdType.AUTO)
    private Integer qid;

    @ApiModelProperty(value = "科目编号")
    @ExcelImport("科目编号")
    private Integer sid;

    @ApiModelProperty(value = "科目名称")
    @ExcelImport("科目名称")
    private String sname;

    @ApiModelProperty(value = "问题题目")
    @ExcelImport("问题题目")
    private String title;

    @ApiModelProperty(value = "试题材料")
    @ExcelImport("试题材料")
    private String testMaterials;


    @ApiModelProperty(value = "选项")
    @ExcelImport("选项")
    private String options;

    @ApiModelProperty(value = "题目类型")
    @ExcelImport("题目类型")
    private String type;

    @ApiModelProperty(value = "参考答案")
    @ExcelImport("参考答案")
    private String referenceAnswers;

    @ApiModelProperty(value = "题目解析")
    @ExcelImport("题目解析")
    private String analysis;

    @ApiModelProperty(value = "题目图片地址")
    @ExcelImport("题目图片地址")
    private String imgTitle;

    @ApiModelProperty(value = "选项图片地址")
    @ExcelImport("选项图片地址")
    private String imgOptions;

    @ApiModelProperty(value = "解析图片地址")
    @ExcelImport("解析图片地址")
    private String imgAnalysis;

    @ApiModelProperty(value = "参考答案图片地址")
    @ExcelImport("参考答案图片地址")
    private String imgReference;

    @ApiModelProperty(value = "考试等级")
    @ExcelImport("考试等级")
    private String grade;

    @ApiModelProperty(value = "考试年份")
    @ExcelImport("考试年份")
    private String year;

    @ApiModelProperty(value = "删除标志 1 ：删除 0 ：未删除")
    @ExcelImport("删除标志")
    private Integer delFlag;

    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @ExcelImport("创建时间")
    private Date createdTime;

    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    @ExcelImport("更新时间")
    private Date updatedTime;


}
