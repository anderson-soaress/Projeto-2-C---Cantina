import java.util.Scanner;

public class Funcionario extends Pessoa{

    // ATRIBUTOS

    private String especialidade;

    // METODOS

    public void mostrarFuncionario(){
        if (this.isCadastrado()) {
            System.out.println("-----------------------------------------");
            System.out.println("    Dados do funcionario    ");
            System.out.println("Funcionario: " + getNome());
            System.out.println(getEspecialidade());
            System.out.println("CPF: " + getCpf());
            System.out.println("Telefone: " + getTelefone());
        } else {
            System.out.println("Não há dados desse funcionario.");
        }

    }

    public void cadastrarFuncionario(){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("Digite o nome do funcionario: ");
        this.setNome(input.nextLine());

        System.out.println("Digite a função do funcionario: ");
        this.setEspecialidade(input.nextLine());

        System.out.println("Digite o CPF do funcionario: ");
        this.setCpf(input.nextInt());

        System.out.println("Digite o número do funcionario: ");
        this.setTelefone(input.nextInt());

        this.setCadastrado(true);
    }

    // METODOS ESPECIAIS

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
