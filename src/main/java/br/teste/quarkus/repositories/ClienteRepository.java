package br.teste.quarkus.repositories;

import br.teste.quarkus.model.Cliente;
import br.teste.quarkus.model.Endereco;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.Dependent;

@Dependent
public class ClienteRepository {

  private static final List<Cliente> clientes = new ArrayList<>();

  static {
    clientes.add(criarCliente(1L, "cliente 1", LocalDate.of(1995, 7, 14), "Bairro 1", "Rua Logradouro 1", "1"));
    clientes.add(criarCliente(2L, "cliente 2", LocalDate.of(1996, 8, 15), "Bairro 2", "Rua Logradouro 2", "2"));
    clientes.add(criarCliente(3L, "cliente 3", LocalDate.of(1997, 9, 16), "Bairro 3", "Rua Logradouro 3", "3"));
    clientes.add(criarCliente(4L, "cliente 4", LocalDate.of(1998, 10, 17), "Bairro 4", "Rua Logradouro 4", "4"));
    clientes.add(criarCliente(5L, "cliente 5", LocalDate.of(1999, 11, 18), "Bairro 5", "Rua Logradouro 5", "5"));

  }

  private static Cliente criarCliente(long id, String nome, LocalDate abertura, String bairro, String logradouro, String numero) {
    Cliente cliente = new Cliente();
    cliente.setIdCliente(id);
    cliente.setNome(nome);
    cliente.setAbertura(abertura);
    Endereco endereco = new Endereco();
    endereco.setBairro(bairro);
    endereco.setLogradouro(logradouro);
    endereco.setNumero(numero);
    cliente.setEndereco(endereco);
    return cliente;
  }

  public Optional<List<Cliente>> buscarClientes() {
    return Optional.of(clientes);
  }

  public Optional<Cliente> buscarClientePorId(Long idCliente) {
    return clientes.stream()
        .filter(c -> c.getIdCliente().equals(idCliente))
        .findFirst();
  }

  public Long cadastrar(Cliente cliente) {
    long id = (long) clientes.size() + 1;
    cliente.setIdCliente(id);
    clientes.add(cliente);

    return id;
  }

  public void deletarCliente(Long idCliente) {
    clientes.removeIf(c -> c.getIdCliente().equals(idCliente));
  }
}
