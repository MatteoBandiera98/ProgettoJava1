package lettore;



import java.util.Scanner; // Importazione della classe Scanner

import elementi.ElementoMultimediale;
import elementi.Immagine;
import elementi.Riproducibile;

public class LettoreMultimediale {
    private ElementoMultimediale[] elementi;

    public LettoreMultimediale(ElementoMultimediale[] elementi) {
        this.elementi = elementi;
    }

    public void eseguiElemento(int indice) {
        if (indice >= 0 && indice < elementi.length) {
            if (elementi[indice] instanceof Riproducibile) {
                ((Riproducibile) elementi[indice]).play();
            } else if (elementi[indice] instanceof Immagine) {
                ((Immagine) elementi[indice]).show();
            } else {
                System.out.println("Elemento non riproducibile.");
            }
        } else {
            System.out.println("Indice non valido.");
        }
    }

    public void interagisciConUtente() {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("Quale elemento vuoi eseguire? (0 per uscire)");
            for (int i = 0; i < elementi.length; i++) {
                System.out.println((i + 1) + ". " + elementi[i].getTitolo());
            }

            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= elementi.length) {
                eseguiElemento(scelta - 1);
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }
}
