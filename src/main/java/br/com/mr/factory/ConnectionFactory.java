package br.com.mr.factory;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    //Dados de usuario
    private static final String USERNAME = "xxxxxxxxxx";

    private static final String PASSWORD = "xxxxxxxxxx";

    // caminho, porta e nome do DB
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cadastro_bovino";

    // conexao com o DB
    public static Connection createConnctionToMySQL() throws Exception {
        // Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Cria a conexao com o DB
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        // Recupera conexão com o DB
        Connection con = createConnctionToMySQL();

        // Testar se a conexao é nula para garantir que não haja muitas conexões
        if (con!=null){
            System.out.println("Conexão obtida com sucesso! ");
            con.close();
        }
    }
}
