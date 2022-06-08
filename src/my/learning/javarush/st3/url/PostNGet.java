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
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PostNGet {
    public static void main(String[] args) throws Exception {
       // PostNGet solution = new PostNGet();
      //solution.sendPost("https://eorvrmrakn8lw4a.m.pipedream.net", "name=zapp&mood=good&locale=&id=777");
      // decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
        code();
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

    public static void decodeURLString(String s) throws MalformedURLException {
        try{
        URL url = new URL(s);
        System.out.println(url.getProtocol());
        System.out.println(url.getAuthority());
        System.out.println(url.getFile());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getPort());
        System.out.println(url.getDefaultPort());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());}
        catch (MalformedURLException e){
            System.out.println("Parameter "+s+" is not a valid URL.");
        }


    }




    public static void code(){
        try {
            URL url = new URL("http://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");


            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Server output .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
