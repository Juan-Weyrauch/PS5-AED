package ucu.edu.aed.tda.clasificacion;

import ucu.edu.aed.tda.clasificacion.respuestas.parte2.TClasificadorImp;

public class MedicionTiempos {
    public static void main(String[] args) {
        TClasificadorImp clasificador = new TClasificadorImp();
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos();
        Integer[] incrementos = { 5, 3, 1 };

        // Vectores grandes (32000) de cada tipo, generados una sola vez
        int[] ascendente = generador.generarDatosAscendentes();
        int[] descendente = generador.generarDatosDescendentes();
        int[] aleatorio = generador.generarDatosAleatorios();

        int n = ascendente.length;
        System.out.println("Tamaño del vector: " + n + " elementos");
        System.out.println("Tiempos en milisegundos (ms)\n");
        System.out.printf("%-22s %12s %12s %12s%n",
                "Algoritmo", "Ascendente", "Descendente", "Aleatorio");

        System.out.printf("%-22s %12d %12d %12d%n", "Insercion directa",
                tiempoInsercion(clasificador, ascendente),
                tiempoInsercion(clasificador, descendente),
                tiempoInsercion(clasificador, aleatorio));

        System.out.printf("%-22s %12d %12d %12d%n", "Shellsort (5,3,1)",
                tiempoShell(clasificador, ascendente, incrementos),
                tiempoShell(clasificador, descendente, incrementos),
                tiempoShell(clasificador, aleatorio, incrementos));

        System.out.printf("%-22s %12d %12d %12d%n", "Burbuja",
                tiempoBurbuja(clasificador, ascendente),
                tiempoBurbuja(clasificador, descendente),
                tiempoBurbuja(clasificador, aleatorio));

        System.out.printf("%-22s %12d %12d %12d%n", "Quicksort",
                tiempoQuicksort(clasificador, ascendente),
                tiempoQuicksort(clasificador, descendente),
                tiempoQuicksort(clasificador, aleatorio));
    }

    static long tiempoInsercion(TClasificadorImp c, int[] base) {
        int[] copia = base.clone(); // copia fresca: cada medición ordena el mismo dato original
        return c.medirTiempoDeEjecución(() -> c.insercionDirecta(copia));
    }

    static long tiempoShell(TClasificadorImp c, int[] base, Integer[] inc) {
        int[] copia = base.clone();
        return c.medirTiempoDeEjecución(() -> c.shell(copia, inc));
    }

    static long tiempoBurbuja(TClasificadorImp c, int[] base) {
        int[] copia = base.clone();
        return c.medirTiempoDeEjecución(() -> c.burbuja(copia));
    }

    static long tiempoQuicksort(TClasificadorImp c, int[] base) {
        int[] copia = base.clone();
        return c.medirTiempoDeEjecución(() -> c.quicksort(copia));
    }
}