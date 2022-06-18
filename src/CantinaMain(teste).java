
import java.util.Scanner;

public class CantinaMain {
    public static void main(String[] args) {

        // CHAMA METODO DE CADASTRO DE CLIENTE
        
        Cliente cliente1 = new Cliente();
        System.out.println("   CADASTRE O CLIENTE   ");
        cliente1.cadastrarCliente();
        
        // CHAMA METODO DE CADASTRO DE CONTA

        ContaBanco conta1 = new ContaBanco();
        conta1.cadastrarConta(cliente1);

        // MENU COM ALGUMAS ACOES
        
        int escolhaMenu = 0;

        while (escolhaMenu != 4){
            System.out.println("------------------------------");
            System.out.println("   ESCOLHA   ");
            System.out.println("1- MOSTRAR DADOS DO CLIENTE");
            System.out.println("2- MOSTRAR DADOS DA CONTA");
            System.out.println("3- ACOES");
            System.out.println("4- SAIR");

            Scanner input = new Scanner(System.in);
            escolhaMenu = input.nextInt();

            switch (escolhaMenu){
                case 1:
                    cliente1.mostrarCliente();
                    break;
                case 2:
                    conta1.mostrarConta();
                    break;
                case 3:
                    int escolhaAcao = 0;
                    while (escolhaAcao != 3) {
                        System.out.println("-------------------");
                        System.out.println("   ESCOLHA    ");
                        System.out.println("1- DEPOSITAR");
                        System.out.println("2- PAGAR");
                        System.out.println("3- SAIR");
                        escolhaAcao = input.nextInt();
                        
                        switch (escolhaAcao) {
                            case 1:
                                System.out.println("Valor do deposito: ");
                                conta1.depositar(input.nextFloat());
                                break;
                            case 2:
                                System.out.println("Valor a ser pago: ");
                                conta1.pagar(input.nextFloat());
                                break;
                            case 3:
                                escolhaAcao = 3;
                                break;
                        }
                    }
                case 4:
                    System.out.println("SAINDO...");

            }
        }
    }
}
