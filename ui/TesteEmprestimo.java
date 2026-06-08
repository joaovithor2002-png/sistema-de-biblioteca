package ui;

import dao.EmprestimoDAO;
import model.Emprestimo;

import java.time.LocalDate;

public class TesteEmprestimo {

    public static void main(String[] args) {

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setIdUsuario(1);
        emprestimo.setIdLivro(1);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setStatus("EMPRESTADO");

        EmprestimoDAO dao = new EmprestimoDAO();
        dao.inserir(emprestimo);
    }
}