/**
 * 计科2102 王彦鑫
 * 爬取博物馆数据的代码在test里 没注释的部分 其他的是个人练习乱写的代码 无任何关系 懒得删了
 */
package com.xiaxin;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class HttpClientPoolTest {
    public static void main(String[] args) throws ParseException {
        //创建连接池管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //设置连接数
        cm.setMaxTotal(100);
        //设置每个主机的最大连接数
        cm.setDefaultMaxPerRoute(10);
        //使用连接池管理器发起请求
        doGet(cm);
        doGet(cm);
    }

    private static void doGet(PoolingHttpClientConnectionManager cm) throws ParseException {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        HttpGet httpGet= new HttpGet("https://www.shanghaimuseum.net/mu/frontend/pg/lib1/antique?page=1&viewType=list&libTypeSort=&libAgeSort=&libTypes=&libAges=&searchText=");

        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(httpGet);
            if(response.getCode() == 200){
                String content = EntityUtils.toString(response.getEntity(),"utf8");
                System.out.println(content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
