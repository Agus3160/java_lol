package fiuni.algorithms;

import java.util.LinkedList;
import java.util.Queue;

import fiuni.model.BCP;

public class Cola {
    private Queue<BCP> colaProcesos;

    public Cola() {
        this.colaProcesos = new LinkedList<>();
    }

    public void insert(BCP elemento) {
      colaProcesos.add(elemento); // Agregar el elemento al final de la cola
    }

    public BCP remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return colaProcesos.poll(); // Eliminar y devolver el primer elemento de la cola
    }

    public BCP peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return colaProcesos.peek(); // Obtener el primer elemento de la cola sin eliminarlo
    }

    public boolean isEmpty() {
        return colaProcesos.isEmpty(); // Verificar si la cola está vacía
    }

    public int size() {
        return colaProcesos.size(); // Devolver el tamaño de la cola
    }
}
