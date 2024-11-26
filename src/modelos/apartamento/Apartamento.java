package modelos.apartamento;

import modelos.Morador;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Apartamento {
    private int andar;
    private int numero;
    private List<Morador> listaMoradores;

    public  abstract String getTipo();

    public double getRendaMediaMoradores() {
        double somaRenda = getListaMoradores().stream().mapToDouble(Morador::getRenda).sum();
        return somaRenda / getListaMoradores().size();
    }

    public List<Morador> getListaMoradores() {
        return this.listaMoradores;
    };

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public void setAndar(int andar) {
        this.andar = andar;
    }

    public void setListaMoradores(List<Morador> listaMoradores) {
        this.listaMoradores = listaMoradores;
    }

    @Override
    public String toString() {
        return   "  Andar: " + andar +
                "\n Número: " + numero +
                "\n Lista de moradores: " + listaMoradores.stream().map(e -> e.toString()).collect(Collectors.joining());
    }
    
    public int getNumero() {
        return numero;
    }
}
