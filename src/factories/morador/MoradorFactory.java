package factories.morador;


import modelos.Morador;

public interface MoradorFactory {

    Morador criarMorador(String nome, int idade, char sexo, String rg, String cpf, double renda);
}
