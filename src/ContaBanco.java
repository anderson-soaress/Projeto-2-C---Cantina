public class ContaBanco {

    // ATRIBUTOS

    private int numConta;
    private Cliente donoConta;
    private double saldoConta;
    private boolean status;

    // METODOS

    public void mostrarConta(){
        if (this.isStatus()){
            System.out.println("-----------------------------");
            System.out.println("    Dados da conta   ");
            System.out.println("Conta de " + this.donoConta.getNomeCliente());
            System.out.println("Saldo: " + getSaldoConta());
        }
    }
    public void cadastrarConta(Cliente cl){
        if (!this.isStatus()){
            this.setStatus(true);
            this.setDonoConta(cl);
            System.out.println("Conta de " + this.donoConta.getNomeCliente() + " cadastrada com sucesso.");
        } else {
            System.out.println(this.donoConta.getNomeCliente() + "já possui uma conta cadastrada.");
        }
    }

    public void depositar(float valor){
        if (this.isStatus()){
            this.setSaldoConta(this.getSaldoConta() + valor);
            System.out.println("Deposito realizado com sucesso na conta de " + this.donoConta.getNomeCliente());
        }else {
            System.out.println(this.donoConta.getNomeCliente() + " não possui uma conta cadastrada.");
        }
    }

    public void pagar(float preco){
        if (this.isStatus()){
            if (getSaldoConta() >= preco){
                this.setSaldoConta(this.getSaldoConta() - preco);
                System.out.println("Pago com sucesso.");
                System.out.println("Saldo atual de " + this.donoConta.getNomeCliente() + ": "+ getSaldoConta());
            } else {
                System.out.println("Saldo de " + this.donoConta.getNomeCliente() + " insuficiente.");
            }
        } else{
            System.out.println(this.donoConta.getNomeCliente() + " não possui uma conta cadastrada.");
        }
    }

    // METODOS ESPECIAIS

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Cliente getDonoConta() {
        return donoConta;
    }

    public void setDonoConta(Cliente donoConta) {
        this.donoConta = donoConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
