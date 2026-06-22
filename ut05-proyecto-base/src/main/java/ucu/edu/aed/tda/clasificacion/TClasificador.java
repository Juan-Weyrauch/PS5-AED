package ucu.edu.aed.tda.clasificacion;

public abstract class TClasificador {

    /**
     * Ordena el vector por inserción directa
     */
    public abstract void insercionDirecta(int[] datos);

    /**
     * Ordena el vector utilizando shellsort con un vector de incrementos datos
     */
    public abstract void shell(int[] datos, Integer[] incrementos);

    /**
     * Ordena el vector utilizando la técnica de Burbuja
     */
    public abstract void burbuja(int[] datos);


    public abstract void quicksort(int[] datos);

    /**
     * método auxiliar y utilizado en quicksort
     * devuelve un valor del vector ubicado entre i <= x < j
     */
    protected abstract int obtenerPivote(int[] datos, int i, int j);

    /**
     * método auxiliar y utilizado en quicksort
     */
    protected abstract int particion(int[] datos, int i, int j, int pivote);

    /**
     * Ordena el vector utilizando clasificación directa
     */
    public abstract void clasificacionDirecta(int[] datos);

    /**
     * Ordena el vector utilizando heapsort
     */
    public abstract void heapsort(int[] datos);

    /**
     * método auxiliar y utilizado en heapsort
     */
    protected abstract void desplazaElemento(int[] datos, int primero, int ultimo);

    /**
     * método de ayuda para intercambiar valores en un vector dados sus índices
     */
    protected void intercambiar(int[] datos, int i, int j) {
        int aux = datos[i];
        datos[i] = datos[j];
        datos[j] = aux;
    }

    /**
     * calcula el tiempo de ejecución de una tarea en milisegundos
     */
    public long medirTiempoDeEjecución(Runnable tarea) {
        long start = System.currentTimeMillis();

        tarea.run();

        return (System.currentTimeMillis() - start);
    }


}
