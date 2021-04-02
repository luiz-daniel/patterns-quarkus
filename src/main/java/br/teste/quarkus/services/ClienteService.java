package br.teste.quarkus.services;

import br.teste.quarkus.dto.ClienteDto;
import br.teste.quarkus.model.Cliente;
import br.teste.quarkus.repositories.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class ClienteService {

  @Inject
  ClienteRepository clienteRepository;

  public Optional<List<ClienteDto>> consultarClientes() {

    List<ClienteDto> lista = clienteRepository.buscarClientes()
        .orElseGet(ArrayList::new)
        .stream()
        .map(Cliente::toDto)
        .collect(Collectors.toList());

    return Optional.of(lista);

  }

  public Long gravarCliente(ClienteDto dto) {

    return clienteRepository.cadastrar(new Cliente(dto));
  }

  public Optional<ClienteDto> consultarClientePorId(Long idCliente) {
    return clienteRepository.buscarClientePorId(idCliente)
        .map(Cliente::toDto);
  }

  public void deletarCliente(Long idCliente) {

    clienteRepository.deletarCliente(idCliente);
  }
}
