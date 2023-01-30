package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {


    /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

    // 1- gonderecegimiz Request icin gerkli olan URL ve ihtiyacimiz varsa Body hazirla
    // 2 - Eger soruda bize verilmisse Expected Data'yi hazirla
    // 3 - Bize donen Response Actual Data olarak kaydet
    // 4-   Expected data ile Actual data'nin karsilastirilmasi- Assertion
  @Test

    public void get01(){

      // 1- Gonderecegimiz Request icin gerkli olan URL ve ihtiyacimiz varsa Body hazirla

      String Url="https://restful-booker.herokuapp.com/booking/1335";

      // 2 - Eger soruda bize verilmisse Expected Data'yi hazirla

      // 3 - Bize donen Response Actual Data olarak kaydet

      Response response= given().when().get(Url);

      response.prettyPrint();

    System.out.println( "Status code"+ response.getStatusCode());
    System.out.println( "Content type"+ response.getContentType());
    System.out.println( "Server Header degeri "+ response.getHeader("Server"));
    System.out.println( "Status Line"+ response.getStatusLine());
    System.out.println( "Response suresi"+ response.getTime());

    // 4-   Expected data ile Actual data'nin karsilastirilmasi- Assertion



  }

}
