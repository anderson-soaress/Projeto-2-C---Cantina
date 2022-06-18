import java.util.Random;
import java.util.Scanner;

public class Cliente {

    // ATRIBUTOS

    private String tipoCliente;
    private String nomeCliente;
    private int cpfCliente;
    private int foneCliente;
    private String pedidoCliente;
    private int codigoCliente;
    public boolean cadastrado;


    // METODOS

    public void fazerPedido(){

    }
    public void mostrarCliente(){
        if (this.isCadastrado()) {
            System.out.println("-----------------------------------------");
            System.out.println("    Dados do cliente    ");
            System.out.println("Cliente: " + getNomeCliente());
            System.out.println(getTipoCliente());
            System.out.println("CPF: " + getCpfCliente());
            System.out.println("Telefone: " + getFoneCliente());
            System.out.println("Codigo do cliente: " + getCodigoCliente());
        } else {
            System.out.println("Não há dados desse cliente.");
        }
    }
    public void cadastrarCliente(){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("Digite o nome do cliente: ");
        this.setNomeCliente(input.nextLine());

        System.out.println("Digite se o cliente é Aluno ou Servidor: ");
        this.setTipoCliente(input.nextLine());

        System.out.println("Digite o CPF: ");
        this.setCpfCliente(input.nextInt());

        System.out.println("Digite o número do cliente: ");
        this.setFoneCliente(input.nextInt());

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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getFoneCliente() {
        return foneCliente;
    }

    public void setFoneCliente(int foneCliente) {
        this.foneCliente = foneCliente;
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

    public boolean isCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }
}
