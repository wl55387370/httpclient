package com.httpclient;

//发送和接收http包的类



import java.io.IOException;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;

public class PostTest {
//定义一个模拟的浏览器对象
	public CloseableHttpClient httpClient;
	public String key="";
	public String value="";
	public String username="";
	public String password="";
	 public PostTest() {
		 //创建一个模拟的浏览器对象
		 httpClient = HttpClientBuilder.create().build();
	 }
	 
	 //定义添加头的方法
	 public void addHeader(String key,String value) {
		
			
		 this.key=key;
		 this.value=value;
		 
	 }
	 
	 //定义一个专门发post接口的方法
	 public String post(String url) throws ParseException, IOException {
		 //指定url地址
		 HttpPost httppost= new HttpPost(url);
		 if(!key.equals("")) {
			 httppost.addHeader(key,value);
		 }
		 
		 //定义存储回包的变量
		 CloseableHttpResponse response=null;
	 //发包
		 try {
			 response=httpClient.execute(httppost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获取回复内容中，Response里面的对象
		 HttpEntity responseEntity = response.getEntity();
		// System.out.println(EntityUtils.toString(responseEntity));
		 Header [] headers = response.getAllHeaders();
			for (Header header : headers) {
				System.out.println("响应头："+header.getName()+"，值为："+header.getValue());
			}
		 return EntityUtils.toString(responseEntity);
		
		 
	 }
	 
}


