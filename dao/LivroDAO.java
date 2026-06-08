package dao;

import connection.ConnectionFactory;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LivroDAO {

    public void inserir(Livro livro) {

        String sql =
        "INSERT INTO livro(titulo,isbn,ano_publicacao,id_categoria) VALUES(?,?,?,?)";

        try {

            Connection con =
                    ConnectionFactory.getConnection();

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getAnoPublicacao());

            // categoria padrão
            stmt.setInt(4, 1);

            stmt.executeUpdate();

            System.out.println("Livro cadastrado!");

            stmt.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}