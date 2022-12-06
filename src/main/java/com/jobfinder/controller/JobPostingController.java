package com.jobfinder.controller;

import com.google.gson.JsonObject;
import com.jobfinder.domain.Job;
import com.jobfinder.domain.Recruit;
import com.jobfinder.service.MainService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Controller
public class JobPostingController {
    @Autowired
    MainService mainService;

    @RequestMapping("/jobPostingForm")
    public String jobPosting(Model model){
        List<Job> job_list = mainService.jobList();
        model.addAttribute("job_list",job_list);
        return "job_posting";
    }

    @RequestMapping("/testSummerNote")
    public String jobPostring(String test){
        System.out.println(test);
        return "/";
    }

    @PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {

        JsonObject jsonObject = new JsonObject();

        String fileRoot = "C:\\summernote_image\\";	//저장될 외부 파일 경로
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자

        String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명

        File targetFile = new File(fileRoot + savedFileName);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
            jsonObject.addProperty("responseCode", "success");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }

        return jsonObject;
    }

    @RequestMapping("/insertJobPosting")
    public String jobPosting(@ModelAttribute Recruit recruit){
        System.out.println(recruit);
        return "redirect:/";
    }



}
