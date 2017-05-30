/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.natansevero.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.natansevero.entidade.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class ProdutoDaoJDBC {
    private final Connection conn;
    
    public ProdutoDaoJDBC() throws ClassNotFoundException, SQLException {
        this.conn = ConnFactory.getConnection();
    }
    
    public List<Produto> listar() {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("select * from produto");
            ResultSet rs = stmt.executeQuery();
            
            List<Produto> produtos = new ArrayList<>();
            
            while(rs.next()) {
                produtos.add(new Produto(rs.getString("nome"), rs.getDouble("preco"), rs.getString("tipo")));
            }
            
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Collections.EMPTY_LIST;
    }
}
