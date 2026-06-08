package dao;

import connection.ConnectionFactory;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void inserir(Livro livro) {
        String sql = "INSERT INTO livro(titulo, isbn, ano_publicacao, id_categoria) VALUES (?, ?, ?, ?)";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.setInt(4, 1);

            stmt.executeUpdate();

            System.out.println("Livro cadastrado!");

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }

    public List<Livro> listar() {
        List<Livro> livros = new ArrayList<>();

        String sql = "SELECT * FROM livro";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();

                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setAnoPublicacao(rs.getInt("ano_publicacao"));

                livros.add(livro);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }

        return livros;
    }

    public void atualizar(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, isbn = ?, ano_publicacao = ? WHERE id_livro = ?";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.setInt(4, livro.getIdLivro());

            stmt.executeUpdate();

            System.out.println("Livro atualizado!");

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    public void excluir(int idLivro) {
        String sql = "DELETE FROM livro WHERE id_livro = ?";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idLivro);

            stmt.executeUpdate();

            System.out.println("Livro excluído!");

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro ao excluir livro: " + e.getMessage());
        }
    }
}