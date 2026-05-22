import java.util.ArrayList;

public class Usuario {

    private String name;
    private String cpf;
    private int idade;

    private ArrayList<Conta> contas = new ArrayList<>(); // cria lista de CONTAS

    public Usuario(String name, String cpf, int idade) {
        this.name = name;
        this.cpf = cpf;   // Metodo construtor
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isMaior() {
        return idade >= 18;  // validação de maioridade
    }

    public void adicionarConta(Conta c) {
        contas.add(c);  // adicionar a Conta
    }

    public ArrayList<Conta> getContas() {
        return contas;  // retorna as Contas
    }

    public Conta buscarConta(int numero) {
        for (Conta c : contas) {              // a busca acontece por meio do numero aleatorio gerado, entao com a Busca de todas as contas, se get.NumConta for
            if (c.getNumConta() == numero) {  // for igual a numero ( variavel que insiro o numero aleatorio, irá retornar a conta especifica.
                return c;
            }
        }
        return null;
    }

    public String descricao() {
        for (Conta c : contas) {
            return name + " | CPF: " + cpf + " | Número Conta: " + c.getNumConta();
        }
        return null;
    }
}