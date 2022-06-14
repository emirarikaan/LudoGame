package ludoogame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author emirarikan
 */
public class LudooGame {

    private static Player simdikiOyuncu;
    private static String[] renkListesi = {"Green", "Yellow", "Red", "Blue"};
    private static LudoBoard ludoTahta;
    private static List<Player> oyuncuListesi = new ArrayList<Player>();

    static int pieceNumberr;

    public static void main(String[] args) throws IOException {
        int baslangic = 0;
        System.out.println("1-Yeni Oyun");
        System.out.println("2-Oyuna Devam Et");
        System.out.println("3-Çıkış");
        Scanner scann = new Scanner(System.in);
        baslangic = scann.nextInt();

        if (baslangic == 1) {

            System.out.println("Kızma Birader oyununa hoş geldiniz 2-4 arasında oyuncu sayısı seçiniz.");
            Scanner scan = null;
            boolean siraa = false;
            int oyuncuSayac = 0;
            int oyuncuSayacc = 0;
            boolean boyuncisayisi = false;
            int number = 0;

            while (!boyuncisayisi) {
                int oyuncusayisi = 0;
                scan = new Scanner(System.in);
                oyuncusayisi = scan.nextInt();
                if (oyuncusayisi > 1 && oyuncusayisi < 5) {

                    boyuncisayisi = true;
                    for (int i = 0; i < oyuncusayisi; i++) {
                        System.out.println("Oyuncu" + i + " ismini giriniz");
                        number++;
                        String isimm = scan.next();
                        oyuncuListesi.add(new Player(renkListesi[i], isimm));
                    }
                } else {
                    System.out.println("Hatalı giriş.Oyuncu sayısı 2-4 arasında olmalıdır.");
                }
            }
            Dosya.yaz(number, oyuncuListesi);
            int arr[] = new int[number];
            int ssayac = 0;
            System.out.println("Oyuncular zar atacak ve en yüksek zar atan oyuncu oyuna ilk başlayacak // x e basarak zar atabilirsiniz");
            while (!siraa) {

                Player nowOyuncu = oyuncuListesi.get(oyuncuSayac);
                System.out.println(nowOyuncu.getIsım() + " sıra sende");
                String cc = scan.next();
                if (cc.equals("x")) {

                    nowOyuncu.zarAtt();
                    arr[ssayac] = nowOyuncu.getNumberRolled();
                    ssayac++;
                    System.out.println(nowOyuncu.getIsım() + " " + nowOyuncu.getNumberRolled() + " attı");
                } else {
                    System.out.println("x dışında bir tuşa basmayınız");
                    continue;
                }
                if (++oyuncuSayac == oyuncuListesi.size()) {
                    System.out.println(oyuncuSayac);
                    siraa = true;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        siraa = false;
                    }
                }
            }
            if (siraa == false) {
                System.out.println("Zar aynı geldiği için bir daha atacağız");
                ssayac = 0;
                oyuncuSayacc = 0;
            }
            while (!siraa) {
                Player nowOyuncu = oyuncuListesi.get(oyuncuSayacc);
                System.out.println(nowOyuncu.getIsım() + " sıra sende");
                String cc = scan.next();
                if (cc.equals("x")) {

                    nowOyuncu.zarAtt();
                    arr[ssayac] = nowOyuncu.getNumberRolled();
                    ssayac++;

                    System.out.println(nowOyuncu.getIsım() + " " + nowOyuncu.getNumberRolled() + " attı");
                } else {
                    System.out.println("x dışında bir tuşa basmayınız");
                    continue;
                }
                if (++oyuncuSayacc == oyuncuListesi.size()) {
                    System.out.println(oyuncuSayac);
                    siraa = true;
                }
            }

            List<Player> enYuksek = enYuksekAtan(oyuncuListesi, number);

            for (int i = 0; i < enYuksek.size(); i++) {
                System.out.println(enYuksek.get(i).getColor() + " attı " + enYuksek.get(i).getNumberRolled());
            }
            simdikiOyuncu = enYuksek.get(0);
            System.out.println(simdikiOyuncu.getIsım() + " oyuna baslayacak.");

            ludoTahta = new LudoBoard();
            for (int i = 0; i < oyuncuListesi.size(); i++) {
                ludoTahta.yükle(oyuncuListesi.get(i));
            }
        }
        if (baslangic == 2) {
            List<String> a = new ArrayList<String>();

            a = Dosya.read();
            String arr[] = new String[a.size()];
            for (int k = 0; k < a.size(); k++) {
                arr[k] = a.get(k);
                oyuncuListesi.add(new Player(renkListesi[k], arr[k]));
            }
            int sayacak = 0;
            
            List<String> aa = new ArrayList<String>();
            List<String> aaa = new ArrayList<String>();
            aaa = Dosya.readkor2();
            aa = Dosya.readkor();
            String arr2[] = new String[aa.size()];
            String arr3[] = new String[aaa.size()];

            for (int j = 0; j < aa.size(); j++) {
                if (aa.get(j).contains("-")) {
                    arr2[sayacak] = aa.get(j);
                    arr3[sayacak] = aaa.get(j);

                    sayacak++;
                 //      System.out.println(arr3[sayacak-1]);
                }
            }

            // currentplayeri ata yukardaki gibi daha sonra setle yerlerini ata en son zor attır başlasınlar
            int l = 1;
            simdikiOyuncu = oyuncuListesi.get(0);
            Piece piece = simdikiOyuncu.getPiece(1);

            int piecenumberr = 0;
            for (l = 0; l < 4; l++) {
                String string = arr3[l];
                String[] parts = string.split("-");
                String part1 = parts[0]; // 004
                String part2 = parts[1];
                String part3 = part1 + part2;
                String stringg = arr2[l];
                String[] partss = stringg.split("-");
                String parts1 = partss[0]; // 004
                String parts2 = partss[1];
                
                if (arr2[l] != null && arr3[l] != null) //  System.out.println(part3+parts1+parts2);  
                {
               //     System.out.println(simdikiOyuncu.getColor() + piece.getPieceNumber());
                }
                if (part3.equals("Blue1")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.contains("Blue2")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                    // System.out.println(currentPlayer.getColor()); 
                    //    System.out.println("firsdf");
                }
                if (part3.equals("Blue3")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Blue4")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Yellow1")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Yellow2")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Yellow3")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Yellow4")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Green1")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Green2")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Green3")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Green4")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Red1")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Red2")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Red3")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                if (part3.equals("Red4")) {
                    piece.setX(Integer.parseInt(parts1));
                    piece.setY(Integer.parseInt(parts2));
                }
                digerOyuncu();

            }
            piecenumberr = 0;
            for (int i = 0; i < 16; i++) {
                piecenumberr++;
                // System.out.println(currentPlayer.getColor()+piece.getPieceNumber());
                digerOyuncu();
            }
             simdikiOyuncu = oyuncuListesi.get(0);
            Piece piecee = simdikiOyuncu.getPiece(0);
            
            System.out.println(simdikiOyuncu.getColor()+piecee.getPieceNumber());
            piecee.setX(9);
            piecee.setY(8);
            
