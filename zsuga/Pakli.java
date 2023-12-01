package zsuga;

import java.util.Arrays;
import java.util.Random;

public class Pakli {
    private Kartya[] kartyapakli;
    private final String JOKER_SZIN;

    public Pakli(int lapszam, String jokerSzin){
        this.kartyapakli = new Kartya[lapszam];
        this.JOKER_SZIN = jokerSzin;
        pakliLetrehoz(lapszam);
    }

    public Pakli(){
        this.kartyapakli = new Kartya[52];
        this.JOKER_SZIN = "fekete";
        pakliLetrehoz(52);
    }

    private void pakliLetrehoz(int kartyaSzam){
        String szin;
        Random rand =  new Random();
        for (int i = 0; i < kartyaSzam; i++) {
            int randSzin = rand.nextInt(2);
            if(randSzin == 0){
                szin = "piros";
            }else {
                szin = "fekete";
            }
            int ertek = (int) ((Math.random() * (14 - 2)) + 2);
            kartyapakli[i] = new Kartya(ertek, szin);
        }
    }
    public Kartya getLap(int index){
        Kartya lapVissza = new Kartya();
        if (index >= 1 && index <= 52){
            lapVissza = this.kartyapakli[index];
        }
        return lapVissza;
    }
    public Kartya[] getOsszesLap(){
        return kartyapakli;
    }
    public void osszesLap(){
        for (int i = kartyapakli.length - 1; i >= 0; i--) {
            System.out.println(kartyapakli[i]);
        }
    }
    public double blackJackLight(int hanyKartya){
        int szamlalo = hanyKartya;
        double osszeg = 0;
        if(kartyapakli.length < hanyKartya){
            szamlalo = kartyapakli.length;
        }
        for (int i = szamlalo - hanyKartya; i < szamlalo; i++) {
            double hozzaad = Math.ceil(kartyapakli[i].getErtek() / 2.0);
            if (kartyapakli[i].getSzin().equals(JOKER_SZIN)){
                hozzaad = kartyapakli[i].getErtek();
            }

            osszeg = osszeg + hozzaad;
        }

        return osszeg;
    }

    public double blackJackLight(Kartya kartya){
        double osszeg = 0;

        for (int i = 0; i < kartyapakli.length; i++) {
            double hozzaad = Math.ceil(kartyapakli[i].getErtek() / 2.0);
            if (kartyapakli[i].getSzin().equals(JOKER_SZIN)){
                hozzaad = kartyapakli[i].getErtek();
            }
            osszeg = osszeg + hozzaad;
            if (kartyapakli[i].getSzin().equals(kartya.getSzin()) &&
                kartyapakli[i].getErtek() == kartya.getErtek()){
                break;
            }
        }
        return osszeg;
    }
    public void egyszinuPakli(){
        for (Kartya lap : kartyapakli) {
            lap.setSzin(JOKER_SZIN);
        }
    }
    @Override
    public String toString() {
        return kartyapakli.length + " lapos kártyapakli " +
                JOKER_SZIN + " joker színnel.";
    }
}


