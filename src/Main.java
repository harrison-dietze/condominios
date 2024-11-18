
import factories.condominio.CondominioFactoryImpl;
import factories.edificio.EdificioFactory;
import factories.edificio.EdificioFactoryImpl;
import factories.morador.MoradorFactoryImpl;
import factories.apartamento.ApartamentoFactory;
import factories.apartamento.ApartamentoLuxoFactory;
import factories.apartamento.ApartamentoPadraoFactory;
import factories.pintura.PinturaFactoryImpl;
import modelos.Condominio;
import modelos.Edificio;
import modelos.Morador;
import modelos.Pintura;
import modelos.apartamento.Apartamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Condominio> listaCondominios = new ArrayList<Condominio>();

    private static final Handler handler = new Handler();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean fechar = false;
        do {
            System.out.println("Selecione a opção desejada: \n 1 -Criar condomínio ");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    listaCondominios.add(criarCondominioPelaFabrica());
                    break;
                case 2:
                    editarCondominio();
                    break;
                default:
                    fechar = true;
                    break;

            }

            System.out.println("Lista atual de condomínios: ");
            listaCondominios.forEach(c -> System.out.println(c.toString()));
        } while (!fechar);
    }

    private static void editarCondominio() {
        System.out.println("Selecione o número do condomínio a ser editado: ");

        int numeroCondominio = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < listaCondominios.size(); i++) {
            if(numeroCondominio == listaCondominios.get(i).getNumero()) {
                encontrado = true;
                listaCondominios.set(i, criarCondominioPelaFabrica());
            }
        }
        if (!encontrado) {
            System.out.println("Condomínio não encontrado!: ");
            editarCondominio();
        }
    }


    private static Condominio criarCondominioPelaFabrica() {
       return receberDadosCondominio();
    }

    private static List<Edificio> criarEdificiosPelaFabrica() {
        List<Edificio> edificios = new ArrayList<Edificio>();

        int numeroEdificios = handler.getNumeroElementos("edificios");

        for (int i = 0; i < numeroEdificios; i++) {
            System.out.println("Dados do edifício " + (i + 1));

            edificios.add(receberDadosEdificio());
        }
        return edificios;

    }

    private static List<Apartamento> criarApartamentosPelaFabrica() {
        List<Apartamento> apartamentos = new ArrayList<Apartamento>();


        int numeroApartamentos = handler.getNumeroElementos("apartamentos");
        for (int i = 0; i < numeroApartamentos; i++) {
            System.out.println("Dados do apartamento " + (i + 1));

            apartamentos.add(receberDadosApartamento());
        }
        return apartamentos;

    }

    private static List<Pintura> criarPinturasPelaFabrica() {
        List<Pintura> pinturas = new ArrayList<Pintura>();

        int numeroPinturas = handler.getNumeroElementos("faces com pinturas diferentes");

        for (int i = 0; i < numeroPinturas; i++) {
            System.out.println("Dados da pintura " + (i + 1));

            pinturas.add(receberDadosPintura());
        }
        return pinturas;
    }

    private static List<Morador> criarMoradoresPelaFabrica() {
        List<Morador> moradores = new ArrayList<Morador>();

        int numeroMoradores = handler.getNumeroElementos("morador");

        for (int i = 0; i < numeroMoradores; i++) {
            System.out.println("Dados do morador " + (i + 1));

            moradores.add(receberDadosMorador());
        }
        return moradores;
    }


    private static Pintura receberDadosPintura() {
        return  new PinturaFactoryImpl().criarPintura(handler.getCor(), handler.getFace());
    }

    private static Condominio receberDadosCondominio() {
        return  new CondominioFactoryImpl().criarCondominio(handler.getNumero("condomínio"), handler.getNome("condomínio"), handler.getCidade("condomínio"), handler.getBairro("condomínio"), criarEdificiosPelaFabrica());
    }

    private static Morador receberDadosMorador() {
        return  new MoradorFactoryImpl().criarMorador(handler.getNome("morador"), handler.getIdade(), handler.getSexo(), handler.getRG(), handler.getCPF(), handler.getRenda());
    }

    private static Edificio receberDadosEdificio() {
        EdificioFactory edificioFactory = new EdificioFactoryImpl();

        return edificioFactory.criarEdificio(
                handler.getNumero("edifício"),
                handler.getNumeroAndares("edifício"), criarApartamentosPelaFabrica(), criarPinturasPelaFabrica());
    }

    private static Apartamento receberDadosApartamento() {
        String tipoApartamento = handler.getTipoApartamento();
        ApartamentoFactory apartamentoFactory = tipoApartamento.equals("Luxo") ?
                new ApartamentoLuxoFactory(handler.getModeloLuminaria(), handler.getPossuiGeladeiraEmbutida(), handler.getPossuiFogaoEmbutido()) :
                new ApartamentoPadraoFactory(handler.getTipoPiso(), handler.getTipoArmarios());


        return apartamentoFactory.criarApartamento(handler.getNumero("apartamento"), handler.getNumeroAndar(), criarMoradoresPelaFabrica());
    }
}
