package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

 /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
*/
    @Test
    public void JsonObje01(){

        JSONObject ilkJsonObje=new JSONObject();

        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put("UserId",1);

        System.out.println(ilkJsonObje);
    }

    @Test
    public void JsonObje02(){

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject innerJsonObje=new JSONObject();
        innerJsonObje.put("checkin","2018-01-01");
        innerJsonObje.put("checkout","2019-01-01");

        JSONObject bodyJsonObje=new JSONObject();
        bodyJsonObje.put("firstname","Jim");
        bodyJsonObje.put("additionalneeds","Breakfast");
        bodyJsonObje.put("bookingdates",innerJsonObje);
        bodyJsonObje.put("totalprice",111);
        bodyJsonObje.put("depositpaid",true);
        bodyJsonObje.put("lastname","Brown");

        System.out.println(bodyJsonObje);
    }
}
