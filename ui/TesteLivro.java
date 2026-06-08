package ui;

import dao.LivroDAO;
import model.Livro;

public class TesteLivro {
    public static void main(String[] args) {
        Livro livro = new Livro();

        livro.setTitulo("Dom Casmurro");
        livro.setIsbn("9788535910663");
        livro.setAnoPublicacao(1899);

        LivroDAO dao = new LivroDAO();
        dao.inserir(livro);
    }
}