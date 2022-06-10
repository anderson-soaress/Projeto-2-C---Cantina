
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


        MenuS mn = new MenuS();
        mn.menuu();



        int esc = sc.nextInt();

        int re = 0;

        //area seleçao menu, lembrar de voltar o metodo
        //talvez nao usar switch

        switch (re) {
            default:
            switch (esc) {
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
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.close();
                default:
                    System.out.println("INSIRA O NUMERO DE 1 A 3");



            }

        }


    }
}




