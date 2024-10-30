/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.directory;

import com.epbt2.common.dao.StdSysParam;
import com.epbt2.common.dao.StdSysParamDaoExt;
import com.epbt2.util.DBHelper;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author BYE
 */
public class CreateDirectory {

    private StdSysParamDaoExt paramDaoExt = new StdSysParamDaoExt();
    private StdSysParam param = new StdSysParam();


    public String createDirectoryMTKN(Connection conn) throws SQLException {
        /*param.setParaId("7");
        folderKutipan = paramDaoExt.sysParamValue(conn, param, "MKLR");

        File dirMKLR = new File(folderKutipan);

        if (!dirMKLR.exists()) {
            dirMKLR.mkdir();
        }*/
        
                param.setParaId("23");
                String mtknDir = paramDaoExt.sysParamValue(conn, param, "MTKN");

                File fileDir = new File(mtknDir);
                if (!fileDir.exists()) {
                        fileDir.mkdirs();
                        System.out.println("Directory is created!");
                }
                return mtknDir;
    }   
            
    
    public String createDirectoryPBT(Connection conn) throws SQLException {
        param.setParaId("46");
        String pbtDir = paramDaoExt.sysParamValue(conn, param, "MTKN");

        File dirPBT = new File(pbtDir);

        if (!dirPBT.exists()) {
            dirPBT.mkdir();
        }
        
        //dirPBT = new File(dirPBT, folderPBT);
        
        return pbtDir;
    }
    
    public String createDirectoryFlatFile(Connection conn) throws SQLException {
        param.setParaId("45");
        String flatFileDir = paramDaoExt.sysParamValue(conn, param, "MTKN");

        File dirFlatFile = new File(flatFileDir);

        if (!dirFlatFile.exists()) {
            dirFlatFile.mkdir();
        }
        
        //dirPBT = new File(dirPBT, folderPBT);
        
        return flatFileDir;
    }
}
