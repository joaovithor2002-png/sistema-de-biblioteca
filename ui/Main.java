package ui;

import dao.EmprestimoDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        JFrame janela = new JFrame("Sistema de Biblioteca");
        janela.setSize(600, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Sistema de Biblioteca", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(0, 2, 10, 10));

        JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
        JButton btnListarLivros = new JButton("Listar Livros");
        JButton btnEditarLivro = new JButton("Editar Livro");
        JButton btnExcluirLivro = new JButton("Excluir Livro");

        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        JButton btnListarUsuarios = new JButton("Listar Usuários");
        JButton btnEditarUsuario = new JButton("Editar Usuário");
        JButton btnExcluirUsuario = new JButton("Excluir Usuário");

        JButton btnEmprestimo = new JButton("Registrar Empréstimo");

        painelBotoes.add(btnCadastrarLivro);
        painelBotoes.add(btnListarLivros);

        painelBotoes.add(btnEditarLivro);
        painelBotoes.add(btnExcluirLivro);

        painelBotoes.add(btnCadastrarUsuario);
        painelBotoes.add(btnListarUsuarios);

        painelBotoes.add(btnEditarUsuario);
        painelBotoes.add(btnExcluirUsuario);

        painelBotoes.add(btnEmprestimo);

        painelPrincipal.add(titulo, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        janela.add(painelPrincipal);
        janela.setVisible(true);

        // CADASTRAR LIVRO
        btnCadastrarLivro.addActionListener(e -> {

            Livro livro = new Livro();

            livro.setTitulo(
                    JOptionPane.showInputDialog("Título:")
            );

            livro.setIsbn(
                    JOptionPane.showInputDialog("ISBN:")
            );

            livro.setAnoPublicacao(
                    Integer.parseInt(
                            JOptionPane.showInputDialog("Ano:")
                    )
            );

            new LivroDAO().inserir(livro);

            JOptionPane.showMessageDialog(
                    null,
                    "Livro cadastrado com sucesso!"
            );
        });

        // LISTAR LIVROS
        btnListarLivros.addActionListener(e -> {

            StringBuilder texto = new StringBuilder();

            for (Livro l : new LivroDAO().listar()) {

                texto.append(
                        l.getIdLivro()
                                + " - "
                                + l.getTitulo()
                                + " - "
                                + l.getIsbn()
                                + " - "
                                + l.getAnoPublicacao()
                                + "\n"
                );
            }

            JOptionPane.showMessageDialog(
                    null,
                    texto.toString()
            );
        });

        // EDITAR LIVRO
        btnEditarLivro.addActionListener(e -> {

            Livro livro = new Livro();

            livro.setIdLivro(
                    Integer.parseInt(
                            JOptionPane.showInputDialog("ID do livro:")
                    )
            );

            livro.setTitulo(
                    JOptionPane.showInputDialog("Novo título:")
            );

            livro.setIsbn(
                    JOptionPane.showInputDialog("Novo ISBN:")
            );

            livro.setAnoPublicacao(
                    Integer.parseInt(
                            JOptionPane.showInputDialog("Novo ano:")
                    )
            );

            new LivroDAO().atualizar(livro);

            JOptionPane.showMessageDialog(
                    null,
                    "Livro atualizado!"
            );
        });

        // EXCLUIR LIVRO
        btnExcluirLivro.addActionListener(e -> {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "ID do livro para excluir:"
                    )
            );

            new LivroDAO().excluir(id);

            JOptionPane.showMessageDialog(
                    null,
                    "Livro excluído!"
            );
        });

        // CADASTRAR USUÁRIO
        btnCadastrarUsuario.addActionListener(e -> {

            Usuario usuario = new Usuario();

            usuario.setNome(
                    JOptionPane.showInputDialog("Nome:")
            );

            usuario.setEmail(
                    JOptionPane.showInputDialog("Email:")
            );

            usuario.setTelefone(
                    JOptionPane.showInputDialog("Telefone:")
            );

            new UsuarioDAO().inserir(usuario);

            JOptionPane.showMessageDialog(
                    null,
                    "Usuário cadastrado!"
            );
        });

        // LISTAR USUÁRIOS
        btnListarUsuarios.addActionListener(e -> {

            StringBuilder texto = new StringBuilder();

            for (Usuario u : new UsuarioDAO().listar()) {

                texto.append(
                        u.getIdUsuario()
                                + " - "
                                + u.getNome()
                                + " - "
                                + u.getEmail()
                                + " - "
                                + u.getTelefone()
                                + "\n"
                );
            }

            JOptionPane.showMessageDialog(
                    null,
                    texto.toString()
            );
        });

        // EDITAR USUÁRIO
        btnEditarUsuario.addActionListener(e -> {

            Usuario usuario = new Usuario();

            usuario.setIdUsuario(
                    Integer.parseInt(
                            JOptionPane.showInputDialog("ID do usuário:")
                    )
            );

            usuario.setNome(
                    JOptionPane.showInputDialog("Novo nome:")
            );

            usuario.setEmail(
                    JOptionPane.showInputDialog("Novo email:")
            );

            usuario.setTelefone(
                    JOptionPane.showInputDialog("Novo telefone:")
            );

            new UsuarioDAO().atualizar(usuario);

            JOptionPane.showMessageDialog(
                    null,
                    "Usuário atualizado!"
            );
        });

        // EXCLUIR USUÁRIO
        btnExcluirUsuario.addActionListener(e -> {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "ID do usuário para excluir:"
                    )
            );

            new UsuarioDAO().excluir(id);

            JOptionPane.showMessageDialog(
                    null,
                    "Usuário excluído!"
            );
        });

        // EMPRÉSTIMO
        btnEmprestimo.addActionListener(e -> {

            Emprestimo emprestimo = new Emprestimo();

            emprestimo.setIdUsuario(
                    Integer.parseInt(
                            JOptionPane.showInputDialog("ID do usuário:")
                    )
            );

            emprestimo.setIdLivro(
                    Integer.parseInt(
                            JOptionPane.showInputDialog("ID do livro:")
                    )
            );

            emprestimo.setDataEmprestimo(LocalDate.now());
            emprestimo.setStatus("EMPRESTADO");

            new EmprestimoDAO().inserir(emprestimo);

            JOptionPane.showMessageDialog(
                    null,
                    "Empréstimo registrado!"
            );
        });
    }
}