package br.teste.quarkus.criadorescodigo;

import javax.enterprise.inject.Produces;

public class JsonMapperProvider {


  @Produces @OracleUrl
  public String getUrlOracle(){

    return "jdbc:oracle:thin:@localhost:1521:db";
  }

  @Produces @PostgresUrl
  public String getUrlPostgres(){

    return "jdbc:postgresql://localhost/test";
  }

  @Produces
  public String getUrlPadrao(){
    return "jdbc:h2:teste";
  }


}
