package FileRenameScript;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;


public class Main{
    static int i = 0;
    public static void main(String[] args) throws Exception{
        //Path path = Paths.get("D:\\ТЕЛЕФОН ПЕРЕБРАТЬ\\Camera 04.12-31.12.2019\\");
        //Path path = Paths.get("D:\\ТЕЛЕФОН ПЕРЕБРАТЬ\\Camera 03.09-03.12.2019\\");
        //Path path = Paths.get("D:\\ТЕЛЕФОН ПЕРЕБРАТЬ\\Camera 03.06-03.09.2019\\");
        //Path path = Paths.get("E:\\Фотографии\\2019\\06 июнь 2019");
        //Path path = Paths.get("E:\\Фотографии\\2019\\05 май 2019");
        Path path = Paths.get("E:\\Фотографии\\2019\\03 март 2019");


        Files.walkFileTree(path, new HashSet<FileVisitOption>(), 1, new MyFileVisitor());
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes) throws IOException {

        //System.out.println(file.getFileName());
        /*
         * Rename File
         * if name contain "IMG_", "PANO_" or "VID_"
         * program will delete it from name of file
         */
        if(file.getFileName().toString().contains("IMG_")){
            Files.move(file, Paths.get(file.toAbsolutePath().toString().replace("IMG_","")));
            System.out.println("IMG_"+(Main.i++));
        }
        if(file.getFileName().toString().contains("PANO_")){
            Files.move(file, Paths.get(file.toAbsolutePath().toString().replace("PANO_","")));
            System.out.println("PANO_"+(Main.i++));
        }
        if(file.getFileName().toString().contains("VID_")){
            Files.move(file, Paths.get(file.toAbsolutePath().toString().replace("VID_","")));
            System.out.println("VID_"+(Main.i++));
        }
        return FileVisitResult.CONTINUE;
    }
}