package br.teste.quarkus.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/emails")
public class EmailResource {

  @Inject
  String url;

  @GET
  public String consultarTodos(){

    return "Dado encontrado: " + url;
  }


//  @POST

//  @PUT

//  @DELETE

}