ludoTahta = new LudoBoard();
for (int i = 0; i < oyuncuListesi.size(); i++) {
                ludoTahta.yükle(oyuncuListesi.get(i));
            }
        }
        if (baslangic == 3) {
            System.exit(0);
        }
        baslat();

    }

    /*
	 * 
	 * Controls the game sequence
	 * 
     */
    private static void baslat() throws IOException {
        FileOutputStream f = new FileOutputStream("Oyun.txt", false);
        PrintStream yaz = new PrintStream(f);
        Scanner scanner = null;
        boolean gameCompleted = false;

        game:
        while (!gameCompleted) {

            ludoTahta.ekranaBas();

            System.out.println(simdikiOyuncu + " sıra sen de x'e basarak zar atabilirsin");

            boolean rollComplete = false;

            while (!rollComplete) {

                scanner = new Scanner(System.in);
                String input = "a";

                try {
                    input = scanner.next();
                } catch (Exception e) {
                    // ignore
                }
                if (input.equals("0")) {
                    Dosya.sort();
                    System.exit(0);
                }
                if (input.equals("x")) {
                    simdikiOyuncu.zarAtt();
                    rollComplete = true;

                } else {

                    System.out.println("Lütfen x'e basınız");
                    continue;

                }

            }

            boolean movesArePossible = ludoTahta.gidisVarmi(simdikiOyuncu, simdikiOyuncu.getNumberRolled());

            if (!movesArePossible) {

                System.out.println("Gidilecek Alan yok");
                digerOyuncu();
                continue;

            }

            System.out.println(simdikiOyuncu + " " + simdikiOyuncu.getNumberRolled()
                    + " attı "
                    + "\"t ve numarasını yazarak alandan çıkarabilirsin\n"
                    + "\"m ve numarasını yazarak haraket ettirebilirsin");

            boolean dönüscomp = false;

            while (!dönüscomp) {

                scanner = new Scanner(System.in);

                String command = null;
                boolean emirbasarili = false;

                try {
                    command = scanner.next();
                } catch (Exception e) {
                    System.out.println("Yanlis komut.Tekrar deneyiniz..");
                    continue;
                }

                if (command.equals("t")) {

                    if (!simdikiOyuncu.hasRolledSix()) {
                        System.out.println(" 6 atmadan alandan çıkaramazsanız"
                        );
                        continue;
                    }
                    int pieceNumber = 0;
                    try {
                        pieceNumber = scanner.nextInt() - 1;
                    } catch (Exception e) {
                        System.out.println("Geçersiz giriş");
                        continue;
                    }
                    if (pieceNumber < 0 || pieceNumber > 3) {

                        System.out.println("Geçersiz rakam");
                        continue;
                    }
                    Piece piece = simdikiOyuncu.getPiece(pieceNumber);

                    emirbasarili = ludoTahta.disarıCikar(piece);
                    //     Dosya.delete1(currentPlayer.getColor() + piece.getPieceNumber());
                    String yazi = simdikiOyuncu.getColor() + piece.getPieceNumber() + " " + " " + piece.getX() + " " + piece.getY();
                    //        yaz.println(yazi);
                    //  System.out.println(currentPlayer.getColor() + piece.getPieceNumber() + " " + " " + piece.getX() + " " + piece.getY());
                    //    Dosya.yazz(currentPlayer, piece, yazi);
                } else if (command.equals("m")) {

                    int pieceNumber = 0;

                    try {
                        pieceNumber = scanner.nextInt() - 1;
                    } catch (Exception e) {
                        System.out.println("Gecersiz parca numarasi.Tekrar deneyiniz");
                        continue;
                    }

                    if (pieceNumber < 0 || pieceNumber > 3) {

                        System.out.println("Gecersiz parca numarasi.Tekrar deneyiniz");
                        continue;

                    }

                    Piece piece = simdikiOyuncu.getPiece(pieceNumber);
                    pieceNumberr = pieceNumber;
                    int squareAmount = simdikiOyuncu.getNumberRolled();
                    String sill = simdikiOyuncu.getColor() + piece.getPieceNumber() + " " + " " + piece.getX() + " " + piece.getY();
                    //    System.out.println(sill);
                    //   Dosya.delete1(sill);

                    emirbasarili = ludoTahta.hareketEttir(piece, squareAmount);
                    //       String yazi = currentPlayer.getColor() + piece.getPieceNumber() + " " + " " + piece.getX() + " " + piece.getY();
                    //     yaz.println(yazi);
                    //      Dosya.yazz(currentPlayer, piece, yazi);
                } else {
                    System.out.println("Geçersiz komut..Tekrar deneyiniz.");
                    continue;
                }
                if (emirbasarili) {
                    Piece piece = simdikiOyuncu.getPiece(pieceNumberr);
                    String sill = simdikiOyuncu.getColor() + piece.getPieceNumber();
                    Dosya.delete1(sill);
                    String yazi = simdikiOyuncu.getColor() +"-"+ piece.getPieceNumber() + " " + " " + piece.getX() + "-" + piece.getY();
                    yaz.println(yazi);
                    yaz.println(yazi);
                    if (simdikiOyuncu.kazandi()) {
                        System.out.println("Tebrikler! " + simdikiOyuncu + " oyunu kazandı");
                        break game;
                    }
                    if (simdikiOyuncu.hasRolledSix()) {
                        System.out.println(simdikiOyuncu + " 6 attı "
                                + "zar at ve hareket ettir..");
                        continue game;
                    }
                    digerOyuncu();
                    dönüscomp = true;
                } else {
                    System.out.println("Hareket tamamlanamadı.Tekrar deneyiniz..");
                }
            }
        }
        scanner.close();
    }

    private static List<Player> enYuksekAtan(List<Player> enYuksekk, int number) {

        List<Player> yuksekList = new ArrayList<Player>();
        Player highestRoller = enYuksekk.get(0);
        boolean complete = false;
        int playerCounter = 1;

        while (!complete) {

            Player siradakiOyuncu = enYuksekk.get(playerCounter++);

            int suanY = highestRoller.getNumberRolled();
            int digerY = siradakiOyuncu.getNumberRolled();

            if (suanY > digerY) {

            } else if (suanY < digerY) {

                highestRoller = siradakiOyuncu;

                yuksekList.clear();

            } else if (suanY == digerY) {

                if (!yuksekList.contains(highestRoller)) {
                    yuksekList.add(highestRoller);
                }
                if (!yuksekList.contains(siradakiOyuncu)) {
                    yuksekList.add(siradakiOyuncu);
                }
            }
            if (playerCounter == enYuksekk.size()) {
                complete = true;
            }
        }
        if (yuksekList.size() == 0) {
            yuksekList.add(highestRoller);
        }
        return yuksekList;
    }

    private static void digerOyuncu() {

        int nextIndex = oyuncuListesi.indexOf(simdikiOyuncu) + 1;

        if (nextIndex == oyuncuListesi.size()) {
            nextIndex = 0;
        }

        simdikiOyuncu = oyuncuListesi.get(nextIndex);

    }

}

class Zar {

    int roll() {
        return new Random().nextInt(6) + 1;
    }

}
