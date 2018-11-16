import org.omg.CORBA.Environment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackupManager {

    private static final String BACKUP_LOCATION_DIR = "backups";
    private static final String BACKUP_EXT = ".bak";
    private static final DateFormat dateFormat = new SimpleDateFormat("-dd_MM_yyyy-hh:mm:ss");
    private File backupDir = new File(BACKUP_LOCATION_DIR);


    public BackupManager() {
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }
    }

    public Path createBackup(File original) throws IOException {
        // TODO: figure out backup file name

        String pathName = "/contactListAgenda";
        return (Files.copy(original.toPath(), new File(BACKUP_LOCATION_DIR + pathName
                + new Date().getTime() + BACKUP_EXT).toPath()));

    }

    public void viewBackup() throws IOException {
        File[] paths = backupDir.listFiles();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].isFile()) {
                System.out.println("File " + paths[i].getName());
                BasicFileAttributes attr = Files.readAttributes(paths[i].toPath(), BasicFileAttributes.class);
//                System.out.println("creationTime: " + " " +attr.creationTime());
                System.out.println("creationTime: " + "" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format((attr.creationTime().toMillis())));
                System.out.println("lastAccessTime: " +" " + attr.lastAccessTime());
                System.out.println("lastModifiedTime: " +" " + attr.lastModifiedTime());
                System.out.println("isDirectory: " + " " +attr.isDirectory());
                System.out.println("isRegularFile: " +" " + attr.isRegularFile());
                System.out.println("size: " + " " +attr.size());
            } else if (paths[i].isDirectory()) {
                System.out.println("Directory " + paths[i].getName());
            }
        }
    }
////////

    public void loadBackup() {
//        se citeste un backup si se rescrie fisierul ListContact.txt deoarece am pierdut ceva informatii
// https://stackoverflow.com/questions/10824027/get-the-metadata-of-a-file
    }

    public void removeBackup() {

    }
}
