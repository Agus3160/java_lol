package fiuni.algorithms;

import fiuni.process_model.Process;
import java.util.List;

// Clase para implementar el algoritmo FCFS
public class FCFS {
    public static void ejecutar(List<Process> procesos) {
        int tiempoActual = 0;
        int tiempoEsperaTotal = 0;
        int tiempoRespuestaTotal = 0;

        System.out.println("Algoritmo: FCFS");
        System.out.println("Proceso   | Tiempo de Llegada | Ráfagas | Tiempo de Espera | Tiempo de Respuesta");
        System.out.println("--------------------------------------------------------------------------------");

        // Obtener el tiempo total del grafico
        int tiempoTotal = 0;
        for (Process proceso : procesos) {
            tiempoTotal += proceso.getRafaga();
        }

        // Crear matriz para representar el gráfico
        char[][] grafico = new char[procesos.size()][tiempoTotal + 1];
        for (char[] row : grafico) {
            for (int i = 0; i < row.length; i++) {
                row[i] = '-';
            }
        }

        for (Process proceso : procesos) {
            // Calcular el tiempo de espera
            int tiempoEspera = Math.max(0, tiempoActual - proceso.getTiempoLlegada());
            tiempoEsperaTotal += tiempoEspera;

            // Calcular el tiempo de respuesta
            int tiempoRespuesta = tiempoEspera + proceso.getRafaga();
            tiempoRespuestaTotal += tiempoRespuesta;

            // Actualizar el tiempo actual
            tiempoActual = Math.max(tiempoActual, proceso.getTiempoLlegada()) + proceso.getRafaga();

            // Mostrar resultados del proceso
            System.out.printf("%-10s| %-19s| %-8s| %-17s| %-18s%n", proceso.getNombre(), proceso.getTiempoLlegada(), proceso.getRafaga(), tiempoEspera, tiempoRespuesta);

            // Actualizar el gráfico
            for (int i = 0; i < proceso.getRafaga(); i++) {
                grafico[Integer.parseInt(proceso.getNombre().substring(1)) - 1][tiempoEspera + i] = 'X';
            }
        }

        // Mostrar el gráfico
        System.out.println("\nGráfico:");
        for (int i = 0; i < grafico.length; i++) {
            System.out.print("P" + (i + 1) + ": ");
            for (char c : grafico[i]) {
                System.out.print(c);
            }
            System.out.println();
        }

        // Calcular promedios
        double promedioEspera = (double) tiempoEsperaTotal / procesos.size();
        double promedioRespuesta = (double) tiempoRespuestaTotal / procesos.size();

        System.out.println("\nTiempo promedio de espera: " + promedioEspera);
        System.out.println("Tiempo promedio de respuesta: " + promedioRespuesta);
    }
}