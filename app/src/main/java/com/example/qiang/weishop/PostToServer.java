package com.example.qiang.weishop;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiang on 2017/3/5.
 */

public class PostToServer {
    String PostToServer_login(String phone, String password,String country) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://123.206.52.70:9900/login");
        try {
            // 为httpPost设置HttpEntity对象
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            parameters.add(new BasicNameValuePair("phone", phone));
            parameters.add(new BasicNameValuePair("password", password));
            parameters.add(new BasicNameValuePair("country", country));
            HttpEntity entity = new UrlEncodedFormEntity(parameters);
            httpPost.setEntity(entity);
            // httpClient执行httpPost表单提交
            HttpResponse response = httpClient.execute(httpPost);
            // 得到服务器响应实体对象
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {

                String entityutils=EntityUtils
                        .toString(responseEntity, "utf-8");
                Log.d("PostToServer", "response:" + entityutils);
                return entityutils;
            } else {
                Log.d("PostToServer", "服务器无响应");
            }
        } catch (Exception e) {
            Log.d("PostToServer", "exception:" + e);
            e.printStackTrace();
        } finally {
            // 释放资源
            httpClient.getConnectionManager().shutdown();
        }
        return null;

    }
    String PostToServer_logout(String phone) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://123.206.52.70:9900/logout");
        try {
            // 为httpPost设置HttpEntity对象
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            parameters.add(new BasicNameValuePair("phone", phone));
            HttpEntity entity = new UrlEncodedFormEntity(parameters);
            httpPost.setEntity(entity);
            // httpClient执行httpPost表单提交
            HttpResponse response = httpClient.execute(httpPost);
            // 得到服务器响应实体对象
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {

                String entityutils=EntityUtils
                        .toString(responseEntity, "utf-8");
                Log.d("PostToServer", "response:" + entityutils);
                return entityutils;
            } else {
                Log.d("PostToServer", "服务器无响应");
            }
        } catch (Exception e) {
            Log.d("PostToServer", "exception:" + e);
            e.printStackTrace();
        } finally {
            // 释放资源
            httpClient.getConnectionManager().shutdown();
        }
        return null;

    }
    String PostToServer_signup(String phone, String password,String country) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://123.206.52.70:9900/register");
        try {
            // 为httpPost设置HttpEntity对象
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            parameters.add(new BasicNameValuePair("phone", phone));
            parameters.add(new BasicNameValuePair("password", password));
            parameters.add(new BasicNameValuePair("country", country));
            HttpEntity entity = new UrlEncodedFormEntity(parameters);
            httpPost.setEntity(entity);
            // httpClient执行httpPost表单提交
            HttpResponse response = httpClient.execute(httpPost);
            // 得到服务器响应实体对象
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {

                String entityutils=EntityUtils
                        .toString(responseEntity, "utf-8");
                Log.d("PostToServer", "response:" + entityutils);
                return entityutils;
            } else {
                Log.d("PostToServer", "服务器无响应");
            }
        } catch (Exception e) {
            Log.d("PostToServer", "exception:" + e);
            e.printStackTrace();
        } finally {
            // 释放资源
            httpClient.getConnectionManager().shutdown();
        }
        return null;
    }
}
