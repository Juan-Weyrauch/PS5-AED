package ucu.edu.aed.tda.clasificacion.respuestas.parte2;

import ucu.edu.aed.tda.clasificacion.TClasificador;

public class TClasificadorImp extends TClasificador {

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

    // para poder compilar.
    @Override
    protected int obtenerPivote(int[] datos, int i, int j) {
        throw new UnsupportedOperationException("No usado en esta entrega");
    }

    @Override
    protected int particion(int[] datos, int i, int j, int pivote) {
        throw new UnsupportedOperationException("No usado en esta entrega");
    }

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
