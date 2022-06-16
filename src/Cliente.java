public class Cliente {
    private int cpf;
    private String nome;
    private String fone;
    private String pedido;
    private int cod;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String cc(){
        System.out.println("NOME CLIENTE: ");

        return nome;
    }
    public String pp(){
        System.out.println("PEDIDO: ");

        return pedido;
    }

    public int codig(){
        System.out.println("CODIGO DO PEDIDO: ");
        return cod;
    }

}
