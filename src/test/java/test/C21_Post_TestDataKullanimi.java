package test;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuapp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends HerokuappBaseUrl {



    @Test
    public void post01(){


        // 1 - URL ve body hazirla

        specHerokuapp.pathParam("pp1","booking");


        // 2 - Expected Data hazirla

        TestDataHerokuapp testDataHerokuapp=new TestDataHerokuapp();

        JSONObject expData =testDataHerokuapp.expBody();


        // 3 - Response'u kaydet

        Response response=given().spec(specHerokuapp).

                contentType(ContentType.JSON).
                when().
                body(expData.toString()).
                post("/{pp1}");



        // 4 - Assertion

        JsonPath resJP= response.jsonPath();

        assertEquals(expData.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));

        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                resJP.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJP.get("booking.bookingdates.checkout"));


    }


}
