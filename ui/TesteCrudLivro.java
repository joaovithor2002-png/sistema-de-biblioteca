package ui;

import dao.LivroDAO;

public class TesteCrudLivro {

    public static void main(String[] args) {

        LivroDAO dao = new LivroDAO();

        dao.excluir(3);

    }
}