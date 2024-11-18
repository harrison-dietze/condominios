package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Condominio {

    private int numero;
    private String nome;
    private String cidade;
    private String bairro;

    private List<Edificio> edificios =  new ArrayList<Edificio>();

    public Condominio(int numero, String nome, String cidade, String bairro, List<Edificio> edificios) {
        this.numero = numero;
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.edificios = edificios;
    }

    @Override
    public String toString() {


        return  "\n Número: "+ numero +
                "\n Nome: "+ nome +
                "\n Cidade: "+ cidade +
                "\n Bairro: " + bairro +
                "\n Edificios: "+ edificios.stream().map(e -> e.toString()).collect(Collectors.toList());

    }

    public int getNumero() {
        return numero;
    }

}
