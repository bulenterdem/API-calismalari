package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C7_Get_BodyTekrarlardanKurtulma {

/*
https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application-json,
	ve response body’sindeki
	"firstname“in,"Susan",
		ve "lastname“in, "Jackson",
		ve "totalprice“in,612,
		ve "depositpaid“in,false,
		ve "additionalneeds“in,"Breakfast"
oldugunu test edin

 */


    @Test
    public void get01(){


        //1- url hazirla

        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2 expected data yi kaydet

        // 3- response kaydet

        Response response= given().when().get(url);

        response.prettyPrint();

        //4 -Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Jim"),
                        "lastname",equalTo("Smith"),
                        "totalprice" , equalTo(761),
                        "depositpaid" , equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));

    }


}
