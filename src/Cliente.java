import java.util.Random;
import java.util.Scanner;

public class Cliente extends Pessoa{

    // ATRIBUTOS

    private String tipoCliente;
    private String pedidoCliente;
    private int codigoCliente;

    // METODOS

    public void fazerPedido(){

    }
    public void mostrarCliente(){
        if (this.isCadastrado()) {
            System.out.println("-----------------------------------------");
            System.out.println("    Dados do cliente    ");
            System.out.println("Cliente: " + getNome());
            System.out.println(getTipoCliente());
            System.out.println("CPF: " + getCpf());
            System.out.println("Telefone: " + getTelefone());
            System.out.println("Codigo do cliente: " + getCodigoCliente());
        } else {
            System.out.println("Não há dados desse cliente.");
        }
    }
    public void cadastrarCliente(){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("Digite o nome do cliente: ");
        this.setNome(input.nextLine());

        System.out.println("Digite se o cliente é Aluno ou Servidor: ");
        this.setTipoCliente(input.nextLine());

        System.out.println("Digite o CPF do cliente: ");
        this.setCpf(input.nextInt());

        System.out.println("Digite o número do cliente: ");
        this.setTelefone(input.nextInt());

        Random cod = new Random();
        this.setCodigoCliente(cod.nextInt(200));
        System.out.println("Codigo gerado: " + getCodigoCliente());

        this.setCadastrado(true);

    }

    // METODOS ESPECIAIS

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getPedidoCliente() {
        return pedidoCliente;
    }

    public void setPedidoCliente(String pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

}
