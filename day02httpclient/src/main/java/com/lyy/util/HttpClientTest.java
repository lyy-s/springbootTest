package com.lyy.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import java.io.IOException;
import java.nio.charset.Charset;


public class HttpClientTest {

    /**
     * 使用httpclient发送get请求
     */

    @Test
    public void  testGet1(){
        //可关闭的httpclient客户端，相当于打开的一个浏览器
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String strUrl = "https://www.baidu.com/";
        //构造httpget请求对象
        HttpGet httpGet = new HttpGet(strUrl);
        //可关闭的响应
        CloseableHttpResponse response = null;
        try {
            response = closeableHttpClient.execute(httpGet);
            //获取响应结果：
            HttpEntity entity = response.getEntity();
            //对httpEntity操作的工具类
            String s = EntityUtils.toString(entity, Charset.defaultCharset());
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
