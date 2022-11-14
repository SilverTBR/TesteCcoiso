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
import model.bean.ModelProduct;
import connection.ConnectionFactory;

public class ModelProductDAO {

    public String insert = "INSERT INTO \"Products\" (\"prod_name\", \"prod_loadCategory\", \"prod_stackingCapacity\") VALUES (?, ?, ?)";
    public String update = "UPDATE \"Products\" SET \"prod_name\" = ?, \"prod_loadCategory\" = ?, \"prod_stackingCapacity\" = ? WHERE \"prod_id\" = ?";
    public String select = "SELECT * FROM \"Products\" ORDER BY \"prod_id\"";
    public String selectId = "SELECT * FROM \"Products\" WHERE \"prod_id\" = ?";
    public String selectName = "SELECT * FROM \"Products\" WHERE \"prod_name\" ILIKE ?";
    public String delete = "DELETE FROM \"Products\" WHERE \"prod_id\" = ?";

    public void Create(ModelProduct model) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        try {
            stmt = con.prepareStatement(insert, resultType, resultConcurrence);

            stmt.setString(1, model.getName());
            stmt.setString(2, model.getLoadCategory());
            stmt.setString(3, model.getStackingCapacity());            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(ModelProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void Update(ModelProduct model) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        try {
            stmt = con.prepareStatement(update, resultType, resultConcurrence);

            stmt.setString(1, model.getName());
            stmt.setString(2, model.getLoadCategory());
            stmt.setString(3, model.getStackingCapacity());
            stmt.setInt(4, model.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            Logger.getLogger(ModelProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(ModelProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<ModelProduct> read() {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelProduct> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        try {
            stmt = con.prepareStatement(select, resultType, resultConcurrence);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelProduct model = new ModelProduct();

                model.setId(rs.getInt("prod_id"));
                model.setName(rs.getString("prod_name"));
                model.setLoadCategory(rs.getString("prod_loadCategory"));
                model.setStackingCapacity(rs.getString("prod_stackingCapacity"));
                
                list.add(model);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public List<ModelProduct> readID(int id) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelProduct> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        try {
            stmt = con.prepareStatement(selectId, resultType, resultConcurrence);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelProduct model = new ModelProduct();

                model.setId(rs.getInt("prod_id"));
                model.setName(rs.getString("prod_name"));
                model.setLoadCategory(rs.getString("prod_loadCategory"));
                model.setStackingCapacity(rs.getString("prod_stackingCapacity"));

                list.add(model);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public List<ModelProduct> readName(String name) {
        Connection con = ConnectionFactory.openConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelProduct> list = new ArrayList<>();

        int resultType = ResultSet.TYPE_SCROLL_SENSITIVE;
        int resultConcurrence = ResultSet.CONCUR_UPDATABLE;

        String queryLike = "%" + name + "%";

        try {
            stmt = con.prepareStatement(selectName, resultType, resultConcurrence);
            stmt.setString(1, queryLike);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelProduct model = new ModelProduct();

                model.setId(rs.getInt("prod_id"));
                model.setName(rs.getString("prod_name"));
                model.setLoadCategory(rs.getString("prod_loadCategory"));
                model.setStackingCapacity(rs.getString("prod_stackingCapacity"));

                list.add(model);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(ModelProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return list;
    }

    public void delete(ModelProduct model) {
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
            Logger.getLogger(ModelProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
