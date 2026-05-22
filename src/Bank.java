import java.util.ArrayList;

public class Bank implements BankInterface {

    private ArrayList<Usuario> users = new ArrayList<>(); // lista de usuarios

    public String adicionarUsuario(String n, String cpf, int i) {

        for (Usuario u : users) {
            if (u.getCpf().equals(cpf)) {   // acessa o Array e se existir CPF, retorna CPF já cadastrado
                return "CPF ja cadastrado";
            }
        }

        users.add(new Usuario(n, cpf, i)); // caso contrário, adicione o usuario na lista
        return "Usuario criado";
    }

    public Usuario buscarPorCPF(String cpf) {

        for (Usuario u : users) {          // se existir o CPF dentro da lista de usuarios, retorne o usuario citado
            if (u.getCpf().equals(cpf)) {
                return u;
            }
        }

        return null;  // caso contrário, retorne nada.
    }

    public ArrayList<Usuario> listarUsuarios() {
        return users;  // retorne a lista de usuarios completa
    }
}