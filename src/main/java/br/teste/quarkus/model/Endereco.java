package br.teste.quarkus.model;

import br.teste.quarkus.dto.EnderecoDto;

public class Endereco {

  private String logradouro;
  private String bairro;
  private String numero;

  public Endereco(EnderecoDto endereco) {
    this.logradouro = endereco.getLogradouro();
    this.bairro = endereco.getBairro();
    this.numero = endereco.getNumero();
  }

  public Endereco() {
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public EnderecoDto toDto() {
    EnderecoDto dto = new EnderecoDto();
    dto.setBairro(this.getBairro());
    dto.setLogradouro(this.getLogradouro());
    dto.setNumero(this.getNumero());
    return dto;
  }
}
