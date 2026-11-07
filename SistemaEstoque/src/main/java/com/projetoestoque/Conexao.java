package com.projetoestoque;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Conexao {
    private static final String URL = "jdbc:sqlite:estoque.db";
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }     
public static void criarTabela() {
    String sqlCategoria = """
        CREATE TABLE IF NOT EXISTS categoria (
            id_categoria INTEGER PRIMARY KEY AUTOINCREMENT,
            nome TEXT NOT NULL
        )
        """;
    String sqlProdutos = """
        CREATE TABLE IF NOT EXISTS produtos (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nome TEXT NOT NULL,
            preco REAL NOT NULL,
            quantidade INTEGER NOT NULL
        )
        """;
    String sqlMovimentacao = """
        CREATE TABLE IF NOT EXISTS movimentacao (
            id_movimentacao INTEGER PRIMARY KEY AUTOINCREMENT,
            id_produto INTEGER NOT NULL,
            tipo TEXT NOT NULL,
            quantidade INTEGER NOT NULL,
            data_movimentacao TEXT NOT NULL,
            FOREIGN KEY (id_produto) REFERENCES produtos(id)
        )
        """;
    try (Connection conn = conectar();
         Statement stmt = conn.createStatement()) {
        stmt.execute(sqlCategoria);
        stmt.execute(sqlProdutos);
        stmt.execute(sqlMovimentacao);
try {
    stmt.execute(
        "ALTER TABLE produtos ADD COLUMN id_categoria INTEGER REFERENCES categoria(id_categoria)"
    );
    System.out.println("Coluna de categoria adicionada!");
} catch (SQLException e) {
    if (!e.getMessage().contains("duplicate column name")) {
        System.out.println(
            "Erro ao adicionar categoria: " + e.getMessage()
        );
    }
}
        System.out.println(
            "Tabelas verificadas com sucesso!"
        );
    } catch (SQLException e) {
        System.out.println(
            "Erro ao criar tabelas: " + e.getMessage()
        );
    }
}
}
