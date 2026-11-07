package com.projetoestoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProdutoDAO {
    public void cadastrarProduto(String nome,double preco,int quantidade) {
        if (nome == null || nome.isBlank()
                || !Double.isFinite(preco)
                || preco < 0 || quantidade < 0) {
            System.out.println("Dados do produto inválidos!");
            return;
        }
        String sql = "INSERT INTO produtos "
                + "(nome, preco, quantidade) "
                + "VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();
            System.out.println(
                "Produto cadastrado com sucesso!"
            );
        } catch (SQLException e) {
            System.out.println(
                "Erro ao cadastrar: " + e.getMessage()
            );
        }
    }
    public void listarProdutos() {
        String sql = "SELECT * FROM produtos ORDER BY id";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("=== LISTA DE PRODUTOS ===");
            boolean encontrou = false;
            while (rs.next()) {
                encontrou = true;
                System.out.println("-------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Preço: R$ " + rs.getDouble("preco"));
                System.out.println("Quantidade: "
                        + rs.getInt("quantidade"));
            }
            if (!encontrou) {
                System.out.println("Nenhum produto cadastrado.");
            }
        } catch (SQLException e) {
            System.out.println(
                "Erro ao consultar: " + e.getMessage()
            );
        }
    }
public static boolean movimentarEstoque(
        int id, int quantidade, boolean entrada) {
    if (id <= 0 || quantidade <= 0) {
        return false;
    }
    String sqlAtualizar;
    if (entrada) {
        sqlAtualizar =
            "UPDATE produtos SET quantidade = quantidade + ? WHERE id = ?";
    } else {
        sqlAtualizar =
            "UPDATE produtos SET quantidade = quantidade - ? " +
            "WHERE id = ? AND quantidade >= ?";
    }
    String sqlHistorico =
        "INSERT INTO movimentacao " +
        "(id_produto, tipo, quantidade, data_movimentacao) " +
        "VALUES (?, ?, ?, datetime('now', 'localtime'))";
    try (java.sql.Connection conn = Conexao.conectar()) {
        conn.setAutoCommit(false);
        try {
            int linhas;
            try (java.sql.PreparedStatement stmt =
                    conn.prepareStatement(sqlAtualizar)) {
                stmt.setInt(1, quantidade);
                stmt.setInt(2, id);
                if (!entrada) {
                    stmt.setInt(3, quantidade);
                }
                linhas = stmt.executeUpdate();
            }
            if (linhas == 0) {
                conn.rollback();
                return false;
            }
            try (java.sql.PreparedStatement stmt =
                    conn.prepareStatement(sqlHistorico)) {
                stmt.setInt(1, id);
                stmt.setString(2, entrada ? "ENTRADA" : "SAIDA");
                stmt.setInt(3, quantidade);
                stmt.executeUpdate();
            }
            conn.commit();
            return true;
        } catch (java.sql.SQLException e) {
            conn.rollback();
            throw e;
        }
    } catch (java.sql.SQLException e) {
        System.out.println(
            "Erro na movimentação: " + e.getMessage()
        );
        return false;
    }
}
}
