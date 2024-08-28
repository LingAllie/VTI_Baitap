/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.Impl.IPositionService;
import com.vti.backend.datalayer.PositionRepository;
import com.vti.backend.datalayer.Impl.IPositionRepository;
import com.vti.entity.Position;

/**
 * 
 */
public class PositionService implements IPositionService{

    IPositionRepository iPositionRepository = new PositionRepository();

    @Override
    public boolean insertPosition(int pId, String pName) throws SQLException, Exception  {
        if (iPositionRepository.getPosInfor(pName) == null) {
            return iPositionRepository.insertPosition(pId, pName);
        }
        return false;
    }

    @Override
    public Position getPosInfor(String arg) throws SQLException {
        try {
            return iPositionRepository.getPosInfor(arg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePosById(int pId, String newName) throws SQLException {
        return iPositionRepository.updatePosById(pId, newName);
    }

    @Override
    public boolean deletePosById(int pId) throws SQLException {
        return iPositionRepository.deletePosById(pId);
    }

    @Override
    public List<Position> viewListPosition() throws SQLException {
        return iPositionRepository.viewListPosition();
    }

}
