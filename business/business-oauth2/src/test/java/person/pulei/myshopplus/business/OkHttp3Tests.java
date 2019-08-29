package person.pulei.myshopplus.business;

import com.google.common.collect.Maps;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import person.pulei.myshopplus.commons.utils.MapperUtils;
import person.pulei.myshopplus.commons.utils.OkHttpClientUtil;

import java.io.IOException;
import java.util.Map;

/**
 * OkHttp3Tests
 *
 * @author LeeSa1
 * @date 2019/8/29 11:18
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OkHttp3Tests {

    @Test
    public void testGet() {
        String url = "https://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String url = "http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUtilsPost() {
        String url = "http://localhost:9001/oauth/token";
        Map<String, String> params = Maps.newHashMap();
        params.put("username", "admin");
        params.put("password", "123456");
        params.put("grant_type", "password");
        params.put("client_id", "client");
        params.put("client_secret", "secret");
        try {
            Response response = OkHttpClientUtil.getInstance().postData(url, params);
            String string = response.body().string();
            Map<String, Object> json2map = MapperUtils.json2map(string);
            String access_token = String.valueOf(json2map.get("access_token"));
            System.out.println(access_token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
