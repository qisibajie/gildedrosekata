package com.oocl.arp.utils.io;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by on 10/19/2017.
 */
public class CreateJarUploadFolderTest {
    private static final String ROOT_FOLDER = CreateJarUploadFolderTest.class.getResource(".").getPath().split("ARP_APP_Server")[0];
    private static final String NEW_LIB_POM_VERSION = "23.4.0.0.009";

    @Test
    @Ignore
    public void testExecute() throws IOException {

        createJarUploadFolderAndPomFile(createJarNameVersionMap());
    }


    private Map<String, String> createJarNameVersionMap() {
        Map<String, String> nameVersionMap = new HashMap<String, String>();
        String fileDirPath = ROOT_FOLDER + "ARP_RES/ARP_LIB/";
        File file = new File(fileDirPath);
        if (file.exists() && file.isDirectory() && file.list() != null) {
            for (String fileName : file.list()) {
                String filePrefix = fileName.substring(0, fileName.lastIndexOf(".jar"));
                String versionLastPart = filePrefix.substring(filePrefix.indexOf("."));
                String versionFirstPartStr = filePrefix.substring(0, filePrefix.indexOf("."));
                String versionFirstPart = versionFirstPartStr.substring(versionFirstPartStr.lastIndexOf("-") + 1);
                String version = versionFirstPart + versionLastPart;
                String jarName = fileName.substring(0, fileName.indexOf(version) - 1);
                if (nameVersionMap.get(jarName) == null) {
                    nameVersionMap.put(jarName, version);
                    System.out.println(jarName + version);
                }
            }

        }
        return nameVersionMap;
    }

    private void createJarUploadFolderAndPomFile(Map<String, String> map) throws IOException {
        String templateFilePath = ROOT_FOLDER + "ARP_LIB/uploadJar_template_file.txt";
        for (Map.Entry<String, String> keyValue : map.entrySet()) {
            String fileDirPath = ROOT_FOLDER + "ARP_LIB/";
            fileDirPath = fileDirPath + keyValue.getKey();
            File fileDir = new File(fileDirPath);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            File pomFile = new File(fileDirPath + "/pom.xml");
            if (!pomFile.exists()) {
                pomFile.createNewFile();
//                renamePomFileTo(pomFile, fileDirPath + "/jar-upgrade.txt");
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(templateFilePath)));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pomFile));
            String content = bufferedReader.readLine();
            final String oldJarVersion = "23.4.0.0.004";
            final String oldLibVersion = "23.4.0.0.006";
            final String previousJarName = "TEMPLATE_JAR_NAME";
            while (content != null) {
                if (content.contains(oldJarVersion)) {
                    content = content.replace(oldJarVersion, keyValue.getValue());
                }
                if (content.contains(oldLibVersion)) {
                    content = content.replace(oldLibVersion, NEW_LIB_POM_VERSION);
                }
                content = content.replace(previousJarName, keyValue.getKey());
                bufferedWriter.write(content + "\n");
                content = bufferedReader.readLine();
            }
            bufferedReader.close();
            bufferedWriter.close();

        }

        replacePomFileVersionAndModule(NEW_LIB_POM_VERSION);
        commentPomFileModulePart(createJarNameVersionMap());
    }

    private void renamePomFileTo(File file, String targetName) {
        file.renameTo(new File(targetName));
    }

    private File createFileBy(String fileName) {
        String fileFullName = ROOT_FOLDER + fileName;
        File originFile = new File(fileFullName);
        return originFile;
    }

    private BufferedReader createBufferedReaderBy(String fileName) throws FileNotFoundException {
        String fileFullName = ROOT_FOLDER + fileName;
        File originFile = new File(fileFullName);
        return new BufferedReader(new FileReader(originFile));
    }

    private BufferedWriter createBufferedWriterBy(String fileName) throws IOException {
        String fileFullName = ROOT_FOLDER + fileName;
        File originFile = new File(fileFullName);
        return new BufferedWriter(new FileWriter(originFile));
    }

    private void replacePomFileVersionAndModule(String newVersion) throws IOException {

        String pomFileName = "ARP_LIB/pom.xml";
        String targetFileName = "ARP_LIB/pom_backup.xml";
        String pomFilePath = ROOT_FOLDER + pomFileName;
        File originFile = createFileBy(pomFileName);
        File targetFile = createFileBy(targetFileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(originFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile));

        String line = bufferedReader.readLine();
        String currentVersion;
        boolean isTheFirstVersion = true;
        while (line != null) {
            if (line.contains("<version>") && isTheFirstVersion) {
                currentVersion = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<"));
                line = line.replace(currentVersion, newVersion);
                isTheFirstVersion = false;
            }
            bufferedWriter.write(line + "\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
        originFile.delete();
        targetFile.renameTo(new File(pomFilePath));
    }

    private void commentPomFileModulePart(Map<String, String> nameVersionMap) throws IOException {
        String pomFileName = "ARP_LIB/pom.xml";
        String targetFileName = "ARP_LIB/pom_backup.xml";
        String pomFilePath = ROOT_FOLDER + pomFileName;
        File originFile = createFileBy(pomFileName);
        File targetFile = createFileBy(targetFileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(originFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile));

        createUploadedJarModulesPartByNameVersionMap(bufferedReader, bufferedWriter,nameVersionMap);

        bufferedReader.close();
        bufferedWriter.close();
        originFile.delete();
        targetFile.renameTo(new File(pomFilePath));
    }

    private void createUploadedJarModulesPartByNameVersionMap(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Map<String, String> nameVersionMap) throws IOException {
        String line = bufferedReader.readLine();
        boolean isBegin = false;
        while (line != null) {
            if (line.contains("<modules>")) {
                isBegin = true;
            }
            if(isBegin && !line.contains("modules")){

                if(line.contains("<module>")&& !line.contains("-->")){
                    String moduleName = line.substring(line.indexOf(">")+1, line.lastIndexOf("<")).trim();
                    nameVersionMap.remove(moduleName);
                    line = "<!--" + line + "-->";
                }
            }
            if(line.contains("</modules>")){
                String newModule = "";
                for(String moduleName : nameVersionMap.keySet()){
                    newModule = newModule + "       <module>" + moduleName+"</module>" + "\n";
                }
                bufferedWriter.write(newModule);
                isBegin = false;
            }
            bufferedWriter.write(line + "\n");
            line = bufferedReader.readLine();
        }
    }
}
