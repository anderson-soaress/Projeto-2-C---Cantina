import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;

import java.util.Scanner;

public class CantinaMain {
    public static void main(String[] args) {

        //registra input
        Scanner input = new Scanner(System.in);


        //gera um codigo aleatorio, de 0 ate 200,
        Random rand = new Random();
        int limit = 200;
        int escolhaMenu = 1;


        while (escolhaMenu == 1) {
            // CHAMA O MENU E LÊ O NUMERO DIGITADO
            MenuS mn = new MenuS();
            mn.menuu();

            escolhaMenu = input.nextInt();

            switch (escolhaMenu) {

                // CRIA NOVA LISTA

                case 1:
                    Cliente cliente1 = new Cliente();
                    cliente1.cadastrarCliente();
                    cliente1.mostrarCliente();
                    break;

                // ACESSAR LISTAS

                case 2:
                    System.out.println("");

                    break;

                // ENCERRAR

                case 3:
                    System.out.close();

                    // Se o número escolhido nao for 1,2 ou 3
                default:
                    System.out.println("");
                    System.out.println("POR FAVOR ESCOLHA UMA DESSAS OPÇÕES");
                    System.out.println("");
                    escolhaMenu = 1;
            }
        }
    }
}

