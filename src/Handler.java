import java.util.Scanner;

public class Handler {

    private Scanner scanner;

    public Handler() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumero(String elemento) {
        System.out.println("Insira o número do " + elemento + ": ");
        return scanner.nextInt();
    }

    public String getNome(String elemento) {
        System.out.println("Insira o nome do " + elemento + ": ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String getCidade(String elemento) {
        System.out.println("Insira o nome da cidade do " + elemento + ": ");
        return scanner.nextLine();
    }


    public String getBairro(String elemento) {
        System.out.println("Insira o nome do bairro do " + elemento + ": ");
        return scanner.nextLine();
    }

    public int getNumeroAndares(String elemento) {
        System.out.println("Insira o número de andares do " + elemento + ": ");
        return scanner.nextInt();
    }

    public int getNumeroAndar() {
        System.out.println("Insira o número do andar: ");
        return scanner.nextInt();
    }

    public String getCor() {
        System.out.println("Insira a cor: ");
        return scanner.nextLine();
    }

    public String getFace() {
        System.out.println("Insira a face: ");
        return scanner.nextLine();
    }

    public int getNumeroElementos(String elementos) {
        System.out.println("Insira o número de " + elementos + ": ");
        return scanner.nextInt();
    }

    public boolean getPossuiGeladeiraEmbutida() {
        System.out.println("Possui geladeira embutida? " +
                "\n 1 - Sim" +
                "\n 2 - Não");
        return scanner.nextLine() == "Sim" ? true : false;
    }

    public boolean getPossuiFogaoEmbutido() {
        System.out.println("Possui fogão embutido? " +
                "\n 1 - Sim" +
                "\n 2 - Não");
        return scanner.nextLine() == "Sim" ? true : false;
    }


    public String getModeloLuminaria() {
        System.out.println("Insira o nome do modelo de luminária: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String getTipoArmarios() {
        System.out.println("Insira o nome do tipo de armários: ");
        return scanner.nextLine();
    }


    public String getTipoPiso() {
        System.out.println("Insira o nome do tipo de piso: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String getTipoApartamento() {
        System.out.println("Tipo de apartamento: " +
                            "\n 1 - Luxo" +
                            "\n 2 - Padrão");
        return scanner.nextInt() == 1 ? "Luxo" : "Padrao";
    }
}
