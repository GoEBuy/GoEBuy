import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class TestWebCollection extends TestCase{
	
	private static Logger logger = LoggerFactory.getLogger(TestWebCollection.class);
	
	@Override
	protected void setUp() throws Exception {
		logger.info("setUp");
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		logger.info("tearDown");
		super.tearDown();
	}
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@Test
	public void testGet() {
		
	}
 
	@Test
	public void testPost() {
		
	}
	
    //post提交调用方法
    public static String post(String uri, Map<String,Object> map) throws UnsupportedEncodingException {
        //所有的参数都放在map中，然后转换成json字符串传递到接口中
        String str = JSONObject.toJSONString(map);
        System.out.println("json参数："+str);
 
        HttpClient httpClient =  HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(new StringEntity(str, Charset.forName("utf-8")));
        try {
            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("http返回码："+statusCode);
            //如果返回状态是200，打印返回信息
            if (statusCode==200) {
                HttpEntity entity = response.getEntity();
                String entityStr = EntityUtils.toString(entity);
                System.out.println("客户端接收内容:"+entityStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return null;
    }
    
  //post提交调用方法
    public static String get(String uri, Map<String,Object> map) throws UnsupportedEncodingException {
        //所有的参数都放在map中，然后转换成json字符串传递到接口中
        String str = JSONObject.toJSONString(map);
        System.out.println("json参数："+str);
 
        HttpClient httpClient =  HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(uri);
//        HttpPost httpPost = new HttpPost(uri);
//        httpPost.setEntity(new StringEntity(str, Charset.forName("utf-8")));
        try {
            HttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("http返回码："+statusCode);
            //如果返回状态是200，打印返回信息
            if (statusCode==200) {
                HttpEntity entity = response.getEntity();
                String entityStr = EntityUtils.toString(entity);
                System.out.println("客户端接收内容:"+entityStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    /**
     *  发送multipart/form-data带有Json文件的Post请求
     * @return
     */
    public String postWithFormData( Map<String, String> params, final Map<String, File> files){
		// 文件sTestsetFile：solr_etl_agent35.json是存有JSON字符串的文件
		String sTestsetFile=System.getProperty("user.dir")+File.separator+"testdata"+File.separator+"solr_etl_agent35.json";
		String sURL="http://172.16.101.46:14401/editorialincre";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost uploadFile = new HttpPost(sURL);
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		 builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); //如果有SocketTimeoutException等情况，可修改这个枚举
		 for(Entry<String, String> e: params.entrySet() ) {
			 builder.addTextBody( e.getKey(), e.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
		 }
		 
		 if (files != null && files.size() > 0) {
			 Set<Entry<String, File>> entries = files.entrySet();
			 for (Entry<String, File> entry : entries) {
		            builder.addPart(entry.getKey(), new FileBody(entry.getValue()));
		        }

		 }
//		// 把文件加到HTTP的post请求中
//		File f = new File(sTestsetFile);
//		try {
//			builder.addBinaryBody(
//			    "file",
//			    new FileInputStream(f),
//			    ContentType.APPLICATION_OCTET_STREAM,
//			    f.getName()
//			);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
 
		HttpEntity multipart = builder.build();
		uploadFile.setEntity(multipart);
		CloseableHttpResponse response;
		String sResponse= null;
		try {
			response = httpClient.execute(uploadFile);
			HttpEntity responseEntity = response.getEntity();
			 sResponse=EntityUtils.toString(responseEntity, "UTF-8");
			System.out.println("Post 返回结果"+sResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sResponse;
		
    }
    
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String,Object> map = new HashMap<>();
        BasicConfigurator.configure(); //自动快速地使用缺省Log4j环境。
        logger.debug("debug");
        logger.info("info");
//        if( new File("log4j.properties").exists() ) {
//        PropertyConfigurator.configure("log4j.properties");
//        logger.debug("debug");
//        logger.info("info");
//        }else {
//        	System.out.println("not exist");
//        }
        //接口1
//        map.put("key","IRR2_0");//有多少个参数，都可放在map中
//        get("http://localhost:8080/users/", map);
//        post("http://localhost:8080/users/", map);
    }
}