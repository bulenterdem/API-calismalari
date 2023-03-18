package test;

import baseURL.DummyBaseURL;
import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C25_Put_DeSerialization extends DummyBaseURL {

    /*
      http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
      body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

              Request Body
              {
                  "status":"success",
                  "data":{
                          "name":“Ahmet",
                          "salary":"1230",
                          "age":"44",
                          "id":40
                          }
              }
                Response Body
                {
              "status":"success",
              "data":{
                  "status":"success",
                  "data":{
                          "name":“Ahmet",
                          "salary":"1230",
                          "age":"44",
                          "id":40
                          }
                     },
              "message":"Successfully! Record has been updated."
              }
                   */
    @Test
    public void put01(){
        // 1 - URL ve body olustur, Put metodu icin body gerekli


            // 1 - URL ve body olustur, Put metodu icin body gerekli

            specDummy.pathParams("pp1","update","pp2",21);

            TestDataDummy testDataDummy=new TestDataDummy();

            HashMap<String,Object> reqBody= testDataDummy.innerBody2OlusturMap();

            System.out.println("request body : " + reqBody);

            // 2 - Expected Data hazirla

            HashMap<String,Object> expBody= testDataDummy.expected1BodyOlusturMap();

            System.out.println("expected body : " + expBody);


            // 3 - Response'u kaydet

            Response response=given().
                    spec(specDummy).
                    contentType(ContentType.JSON).
                    when().
                    body(reqBody).
                    put("/{pp1}/{pp2}");

            response.prettyPrint();
        // 4 - Assertion

        HashMap<String,Object> rsMap=response.as(HashMap.class);


        Assert.assertEquals(expBody.get("status"),reqBody.get("status"));
        Assert.assertEquals(expBody.get("message"),reqBody.get("message"));


        Assert.assertEquals(  ((Map) (expBody.get("data") )).get("status") ,((Map)(rsMap.get("data") )).get("status") );

        Assert.assertEquals( ((Map) (((Map) (expBody.get("data") )).get("status") )).get("name") , ((Map) (((Map) (rsMap.get("data") )).get("status") )).get("name") ) ;
        Assert.assertEquals( ((Map) (((Map) (expBody.get("data") )).get("status") )).get("name") , ((Map) (((Map) (rsMap.get("data") )).get("status") )).get("name") ) ;
        Assert.assertEquals( ((Map) (((Map) (expBody.get("data") )).get("status") )).get("name") , ((Map) (((Map) (rsMap.get("data") )).get("status") )).get("name") ) ;

        Assert.assertEquals( ((Map) (((Map) (expBody.get("data") )).get("status") )).get("name") , ((Map) (((Map) (rsMap.get("data") )).get("status") )).get("name") ) ;
    }
}
