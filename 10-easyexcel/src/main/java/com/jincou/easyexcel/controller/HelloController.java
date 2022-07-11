package com.jincou.easyexcel.controller;

import com.jincou.easyexcel.service.ExcelExportService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;




/**
 * 文件上下传Controller类
 */
@Slf4j
@RestController
public class HelloController {

    @Resource
    private ExcelExportService excelExportService;

    /**
     * 文件上传
     */
    @PostMapping("/upload")
    @ResponseBody
    public Boolean upload(MultipartFile file,Integer type ){
        if(file == null){
            return false;
        }

        try{
            excelExportService.handleExcel(file);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 文件上传
     */
    @PostMapping("/kehuExcel")
    @ResponseBody
    public Boolean kehuExcel(MultipartFile file){
        if(file == null){
            return false;
        }
        try{
            excelExportService.kehuExcel(file);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}