/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.PositionService;
import com.vti.backend.businesslayer.Impl.IPositionService;
import com.vti.entity.Position;

/**
 * 
 */
public class PositionController {

    IPositionService iPositionService = new PositionService();

    public boolean insertPosition(int pId, String pName) throws Exception {
        return iPositionService.insertPosition(pId, pName);
    }

    public Position getPosInfor(String arg) throws SQLException {
        return iPositionService.getPosInfor(arg);
    }

    public boolean updatePosById(int pId, String newName) throws SQLException {
        return iPositionService.updatePosById(pId, newName);
    }

    public boolean deletePosById(int pId) throws SQLException {
        return iPositionService.deletePosById(pId);
    }

    public List<Position> viewListPosition() throws SQLException {
        return iPositionService.viewListPosition();
    }
}
