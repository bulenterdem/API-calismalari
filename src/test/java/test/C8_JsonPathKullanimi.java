package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C8_JsonPathKullanimi {



    @Test
    public void post01(){

        JSONObject kisiBilgisi=new JSONObject();
        JSONObject adresBilgisi=new JSONObject();
        JSONObject cepTelefonu=new JSONObject();
        JSONObject evTel= new JSONObject();
        JSONArray telBilgileri =new JSONArray();

        cepTelefonu.put("type","Cep Telefonu");
        cepTelefonu.put("number", "555-123-4567");
        evTel.put("type","Ev telefonu");
        evTel.put("number","312-123-4567");

        telBilgileri.put(cepTelefonu);
        telBilgileri.put(evTel);

        adresBilgisi.put("streetAddress", "Yenimahalle kurtulus cad");
        adresBilgisi.put("city","Ankara");
        adresBilgisi.put("postalCode","06100");

        kisiBilgisi.put("firstName","Ahmet");
        kisiBilgisi.put("lastName","Bulut");
        kisiBilgisi.put("age",49);
        kisiBilgisi.put("address",adresBilgisi);
        kisiBilgisi.put("phoneNumbers",telBilgileri);


        System.out.println(kisiBilgisi);



    }

}
