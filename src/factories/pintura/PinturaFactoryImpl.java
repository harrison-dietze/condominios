package factories.pintura;

import modelos.Pintura;

public class PinturaFactoryImpl implements PinturaFactory {

    public Pintura criarPintura(String cor, String face) {
        return new Pintura(cor, face);
    }

}
