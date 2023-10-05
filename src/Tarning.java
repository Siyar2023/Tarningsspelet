import java.util.Scanner;
import java.util.Random;

public class Tarning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Användaren väljer antal spelare
        System.out.print("Ange antal spelare (minst 2): ");
        int antalSpelare = scanner.nextInt();

        if (antalSpelare < 2) {
            System.out.println("Det måste vara minst 2 spelare för att spela.");
            return;
        }

        // Skapa en array för spelarnas poäng
        int[] spelarPoang = new int[antalSpelare];
        String[] spelarNamn = new String[antalSpelare];

        // Användaren anger spelarnas namn
        for (int i = 0; i < antalSpelare; i++) {
            System.out.print("Ange namn för spelare " + (i + 1) + ": ");
            spelarNamn[i] = scanner.next();
        }

        // Användaren väljer antal tärningar
        System.out.print("Ange antal tärningar att kasta: ");
        int antalTarningar = scanner.nextInt();

        // Kasta tärningarna och räkna poäng
        for (int runda = 1; runda <= 3; runda++) { // 3 rundor
            System.out.println("Runda " + runda + ":");
            for (int spelareIndex = 0; spelareIndex < antalSpelare; spelareIndex++) {
                int poangForRunda = kastaTarningar(antalTarningar);
                spelarPoang[spelareIndex] += poangForRunda;
                System.out.println(spelarNamn[spelareIndex] + " kastade " + antalTarningar + " tärning/ar och fick " + poangForRunda + " poäng.");
            }
        }

        // Hitta vinnaren
        int maxPoang = spelarPoang[0];
        int vinnareIndex = 0;

        for (int i = 1; i < antalSpelare; i++) {
            if (spelarPoang[i] > maxPoang) {
                maxPoang = spelarPoang[i];
                vinnareIndex = i;
            }
        }

        System.out.println("Spelaren " + spelarNamn[vinnareIndex] + " vinner med " + maxPoang + " poäng!");
    }

    // Funktion för att kasta tärningar och returnera poängen
    public static int kastaTarningar(int antalTarningar) {
        Random random = new Random();
        int poang = 0;

        for (int i = 0; i < antalTarningar; i++) {
            poang += random.nextInt(6) + 1; // Slumpmässigt tal mellan 1 och 6
        }

        return poang;
    }
}