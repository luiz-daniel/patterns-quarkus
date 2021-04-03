package br.teste.quarkus.dto;

public class EnderecoDto {

  private String logradouro;
  private String bairro;
  private String numero;
  private Long idEndereco;

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

  public Long getIdEndereco() { return idEndereco;}

  public void setIdEndereco(Long idEndereco) { this.idEndereco = idEndereco;}

  @Override
  public String toString() {
    return "EnderecoDto{" +
        "logradouro='" + logradouro + '\'' +
        ", bairro='" + bairro + '\'' +
        ", numero='" + numero + '\'' +
        ", idEndereco=" + idEndereco +
        '}';
  }
}
