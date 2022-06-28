
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CantinaMain {
    public static void main(String[] args) {


        int escolhaMenu = 0;
        Scanner input = new Scanner(System.in);
        Cliente menu = new Cliente();

        do {
            System.out.println("------MENU------");
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - DADOS");
            System.out.println("3 - SAIR");
            System.out.println("----------------");

            escolhaMenu = input.nextInt();
        switch (escolhaMenu) {
            case 1:
                menu.cadastrar();
                break;
            case 2:
                menu.manipular();
                break;
            case 3:
                System.out.println("Saindo...");
                break;
        }
        } while (escolhaMenu != 3);
    }
}
