package modelos.apartamento;

import modelos.Morador;

import java.util.List;


public class ApartamentoLuxo extends Apartamento {
    private String modeloLuminaria;
    private boolean possuiGeladeiraEmbutida;
    private boolean possuiFogaoEmbutido;

    public ApartamentoLuxo(int numero, int andar, List<Morador> listaMoradores, String modeloLuminaria, boolean possuiGeladeiraEmbutida, boolean possuiFogaoEmbutido) {
        this.modeloLuminaria = modeloLuminaria;
        this.possuiGeladeiraEmbutida = possuiGeladeiraEmbutida;
        this.possuiFogaoEmbutido = possuiFogaoEmbutido;
        this.setNumero(numero);
        this.setAndar(andar);
        this.setListaMoradores(listaMoradores);
    }

    @Override
    public String getTipo() {
        return "Apartamento Luxo";
    }

    @Override
    public String toString() {
        return super.toString() + "\n Luminária: " + modeloLuminaria +
                                  "\n Geladeira Embutida: " + (possuiGeladeiraEmbutida ? "Sim" : "Não") +
                                  "\n Fogão Embutido: " + (possuiFogaoEmbutido ? "Sim" : "Não");
    }


}