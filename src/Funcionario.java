import java.util.HashMap;
import java.util.Scanner;

public class Funcionario extends Pessoa{

    // ATRIBUTOS

    private String especialidade;


    // OBJETOS

    Scanner input = new Scanner(System.in);
    public HashMap<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();

    // METODOS

    @Override
    public void coletar() {

        Interface.limpatela();
        System.out.println("-----------------------------------------");
        System.out.println("Digite o nome do funcionario: ");
        this.setNome(input.nextLine());

        System.out.println("Digite a função do funcionario: ");
        this.setEspecialidade(input.nextLine());

        System.out.println("Digite o CPF do funcionario: ");
        this.setCpf(input.nextLine());

        System.out.println("Digite o número do funcionario: ");
        this.setTelefone(input.nextInt());

        this.setCadastrado(true);
    }
    @Override
    public void dados() {
        if (this.isCadastrado()) {
            Interface.limpatela();
            System.out.println("-----------------------------------------");
            System.out.println("    Dados do funcionario    ");
            System.out.println("Funcionario: " + getNome());
            System.out.println(getEspecialidade());
            System.out.println("CPF: " + getCpf());
            System.out.println("Telefone: " + getTelefone());
            esperar();
        } else {
            System.out.println("Não há dados desse funcionario.");
            esperar();
        }
    }
    @Override
    public void cadastrar() {
        Funcionario funcionario = new Funcionario();
        funcionario.coletar();

        if (funcionarios.containsKey(getCpf())) {
            System.out.println("Este cpf já foi informado.");
            esperar();
        } else {
            funcionarios.put(funcionario.getCpf(), funcionario);
            System.out.println("Cadastrado com sucesso!");
            esperar();
        }
    }
    @Override
    public void manipular() {
        do {
            Interface.limpatela();
            System.out.println("------DADOS------");
            System.out.println("1 - MOSTRAR");
            System.out.println("2 - ALTERAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - SAIR");

            escolhaMenu = input.nextLine();

            if (!escolhaMenu.equals("4")) {
                System.out.println("--------------");
                System.out.println("DIGITE O CPF: ");
                this.setCpfConsulta(input.nextLine());

                if (funcionarios.get(getCpfConsulta()) != null) {
                    switch (escolhaMenu) {
                        case "1":
                            funcionarios.get(getCpfConsulta()).dados();
                            break;
                        case "2":
                            funcionarios.get(getCpfConsulta()).alterar();
                            break;
                        case "3":
                            Interface.limpatela();
                            System.out.println("VOCÊ TEM CERTEZA QUE QUER REMOVER CPF: " + this.getCpfConsulta() + "?");
                            System.out.println("1 - SIM");
                            System.out.println("2 - NÃO");
                            String escolhaCerteza = "0";
                            escolhaCerteza = input.nextLine();

                            if (escolhaCerteza.equals("1")) {
                                funcionarios.remove(getCpfConsulta());
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
                    this.setTelefone(input.nextInt());
                    System.out.println("TELEFONE ALTERADO COM SUCESSO!");
                    esperar();
                    break;
                case "4":
                    System.out.println("SAINDO...");
                    break;
            }
        } while (!escolhaMenu.equals("4"));
    }

    // METODOS ESPECIAIS

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
