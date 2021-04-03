package br.teste.quarkus.model;

import br.teste.quarkus.dto.EnderecoDto;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_endereco")
  private Long idEndereco;

  @Column(name = "logradouro")
  private String logradouro;
  @Column(name = "bairro")
  private String bairro;
  @Column(name = "numero")
  private String numero;

  @OneToMany(mappedBy = "endereco")
  private List<Cliente> clientes;

  public Endereco(EnderecoDto endereco) {
    this.idEndereco = endereco.getIdEndereco();
    this.logradouro = endereco.getLogradouro();
    this.bairro = endereco.getBairro();
    this.numero = endereco.getNumero();
  }

  public List<Cliente> getClientes() {
    return clientes;
  }

  public void setClientes(List<Cliente> clientes) {
    this.clientes = clientes;
  }

  public Endereco() {
  }

  public Long getIdEndereco() {return idEndereco;}

  public void setIdEndereco(Long idEndereco) { this.idEndereco = idEndereco;}

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
    dto.setIdEndereco(this.getIdEndereco());
    dto.setBairro(this.getBairro());
    dto.setLogradouro(this.getLogradouro());
    dto.setNumero(this.getNumero());
    return dto;
  }
}
