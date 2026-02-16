package recurrsion;

import java.io.File;
import java.io.IOException;

public class FilesCanonicalPath {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ishan Raghav\\OneDrive\\Desktop\\root";
        File rootFolder = new File(filePath);
        if(rootFolder.exists() && rootFolder.isDirectory()){
            getAllCanonicalPath(rootFolder);
        }else{
            System.out.println("Invalid File Path");
        }
    }

    private static void getAllCanonicalPath(File rootFolder) {
        File[] listFiles = rootFolder.listFiles();
        if(listFiles!=null){
            for(File file: listFiles){
                if(file.isFile()){
                    try{
                        System.out.println("Path :: " + file.getCanonicalPath());
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                } else if (file.isDirectory()) {
                    getAllCanonicalPath(file);
                }
            }
        }
    }
}
