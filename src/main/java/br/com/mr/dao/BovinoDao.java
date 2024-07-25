package br.com.mr.dao;

import br.com.mr.agenda.Bovino;
import br.com.mr.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BovinoDao {
    //CRUD

    public void save(Bovino bovino) {

        String sql = "INSERT INTO bovinos(codigo_registro, raca, sexo, peso, data_nascimento) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Cria conexao com o DB
            conn = ConnectionFactory.createConnctionToMySQL();

            // cria-se uma PreparedStatement para executar um query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            // add os valores que sao esperados pelas query

            pstm.setString(1, bovino.getCodigoRegistro());
            pstm.setString(2, bovino.getRaca());
            pstm.setString(3, bovino.getSexo());
            pstm.setDouble(4, bovino.getPeso());
            pstm.setDate(5, new java.sql.Date(bovino.getDataNascimento().getTime()));

            // Executar
            pstm.execute();

            System.out.println("Salvo com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar as conexoes
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Bovino bovino){
        String sql = "UPDATE bovinos SET codigo_registro = ?, raca = ?, sexo = ?, peso = ?, data_nascimento = ? " +
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            // Criar conexao
            conn = ConnectionFactory.createConnctionToMySQL();

            //Criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            // Add valores para atualizar
            pstm.setString(1, bovino.getCodigoRegistro());
            pstm.setString(2, bovino.getRaca());
            pstm.setString(3, bovino.getSexo());
            pstm.setDouble(4, bovino.getPeso());
            pstm.setDate(5, new java.sql.Date(bovino.getDataNascimento().getTime()));
            pstm.setInt(6, bovino.getId());

            // Executar a query
            pstm.execute();
            System.out.println("Atualizado com sucesso!");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm!= null){
                    pstm.close();
                }
                if (conn!= null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void deleteById(String codigo){
        String sql = "DELETE FROM bovinos WHERE codigo_registro = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnctionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, codigo);

            pstm.execute();

            System.out.println("Deletado com sucesso!");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Bovino> getBovinos() {
        String sql = "SELECT * FROM bovinos";

        List<Bovino> bovinos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        // Classe que vai recuperar os dados do DB
        ResultSet rset = null;

        try {
            // Cria conexao com o DB
            conn = ConnectionFactory.createConnctionToMySQL();

            // cria-se uma PreparedStatement para executar um query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {

                Bovino bovino = new Bovino();

                // Recuperar dados: id, nome, idade...
                bovino.setId(rset.getInt("id"));
                bovino.setCodigoRegistro(rset.getString("codigo_registro"));
                bovino.setRaca(rset.getString("raca"));
                bovino.setSexo(rset.getString("sexo"));
                bovino.setPeso(rset.getDouble("peso"));
                bovino.setDataNascimento(rset.getDate("data_nascimento"));

                bovinos.add(bovino);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return bovinos;
    }

}
