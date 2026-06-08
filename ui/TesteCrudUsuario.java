package ui;

import dao.UsuarioDAO;
import model.Usuario;

public class TesteCrudUsuario {

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario = new Usuario();

        usuario.setNome("Maria Silva");
        usuario.setEmail("maria@email.com");
        usuario.setTelefone("61999999999");

        dao.inserir(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }
}