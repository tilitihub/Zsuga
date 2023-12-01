import zsuga.Kartya;
import zsuga.Pakli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void kiIr(Pakli p, int l){
        System.out.println("A pakli lapjai: ");
        p.osszesLap();
        System.out.println("\nBlack Jack Light: ");
        System.out.println("A húzott lapok összege: " + p.blackJackLight(l));

        System.out.println("\nBJL kártyával /fekete,3/:");
        Kartya k = new Kartya(3, "fekete");
        System.out.println("A húzott lapok összege: " + p.blackJackLight(k));
        System.out.println("\nJoker színűvé tesszük a paklit:");
        p.egyszinuPakli();
        p.osszesLap();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Add meg a pakli méretét: ");
        String pakliMeret = br.readLine();
        System.out.print("Megnézendő lapok száma: ");
        String lapokSzama = br.readLine();

        if (pakliMeret.isEmpty() && lapokSzama.isEmpty()) {
            System.out.println("Nem adtál meg megfelelő adatokat!");
            System.exit(0);
        }
            int kartyaSzam = Integer.parseInt(pakliMeret);
            int lapSzam = Integer.parseInt(lapokSzama);

            if (kartyaSzam <= 0){
                Pakli pakli = new Pakli();
                kiIr(pakli, lapSzam);
            }else{
                Pakli pakli = new Pakli(kartyaSzam, "piros");
                kiIr(pakli, lapSzam);
            }










    }
}
