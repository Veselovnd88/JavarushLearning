package my.learning.javarush.st3.url;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PostNGet {
    public static void main(String[] args) throws Exception {
        PostNGet solution = new PostNGet();
        solution.sendPost("https://eorvrmrakn8lw4a.m.pipedream.net", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        HttpClient client = getHttpClient();
        HttpPost request = new HttpPost(url);

        request.addHeader("User-Agent", "Mozilla/5.0");
        List<NameValuePair> urlParams = new ArrayList<>();
        String[] parts = urlParameters.split("&");
        //    System.out.println(Arrays.toString(parts));
        for (String part: parts){
            String[] pair = part.split("=");
            String name = pair[0];
            String value = "";
            if(pair.length==2){
                value = pair[1];
            }
            urlParams.add(new BasicNameValuePair(name,value));
        }
        request.setEntity(new UrlEncodedFormEntity(urlParams));
        HttpResponse response = client.execute(request);

        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            result.append(responseLine);
        }

        System.out.println("Response: " + result);
    }

    protected HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }
}
