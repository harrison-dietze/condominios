package factories.morador;

import modelos.Morador;


public class MoradorFactoryImpl implements MoradorFactory {

    public Morador criarMorador(String nome, int idade, char sexo, String rg, String cpf, double renda) {
        return new Morador(nome, idade, sexo, rg, cpf, renda);
    }

}
