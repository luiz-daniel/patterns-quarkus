package br.teste.quarkus.dto;

import java.time.LocalDate;

public class ClienteDto {

  private Long idCliente;
  private String nome;
  private LocalDate abertura;
  private EnderecoDto endereco;

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

  public EnderecoDto getEndereco() {
    return endereco;
  }

  public void setEndereco(EnderecoDto endereco) {
    this.endereco = endereco;
  }

  @Override
  public String toString() {
    return "ClienteDto{" +
        "idCliente=" + idCliente +
        ", nome='" + nome + '\'' +
        ", abertura=" + abertura +
        ", endereco=" + endereco +
        '}';
  }
}
