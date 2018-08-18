package com.httpclient.demo;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

public class CookiesTest {

    private String url;
    private ResourceBundle bundle;
    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }

    @Test
    public void getCookies() throws IOException {
        url = url + bundle.getString("getCookies");
        HttpGet get = new HttpGet(url);
        DefaultHttpClient c = new DefaultHttpClient();
        HttpResponse response = c.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity,"utf-8");
        System.out.println(result);
        CookieStore cookieStore = c.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie c1 : cookies) {
            System.out.println(c1.getName());
            System.out.println(c1.getValue());
        }
    }
}
