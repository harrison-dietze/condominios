package factories.edificio;

import modelos.Edificio;
import modelos.Pintura;
import modelos.apartamento.Apartamento;

import java.util.List;

public class EdificioFactoryImpl implements EdificioFactory {

    public Edificio criarEdificio(int numero, int numeroAndares, List<Apartamento> listaApartamentos, List<Pintura> listaPinturas) {
        return new Edificio(numero, numeroAndares, listaApartamentos, listaPinturas);
    }
}
