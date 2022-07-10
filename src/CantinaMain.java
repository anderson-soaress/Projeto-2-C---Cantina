
import java.util.Scanner;

public class CantinaMain {
    public static void main(String[] args) {

        // OBJETOS

        String escolhaMenu = "0";

        Scanner input = new Scanner(System.in);
        Cliente CL = new Cliente();
        Funcionario F = new Funcionario();
        Produto P = new Produto();

        // MENU PRINCIPAL

        do {
            String escolhaOpcoes = "0";
            Interface.limpatela();

            System.out.println("-------MENU--------");
            System.out.println("| 1 - CADASTRAR   |");
            System.out.println("| 2 - DADOS       |");
            System.out.println("| 3 - ACOES       |");
            System.out.println("| 4 - SAIR        |");
            System.out.println("-------------------");

            escolhaMenu = input.nextLine();

            switch (escolhaMenu) {

                case "1": // MENU DE CADASTRO

                        Interface.limpatela();
                        System.out.println("------CADASTRO------");
                        System.out.println("| 1 - CLIENTE      |");
                        System.out.println("| 2 - FUNCIONARIO  |");
                        System.out.println("| 3 - PRODUTO      |");
                        System.out.println("| 4 - SAIR         |");
                        System.out.println("--------------------");
                        escolhaOpcoes = input.nextLine();

                        switch (escolhaOpcoes) {
                            case "1": // CADASTRO CLIENTE
                                CL.cadastrar();
                                break;
                            case "2":
                                F.cadastrar(); // CADASTRO FUNCIONARIO
                                break;
                            case "3":
                                P.cadastrar(); // CADASTRO DE PRODUTO
                                break;
                            case "4": // SAIR DO MENU DE CADASTRO
                                System.out.println("SAINDO...");
                                break;
                        }

                    break;

                case "2": // MENU DE DADOS

                    Interface.limpatela();
                    System.out.println("-------DADOS-------");
                    System.out.println("| 1 - CLIENTE     |");
                    System.out.println("| 2 - FUNCIONARIO |");
                    System.out.println("| 3 - PRODUTO     |");
                    System.out.println("| 4 - SAIR        |");
                    System.out.println("-------------------");
                    escolhaOpcoes = input.nextLine();

                    switch (escolhaOpcoes) {
                        case "1": // DADOS CLIENTE
                            CL.manipular();
                            break;
                        case "2": // DADOS FUNCIONARIO
                            F.manipular();
                            break;
                        case "3": // DADOS PRODUTO
                            P.manipular();
                            break;
                        case "4": // SAIR DO MENU DE DADOS
                            System.out.println("SAINDO...");
                            break;
                    }

                    break;

                case "3": // AÇÕES

                    Interface.limpatela();
                    System.out.println("------ACOES------");
                    System.out.println("| 1 - DEPOSITAR |");
                    System.out.println("| 2 - PAGAR     |");
                    System.out.println("| 3 - SAIR      |");
                    System.out.println("-----------------");
                    escolhaOpcoes = input.nextLine();

                        switch (escolhaOpcoes){
                            case "1":
                                CL.depositar();
                                break;
                            case "2":
                                CL.pagar();
                                break;
                            case "3":
                                System.out.println("SAINDO...");
                                break;
                        }

                case "4":// SAIR DO PROGRAMA
                    System.out.println("Saindo...");
                    break;

            }

        } while (!escolhaMenu.equals("4"));

    }
}
