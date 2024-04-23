package fiuni.algorithms;

import java.util.HashMap;
import java.util.List;
import fiuni.process_model.BCP;
import fiuni.utils.Utils;

public class SJF {

  public static void ejecutar(List<BCP> procesos) {

    int tiempoActual = 0;

    int totalTiempoRespuesta = 0;
    int totalTiempoEspera = 0;

    // Crear una lista para mantener los procesos que aún no han llegado
    HashMap<BCP, Integer> pendientes = new HashMap<BCP, Integer>();

    for(int i = 0; i < procesos.size(); i++){
      pendientes.put(procesos.get(i), (i));
    }

    // Crear matriz para representar el gráfico
    int tiempoTotal = Utils.obtenerTiempoTotal(procesos); 
    String grafico[][] = Utils.obtenerTiempoLlegadaTotal(procesos, tiempoTotal);

    // Buscar el proceso más corto que esté listo para ejecutarse
    BCP procesoEjecutar = null;

    while (tiempoActual < tiempoTotal) {

      if(procesoEjecutar == null){
        for (BCP proceso : pendientes.keySet()) {
          if (proceso.getTiempoLlegada() <= tiempoActual && (procesoEjecutar == null || proceso.getRafaga() < procesoEjecutar.getRafaga())) {
            procesoEjecutar = proceso;
          }
        }
      }

      // Ejecutar el proceso encontrado
      for(BCP process : pendientes.keySet()){
        if(process == procesoEjecutar){
          grafico[pendientes.get(process)][tiempoActual] = " 1 ";
          procesoEjecutar.setRafagasEjecutadas(procesoEjecutar.getRafagasEjecutadas() + 1);
        }else if(process.getTiempoLlegada() <= tiempoActual && process.getRafaga() != process.getRafagasEjecutadas()){
          grafico[pendientes.get(process)][tiempoActual] = " W ";
        }else{
          grafico[pendientes.get(process)][tiempoActual] = " 0 ";
        }
      }

      // Calcular tiempos de espera y respuesta
      if (procesoEjecutar.getRafagasEjecutadas() == procesoEjecutar.getRafaga()) {
        totalTiempoEspera += tiempoActual + 1 - procesoEjecutar.getTiempoLlegada() - procesoEjecutar.getRafagasEjecutadas();
        totalTiempoRespuesta += tiempoActual + 1 - procesoEjecutar.getTiempoLlegada() - (procesoEjecutar.getRafagasEjecutadas() - 1);
        pendientes.remove(procesoEjecutar); // Eliminar el proceso de la lista de pendientes
        procesoEjecutar = null;
      }

      tiempoActual++;
    }

    // Mostrar el gráfico
    Utils.mostrarGrafico(grafico, procesos);

    // Calcular promedios
    double promedioEspera = (double) totalTiempoEspera / procesos.size();
    double promedioRespuesta = (double) totalTiempoRespuesta / procesos.size();

    System.out.println("\nTiempo promedio de espera: " + promedioEspera);
    System.out.println("Tiempo promedio de respuesta: " + promedioRespuesta);
  }
}
