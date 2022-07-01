
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Cliente extends Pessoa {

    // ATRIBUTOS

    private float preco;
    private float saldo;
    private String tipoCliente;
    private String pedidoCliente;
    private int codigoCliente;

    // OBJETOS
    Scanner input = new Scanner(System.in);
    HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
    String espera = "1";

    // METODOS

    @Override
    public void coletar() {

        Interface.limpatela();
        System.out.println("---------CADASTRO---------");
        System.out.println("Digite o nome do cliente: ");
        this.setNome(input.nextLine());

        System.out.println("Digite se o cliente é Aluno ou Servidor: ");
        this.setTipoCliente(input.nextLine());

        System.out.println("Digite o CPF do cliente: ");
        this.setCpf(input.nextLine());

        System.out.println("Digite o número do cliente: ");
        this.setTelefone(input.nextLine());

        Random cod = new Random();
        this.setCodigoCliente(cod.nextInt(200));
        System.out.println("Codigo gerado: " + getCodigoCliente());

        this.setCadastrado(true);

    }

    @Override
    public void dados() {
        if (this.isCadastrado()) {
            Interface.limpatela();
            System.out.println("-----Dados do cliente-----");
            System.out.println("Cliente: " + getNome());
            System.out.println(getTipoCliente());
            System.out.println("CPF: " + getCpf());
            System.out.println("Telefone: " + getTelefone());
            System.out.println("Codigo do cliente: " + getCodigoCliente());
            esperar();
        } else {
            System.out.println("Não há dados desse cliente.");
            esperar();
        }
    }

    public void dadosConta() {
        Interface.limpatela();
        System.out.println("-----------------------------");
        System.out.println("    Dados da conta   ");
        System.out.println("Conta de " + this.getNome());
        System.out.println("Saldo: " + this.getSaldo());
    }

    @Override
    public void cadastrar() {
        Cliente cliente = new Cliente();
        cliente.coletar();

        if (clientes.containsKey(getCpf())) {
            System.out.println("Este cpf já foi informado.");
            esperar();
        } else {
            clientes.put(cliente.getCpf(), cliente);
            System.out.println();
            System.out.println("Cadastrado com sucesso!");
            esperar();
        }
    }

    @Override
    public void manipular() {

        do {
            Interface.limpatela();
            System.out.println("------DADOS CLIENTE------");
            System.out.println("1 - MOSTRAR");
            System.out.println("2 - ALTERAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - SAIR");

            escolhaMenu = input.nextLine();

            if (!escolhaMenu.equals("4")) {
                System.out.println("--------------");
                System.out.println("DIGITE O CPF: ");
                this.setCpfConsulta(input.nextLine());

                if (clientes.get(getCpfConsulta()) != null) {
                    switch (escolhaMenu) {
                        case "1":
                            do {
                                Interface.limpatela();
                                System.out.println("CPF: " + getCpfConsulta());
                                System.out.println("1 - DADOS DO CLIENTE");
                                System.out.println("2 - SALDO");
                                System.out.println("3 - SAIR");

                                escolhaMenu = input.nextLine();
                                if (!escolhaMenu.equals("3")) {
                                    switch (escolhaMenu) {
                                        case "1":
                                            clientes.get(getCpfConsulta()).dados();
                                            break;
                                        case "2":
                                            clientes.get(getCpfConsulta()).dadosConta();
                                            esperar();
                                            break;
                                        case "3":
                                            System.out.println("SAINDO...");
                                            break;
                                    }
                                }
                            } while (!escolhaMenu.equals("3"));
                            break;
                        case "2":
                            clientes.get(getCpfConsulta()).alterar();
                            break;
                        case "3":
                            Interface.limpatela();
                            System.out.println("VOCÊ TEM CERTEZA QUE QUER REMOVER CPF: " + this.getCpfConsulta() + "?");
                            System.out.println("1 - SIM");
                            System.out.println("2 - NÃO");
                            String escolhaCerteza = "0";
                            escolhaCerteza = input.nextLine();

                            if (escolhaCerteza.equals("1")) {
                                clientes.remove(getCpfConsulta());
                                System.out.println("REMOVIDO COM SUCESSO.");
                                esperar();
                            } else {
                                System.out.println("SAINDO...");
                            }
                            break;
                        case "4":
                            System.out.println("SAINDO...");
                    }
                } else {
                    System.out.println("CPF NÃO CADASTRADO");
                    System.out.println("TENTE NOVAMENTE.");
                    esperar();
                }
            }
        } while (!escolhaMenu.equals("4"));
    }

    @Override
    public void alterar() {
        do {
            Interface.limpatela();
            System.out.println("-----ALTERAR-----");
            System.out.println("1 - NOME");
            System.out.println("2 - CPF");
            System.out.println("3 - TELEFONE");
            System.out.println("4 - SAIR");

            escolhaMenu = input.nextLine();

            switch (escolhaMenu) {
                case "1":
                    System.out.println("NOME ATUAL: " + this.getNome());
                    System.out.println("DIGITE O NOVO NOME: ");
                    this.setNome(input.nextLine());
                    System.out.println("NOME ALTERADO COM SUCESSO!");
                    esperar();
                    break;
                case "2":
                    System.out.println("NAO E POSSIVEL MUDAR O CPF");
                    System.out.println("EXCLUA ESSE CPF E CADASTRE OUTRO USUARIO NELE.");
                    esperar();
                    break;
                case "3":
                    System.out.println("TELEFONE ATUAL: " + this.getTelefone());
                    System.out.println("DIGITE O NOVO TELEFONE: ");
                    System.out.println("TELEFONE ALTERADO COM SUCESSO!");
                    this.setTelefone(input.nextLine());
                    esperar();
                    break;
                case "4":
                    System.out.println("SAINDO...");
                    break;
            }
        } while (!escolhaMenu.equals("4"));
    }

    public void depositar() {

        System.out.println("-----SALDO-----");
        System.out.println("DIGITE O CPF: ");
        this.setCpfConsulta(input.nextLine());

        if (clientes.get(getCpfConsulta()) != null) {

            Interface.limpatela();
            clientes.get(getCpfConsulta()).dadosConta();

            System.out.println("DIGITE O VALOR PARA DEPÓSITO: ");
            clientes.get(getCpfConsulta()).setSaldo(clientes.get(getCpfConsulta()).getSaldo() + Float.parseFloat(input.nextLine()));

            System.out.println("DEPÓSITO REALIZADO COM SUCESSO!");
            System.out.println("SALDO ATUAL: " + clientes.get(getCpfConsulta()).getSaldo());
            esperar();

        } else {
            System.out.println("CPF NÃO CADASTRADO");
            System.out.println("TENTE NOVAMENTE.");
            esperar();
        }

    }

    public void pagar() {
        String escolhaOpcoes = "0";
        String escolhaOpcoes2 = "0";
        this.setPreco(0f);

        do {
            System.out.println("DIGITE O VALOR DO PRODUTO: ");
            this.setPreco(this.getPreco() + Float.parseFloat(input.nextLine()));
            System.out.println();
            System.out.println("VALOR ATUAL: " + this.getPreco());
            System.out.println("1 - ADICIONAR MAIS");
            System.out.println("2 - FINALIZAR COMPRA");
            escolhaOpcoes = input.nextLine();
        } while (!escolhaOpcoes.equals("2"));

        System.out.println("VALOR A SER PAGO: R$" + getPreco());

        do {
            System.out.println("FORMA DE PAGAMENTO: ");
            System.out.println("1 - CONTA");
            System.out.println("2 - PESSOALMENTE");
            escolhaOpcoes2 = input.nextLine();

            switch (escolhaOpcoes2){

                case "1": // PAGAR USANDO CONTA

                    Interface.limpatela();
                    System.out.println("-----PAGAMENTO-----");
                    System.out.println("DIGITE O CPF: ");
                    this.setCpfConsulta(input.nextLine());

                    if (clientes.get(getCpfConsulta()) != null) {
                        String escolhaCompra = "0";

                        Interface.limpatela();
                        clientes.get(getCpfConsulta()).dadosConta();
                        System.out.println();
                        System.out.println("VALOR A SER PAGO: " + this.getPreco());
                        System.out.println("CONFIRMAR COMPRA? ");
                        System.out.println("1 - SIM");
                        System.out.println("2 - NÃO");
                        escolhaCompra = input.nextLine();

                        switch (escolhaCompra){
                            case "1":
                                if (clientes.get(getCpfConsulta()).getSaldo() >= this.getPreco()){

                                    Interface.limpatela();
                                    clientes.get(getCpfConsulta()).setSaldo(clientes.get(getCpfConsulta()).getSaldo() - getPreco());
                                    System.out.println("PAGO COM SUCESSO!");
                                    System.out.println("SALDO ATUAL: " + clientes.get(getCpfConsulta()).getSaldo());
                                    escolhaOpcoes2 = "2";
                                    esperar();

                                } else {
                                    System.out.println("SALDO INSUFICIENTE!");
                                    esperar();
                                }

                                break;
                            case "2":

                        }
                    } else {
                        System.out.println("CPF NÃO CADASTRADO");
                        System.out.println("TENTE NOVAMENTE.");
                        esperar();

                    }

                    break;
                case "2": // PAGAR PESSOALMENTE
                    Interface.limpatela();
                    System.out.println("VALOR A SER PAGO: R$" + this.getPreco());
                    esperar();
                    break;

            }
        } while(!escolhaOpcoes2.equals("2"));

    }

    // METODOS ESPECIAIS

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
