package testMyApi;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.checkerframework.checker.units.qual.C;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class MyAPItesting {
    @Test
    public void getRequest(){
        baseURI="http://localhost:3000";
        given().get("/users").then().statusCode(200).log().all();

    }
    @Test
    public void post(){
       // HashMap<String, String> mps= new HashMap<String,String>();
       // mps.put("FirstName","Thomas");![](../../../../../../AppData/Local/Temp/13fcbd222ba9731c0bcfb78c12bf2591.png)
       // mps.put("Address","UK");
        //mps.put("Subject",1);
        JSONObject req= new JSONObject();
        req.put("Name","Mons");
        req.put("id","Nepal");
        System.out.println(req.toJSONString());

        baseURI="http://localhost:3000";
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(req.toJSONString())
                .when().post("/infos").then().statusCode(201).log().all();
    }
    @Test
    public void usersPost(){
        JSONObject reqs = new JSONObject();
        reqs.put("id","Thoma");
        reqs.put("lastName","Ediion");
        reqs.put("subjectId",5);
        baseURI="http://localhost:3000";
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(reqs.toJSONString()).when().post("/users").then().statusCode(201);
    }

    @Test
    public void subPost(){
        JSONObject jso=new JSONObject();
        jso.put("id",7);
        jso.put("Name","Seven");
        baseURI="http://localhost:3000";
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jso.toJSONString()).when().post("/subjects").then().statusCode(201);
    }
    @Test
    public void supPatch(){
      JSONObject jsc= new JSONObject();
      jsc.put("id",7);
      jsc.put("Name","Seve");
      baseURI="http://localhost:3000";
      given().contentType(ContentType.JSON).accept(ContentType.JSON)
              .body(jsc.toJSONString()).when().put("/subjects/4").then().statusCode(200);
    }


}
