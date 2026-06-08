package dao;

import connection.ConnectionFactory;
import model.Emprestimo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class EmprestimoDAO {

    public void inserir(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimo(id_usuario, id_livro, data_emprestimo, status) VALUES (?, ?, ?, ?)";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, emprestimo.getIdUsuario());
            stmt.setInt(2, emprestimo.getIdLivro());
            stmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setString(4, emprestimo.getStatus());

            stmt.executeUpdate();

            System.out.println("Empréstimo cadastrado!");

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar empréstimo: " + e.getMessage());
        }
    }

    public void devolver(int idEmprestimo) {
        String sql = "UPDATE emprestimo SET data_devolucao = CURDATE(), status = 'DEVOLVIDO' WHERE id_emprestimo = ?";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idEmprestimo);

            stmt.executeUpdate();

            System.out.println("Livro devolvido!");

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao devolver livro: " + e.getMessage());
        }
    }
}