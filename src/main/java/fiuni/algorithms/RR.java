package fiuni.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import fiuni.model.BCP;
import fiuni.utils.Utils;

public class RR {
  public static void ejecutar(List<BCP> procesos, int quantum) {

    int tiempoActual = 0;

    int totalTiempoRespuesta = 0;
    int totalTiempoEspera = 0;

    // Lista de Cola de procesos
    Queue<BCP> colaProcesos = new LinkedList<BCP>();

    // Crear matriz para representar el gráfico
    int tiempoTotal = Utils.obtenerTiempoTotal(procesos); 
    String grafico[][] = Utils.dibujarTablaProcesos(procesos, tiempoTotal);

    // Buscar el proceso más corto que esté listo para ejecutarse
    BCP currentProcess = null;

    while (tiempoActual < tiempoTotal) {

      // Buscar el proceso que esté listo para ejecutarse
      for (BCP proceso : procesos) {
        if (proceso.getTiempoLlegada() <= tiempoActual && proceso.getRafagasEjecutadas() != proceso.getRafaga() && !colaProcesos.contains(proceso)) {
          colaProcesos.add(proceso);
        }
      }

      if (currentProcess == null) {
        
        currentProcess = colaProcesos.poll();
        int rafagasPorEjecutar = currentProcess.getRafaga() - currentProcess.getRafagasEjecutadas();
        int tiempoDeEjecucion = 0;

        if(currentProcess.getRafagasEjecutadas() == 0){
          totalTiempoRespuesta += tiempoActual - currentProcess.getTiempoLlegada() + 1;
        }

        if(rafagasPorEjecutar > quantum){

          currentProcess.setRafagasEjecutadas(currentProcess.getRafagasEjecutadas() + quantum);
          tiempoDeEjecucion = quantum;
          colaProcesos.add(currentProcess);

        }else {

          currentProcess.setRafagasEjecutadas(currentProcess.getRafagasEjecutadas() + rafagasPorEjecutar);
          tiempoDeEjecucion = rafagasPorEjecutar;

        }
        
        for(BCP p : procesos){
          for(int i = tiempoActual; i < tiempoActual + tiempoDeEjecucion; i++){
            if(p == currentProcess)grafico[procesos.indexOf(currentProcess)][i] = " 1 ";
            else if (p.getRafagasEjecutadas() < p.getRafaga() && p.getTiempoLlegada() <= i){ 
              grafico[procesos.indexOf(p)][i] = " W ";
              totalTiempoEspera++;
            }
          }
        }

        currentProcess = null;
        tiempoActual += tiempoDeEjecucion;
      }

    }
  
    // Mostrar el gráfico
    Utils.mostrarGrafico(grafico, procesos);

    // Calcular promedios
    Utils.calcularPromedios(totalTiempoEspera, totalTiempoRespuesta, procesos.size());
  }
}
