package com.oocl.arp.utils.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by on 10/30/2017.
 */
public class ScanDRTReportColumnTest {
    @Test
    public void executeTest() throws IOException {
        boolean isForLocal = false;
        if(isForLocal){
            scanColumnByPath();
        }
    }

    private void scanColumnByPath() throws IOException {
        final String filePath = "C:\\Users\\wangwi\\Desktop\\Report\\outstanding_exception.txt";
        getReportColumnByScanFile(filePath);
    }

    private void getReportColumnByScanFile(String filePath) throws IOException {
        File exceptionFile = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(exceptionFile));
        String content = bufferedReader.readLine();
        while (content != null) {
            /*if(content.contains("<dependentColumnCode>")){
                System.out.println(content.substring(content.indexOf(">") + 5, content.lastIndexOf("<")));
            }*/
            /*if(content.contains("<displayText>")){
                System.out.println(content.substring(content.indexOf(">") + 1, content.lastIndexOf("<")));
            }*/
            if(content.contains("<value>")){
                System.out.println(content.substring(content.indexOf(">") + 1, content.lastIndexOf("<")));
            }
            content = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
