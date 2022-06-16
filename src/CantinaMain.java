import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;

import java.util.Scanner;

public class CantinaMain {
    public static void main(String[] args) {

        //registra input
        Scanner sc = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        Scanner pedido = new Scanner(System.in);

        //gera um codigo aleatorio, de 0 ate 200,
        Random rand = new Random();
        int limit = 200;
        int escolhaMenu = 1;


        while (escolhaMenu == 1) {
            // CHAMA O MENU E LÊ O NUMERO DIGITADO
            MenuS mn = new MenuS();
            mn.menuu();
            escolhaMenu = sc.nextInt();

            switch (escolhaMenu) {

                // CRIA NOVA LISTA
                case 1:
                    Cliente cl = new Cliente();
                    cl.cc();
                    String nome = name.nextLine();

                    cl.pp();
                    String ped = pedido.nextLine();

                    cl.codig();
                    int int_random = rand.nextInt(limit);

                    System.out.println(int_random);

                    System.out.println("CLIENTE: " + nome + " PEDIDO: " + ped + " CODIGO: " + int_random);

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
