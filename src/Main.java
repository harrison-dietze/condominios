
import factories.condominio.CondominioFactoryImpl;
import factories.edificio.EdificioFactory;
import factories.edificio.EdificioFactoryImpl;
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

    public static void main(String[] args) {
        boolean fechar = false;
        do {
            System.out.println("Selecione a opção desejada: \n 1 -Criar condomínio ");

            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            if (opcao == 1) {
                listaCondominios.add(criarCondominioPelaFabrica());
            }
            else {
                fechar = true;
            }

            System.out.println("Lista atual de condomínios: ");
            listaCondominios.forEach(c -> c.toString());
        } while (!fechar);
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


    private static Pintura receberDadosPintura() {
        return  new PinturaFactoryImpl().criarPintura(handler.getCor(), handler.getFace());
    }

    private static Condominio receberDadosCondominio() {
        return  new CondominioFactoryImpl().criarCondominio(handler.getNumero("condomínio"), handler.getNome("condomínio"), handler.getCidade("condomínio"), handler.getBairro("condomínio"), criarEdificiosPelaFabrica());
    }

    private static Morador receberDadosMorador() {
        return  new MoradorFactoryImpl().criarMorador(handler.getNome("morador"), handler.getCPF(), handler.getRG(), handler.getRenda());
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


        return apartamentoFactory.criarApartamento(handler.getNumero("apartamento"), handler.getNumeroAndar(), new ArrayList<>());
    }
}
