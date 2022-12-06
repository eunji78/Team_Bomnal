package com.jobfinder.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.jobfinder.domain.LoginVO;
import com.jobfinder.domain.Login_ComVO;
import com.jobfinder.domain.Recruit;
import com.jobfinder.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public LoginVO login_per(LoginVO vo){
        LoginVO rvo = loginRepository.login_per(vo);
        System.out.println("service_login_per" + rvo);
        return rvo;
    }

    public Login_ComVO login_com(Login_ComVO cvo){
        Login_ComVO rcvo = loginRepository.login_com(cvo);
        System.out.println("service_login_com" + rcvo);
        return rcvo;
    }

    public int set_signup_com(Login_ComVO cvo){
        int res = loginRepository.set_signup_com(cvo);
        return res;
    }
    public int set_signup_per(LoginVO vo){
        int res = loginRepository.set_signup_per(vo);
        return res;
    }
    public int set_signup_kko(LoginVO vo){
        int res = loginRepository.set_signup_kko(vo);
        return res;
    }

    public String id_check_com(String insert_id){
        System.out.println("com Service in : " + insert_id);
        String com_id = loginRepository.id_check_com(insert_id);
        System.out.println("com Service in : " + insert_id);
        return com_id;
    }

    public String id_check_per(String insert_id){
        System.out.println("per Service in : " + insert_id);
        String per_id = loginRepository.id_check_per(insert_id);
        System.out.println("per Service in : " + insert_id);
        return per_id;
    }

    public String getAccessToken (String authorize_code) {

        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=a975f70f0a16a4f131af7f7cdd795234");  //본인이 발급받은 key
            sb.append("&redirect_uri=http://127.0.0.1:8081/kakaologin");     // 본인이 설정해 놓은 경로
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return access_Token;
    }

    public HashMap<String, String> getUserInfo (String access_Token) {

        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, String> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String id = element.getAsJsonObject().get("id").getAsString();
            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String profile_image = properties.getAsJsonObject().get("profile_image").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();
            String birthday = kakao_account.getAsJsonObject().get("birthday").getAsString();
            String gender = kakao_account.getAsJsonObject().get("gender").getAsString();

            userInfo.put("id", id);
            userInfo.put("nickname", nickname);
            userInfo.put("email", email);
            userInfo.put("profile_image", profile_image);
            userInfo.put("birthday", birthday);
            userInfo.put("gender", gender);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }

    public void update_vo(LoginVO vo) {
        loginRepository.update_vo(vo);
    }

    public void update_cvo(Login_ComVO cvo) {
        loginRepository.update_cvo(cvo);
    }

    public List<Recruit> rec_list(String company_id) {
        List<Recruit> rec = loginRepository.rec_list(company_id);
        return rec;
    }


    public int all_delete_data_per(String mem_id) {
        int res = loginRepository.all_delete_data_per(mem_id);
        return res;
    }
    public int all_delete_data_com(String company_id) {
        int res = loginRepository.all_delete_data_com(company_id);
        return res;
    }


}
