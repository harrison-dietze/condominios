package factories.apartamento;

import modelos.Morador;
import modelos.apartamento.Apartamento;
import modelos.apartamento.ApartamentoLuxo;

import java.util.List;

public class ApartamentoLuxoFactory extends ApartamentoFactory {
    private String modeloLuminaria;
    private boolean possuiGeladeiraEmbutida;
    private boolean possuiFogaoEmbutido;

    public ApartamentoLuxoFactory(String modeloLuminaria, boolean possuiGeladeiraEmbutida, boolean possuiFogaoEmbutido) {
        this.modeloLuminaria = modeloLuminaria;
        this.possuiGeladeiraEmbutida = possuiGeladeiraEmbutida;
        this.possuiFogaoEmbutido = possuiFogaoEmbutido;
    }

    @Override
    public Apartamento criarApartamento(int numero, int andar, List<Morador> listaMoradores) {
        return new ApartamentoLuxo(numero, andar, listaMoradores, modeloLuminaria, possuiGeladeiraEmbutida, possuiFogaoEmbutido);
    }

}