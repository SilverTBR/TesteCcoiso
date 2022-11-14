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
import model.bean.ModelDistributor;
import connection.ConnectionFactory;

public class ModelDistributorDAO {

    public String insert = "INSERT INTO \"Distributor\" (\"dist_distributorName\", \"dist_distributorCNPJ\", \"dist_distributorMail\",\"dist_phoneNumber\", \"dist_loadType\", \"dist_splitMaxCapacity\", \"dist_unitMaxCapacity\", \"dist_state\", \"dist_city\", \"dist_streetName\", \"dist_number\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public String update = "UPDATE \"Distributor\" SET \"dist_distributorName\" = ?, \"dist_distributorCNPJ\" = ?, \"dist_distributorMail\" = ?,\"dist_phoneNumber\" = ?, \"dist_loadType\" = ?, \"dist_splitMaxCapacity\" = ?, \"dist_unitMaxCapacity\" = ?, \"dist_state\" = ?, \"dist_city\" = ?, \"dist_streetName\" = ?, \"dist_number\" = ? WHERE \"dist_id\" = ?";
    public String select = "SELECT * FROM \"Distributor\" ORDER BY \"dist_id\"";
    public String selectId = "SELECT * FROM \"Distributor\" WHERE \"dist_id\" = ?";
    public String selectName = "SELECT * FROM \"Distributor\" WHERE \"dist_distributorName\" ILIKE ?";
    public String delete = "DELETE FROM \"Distributor\" WHERE \"dist_id\" = ?";

    public void Create(ModelDistributor model) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        try {
            stmt = con.prepareStatement(insert, resultType, resultConcurrence);

            stmt.setString(1, model.getDistributorName());
            stmt.setString(2, model.getDistributorCNPJ());
            stmt.setString(3, model.getDistributosMail());
            stmt.setString(4, model.getPhoneNumber());
            stmt.setString(5, model.getLoadType());
            stmt.setString(6, model.getSplitMaxCapacity());
            stmt.setString(7, model.getUnitMaxCapacity());
            stmt.setString(8, model.getAdress().getState());
            stmt.setString(9, model.getAdress().getCity());
            stmt.setString(10, model.getAdress().getStreetName());
            stmt.setInt(11, model.getAdress().getNumber());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(ModelDistributorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void Update(ModelDistributor model) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        try {
            stmt = con.prepareStatement(update, resultType, resultConcurrence);

            stmt.setString(1, model.getDistributorName());
            stmt.setString(2, model.getDistributorCNPJ());
            stmt.setString(3, model.getDistributosMail());
            stmt.setString(4, model.getPhoneNumber());
            stmt.setString(5, model.getLoadType());
            stmt.setString(6, model.getSplitMaxCapacity());
            stmt.setString(7, model.getUnitMaxCapacity());
            stmt.setString(8, model.getAdress().getState());
            stmt.setString(9, model.getAdress().getCity());
            stmt.setString(10, model.getAdress().getStreetName());
            stmt.setInt(11, model.getAdress().getNumber());
            stmt.setInt(12, model.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            Logger.getLogger(ModelDistributorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(ModelDistributorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<ModelDistributor> read() {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelDistributor> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        try {
            stmt = con.prepareStatement(select, resultType, resultConcurrence);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelDistributor model = new ModelDistributor();

                model.setId(rs.getInt("dist_id"));
                model.setDistributorName(rs.getString("dist_distributorName"));
                model.setDistributorCNPJ(rs.getString("dist_distributorCNPJ"));
                model.setDistributosMail(rs.getString("dist_distributorMail"));
                model.setPhoneNumber(rs.getString("dist_phoneNumber"));
                model.setLoadType(rs.getString("dist_loadType"));
                model.setSplitMaxCapacity(rs.getString("dist_splitMaxCapacity"));
                model.setUnitMaxCapacity(rs.getString("dist_unitMaxCapacity"));
                model.getAdress().setState(rs.getString("dist_state"));
                model.getAdress().setCity(rs.getString("dist_city"));
                model.getAdress().setStreetName(rs.getString("dist_streetName"));
                model.getAdress().setNumber(rs.getInt("dist_number"));

                list.add(model);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelDistributorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public List<ModelDistributor> readID(int id) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelDistributor> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        try {
            stmt = con.prepareStatement(selectId, resultType, resultConcurrence);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelDistributor model = new ModelDistributor();

                model.setId(rs.getInt("dist_id"));
                model.setDistributorName(rs.getString("dist_distributorName"));
                model.setDistributorCNPJ(rs.getString("dist_distributorCNPJ"));
                model.setDistributosMail(rs.getString("dist_distributorMail"));
                model.setPhoneNumber(rs.getString("dist_phoneNumber"));
                model.setLoadType(rs.getString("dist_loadType"));
                model.setSplitMaxCapacity(rs.getString("dist_splitMaxCapacity"));
                model.setUnitMaxCapacity(rs.getString("dist_unitMaxCapacity"));
                model.getAdress().setState(rs.getString("dist_state"));
                model.getAdress().setCity(rs.getString("dist_city"));
                model.getAdress().setStreetName(rs.getString("dist_streetName"));
                model.getAdress().setNumber(rs.getInt("dist_number"));

                list.add(model);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelDistributorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public List<ModelDistributor> readName(String name) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelDistributor> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        String queryLike = "%" + name + "%";

        try {
            stmt = con.prepareStatement(selectName, resultType, resultConcurrence);
            stmt.setString(1, queryLike);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelDistributor model = new ModelDistributor();

                model.setId(rs.getInt("dist_id"));
                model.setDistributorName(rs.getString("dist_distributorName"));
                model.setDistributorCNPJ(rs.getString("dist_distributorCNPJ"));
                model.setDistributosMail(rs.getString("dist_distributorMail"));
                model.setPhoneNumber(rs.getString("dist_phoneNumber"));
                model.setLoadType(rs.getString("dist_loadType"));
                model.setSplitMaxCapacity(rs.getString("dist_splitMaxCapacity"));
                model.setUnitMaxCapacity(rs.getString("dist_unitMaxCapacity"));
                model.getAdress().setState(rs.getString("dist_state"));
                model.getAdress().setCity(rs.getString("dist_city"));
                model.getAdress().setStreetName(rs.getString("dist_streetName"));
                model.getAdress().setNumber(rs.getInt("dist_number"));

                list.add(model);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelDistributorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public void delete(ModelDistributor model) {
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
            Logger.getLogger(ModelDistributorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
