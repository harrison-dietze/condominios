package modelos;

import modelos.apartamento.Apartamento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Edificio {

    private int numero;
    private int numeroAndares;

    private List<Apartamento> apartamentos = new ArrayList<Apartamento>();
    private List<Pintura> pinturas = new ArrayList<Pintura>();

    public Edificio(int numero, int numeroAndares, List<Apartamento> apartamentos, List<Pintura> pinturas) {
        this.numero = numero;
        this.numeroAndares = numeroAndares;
        this.apartamentos = apartamentos;
        this.pinturas = pinturas;
    }

    @Override
    public String toString() {


        return  "\n Número: " + numero +
                "\n Número de andares:  " + numeroAndares +
                "\n Pintura: " + pinturas.stream().map(p -> p.toString()).collect(Collectors.joining()) +
                "\n Apartamentos: " + apartamentos.stream().map(a -> a.toString()).collect(Collectors.joining());

    }

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public List<Pintura> getPinturas() {
        return pinturas;
    }

    public int getQuantidadeApartamentos() {
        return this.apartamentos.size();
    }

    public int getNumero() {
        return numero;
    }
}
