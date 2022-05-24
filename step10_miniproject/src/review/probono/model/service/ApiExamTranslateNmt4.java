/*이 클래스를 아예 변환해서 startview 기준으로 변환해서 새 클래스로 옮겨야한다.*/
/* startview main()메서드1/ 파파고 api main2()메서드 는 서로 호환이나 전달이 안된다. */



package review.probono.model.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import review.probono.model.service.Model;


// 네이버 기계번역 (Papago SMT) API 예제
public class ApiExamTranslateNmt4 {
	
	public static String v =null;
	
	private static ApiExamTranslateNmt4 instance = new ApiExamTranslateNmt4();
	public static ApiExamTranslateNmt4 getInstance() { 
			return instance;
	}
	
	public static Model trans = Model.getInstance();
	
	public static String translate(String msg, String clientId, String clientSecret, String apiURL) {
		String text = null; 
		try {
	            text = URLEncoder.encode(msg, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("인코딩 실패", e);
	        }

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        String responseBody = post(apiURL, requestHeaders, text);
	        
	        return responseBody;
	        
	}
	
	public static String stringToJson(String t) {
		 JSONParser jsonParser = new JSONParser();
      
      try {
			JSONObject jsonObj1 = (JSONObject) jsonParser.parse(t);
			JSONObject jsonObj2 = (JSONObject)jsonObj1.get("message");
			JSONObject jsonObj3 = (JSONObject)jsonObj2.get("result");
      	
			
			t=(String) jsonObj3.get("translatedText");  //The weather is nice
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
	return t;
	
	}
	
	public static String getResult() {
		return v;
	}
	

    public static void main(String[] args) throws IOException {
    	//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
        String clientId = "kFxYDrgDU3HtBI7a9wb9";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "yN_z7jGzaG";//애플리케이션 클라이언트 시크릿값";

        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        
        //? bf 
        
        String text = null;
        System.out.println(trans.before());
        
        text=trans.before();
        //System.out.println(text+ " | " + translate(text, clientId, clientSecret, apiURL));
        
        v= stringToJson(translate(text, clientId, clientSecret, apiURL));
        
        getResult();
       
    }
    
    
    
    

    private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=ko&target=en&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes()); //실제 번역 요청 후 response 결과 받아오는 듯.
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}