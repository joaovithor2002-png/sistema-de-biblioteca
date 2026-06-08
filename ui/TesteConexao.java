package ui;

import connection.ConnectionFactory;
import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        try {

            Connection con =
                    ConnectionFactory.getConnection();

            System.out.println("Conectado com sucesso!");

            con.close();

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }
    }
}