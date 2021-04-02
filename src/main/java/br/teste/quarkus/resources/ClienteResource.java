package br.teste.quarkus.resources;

import br.teste.quarkus.dto.ClienteDto;
import br.teste.quarkus.services.ClienteService;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("clientes")
public class ClienteResource {

  @Inject
  ClienteService clienteService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response consultarTodos() {

    return clienteService.consultarClientes()
        .filter(lista -> !lista.isEmpty())
        .map(lista -> Response.ok(lista).build())
        .orElseGet(() -> Response.noContent().build());

  }

  @GET
  @Path("{id}")
  public Response consultarCliente(@PathParam("id") Long idCliente) {

    return clienteService.consultarClientePorId(idCliente)
        .map(c -> Response.ok(c).build())
        .orElseGet(() -> Response.noContent().build());

  }

  @POST
  public Response gravarCliente(ClienteDto dto, @Context UriInfo uriInfo) {

    Long idCliente = clienteService.gravarCliente(dto);

    return Response.created(getLocation(uriInfo,idCliente)).build();
  }

  @Path("{id}")
  @DELETE
  public Response deletarCliente(@PathParam("id") Long idCliente){

    clienteService.deletarCliente(idCliente);

    return Response.noContent().build();
  }

  private URI getLocation(UriInfo uriInfo, Long idCliente) {
    return uriInfo.getAbsolutePathBuilder().path(idCliente.toString()).build();
  }
}
