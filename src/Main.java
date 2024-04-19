
import elementi.ElementoMultimediale;
import elementi.Immagine;
import elementi.RegistrazioneAudio;
import elementi.Video;
import lettore.LettoreMultimediale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inizializzazione degli elementi multimediali
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Esempio di inizializzazione di alcuni elementi (puoi personalizzare secondo necessità)
        elementi[0] = new RegistrazioneAudio("Registrazione 1", 3, 5);
        elementi[1] = new Video("Video 1", 2, 6, 8);
        elementi[2] = new Immagine("Immagine 5", 10);
        elementi[3] = new RegistrazioneAudio("Registrazione 2", 8, 3);
        elementi[4] = new Immagine("Immagine 2", 5);

        // Creazione del lettore multimediale
        LettoreMultimediale lettore = new LettoreMultimediale(elementi);

        // Interazione con l'utente per eseguire gli elementi
        int scelta;
        do {
            System.out.println("Quale elemento vuoi eseguire? (1-5 per eseguire un elemento, 0 per uscire)");
            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= 5) {
                lettore.eseguiElemento(scelta - 1);
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        scanner.close();
    }
}
