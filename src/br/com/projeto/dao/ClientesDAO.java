/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.view.Frmclientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {

        this.con = new ConnectionFactory().getConnection();

    }

    //Metodo cadastrarCliente
    //recebera o objeto cliente da classe do model
    public void cadastrarCliente(Clientes obj) {
        try {
            //1 passo criar o comando sql
            String sql = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            //3 passo - executar comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //metodo alterar cliente
    public void alterarCliente(Clientes obj) {

        try {
            //1 passo criar o comando sql
            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,"
                    + "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            stmt.setInt(14, obj.getId());

            //3 passo - executar comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo Excluir Cliente
    public void excluirCliente(Clientes obj) {
        //excluir cliente
        try {
            //1 passo criar o comando sql
            String sql = "delete from tb_clientes where id = ?";
            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            //3 passo - executar comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }
//Metodo Listar Cliente

    public List<Clientes> listarClientes() {

        try {

            //1 PAsso criar a lista
            List<Clientes> lista = new ArrayList<>();

            //2 passo - criar, organizar e executar o comando sql
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setBairro(rs.getString("bairro"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

            return null;
        }

    }

    public List<Clientes> buscarCliente(String nome, int opcao) {
//Nome Rg, cpf, email,telefone,celular, cep, endereco, numero, complemento, vairro, cidade, estado / UF
        try {
            //1 PAsso criar a lista
            List<Clientes> lista = new ArrayList<>();
            String tipo = "";

            switch (opcao) {
                case 0:
                    return null;
                case 1:
                    tipo = "nome";
                    break;
                case 2:
                    tipo = "codigo";
                    break;
                case 3:
                    tipo = "rg";
                    break;
                case 4:
                    tipo = "cpf";
                    break;
                case 5:
                    tipo = "email";
                    break;
                case 6:
                    tipo = "telefone";
                    break;
                case 7:
                    tipo = "celular";
                    break;
                case 8:
                    tipo = "cep";
                    break;
                case 9:
                    tipo = "endereco";
                    break;
                case 10:
                    tipo = "numero";
                    break;
                case 11:
                    tipo = "complemento";
                    break;
                case 12:
                    tipo = "bairro";
                    break;
                case 13:
                    tipo = "cidade";
                    break;
                case 14:
                    tipo = "estado";
                    break;
                default:
                    break;
            }

            System.out.println("tipo = " + tipo);
            System.out.println("streing" + nome);
            //2 passo - criar, organizar e executar o comando sql
            String sql = "select * from tb_clientes where " + tipo + " like ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(
                    1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setBairro(rs.getString("bairro"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

            return null;
        }

    }

}
