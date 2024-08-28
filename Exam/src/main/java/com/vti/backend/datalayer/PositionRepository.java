/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.vti.backend.datalayer.Impl.IPositionRepository;
import com.vti.entity.Position;
import com.vti.utils.JdbcConnection;

/**
 * 
 */
public class PositionRepository implements IPositionRepository{

    private static Connection con = null;
    private static PreparedStatement psmt = null;
    private static ResultSet rs = null;

    @Override
    public boolean insertPosition(int pId, String pName) throws Exception {

        try {
            con = JdbcConnection.getConnection();
            con.setAutoCommit(false);

            String sql = "INSERT INTO `position` VALUES (?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, pId);
            psmt.setString(2, pName);

            int count = psmt.executeUpdate();
            if(count > 0) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
            throw new Exception("System insert error !" + e.getMessage(), e);
        } finally {
            JdbcConnection.closeConnection(con, psmt, null, null);
        }

        return false;
    }

    @Override
    public Position getPosInfor(String arg) throws SQLException {
        
        try {
            con = JdbcConnection.getConnection();
            
            boolean isNumeric = arg.matches("\\d+");

            if(isNumeric) {
                String sql = "SELECT * FROM `position` WHERE p_id = ?";
                psmt = con.prepareStatement(sql);
                psmt.setInt(1, Integer.parseInt(arg));
                rs = psmt.executeQuery();
            } else {
                String sql = "SELECT * FROM `position` WHERE p_name = ?";
                psmt = con.prepareStatement(sql);
                psmt.setString(1, arg);
                rs = psmt.executeQuery();
            }
            
            if (rs.next()) {
                return new Position(rs.getInt("p_id"), rs.getString("p_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.closeConnection(con, psmt, rs, null);
        }

        return null;
    }

    @Override
    public boolean updatePosById(int pId, String newName) throws SQLException {
        
        try {
            con = JdbcConnection.getConnection();
            String sql = "UPDATE `position` SET p_name = ? WHERE p_id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, newName);
            psmt.setInt(2, pId);

            int count = psmt.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.closeConnection(con, psmt, rs, null);
        }

        return false;
    }

    @Override
    public boolean deletePosById(int pId) throws SQLException {
        
        try {
            con = JdbcConnection.getConnection();
            String sql = "DELETE FROM `position` WHERE p_id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, pId);

            int count = psmt.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.closeConnection(con, psmt, rs, null);
        }
        return false;
    }

    @Override
    public List<Position> viewListPosition() throws SQLException {
        
        try {
            con = JdbcConnection.getConnection();
            String sql = "SELECT * FROM `position`";
            List<Position> posList = new ArrayList<>();

            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();

            while(rs.next()) {
                posList.add(new Position(rs.getInt("p_id"), rs.getString("p_name")));
            }
            if(!posList.isEmpty()) {
                return posList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.closeConnection(con, psmt, rs, null);
        }
        return null;
    }

}
