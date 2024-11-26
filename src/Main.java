
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
                System.out.println("O que você deseja fazer? \n "+
                                   "1 - Recriar condomínio \n "+
                                   "2 - Editar edifício do condomínio \n" +
                                   "3 - Excluir edifício do condomínio ");

                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        listaCondominios.set(i, criarCondominioPelaFabrica());
                    case 2: 
                       editarEdificio(listaCondominios.get(i));
                    case 3:
                       excluirEdificio(listaCondominios.get(i));
                } 

               
            }
        }
        if (!encontrado) {
            System.out.println("Condomínio não encontrado!: ");
            editarCondominio();
        }
    }

    private static void editarEdificio(Condominio condominio) {
        System.out.println("Selecione o número do edifício a ser editado: ");

        int numeroEdifício = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < condominio.getEdificios().size(); i++) {
            if(numeroEdifício == condominio.getEdificios().get(i).getNumero()) {
                encontrado = true;
                System.out.println("O que você deseja fazer? \n" +
                                    "1 - Recriar edifício \n" +
                                    "2 - Editar apartamento do edifício \n" +
                                    "3 - Editar pintura do edifício \n" +
                                    "4 - Excluir apartamemto do edifício \n" +
                                    "5 - Excluir pintura do edifício");

                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        condominio.getEdificios().set(i, receberDadosEdificio());
                    case 2: 
                        editarApartamento(condominio.getEdificios().get(i));
                    case 3:
                        editarPintura(condominio.getEdificios().get(i));
                    case 4:
                        excluirApartamento(condominio.getEdificios().get(i));
                    case 5:
                        excluirPintura(condominio.getEdificios().get(i));
                }

               
            }
        }
        if (!encontrado) {
            System.out.println("Edifício não encontrado!: ");
            editarCondominio();
        }
    }

    private static void editarApartamento(Edificio edificio) {
        System.out.println("Selecione o número do apartamento a ser editado: ");

        int numeroApartamemto = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < edificio.getApartamentos().size(); i++) {
            if(numeroApartamemto == edificio.getApartamentos().get(i).getNumero()) {
                encontrado = true;
                System.out.println("O que você deseja fazer? \n" +
                                    "1 - Recriar apartamento \n" +
                                    "2 - Editar morador do apartamento \n" +
                                    "3 - Excluir morador do apartamento ");

                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        edificio.getApartamentos().set(i, receberDadosApartamento());
                    case 2:
                        editarMorador(edificio.getApartamentos().get(i));
                    case 3:
                        excluirMorador(edificio.getApartamentos().get(i));
                }
            }
        }
        if (!encontrado) {
            System.out.println("Apartamento não encontrado!: ");
            editarCondominio();
        }
    }

    private static void editarMorador(Apartamento apartamento) {
        System.out.println("Selecione o CPF do morador a ser editado: ");

        String cpfMorador = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < apartamento.getListaMoradores().size(); i++) {
            if(cpfMorador.equals(apartamento.getListaMoradores().get(i).getCpf())) {
                encontrado = true;
                System.out.println("O que você deseja fazer? \n" +
                        "1 - Substituir dados do morador");

                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        apartamento.getListaMoradores().set(i, receberDadosMorador());
                }
            }
        }
        if (!encontrado) {
            System.out.println("Morador não encontrado!: ");
            editarCondominio();
        }
    }

    private static void editarPintura(Edificio edificio) {
        System.out.println("Selecione a face da pintura a ser editado: ");

        String face = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < edificio.getPinturas().size(); i++) {
            if(face.equals(edificio.getPinturas().get(i).getFace())) {
                encontrado = true;
                System.out.println("O que você deseja fazer? \n" +
                        "1 - Substituir dados do morador");

                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        edificio.getPinturas().set(i, receberDadosPintura());
                }
            }
        }
        if (!encontrado) {
            System.out.println("Face não encontrada!: ");
            editarCondominio();
        }
    }

    private static void excluirPintura(Edificio edificio) {
        System.out.println("Selecione a face da pintura a ser excluída: ");

        String face = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < edificio.getPinturas().size(); i++) {
            if(face.equals(edificio.getPinturas().get(i).getFace())) {
                encontrado = true;

                edificio.getPinturas().remove(i);
            }
        }
        if (!encontrado) {
            System.out.println("Face não encontrada!: ");
            editarCondominio();
        }
    }

    private static void excluirEdificio(Condominio condominio) {
        System.out.println("Selecione o número do edifício a ser excluído: ");

        int numeroEdificio = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < condominio.getEdificios().size(); i++) {
            if(numeroEdificio == condominio.getEdificios().get(i).getNumero()) {
                encontrado = true;

                condominio.getEdificios().remove(i);
            }
        }
        if (!encontrado) {
            System.out.println("Edifício não encontrado!: ");
            editarCondominio();
        }
    }

    private static void excluirApartamento(Edificio edificio) {
        System.out.println("Selecione o número do apartamento a ser excluído: ");

        int numeroApartamento = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < edificio.getApartamentos().size(); i++) {
            if(numeroApartamento == edificio.getApartamentos().get(i).getNumero()) {
                encontrado = true;

                edificio.getApartamentos().remove(i);
            }
        }
        if (!encontrado) {
            System.out.println("Edifício não encontrado!: ");
            editarCondominio();
        }
    }

    private static void excluirMorador(Apartamento apartamento) {
        System.out.println("Selecione o CPF do morador a ser excluído: ");

        String cpf = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < apartamento.getListaMoradores().size(); i++) {
            if(cpf.equals(apartamento.getListaMoradores().get(i).getCpf())) {
                encontrado = true;

                apartamento.getListaMoradores().remove(i);
            }
        }
        if (!encontrado) {
            System.out.println("Edifício não encontrado!: ");
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
