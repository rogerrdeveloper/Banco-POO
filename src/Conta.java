import java.util.Random;

public abstract class Conta {

    private int numConta;
    private double saldo;
    private boolean status;

    public Conta() {
        this.numConta = new Random().nextInt(90000) + 10000;
        this.status = false;        // status inicial da conta: ja cria um numero aleatorio para cada conta
        this.saldo = 0;
    }

    public int getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void abrirConta() {
        this.status = true;
    }

    public String depositar(double v) {
        if (!status) return "Conta fechada";  // se status for diferente de verdadeiro retorne conta fechada
        if (v <= 0) return "Valor invalido";

        saldo += v;
        return "Deposito realizado";
    }

    public String sacar(double v) {
        if (!status) return "Conta fechada";  // se status for diferente de verdadeiro retorne conta fechada
        if (v > saldo) return "Saldo insuficiente";

        saldo -= v;
        return "Saque realizado";
    }

    public String transferir(Conta destino, double v) {

        if (!status || !destino.status) return "Conta fechada";  // se status for diferente de verdadeiro retorne conta fechada
        if (v > saldo) return "Saldo insuficiente";              // ou destino.status for diferente de verdadeiro, retorne conta fechada
        // se V for maior que saldo, retorne saldo insuficiente
        saldo -= v; // caso tudo isso seja falso, saldo recebe saldo - v;
        destino.saldo += v;  // e saldo do destinario vai receber o valor transferido

        return "Transferencia realizada";
    }
}