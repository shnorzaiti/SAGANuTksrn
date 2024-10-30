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
public class FlatFileJanaNotis {

    public void main(String[] args) throws Exception {
        String content = "";
        String fileName;
        String  majlis = args[0];

        HnotisDaoExt notisDaoExt = new HnotisDaoExt();

        List<Hnotis> notisList;

        Connection conn = DBHelper.getConnectionDS();
        try {
            try {

                if ( majlis.equals("MPAJ")) {
                    notisList = notisDaoExt.flatFileNotisMpaj(conn);
                } else if ( majlis.equals("MDKPR")) {
                    notisList = notisDaoExt.flatFileNotisMdkpr(conn);
                } else {
                    notisList = notisDaoExt.flatFileNotis(conn);
                }

                for (int i = 0; i < notisList.size(); i++) {
                    content = content + notisList.get(i).getKeter();
                }

                CreateDirectory cDir = new CreateDirectory();

                String mtknBackupDir = cDir.createDirectoryFlatFile(conn);

                File file = new File(mtknBackupDir + "NOTIS");

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