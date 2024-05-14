package com.xiaxin;
/**
 * 计科2102 王彦鑫
 * 爬取博物馆数据的代码在test里 没注释的部分 其他的是个人练习乱写的代码 无任何关系 懒得删了
 */
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.nio.charset.Charset;
import java.util.*;

public class  HttpPostParamTest {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://yun.itheima.com/search");
        //声明List集合，封装表单参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //设置请求地址https://yun.itheima.com/search?keys=Java
        params.add(new BasicNameValuePair("keys","Java"));
        //创建表单Entity对象
        Charset charset = Charset.forName("UTF-8");
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, charset);
        //设置表单的Entity对象到Post请求中
        httpPost.setEntity(formEntity);
        System.out.println("发起请求的信息：" + httpPost);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if(response.getCode() == 200){
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf8");
            System.out.println(content);
        }
        response.close();
        httpClient.close();
    }
}
