package factories.condominio;

import modelos.Condominio;
import modelos.Edificio;

import java.util.List;

public class CondominioFactoryImpl implements CondominioFactory {

    public Condominio criarCondominio(int numero, String nome, String cidade, String bairro, List<Edificio> listaEdificios) {
        return new Condominio(numero, nome, cidade, bairro, listaEdificios);
    }
}
