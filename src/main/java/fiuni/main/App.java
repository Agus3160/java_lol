package fiuni.main;

import fiuni.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import fiuni.algorithms.FCFS;
import fiuni.algorithms.Priority;
import fiuni.algorithms.RR;
import fiuni.algorithms.SJF;
import fiuni.algorithms.SJFDesalojo;
import fiuni.model.BCP;

public class App {
    public static void main(String[] args) {
        // Crear una lista de procesos de ejemplo (puedes leerlos desde un archivo CSV
        // en su lugar)
        List<BCP> procesos = new ArrayList<>();
        procesos.add(new BCP("P1", 0, 3));
        procesos.add(new BCP("P2", 1, 4));
        procesos.add(new BCP("P3", 2,5));
        procesos.add(new BCP("P4", 3,2));
        procesos.add(new BCP("P5", 4,6));
        procesos.add(new BCP("P6", 4,3));
        procesos.add(new BCP("P7", 4, 3));


        //Crear una lista de procesos con prioridad
        List<BCP> procesosPriority = new ArrayList<>();
        procesosPriority.add(new BCP("P1", 0, 5, 2));
        procesosPriority.add(new BCP("P2", 2, 3, 5));
        procesosPriority.add(new BCP("P3", 4, 4, 7));
        procesosPriority.add(new BCP("P4", 6, 2, 8));
        procesosPriority.add(new BCP("P5", 6, 3, 1));
        procesosPriority.add(new BCP("P6", 8, 4, 9));

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

        // Ejecutar el algoritmo Prioridad
        Priority.ejecutar(procesosPriority);

        // Reiniciar las rafagas de ejecución
        Utils.reiniciarRafagasEjecutadas(procesos);

        // Ejecutar el algoritmo RR
        RR.ejecutar(procesos, 4);
        
    }
}
