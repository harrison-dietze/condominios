package modelos;

import modelos.apartamento.Apartamento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Edificio {
    public int getQuantidadeApartamentos() {
        return this.listaApartamentos.size();
    }

    private int numero;
    private int numeroAndares;

    private List<Apartamento> listaApartamentos = new ArrayList<Apartamento>();
    private List<Pintura> listaPinturas = new ArrayList<Pintura>();

    public Edificio(int numero, int numeroAndares, List<Apartamento> listaApartamentos, List<Pintura> listaPinturas) {
        this.numero = numero;
        this.numeroAndares = numeroAndares;
        this.listaApartamentos = listaApartamentos;
        this.listaPinturas = listaPinturas;
    }

    @Override
    public String toString() {


        return  "\n Número: " + numero +
                "\n Número de andares:  " + numeroAndares +
                "\n Pintura: " + listaPinturas.stream().map(p -> p.toString()).collect(Collectors.joining()) +
                "\n Apartamentos: " + listaApartamentos.stream().map(a -> a.toString()).collect(Collectors.joining());

    }
}
