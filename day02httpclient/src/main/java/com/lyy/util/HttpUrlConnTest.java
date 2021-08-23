package com.lyy.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUrlConnTest {
    /**
     * 使用jdk原生的api来请求网页
     */
    @Test
    public void test() throws Exception {
        String urlStr = "https://www.baidu.com/";
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpURLConn = (HttpURLConnection) urlConnection;
        //被限制，无法访问时，加请求头代理（user-agent）。
        httpURLConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
        //防盗链，url：发生防止防盗链的网站的URL
        httpURLConn.setRequestProperty("Referer", "https://www.baidu.com/");

        //获取HttpURLConnection的输入流
        InputStream is = httpURLConn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String str ;
        while ((str = br.readLine())!=null){
            System.out.println(str);
        }

    }

}
