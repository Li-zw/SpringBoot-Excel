package com.example.exceldemo.controller;


import com.example.exceldemo.entity.Result;
import com.example.exceldemo.service.ExamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LZW
 * @since 2022-09-26
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Resource
    ExamService examService;

    @PostMapping("/import")
    public Result importUser(@RequestPart("file") MultipartFile file) throws Exception {
        return examService.importExcel(file);
    }

}

