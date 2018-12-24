package com.httpclient;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**����httpclient��ʾpost���ͽӿڵĵ���
 * @author Administrator
 *
 */
public class PostDemo {
	/**java���ִ�����
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws Exception {
		//�ӿڵ�ַ
		String url = "http://test.lemonban.com/futureloan/mvc/api/member/login";
		//ȷ���ӿ��ύ����
		HttpPost post = new HttpPost(url);
		//׼���ӿڵı��������mobilephone��pwd
		String mobilephone = "13517315120";
		String pwd = "123456";
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("mobilephone", mobilephone));
		parameters.add(new BasicNameValuePair("pwd", pwd));
		post.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
		//׼���ͻ���
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//ִ�з��������ýӿ�
		CloseableHttpResponse httpResponse = httpClient.execute(post);
		//�õ��������˷��ص�����ȥ����һ���ж�
		//��ȡ״̬��
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		//��ȡ��Ӧ����
		String result = EntityUtils.toString(httpResponse.getEntity());
		//��ȡ��Ӧͷ
		Header [] headers = httpResponse.getAllHeaders();
		for (Header header : headers) {
			System.out.println("��Ӧͷ��"+header.getName()+"��ֵΪ��"+header.getValue());
		}
		System.out.println("statusCode="+statusCode);
		System.out.println("result="+result);
		
	}
}

