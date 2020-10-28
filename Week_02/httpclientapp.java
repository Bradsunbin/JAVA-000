import java.io.File;
import java.io.IOException;
import java.net.URI;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class httpclientapp {

    public static void main(String[] args) {
        
                // 创建Httpclient对象
                CloseableHttpClient httpclient = HttpClients.createDefault();
                // 创建http GET请求
                HttpGet httpGet = new HttpGet(" http://localhost:8801");
                CloseableHttpResponse response = null;
                try {
                    response = httpclient.execute(httpGet);
                    // 判断返回状态是否为200
                    if (response.getStatusLine().getStatusCode() == 200) {
                        //请求体内容
                        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                        //内容写入文件

                        System.out.println(content);
                    } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    } finally {
                    if (response != null) {
                        response.close();
                    }
                    httpclient.close();
                }
            }
        

}
