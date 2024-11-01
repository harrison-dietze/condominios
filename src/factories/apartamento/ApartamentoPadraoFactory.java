package factories.apartamento;

import modelos.Morador;
import modelos.apartamento.Apartamento;
import modelos.apartamento.ApartamentoPadrao;

import java.util.List;

public class ApartamentoPadraoFactory extends ApartamentoFactory {
    private String tipoArmarios;
    private String tipoPiso;

    public ApartamentoPadraoFactory(String tipoArmarios, String tipoPiso) {
        this.tipoArmarios = tipoArmarios;
        this.tipoPiso = tipoPiso;
    }

    @Override
    public Apartamento criarApartamento(int numero, int andar, List<Morador> listaMoradores) {
        return new ApartamentoPadrao(numero, andar, listaMoradores, tipoArmarios, tipoPiso);
    }
}