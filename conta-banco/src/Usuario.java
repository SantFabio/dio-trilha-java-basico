public class Usuario {
    private int numero = 1021;
    private String agencia = "067-8";
    private String nome;
    private double saldo;

    public Usuario(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public Usuario() {
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
