package factories.edificio;

import modelos.Edificio;
import modelos.Pintura;
import modelos.apartamento.Apartamento;

import java.util.List;

public interface EdificioFactory {

   Edificio criarEdificio(int numero, int numeroAndares, List<Apartamento> listaApartamentos, List<Pintura> listaPinturas);
}
