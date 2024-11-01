package modelos.apartamento;

import modelos.Morador;

import java.util.List;

public class ApartamentoPadrao extends Apartamento {
    private String tipoArmarios;
    private String tipoPiso;

    public ApartamentoPadrao(int numero, int andar, List<Morador> listaMoradores, String tipoArmarios, String tipoPiso) {
        this.tipoArmarios = tipoArmarios;
        this.tipoPiso = tipoPiso;
        this.setNumero(numero);
        this.setAndar(andar);
        this.setListaMoradores(listaMoradores);
    }

    @Override
    public String getTipo() {
        return "Apartamento Padrão";
    }

    @Override
    public String toString() {
        return super.toString() +   "\n Armários: " + tipoArmarios +
                "\n Piso: " + tipoPiso;
    }


}