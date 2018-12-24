package com.httpclient;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetTest {
	//定义一个模拟的浏览器对象
		public CloseableHttpClient httpClient;
		public String key="";
		public String value="";
		 public GetTest() {
			 //创建一个模拟的浏览器对象
			 httpClient = HttpClientBuilder.create().build();
		 }

		 public String get(String url) throws ClientProtocolException, IOException  {
			 //指定url地址

			//创建请求对象
			 HttpGet get= new HttpGet(url);
			 //发起请求
			 HttpClient httpclient = HttpClients.createDefault();
		HttpResponse response=	httpclient.execute(get);
	//响应报文信息
		//1.状态行
		StatusLine statusLine=response.getStatusLine();
		System.out.println(statusLine.getProtocolVersion());
		System.out.println(statusLine.getStatusCode());
		System.out.println(statusLine.getReasonPhrase());
	//2.响应头
	Header[] headers = response.getAllHeaders();
		 
		 for(Header header:headers) {
			 System.out.println(header.getName()+":"+header.getValue());
		 }
		 
		 //3.响应体
		 HttpEntity responseEntity = response.getEntity();
			// System.out.println(EntityUtils.toString(responseEntity));
			 return EntityUtils.toString(responseEntity);

		 } 
		 }
		
