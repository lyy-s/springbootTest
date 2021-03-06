package com.lyy.util;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class HttpClientTest {

    /**
     * 使用httpclient发送get请求
     */

    @Test
    public void  testGet1() throws UnsupportedEncodingException {
        //可关闭的httpclient客户端，相当于打开的一个浏览器
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String strUrl = "https://www.baidu.com/";

        String passWordParam = "123+aabc aaa|111a";//123 abc
        //做urlencode：如果是浏览器的话，浏览器会帮我们自动给做了(请求路径就可以有空格，特殊字符|等)
        passWordParam = URLEncoder.encode(passWordParam, StandardCharsets.UTF_8.name());//123%2Baabc+aaa
        strUrl = "http://localhost:8899/day02httpclient/test1?userName=aaa&password="+passWordParam;
        //构造httpget请求对象
        HttpGet httpGet = new HttpGet(strUrl);
        //可关闭的响应
        CloseableHttpResponse response = null;
        try {
            response = closeableHttpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if (HttpStatus.SC_OK == statusLine.getStatusCode()){
                System.out.println("响应成功");

                Header[] allHeaders = response.getAllHeaders();
                for (Header header: allHeaders){
                    System.out.println("响应头"+header.getName()+"的值:"+header.getValue());
                }
                //获取响应结果：
                HttpEntity entity = response.getEntity();
                Header contentType = entity.getContentType();
                System.out.println("contentType:"+contentType);
                //对httpEntity操作的工具类
                String s = EntityUtils.toString(entity, Charset.defaultCharset());
                System.out.println(s);
            }else {
                System.out.println(statusLine.getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    http://i0.hdslb.com/bfs/archive/9e5f278027ae7f1e1933b6e4002870361da6c20b.png
    //爬取网上图片
    @Test
    public void testDown() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String strUrl = "http://i0.hdslb.com/bfs/archive/9e5f278027ae7f1e1933b6e4002870361da6c20b.png";
        HttpGet httpGet = new HttpGet(strUrl);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        HttpEntity entity = response.getEntity();

        String contentType = entity.getContentType().getValue();
        String suffix = ".jpg";
        if (contentType.contains("jpg")||contentType.contains("jpeg")){
            suffix = ".jpg";
        }else if (contentType.contains("png")){
            suffix = ".png";
        }
        byte[] bytes = EntityUtils.toByteArray(entity);
        String localAbsPath = "D:\\a"+suffix;
        FileOutputStream fos = new FileOutputStream(localAbsPath);
        fos.write(bytes);
        fos.close();
        EntityUtils.consume(entity);

    }

}
