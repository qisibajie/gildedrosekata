package com.oocl.arp.utils.io;

import org.junit.Test;

import java.io.File;

/**
 * Created by on 10/23/2017.
 */
public class ScanFolderFilesTest {
    private static final String ROOT_FOLDER = "D:\\work\\sourceCode\\ARPCode\\WLS_DOM_ARPDRT\\ear_file\\target\\WLS_DOM_ARPDRT\\ARP_DRT_Server-web\\WEB-INF\\lib";

    @Test
    public void executeTest() {
        scanFolderFiles();
    }

    private void scanFolderFiles() {
        File rootFolder = new File(ROOT_FOLDER);
        if(rootFolder.exists()&& rootFolder.isDirectory()){
            for(File file : rootFolder.listFiles()){
//                System.out.println(file.getName());
                String fileName = file.getName();
                String versionLastPart = fileName.substring(0,fileName.lastIndexOf(".")).substring(fileName.indexOf("."));
                String strVersionFirstPart = fileName.substring(0,fileName.lastIndexOf(".")).substring(0, fileName.indexOf("."));
                String versionFirstPart = "";
                if(strVersionFirstPart.contains("-")) {
                    versionFirstPart = strVersionFirstPart.substring(strVersionFirstPart.lastIndexOf("-")+1);
                }
                String version = versionFirstPart + versionLastPart;
                String fileNameWithoutVersion = "";
                if(fileName.contains("-")){
                    fileNameWithoutVersion = fileName.split("-"+version+".jar")[0];
                }else {
                    fileNameWithoutVersion = fileName.split(version+".jar")[0];
                }
//                System.out.println(versionFirstPart+versionLastPart);
//                System.out.println(fileNameWithoutVersion);
                System.out.println("<copy file=\"target/${project.build.finalName}/ARP_DRT_Server-web/WEB-INF/libTmp/"+fileName+ "\"" + " tofile=\"target/${project.build.finalName}/ARP_DRT_Server-web/WEB-INF/lib/"+fileName+"\" overwrite=\"true\" />"  );

            }
        }
    }
}
