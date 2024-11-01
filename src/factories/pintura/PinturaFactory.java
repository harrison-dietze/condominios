package factories.pintura;


import modelos.Pintura;

public interface PinturaFactory {

   Pintura criarPintura(String cor, String face);
}
