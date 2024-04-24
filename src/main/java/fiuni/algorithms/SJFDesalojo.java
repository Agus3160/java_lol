package fiuni.algorithms;

import java.util.List;

import fiuni.model.BCP;
import fiuni.utils.Utils;

/**
 * SFJDesalojo
 */
public class SJFDesalojo {

  public static void ejecutar(List<BCP> procesos) {

    int tiempoActual = 0;
    int totalTiempoEspera = 0;
    int totalTiempoRespuesta = 0;

    int tiempoTotal = Utils.obtenerTiempoTotal(procesos);
    String grafico[][] = Utils.dibujarTablaProcesos(procesos, tiempoTotal);

    while (tiempoActual < tiempoTotal) {
      BCP currentBcp = null;
      int currentRow = 0;

      for (int j = 0; j < procesos.size(); j++) {
        BCP pTemp = procesos.get(j); // Proceso en ser verificado
        
        if (pTemp.getTiempoLlegada() <= tiempoActual && pTemp.getRafagasEjecutadas() < pTemp.getRafaga()) {

          if (currentBcp == null || (currentBcp.getRafaga() - currentBcp.getRafagasEjecutadas()) > pTemp.getRafaga()) { 
            currentBcp = pTemp;
            currentRow = j;
          }
       
        }

        grafico[j][tiempoActual] = (pTemp.getRafagasEjecutadas() < pTemp.getRafaga() && pTemp.getTiempoLlegada() <= tiempoActual) ? " W " : " 0 ";
      
      }

      if (currentBcp != null) {
        grafico[currentRow][tiempoActual] = " 1 ";
        currentBcp.setRafagasEjecutadas(currentBcp.getRafagasEjecutadas() + 1);

        if (currentBcp.getRafagasEjecutadas() == currentBcp.getRafaga()) {
          totalTiempoEspera += tiempoActual + 1 - currentBcp.getTiempoLlegada() - currentBcp.getRafagasEjecutadas();
          totalTiempoRespuesta += tiempoActual + 1 - currentBcp.getTiempoLlegada() - (currentBcp.getRafagasEjecutadas() -1);
        }
      }

      tiempoActual++;
    }
    // Mostrar el gráfico
    Utils.mostrarGrafico(grafico, procesos);

    // Calcular promedios
    Utils.calcularPromedios(totalTiempoEspera, totalTiempoRespuesta, procesos.size());

  }

}
