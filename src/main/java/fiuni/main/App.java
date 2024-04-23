package fiuni.main;

import fiuni.process_model.BCP;
import fiuni.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import fiuni.algorithms.FCFS;
import fiuni.algorithms.SJF;
import fiuni.algorithms.SJFDesalojo;

public class App {
    public static void main(String[] args) {
        // Crear una lista de procesos de ejemplo (puedes leerlos desde un archivo CSV
        // en su lugar)
        List<BCP> procesos = new ArrayList<>();
        procesos.add(new BCP("P1", 0, 5));
        procesos.add(new BCP("P2", 2, 3));
        procesos.add(new BCP("P3", 4, 4));
        procesos.add(new BCP("P4", 6, 2));
        procesos.add(new BCP("P5", 6, 3));
        procesos.add(new BCP("P6", 8, 4));

        // Ejecutar el algoritmo SJF
        FCFS.ejecutar(procesos);

        // Ejecutar el algoritmo FCFS
        SJFDesalojo.ejecutar(procesos);

        // Reiniciar las rafagas de ejecución
        Utils.reiniciarRafagasEjecutadas(procesos);

        // Ejecutar el algoritmo SJF
        SJF.ejecutar(procesos);

        // Reiniciar las rafagas de ejecución
        Utils.reiniciarRafagasEjecutadas(procesos);

        
        
    }
}
