package br.teste.quarkus.resource;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ClienteResourceTest {

  @Test
  public void testaConsultaCliente(){
//    given().basePath("/cliente");
//    WebTarget target = ClientBuilder.newClient().target("http://localhost:8080/cliente");


  }

}
