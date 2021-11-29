/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;


import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO(){
        
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    //Metodo cadastrarCliente
    //recebera o objeto cliente da classe do model
    public void cadastrarCliente(Clientes obj){
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
            
            JOptionPane.showMessageDialog(null, "Erro: "+ erro);
            
        }
        
    }
    
    //metodo alterar cliente
    public void alterarCliente(){
        
    }
    
    //Metodo Excluir Cliente
    public void excluiCliente(){
    
    
    }
}