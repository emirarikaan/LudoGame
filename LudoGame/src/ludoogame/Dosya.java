package ludoogame;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dosya {

    private static String[] colorList = {"Green", "Yellow", "Red", "Blue"};

    public static void yaz(int sayi, List<Player> playerList) throws IOException {

        try {
            FileOutputStream f = new FileOutputStream("OyuncuListesi.txt", false);
            PrintStream yaz = new PrintStream(f);
            for (int i = 0; i < sayi; i++) {
                yaz.println(colorList[i] + " " + playerList.get(i).getIsım());

            }
        } catch (IOException e) {
        }
    }

    public static void yazz(Player currentPlayer, Piece piece, String lineContent) throws IOException {
        File file = new File("Oyun.txt");
        File temp = new File("_temp_");
        PrintWriter out = new PrintWriter(new FileWriter(temp));
        Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .forEach(out::println);
        out.flush();
        out.close();
        temp.renameTo(file);
        String yazi = currentPlayer.getColor() + piece.getPieceNumber() + " " + " " + piece.getX() + " " + piece.getY();
        try {
            FileOutputStream f = new FileOutputStream("Oyun.txt", false);
            PrintStream yaz = new PrintStream(f);

            yaz.println(yazi);

        } catch (IOException e) {
        }

    }

    public static void yaz2(Player currentPlayer, Piece piece) throws FileNotFoundException, IOException {

        String yazi = currentPlayer.getColor() + piece.getPieceNumber() + " " + " " + piece.getX() + " " + piece.getY();
        try {
            FileOutputStream f = new FileOutputStream("Oyun.txt", false);
            PrintStream yaz = new PrintStream(f);

            yaz.println(yazi);

        } catch (IOException e) {
        }
    }

    public static void sil(String lineContent) throws IOException {
        File file = new File("Oyun.txt");
        File temp = new File("_temp_");
        PrintWriter out = new PrintWriter(new FileWriter(temp));
        Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .forEach(out::println);
        out.flush();
        out.close();
        temp.renameTo(file);
    }

    public static void delete1(String str) {
        try {
            String lineContent = str;
            File file = new File("Oyun.txt");
            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !line.contains(lineContent))
                    .collect(Collectors.toList());
            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
        }

    }

    public static void bosluksil() throws FileNotFoundException {
        Scanner file;
        PrintWriter writer;
        file = new Scanner(new File("Oyun.txt"));

        writer = new PrintWriter("Oyunnn.txt");

        while (file.hasNext()) {
            String line = file.nextLine();
            if (!line.isEmpty()) {
                writer.write(line);
                writer.write("\n");
            }
        }

        file.close();
        writer.close();

    }

    public static void sort() throws IOException {
        Path initialFile = Paths.get("Oyun.txt");
        Path sortedFile = Paths.get("Oyunn.txt");

        Stream<CharSequence> sortedLines = Files.lines(initialFile).sorted().map(Function.identity());

        Files.write(sortedFile, sortedLines::iterator, StandardOpenOption.CREATE);
    }

    public static void kullancıBul() {
        //     String a="";
        List<Player> playerList = new ArrayList<Player>();
        try {
            FileInputStream fi = new FileInputStream("OyuncuListesi.txt");

            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
            String satir;
            while ((satir = buf.readLine()) != null) {
                if (!satir.contains("Yellow")) 
          //       playerList.add(satir);
                 ;

            }
        } catch (FileNotFoundException f) {

        } catch (IOException ioex) {
        }
        //   Collections.reverse(sa);

        //    return playerList;
    }

    public static List<String> read() throws IOException {
        List<String> a = new ArrayList<String>();
        File file = new File("OyuncuListesi.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split(" ");
            String last = tokens[tokens.length - 1];
            a.add(last);
        }
        return a;
    }

    public static List<String> readkor() throws IOException {
        List<String> a = new ArrayList<String>();
        File file = new File("Oyunn.txt");
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split("  ");
            String last = tokens[tokens.length - 1];
           // System.out.println(last);
            a.add(last);
            
        }
        
        return a;
    }
    
    public static List<String> readkor2() throws IOException {
        List<String> a = new ArrayList<String>();
        File file = new File("Oyunn.txt");
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split("  ");
            String last = tokens[tokens.length - 2];
           // System.out.println(last);
            a.add(last);
            
        }
        
        return a;
    }
}

//  [][] kur rotaları at  [][] isimleri at

