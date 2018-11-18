

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
                System.out.println("creationTime: " + ""
                        + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format((attr.creationTime().toMillis())));
                System.out.println("lastAccessTime: " + " " + attr.lastAccessTime());
                System.out.println("lastModifiedTime: " + " " + attr.lastModifiedTime());
                System.out.println("isDirectory: " + " " + attr.isDirectory());
                System.out.println("isRegularFile: " + " " + attr.isRegularFile());
                System.out.println("size: " + " " + attr.size());
            } else if (paths[i].isDirectory()) {
                System.out.println("Directory " + paths[i].getName());
            }
        }
    }


    public void loadBackup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the backup or enter the full path to the file)");
        String path = sc.nextLine();
        File[] paths = backupDir.listFiles();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].getName().equals(path) && paths[i].isFile()) {
                path = paths[i].getAbsoluteFile().getAbsolutePath();
                System.out.println(path);
            }
        }
        File file = new File(path);

//D:\ListContact1.txt

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("ListContact.txt"));

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {

                lines.add(line);
                writer.write(line + "\n");
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found\n" + e);
        } catch (IOException ex) {
            System.out.println("Failed to read content from file " + "ListContact.txt" + "\n" + ex);
        }

//        se citeste un backup si se rescrie fisierul ListContact.txt deoarece am pierdut ceva informatii
// https://stackoverflow.com/questions/10824027/get-the-metadata-of-a-file
    }


    public void removeBackup() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the backup (the full path to the  backup)");
        String path = sc.nextLine();

        File[] paths = backupDir.listFiles();

        for (int i = 0; i < paths.length; i++) {
            if (paths[i].getName().equals(path) && paths[i].isFile()) {
                Files.delete(paths[i].getAbsoluteFile().toPath());
            }
        }
        System.out.println(Arrays.toString(paths));
    }
//   When loading a backup file, the user should be presented with an option to input a custom path,
// besides the ones already available in the default location
// Atunci când se încarcă un fișier de rezervă, utilizatorul trebuie să aibă o opțiune de introducere a unei căi
// personalizate, pe lângă cele deja disponibile în locația prestabilită
}