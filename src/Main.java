import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int op; // variavel reservada para controlar as opções

        do {
            System.out.println("--- BANCO POO JAVA ---");
            System.out.println("1- Criar usuario");
            System.out.println("2- Listar usuarios");
            System.out.println("3- Abrir conta");
            System.out.println("4- Depositar");
            System.out.println("5- Sacar");
            System.out.println("6- Transferir");
            System.out.println("0- Sair");

            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {

                System.out.print("Nome: ");
                String n = sc.nextLine();

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                System.out.print("Idade: ");
                int i = sc.nextInt();
                sc.nextLine();

                System.out.println(bank.adicionarUsuario(n, cpf, i)); //variaveis declaradas e colocada nos parametros do metodo adicionar usuario;
            }

            if (op == 2) {

                for (Usuario u : bank.listarUsuarios()) {
                    System.out.println(u.descricao());  // o for each passa pela lista de usuarios e retorna o metodo descrição de cada usuario
                }
            }

            if (op == 3) {

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                Usuario u = bank.buscarPorCPF(cpf); // digita o CPF e utiliza o metodo buscarCpf

                if (u == null) {
                    System.out.println("Usuario nao encontrado");
                    continue;  // caso o CPF de u nao exista, retorne usuario nao encontrado
                }

                if (!u.isMaior()) {
                    System.out.println("Menor nao pode abrir conta");
                    continue;  // caso a idade definida pelo usuario for menor de idade, retorne menor de idade
                }
                //  caso seja falso, o objeto Conta sera instanciado
                System.out.println("1- Conta Corrente / 2- Conta Poupança");
                int contaEsc = sc.nextInt();
                if (contaEsc == 1) {
                    Conta c = new ContaCorrente();
                    c.abrirConta();
                    u.adicionarConta(c);
                    System.out.println("Conta Corrente aberta: " + c.getNumConta());
                }
                else if (contaEsc == 2) {
                    Conta c = new ContaPoupanca();
                    c.abrirConta();
                    u.adicionarConta(c);
                    System.out.println("Conta Poupança aberta: " + c.getNumConta());
                }
            }

            if (op == 4 || op == 5) {

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                Usuario u = bank.buscarPorCPF(cpf);

                if (u == null) {
                    System.out.println("Usuario nao encontrado");
                    continue;
                }

                System.out.print("Numero conta de " + u.getName() + ": ");
                int num = sc.nextInt();
                sc.nextLine();

                Conta c = u.buscarConta(num);

                if (c == null) {
                    System.out.println("Conta nao encontrada");
                    continue;
                }

                if (op == 4) {
                    System.out.print("R$:");
                    System.out.println(c.depositar(sc.nextDouble()));
                } else {
                    System.out.print("R$: ");
                    System.out.println(c.sacar(sc.nextDouble()));
                }

                sc.nextLine();
            }

            if (op == 6) {

                System.out.print("CPF origem: ");
                Usuario u1 = bank.buscarPorCPF(sc.nextLine());
                System.out.println(u1.descricao());

                System.out.print("CPF destino: ");
                Usuario u2 = bank.buscarPorCPF(sc.nextLine());
                System.out.println(u2.descricao());

                if (u1 == null || u2 == null) {
                    System.out.println("Usuario de origem ou destino nao encontrado");
                    continue; // caso u1 ou u2 esteja vazio, retorna Usuario nao encontrado
                }

                System.out.print("Conta origem: ");
                int c1n = sc.nextInt();
                sc.nextLine();

                System.out.print("Conta destino: ");
                int c2n = sc.nextInt();
                sc.nextLine();

                Conta c1 = u1.buscarConta(c1n);
                Conta c2 = u2.buscarConta(c2n);

                if (c1 == null || c2 == null) {
                    System.out.println("Conta invalida");
                    continue;
                }

                System.out.print("R$: ");
                double v = sc.nextDouble();
                sc.nextLine();

                System.out.println(c1.transferir(c2, v));
                System.out.println("Saldo  Atual de " + u1.getName() + ": R$ " + c1.getSaldo());
                System.out.println("Saldo Atual de " + u2.getName() + ": R$ " + c2.getSaldo());
            }

        } while (op != 0);

        sc.close();
    }
}