import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();

        System.out.print("Wpisz liczbe pudelek: ");
        int liczba_pudelek = scan.nextInt();

        System.out.print("Wpisz liczbe rund: ");
        int liczba_rund = scan.nextInt();

        System.out.print("Wybierz strategie (1 zeby zmieniac pudelko, 0 zeby nie zmieniac): ");
        int strategia_gracza = scan.nextInt();

        System.out.print("Wpisz liczbe otwieranych pudelek: ");
        int liczba_otwieranych_pudel = scan.nextInt();

        int wygranaCount = 0;
        int przegranaCount = 0;

        for (int rundy = 0; rundy < liczba_rund; rundy++) {
            int nagroda_pudelko = generator.nextInt(liczba_pudelek) + 1;
            int wybrane_pudelko = generator.nextInt(liczba_pudelek) + 1;


            boolean[] otwarte_pudelka = new boolean[liczba_pudelek + 1];


            for (int i = 0; i < liczba_otwieranych_pudel; i++) {
                int puste_pudelko_prowadzacy;
                do {
                    puste_pudelko_prowadzacy = generator.nextInt(liczba_pudelek) + 1;
                } while (puste_pudelko_prowadzacy == wybrane_pudelko || puste_pudelko_prowadzacy == nagroda_pudelko || otwarte_pudelka[puste_pudelko_prowadzacy]);

                otwarte_pudelka[puste_pudelko_prowadzacy] = true;
            }


            if (strategia_gracza == 1) {
                int nowe_wybrane_pudelko;
                do {
                    nowe_wybrane_pudelko = generator.nextInt(liczba_pudelek) + 1;
                } while (nowe_wybrane_pudelko == wybrane_pudelko || otwarte_pudelka[nowe_wybrane_pudelko]);
                wybrane_pudelko = nowe_wybrane_pudelko;
            }


            if (wybrane_pudelko == nagroda_pudelko) {
                System.out.println("WYGRANA");
                wygranaCount++;
            } else {
                System.out.println("PRZEGRANA");
                przegranaCount++;
            }
        }


        System.out.println("Total WYGRANA: " + wygranaCount);
        System.out.println("Total PRZEGRANA: " + przegranaCount);
        double procent_wygranych = ((double) wygranaCount / liczba_rund) * 100;
        System.out.printf("Wygrane: %.2f%%\n", procent_wygranych);
    }
}
