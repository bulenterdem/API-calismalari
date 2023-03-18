package test;

import baseURL.DummyBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C26_Get_DeSerialization extends DummyBaseURL {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3
    url’ine bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body

{
"status":"success",
"data":{
"id":3,
"employee_name":"Ashton Cox",
"employee_salary":86000,
"employee_age":66,
"profile_image":""
},
"message":"Successfully! Record has been fetched."
}


     */

    @Test
    public void get01(){

        // 1. adim URl ve Body hazirla

        specDummy.pathParams("pp1","employee","pp2",3);

        //2- expected data hazirla

        TestDataDummy testDataDummy=new TestDataDummy();

        HashMap <String,Object> expData=testDataDummy.expectedBodyOlusturMap();


        // 3 responsive kaydet

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        HashMap<String,Object> rsMap=response.as(HashMap.class);

        Assert.assertEquals(   expData.get("status"),rsMap.get("status")   );
        Assert.assertEquals(   expData.get("message"),rsMap.get("message")   );

        Assert.assertEquals(  ((Map) (expData.get("data"))).get("id"),  ((Map) (rsMap.get("data"))).get("id") );
        Assert.assertEquals(  ((Map) (expData.get("data"))).get("employee_name"), ((Map) (rsMap.get("data"))).get("employee_name") );
        Assert.assertEquals(  ((Map) (expData.get("data"))).get("employee_salary"),((Map) (rsMap.get("data"))).get("employee_salary") );
        Assert.assertEquals(  ((Map) (expData.get("data"))).get("employee_age"), ((Map) (rsMap.get("data"))).get("employee_age") );
    }





}
