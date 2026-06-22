package ucu.edu.aed.tda.clasificacion;

import ucu.edu.aed.tda.clasificacion.respuestas.parte2.TClasificadorImp;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TClasificadorImp clasificador = new TClasificadorImp();
        Integer[] incrementos = { 5, 3, 1 };

        // Vectores chicos de cada tipo (paso 1 y paso 6)
        int[] ascendente  = { 1, 2, 3, 4, 5 };
        int[] descendente = { 5, 4, 3, 2, 1 };
        int[] aleatorio   = { 5, 2, 8, 1, 3 };

        System.out.println("===== INSERCION DIRECTA =====");
        insercion(clasificador, "ascendente",  ascendente);
        insercion(clasificador, "descendente", descendente);
        insercion(clasificador, "aleatorio",   aleatorio);

        System.out.println("\n===== SHELLSORT (5, 3, 1) =====");
        shell(clasificador, "ascendente",  ascendente,  incrementos);
        shell(clasificador, "descendente", descendente, incrementos);
        shell(clasificador, "aleatorio",   aleatorio,   incrementos);

        System.out.println("\n===== BURBUJA =====");
        burbuja(clasificador, "ascendente",  ascendente);
        burbuja(clasificador, "descendente", descendente);
        burbuja(clasificador, "aleatorio",   aleatorio);
    }

    static void insercion(TClasificadorImp c, String tipo, int[] original) {
        int[] copia = original.clone();   // copia para no pisar el original
        c.insercionDirecta(copia);
        reportar("Insercion directa", tipo, original, copia, c);
    }

    static void shell(TClasificadorImp c, String tipo, int[] original, Integer[] inc) {
        int[] copia = original.clone();
        c.shell(copia, inc);
        reportar("Shellsort", tipo, original, copia, c);
    }

    static void burbuja(TClasificadorImp c, String tipo, int[] original) {
        int[] copia = original.clone();
        c.burbuja(copia);
        reportar("Burbuja", tipo, original, copia, c);
    }

    static void reportar(String algo, String tipo, int[] original, int[] resultado, TClasificadorImp c) {
        System.out.println(algo + " / " + tipo);
        System.out.println("  entrada:    " + Arrays.toString(original));
        System.out.println("  salida:     " + Arrays.toString(resultado));
        System.out.println("  ordenado?   " + c.estaOrdenado(resultado));
        System.out.println("-----------"); // i just wanted an empty line teach
    }
}