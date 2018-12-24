package com.httpclient;

import java.io.IOException;

import org.apache.http.ParseException;
import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class Test 
{
    public static void main( String[] args ) throws ParseException, IOException
    {
       PostTest http = new PostTest();
       /*GetTest get=new GetTest() ;
       String res1=get.get("http://39.108.136.60:8380/ningmengban/app/login/login.html");
     
       System.out.println(res1);*/
       //发送授权包，获取token
       String res=http.post("http://www.testingedu.com.cn/inter/HTTP/auth");
   System.out.println(res);
   //解析返回值，获取token的值
   JSONObject json = new JSONObject(res);
   System.out.println(json.getString("token"));
   //在请求头里添加token键值对
   http.addHeader("token", json.getString("token"));
   //发送登录请求
   res=http.post("http://www.testingedu.com.cn/inter/HTTP//login?username=Antoy&password=123456");
   System.out.println(res);
   //发送注销请求
   res=http.post("http://www.testingedu.com.cn/inter/HTTP/logout");
   System.out.println(res);
    }
}
