package br.teste.quarkus.model;

import br.teste.quarkus.dto.ClienteDto;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy =GenerationType.IDENTITY)
  @Column(name = "id_cliente")
  private Long idCliente;

  @Column(name = "nome")
  private String nome;

  @Column(name = "abertura")
  private LocalDate abertura;

  @ManyToOne
  @JoinColumn(name = "id_endereco")
  private Endereco endereco;

  public Cliente() {
  }

  public Cliente(ClienteDto dto) {
    this.idCliente = dto.getIdCliente();
    this.nome = dto.getNome();
    this.abertura = dto.getAbertura();

    if (dto.getEndereco() != null) {
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

  public ClienteDto toDto() {

    ClienteDto dto = new ClienteDto();
    dto.setIdCliente(this.getIdCliente());
    dto.setAbertura(this.getAbertura());
    dto.setNome(this.getNome());
    if (this.endereco != null) {
      dto.setEndereco(this.endereco.toDto());
    }

    return dto;
  }

}
