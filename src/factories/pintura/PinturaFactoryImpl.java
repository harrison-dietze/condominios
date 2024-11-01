package factories.pintura;

import modelos.Edificio;
import modelos.Pintura;
import modelos.apartamento.Apartamento;

import java.util.List;

public class PinturaFactoryImpl implements PinturaFactory {

    public Pintura criarPintura(String cor, String face) {
        return new Pintura(cor, face);
    }

}
