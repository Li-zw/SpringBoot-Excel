package com.example.exceldemo.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.exceldemo.utils.ExcelUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("test")
public class TestExcel {

    @PostMapping("/import")
    public JSONArray importUser(@RequestPart("file") MultipartFile file) throws Exception {
        JSONArray array = ExcelUtils.readMultipartFile(file);
        System.out.println("导入数据为:" + array);
        return array;
    }

}
