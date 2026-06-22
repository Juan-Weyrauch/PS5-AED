package ucu.edu.aed.tda.clasificacion.respuestas.parte2;

import java.util.Random;

import ucu.edu.aed.tda.clasificacion.TClasificador;

public class TClasificadorImp extends TClasificador {
    private final Random rand = new Random(); // se usa en obtener pivote. Para no hacer un nuevo elemento random por cada iteracion.

    @Override
    public void insercionDirecta(int[] datos) {
        for (int i = 1; i < datos.length; i++) {
            int clave = datos[i];
            int j = i - 1;
            // corro hacia la derecha los mayores que la clave
            while (j >= 0 && datos[j] > clave) {
                datos[j + 1] = datos[j];
                j--;
            }
            datos[j + 1] = clave; // inserto la clave en su lugar
        }
    }

    @Override
    public void shell(int[] datos, Integer[] incrementos) { // [O(n^1.25) - O(n^1.5)]
        for (int k = 0; k < incrementos.length; k++) {
            int h = incrementos[k];
            for (int i = h; i < datos.length; i++) {
                int aux = datos[i];
                int j = i - h;
                while (j >= 0 && aux < datos[j]) {
                    datos[j + h] = datos[j];
                    j = j - h;
                }
                datos[j + h] = aux;
            }
        }
    }

    @Override
    public void burbuja(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            for (int j = datos.length - 1; j >= i + 1; j--) {
                if (datos[j] < datos[j - 1]) {
                    intercambiar(datos, j, j - 1);
                }
            }
        }
    }

    public boolean estaOrdenado(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            if (datos[i] > datos[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void quicksort(int[] datos) {
        quicksort(datos, 0, datos.length - 1);
    }

    /**
     * método recursivo de quicksort
     */
    private void quicksort(int[] datos, int low, int high) {
        if (low < high) {
            int indicePivote = obtenerPivote(datos, low, high); // deja el pivote en 'high' y devuelve ese índice
            int pivote = datos[indicePivote];
            int k = particion(datos, low, high, pivote); // Lomuto: deja el pivote en su lugar final 'k'
            quicksort(datos, low, k - 1);
            quicksort(datos, k + 1, high);
        }
    }

    @Override
    protected int obtenerPivote(int[] datos, int low, int high) {
        int pivot = rand.nextInt(high - low + 1) + low; // índice al azar en [low, high]
        intercambiar(datos, pivot, high); // muevo el pivote al final
        return high; // devuelvo el ÍNDICE del pivote
    }

    @Override
    protected int particion(int[] datos, int low, int high, int pivote) {
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (datos[j] < pivote) {
                i++;
                intercambiar(datos, i, j);
            }
        }

        // swap datos[i+1] and datos[high] (or pivot)
        int temp = datos[i + 1];
        datos[i + 1] = datos[high];
        datos[high] = temp;

        return i + 1;
    }

    // para poder compilar.
    @Override
    public void clasificacionDirecta(int[] datos) {
        throw new UnsupportedOperationException("No usado en esta entrega");
    }

    @Override
    public void heapsort(int[] datos) {
        throw new UnsupportedOperationException("No usado en esta entrega");
    }

    @Override
    protected void desplazaElemento(int[] datos, int primero, int ultimo) {
        throw new UnsupportedOperationException("No usado en esta entrega");
    }
}
