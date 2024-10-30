/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epbt2.mtkn.pemprosesan;

import com.epbt2.mtkn.directory.CreateDirectory;
import com.epbt2.mtkn.pemprosesan.dao.Hnotis;
import com.epbt2.mtkn.pemprosesan.dao.HnotisDaoExt;
import com.epbt2.util.DBHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Baizura
 */
public class FlatFileJanaCTA2 {

    public void main(String[] args) throws Exception {
        String content = "";
        String  majlis = args[0];
        String jpkod = args[1];
        String fileName = "";

        HnotisDaoExt notisDaoExt = new HnotisDaoExt();

        List<Hnotis> cta2List;

        Connection conn = DBHelper.getConnectionDS();
        try {
            try {

                if ( majlis.equals("MPAJ")) {
                    cta2List = notisDaoExt.flatFileCta2Mpaj(conn);
                } else {
                    cta2List = notisDaoExt.flatFileCta2(conn);
                }

                for (int i = 0; i < cta2List.size(); i++) {
                    content = content + cta2List.get(i).getKeter();
                }

                CreateDirectory cDir = new CreateDirectory();

                String mtknBackupDir = cDir.createDirectoryFlatFile(conn);

                if (! majlis.equals("MPAJ")) {
                    if (jpkod.equals("1")) {
                        fileName = "_IDV";
                    } else if (jpkod.equals("2")) {
                        fileName = "_SKT";
                    } else {
                        fileName = "_ALL";
                    }
                }

                File file = new File(mtknBackupDir + "CTA" + fileName);

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

                System.out.println("Done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(conn);
        }
    }

}
