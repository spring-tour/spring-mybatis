package twindy.common.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * http工具类
 */
public class HttpClientUtils {

    private static final int CONNECT_TIMEOUT = 10000; //连接超时时间
    public  static final int SOCKET_TIMEOUT = 10000; //socket超时时间
    private static final String DEFAULT_CHARSET = "utf-8";
    private static final Log log = LogFactory.getLog(HttpClientUtils.class);

    /**
     * 获取简单的httpClient
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(SOCKET_TIMEOUT) //设置socket超时
                .setConnectTimeout(CONNECT_TIMEOUT) //设置connect超时
                .build();
        return HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
    }

    /**
     * post方法
     * @param url 请求地址
     * @param params post 参数 new BasicNameValuePair("key", "value")
     * @return
     * @throws IOException
     */
    public static String post(String url, List<NameValuePair> params) throws IOException{
        CloseableHttpClient httpClient = getHttpClient();
        try {
            HttpPost request = new HttpPost(url);
            request.setEntity(new UrlEncodedFormEntity(params, DEFAULT_CHARSET));
            HttpResponse response = httpClient.execute(request);
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);//取出应答字符串
        } catch (Exception e) {
            log.error("请求url:" + url + " 失败！");
        } finally {
            httpClient.close();
        }
        return null;
    }

    /**
     *  get方法
     * @param url  请求地址
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException{
        CloseableHttpClient httpClient = getHttpClient();
        try {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);//取出应答字符串
        } catch (Exception e) {
            log.error("请求url:" + url + " 失败！");
        } finally {
            httpClient.close();
        }
        return null;
    }
}

