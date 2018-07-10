package com.lu.httpdemo;

import com.lu.http.HttpProxy;
import com.lu.httpdemo.api.PhpService;

/**
 * Author: luqihua
 * Time: 2017/11/24
 * Description: HttpClientRetrofit
 */

public class HttpClientRetrofit {
    private static PhpService sApiService;

    public static PhpService getApiService() {
        if (sApiService == null) {
            synchronized (HttpClientRetrofit.class) {
                if (sApiService == null) {
                    HttpProxy proxy = new HttpProxy.Builder()
                            .baseUrl("http://119.23.237.24:8080/apidemo/api/")
                            .build();
                    sApiService = proxy.create(PhpService.class);
                }
            }
        }
        return sApiService;
    }
}
