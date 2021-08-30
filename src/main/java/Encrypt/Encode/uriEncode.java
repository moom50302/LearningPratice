package Encrypt.Encode;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.net.URLEncoder;

public class uriEncode {
    @DisplayName("Test URL Encode function.")
    @Test
    public void testCase() {
        String url = "http://www.test.tw?parameter_1=check&parameter_2>2";
        System.out.println("Origin Url: " + url);

        try{
            String encodeURL = URLEncoder.encode(url, "UTF-8");
            System.out.println("URL Encode: " + encodeURL);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void BeforeAll(){
        System.out.println("Test Start");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Test End");
    }
}
