package br.teste.quarkus.repositories;

import br.teste.quarkus.model.Cliente;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Dependent
public class ClienteRepository {

  @Inject
  private EntityManager em;

  public Optional<List<Cliente>> buscarClientes() {
    return Optional.of(em.createQuery("select c from Cliente c").getResultList());
  }

  public Optional<Cliente> buscarClientePorId(Long idCliente) {
    return Optional.of(em.find(Cliente.class,idCliente));
  }

  public Long cadastrar(Cliente cliente) {
    em.persist(cliente);
    commit();
    return cliente.getIdCliente();
  }

  private void commit() {
    em.flush();
    em.clear();
  }

  public void deletarCliente(Long idCliente) {
    em.createQuery("delete from Cliente where idCliente = :id")
        .setParameter("id", idCliente)
        .executeUpdate();
    commit();
  }
}
