package fiuni.main;

import fiuni.process_model.Process;

import java.util.ArrayList;
import java.util.List;

import fiuni.algorithms.FCFS;

public class App {
    public static void main(String[] args) {
        // Crear una lista de procesos de ejemplo (puedes leerlos desde un archivo CSV
        // en su lugar)
        List<Process> procesos = new ArrayList<>();
        procesos.add(new Process("P1", 0, 5));
        procesos.add(new Process("P2", 2, 3));
        procesos.add(new Process("P3", 4, 4));
        procesos.add(new Process("P4", 6, 2));
        procesos.add(new Process("P5", 8, 4));

        // Ejecutar el algoritmo FCFS
        FCFS.ejecutar(procesos);
    }
}
