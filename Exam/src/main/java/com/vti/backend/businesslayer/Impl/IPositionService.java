/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.businesslayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Position;

/**
 * 
 */
public interface IPositionService {

    public abstract boolean insertPosition(int pId, String pName) throws SQLException, Exception;

    public abstract Position getPosInfor(String arg) throws SQLException;

    public abstract boolean updatePosById(int pId, String newName) throws SQLException;

    public abstract boolean deletePosById(int pId) throws SQLException;

    public abstract List<Position> viewListPosition() throws SQLException;
}
