import java.util.HashMap;
import java.util.Scanner;

public class Produto {

    // ATRIBUTOS

    private String nome;
    private String codigo;
    private float preco;
    private Cliente comprador;
    private Funcionario vendedor;

    // OBJETOS

    String codigoConsulta;
    String escolhaMenu;
    String espera;
    Scanner input = new Scanner(System.in);
    public HashMap <String, Produto> produtos = new HashMap<String,Produto>();

    public void esperar(){
        System.out.println("DIGITE QUALQUER COISA PARA CONTINUAR");
        espera = input.nextLine();
    }

    // METODOS

    public void coletar(){

        Interface.limpatela();
        System.out.println("---------CADASTRO---------");
        System.out.println("Digite o nome do produto: ");
        this.setNome(input.nextLine());

        System.out.println("Digite o código do produto: ");
        this.setCodigo(input.nextLine());

        System.out.println("Digite o preco do produto: ");
        this.setPreco(Float.parseFloat(input.nextLine()));

    }

    public void dados() {
            Interface.limpatela();
            System.out.println("-----DADOS DO PRODUTO-----");
            System.out.println("| NOME: " + getNome() + " |");
            System.out.println("| CODIGO: " + getCodigo() + "|");
            System.out.println("| PRECO: " + getPreco() + "|");
            System.out.println("-------------------------");
            esperar();
    }

    public void cadastrar() {
        Produto produto = new Produto();
        produto.coletar();

        if (produtos.containsKey(produto.getCodigo())) {
            System.out.println("Este codigo já foi informado.");
            esperar();
        } else {
            produtos.put(produto.getCodigo(), produto);
            System.out.println();
            System.out.println("Cadastrado com sucesso!");
            esperar();
        }
    }

    public void manipular() {

        do {
            Interface.limpatela();
            System.out.println("------DADOS PRODUTO------");
            System.out.println("| 1 - MOSTRAR           |");
            System.out.println("| 2 - ALTERAR           |");
            System.out.println("| 3 - EXCLUIR           |");
            System.out.println("| 4 - SAIR              |");
            System.out.println("-------------------------");

            escolhaMenu = input.nextLine();

            if (!escolhaMenu.equals("4")) {
                System.out.println("----------------------------");
                System.out.println("DIGITE O CODIGO DO PRODUTO: ");
                this.setCodigoConsulta(input.nextLine());

                if (produtos.get(getCodigoConsulta()) != null) {
                    switch (escolhaMenu) {
                        case "1":
                            produtos.get(getCodigoConsulta()).dados();
                            break;
                        case "2":
                            produtos.get(getCodigoConsulta()).alterar();
                            break;
                        case "3":
                            Interface.limpatela();
                            System.out.println("VOCÊ TEM CERTEZA QUE QUER REMOVER O PRODUTO: " + this.getCodigoConsulta() + "?");
                            System.out.println("1 - SIM");
                            System.out.println("2 - NÃO");
                            String escolhaCerteza = "0";
                            escolhaCerteza = input.nextLine();

                            if (escolhaCerteza.equals("1")) {
                                produtos.remove(getCodigoConsulta());
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
                    System.out.println("NAO HA UM PRODUTO COM ESTE CODIGO");
                    System.out.println("TENTE NOVAMENTE.");
                    esperar();
                }
            }
        } while (!escolhaMenu.equals("4"));
    }

    public void alterar() {
        do {
            Interface.limpatela();
            System.out.println("-----ALTERAR-----");
            System.out.println("| 1 - NOME      |");
            System.out.println("| 2 - CODIGO    |");
            System.out.println("| 3 - TELEFONE  |");
            System.out.println("| 4 - SAIR      |");
            System.out.println("-----------------");

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
                    System.out.println("NAO E POSSIVEL MUDAR O CODIGO");
                    System.out.println("EXCLUA ESSE PRODUTO E CADASTRE OUTRO.");
                    esperar();
                    break;
                case "3":
                    System.out.println("PRECO ATUAL: R$ " + this.getPreco());
                    System.out.println("DIGITE O NOVO PRECO: ");
                    System.out.println("PRECO ALTERADO COM SUCESSO!");
                    this.setPreco(Float.parseFloat(input.nextLine()));
                    esperar();
                    break;
                case "4":
                    System.out.println("SAINDO...");
                    break;
            }
        } while (!escolhaMenu.equals("4"));
    }

    // METODOS ESPECIAIS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public String getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(String codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }
}
