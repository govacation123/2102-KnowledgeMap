/**
 * 计科2102 王彦鑫
 * 爬取博物馆数据的代码在test里 没注释的部分 其他的是个人练习乱写的代码 无任何关系 懒得删了
 */

package com.xiaxin;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class First {
    public static void main(String[] args) throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if(response.getCode() == 200){
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf8");
            System.out.println(content);
        }
        response.close();
        httpClient.close();
    }
}