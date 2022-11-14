package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.ModelClient;
import connection.ConnectionFactory;

public class ModelClientDAO {

    public String insert = "INSERT INTO \"Client\" (\"clie_name\", \"clie_cpf\", \"clie_email\",\"clie_phoneNumber\", \"clie_state\", \"clie_city\", \"clie_streetName\", \"clie_number\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public String update = "UPDATE \"Client\" SET \"clie_name\" = ?, \"clie_cpf\" = ?, \"clie_email\" = ?,\"clie_phoneNumber\" = ?, \"clie_state\" = ?, \"clie_city\" = ?, \"clie_streetName\" = ?, \"clie_number\" = ? WHERE \"clie_id\" = ?";
    public String select = "SELECT * FROM \"Client\" ORDER BY \"clie_id\"";
    public String selectId = "SELECT * FROM \"Client\" WHERE \"clie_id\" = ?";
    public String selectName = "SELECT * FROM \"Client\" WHERE \"clie_name\" ILIKE ?";
    public String delete = "DELETE FROM \"Client\" WHERE \"clie_id\" = ?";
    
    public void Create(ModelClient model) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        
        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;
        
        try {
            stmt = con.prepareStatement(insert, resultType, resultConcurrence);
            
            stmt.setString(1, model.getName());
            stmt.setString(2, model.getCpf());
            stmt.setString(3, model.getEmail());
            stmt.setString(4, model.getPhoneNumber());
            stmt.setString(5, model.getAdress().getState());
            stmt.setString(6, model.getAdress().getCity());
            stmt.setString(7, model.getAdress().getStreetName());
            stmt.setInt(8, model.getAdress().getNumber());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(ModelClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void Update(ModelClient model) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;
        
        try {
            stmt = con.prepareStatement(update, resultType, resultConcurrence);
            
            stmt.setString(1, model.getName());
            stmt.setString(2, model.getCpf());
            stmt.setString(3, model.getEmail());
            stmt.setString(4, model.getPhoneNumber());
            stmt.setString(5, model.getAdress().getState());
            stmt.setString(6, model.getAdress().getCity());
            stmt.setString(7, model.getAdress().getStreetName());
            stmt.setInt(8, model.getAdress().getNumber());
            stmt.setInt(9, model.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            Logger.getLogger(ModelClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(ModelClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<ModelClient> read() {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelClient> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;
        
        try {
            stmt = con.prepareStatement(select, resultType, resultConcurrence);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                ModelClient model = new ModelClient();

                model.setId(rs.getInt("clie_id"));
                model.setName(rs.getString("clie_name"));
                model.setCpf(rs.getString("clie_cpf"));
                model.setEmail(rs.getString("clie_email"));
                model.setPhoneNumber(rs.getString("clie_phoneNumber"));
                model.getAdress().setState(rs.getString("clie_state"));
                model.getAdress().setCity(rs.getString("clie_city"));
                model.getAdress().setStreetName(rs.getString("clie_streetName"));
                model.getAdress().setNumber(rs.getInt("clie_number"));

                list.add(model);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public List<ModelClient> readID(int id) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelClient> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;
        
        try {
            stmt = con.prepareStatement(selectId, resultType, resultConcurrence);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelClient model = new ModelClient();

                model.setId(rs.getInt("clie_id"));
                model.setName(rs.getString("clie_name"));
                model.setCpf(rs.getString("clie_cpf"));
                model.setEmail(rs.getString("clie_email"));
                model.setPhoneNumber(rs.getString("clie_phoneNumber"));
                model.getAdress().setState(rs.getString("clie_state"));
                model.getAdress().setCity(rs.getString("clie_city"));
                model.getAdress().setStreetName(rs.getString("clie_streetName"));
                model.getAdress().setNumber(rs.getInt("clie_number"));

                list.add(model);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public List<ModelClient> readName(String name) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelClient> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;
        
        String queryLike = "%" + name + "%"; 
        
        try {
            stmt = con.prepareStatement(selectName, resultType, resultConcurrence);
            stmt.setString(1, queryLike);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelClient model = new ModelClient();

                model.setId(rs.getInt("clie_id"));
                model.setName(rs.getString("clie_name"));
                model.setCpf(rs.getString("clie_cpf"));
                model.setEmail(rs.getString("clie_email"));
                model.setPhoneNumber(rs.getString("clie_phoneNumber"));
                model.getAdress().setState(rs.getString("clie_state"));
                model.getAdress().setCity(rs.getString("clie_city"));
                model.getAdress().setStreetName(rs.getString("clie_streetName"));
                model.getAdress().setNumber(rs.getInt("clie_number"));

                list.add(model);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public void delete(ModelClient model) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;
        
        try {
            stmt = con.prepareStatement(delete, resultType, resultConcurrence);
            stmt.setInt(1, model.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
            Logger.getLogger(ModelClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
