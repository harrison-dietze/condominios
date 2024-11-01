package factories.condominio;

import modelos.Condominio;
import modelos.Edificio;

import java.util.List;

public interface CondominioFactory {
    Condominio criarCondominio(int numero, String nome, String cidade, String bairro, List<Edificio> listaEdificios);
}


