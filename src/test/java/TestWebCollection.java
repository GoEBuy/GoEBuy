import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
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