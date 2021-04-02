package br.teste.quarkus.model;

import br.teste.quarkus.dto.ClienteDto;
import java.time.LocalDate;

public class Cliente {

  private Long idCliente;
  private String nome;
  private LocalDate abertura;
  private Endereco endereco;

  public Cliente() {
  }

  public Cliente(ClienteDto dto) {
    this.idCliente = dto.getIdCliente();
    this.nome = dto.getNome();
    this.abertura = dto.getAbertura();

    if(dto.getEndereco() != null){
      this.endereco = new Endereco(dto.getEndereco());
    }

  }


  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getAbertura() {
    return abertura;
  }

  public void setAbertura(LocalDate abertura) {
    this.abertura = abertura;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public ClienteDto toDto(){

    ClienteDto dto = new ClienteDto();
    dto.setIdCliente(this.getIdCliente());
    dto.setAbertura(this.getAbertura());
    dto.setNome(this.getNome());
    if(this.endereco != null) {
      dto.setEndereco(this.endereco.toDto());
    }

    return dto;
  }

}
