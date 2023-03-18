package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {

    public int basariliStatusCode = 200;
    public String contentType = "application/json";

    /*
    {
    "status":"success",
    "data": {
            "id": 3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */

    public JSONObject innerJSONBody (){

        JSONObject innerBody = new JSONObject();

        innerBody.put("id", 3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        return innerBody;
    }
    public JSONObject expectedBodyOlusturJson (){

        JSONObject expBody = new JSONObject();

        expBody.put("status","success");
        expBody.put("message","Successfully! Record has been fetched.");
        expBody.put("data",innerJSONBody());

        return expBody;
    }
    public HashMap innerBodyOlusturMap (){

        HashMap<String ,Object> innerBodyMap = new HashMap<>();

        innerBodyMap.put("id",3.0);
        innerBodyMap.put("employee_name","Ashton Cox");
        innerBodyMap.put("employee_salary",86000.0);
        innerBodyMap.put("employee_age",66.0);
        innerBodyMap.put("profile_image","");

        return innerBodyMap;
    }

    public HashMap expectedBodyOlusturMap(){

        HashMap<String ,Object> expBody = new HashMap<>();

        expBody.put("status","success");
        expBody.put("message","Successfully! Record has been fetched.");
        expBody.put("data",innerBodyOlusturMap());

        return expBody;
    }
    public HashMap innerBody1OlusturMap (){

        HashMap<String ,Object> innerBodyMap1 = new HashMap<>();

        innerBodyMap1.put("id",40.0);
        innerBodyMap1.put("name","Ahmet");
        innerBodyMap1.put("salary",1230.0);
        innerBodyMap1.put("age",44.0);


        return innerBodyMap1;
    }
    public HashMap innerBody2OlusturMap(){

        HashMap<String ,Object> innerBody2 = new HashMap<>();

        innerBody2.put("status","success");
       innerBody2.put("data",innerBody1OlusturMap());

        return innerBody2;
    }


    public HashMap expected1BodyOlusturMap(){

        HashMap<String ,Object> expBody1 = new HashMap<>();

        expBody1.put("status","success");
        expBody1.put("message","Successfully! Record has been fetched.");
        expBody1.put("data",innerBody2OlusturMap());

        return expBody1;
    }

    /*
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



}
