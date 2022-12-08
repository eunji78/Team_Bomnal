package com.jobfinder.service;

import com.google.gson.JsonObject;
import com.jobfinder.domain.Recruit;
import com.jobfinder.repository.RecruitRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecruitService {

    @Autowired
    RecruitRepository recruitRepository;

    public Recruit notice(int r_seq){
        Recruit notice = recruitRepository.notice(r_seq);
        return notice;
    }

    public ArrayList<Recruit> noticeList(int super_job_seq){
        ArrayList<Recruit> noticeList = recruitRepository.noticeList(super_job_seq);
        return noticeList;
    }



    public JsonObject uploadSummernoteImageFile(MultipartFile multipartFile) {

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

    public void insertJobPosting(Recruit recruit) {
        recruitRepository.insertJobPosting(recruit);
    }

    public List<Recruit> getLatestRecruits(){
        List<Recruit> recruits = recruitRepository.getLatestRecruits();
        return recruits;
    }

}
