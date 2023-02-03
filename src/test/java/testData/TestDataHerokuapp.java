package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataHerokuapp {

    public int basariliStatusCode = 200;
    public String contentType = "application/json";


    /*
    {
       "bookingid":24,
       "booking":{
           "firstname":"Ali",
           "lastname":"Bak",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
           },
           "additionalneeds":"wi-fi"
           }
       }
     */

    public HashMap bookingDatesOlusturMap() {

        HashMap <String,Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        return bookingdates;
    }
    public HashMap bookingOlusturMap() {

        HashMap <String,Object> booking = new HashMap<>();

        booking.put("firstname","Ali");
        booking.put("lastname","Bak");
        booking.put("totalprice",500.0);
        booking.put("depositpaid",false);
        booking.put("bookingdates",bookingDatesOlusturMap());
        booking.put("additionalneeds","wi-fi");

        return booking;
    }

    public HashMap expBodyOlusturMap() {

        HashMap <String,Object> expBodyMap = new HashMap<>();

        expBodyMap.put("bookingid",24.0);
        expBodyMap.put("booking",bookingOlusturMap());

        return expBodyMap;
    }

    public JSONObject innerbodyJsonMethod(){

        JSONObject innerBody = new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        return innerBody;
    }


    public JSONObject reqBodyJsonMethod(){

        JSONObject reqBody = new JSONObject();


        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", innerbodyJsonMethod());
        reqBody.put("additionalneeds", "wi-fi");

        return reqBody;
    }


    public JSONObject expBody(){
        JSONObject expBody = new JSONObject();


        expBody.put("booking", reqBodyJsonMethod());
        expBody.put("bookingid", 24.0);

        return expBody;

    }


}
