package fiuni.algorithms;

import java.util.List;

import fiuni.model.BCP;
import fiuni.utils.Utils;

// Clase para implementar el algoritmo FCFS
public class FCFS {
    public static void ejecutar(List<BCP> procesos) {
        
        int tiempoActual = 0;
        int totalTiempoEspera = 0;
        int totalTiempoRespuesta = 0;

        int tiempoTotal = Utils.obtenerTiempoTotal(procesos);
        String grafico[][] = Utils.dibujarTablaProcesos(procesos, tiempoTotal);

        while(tiempoActual < tiempoTotal) {

            for (int j = 0; j < procesos.size(); j++) {
              
              BCP pTemp = procesos.get(j); //Proceso en ser verificado
              int tiempoPrimeraEjecucion = 0;  //Tiempo de la primera vez que se ejecuta el proceso
              
              //Ejecutar peroceso si es que el tiempo actual corresponde a su tiempo de llegada o si el tiempo actual sobre pasa al tiempo de llegada
              if (pTemp.getTiempoLlegada() <= tiempoActual) {
                
                //Obtener tiempo de respuesta
                tiempoPrimeraEjecucion = tiempoActual;
                totalTiempoEspera += tiempoPrimeraEjecucion - pTemp.getTiempoLlegada();
                
                //Obtener el tiempo de respuesta que seria cuando el proceso se ejecutara por primera vez
                totalTiempoRespuesta += tiempoPrimeraEjecucion - pTemp.getTiempoLlegada() + 1;
                
                //Dibujamos en la matriz los nodos de tiempo que el proceso en cuestion esta de espera
                for(int k = pTemp.getTiempoLlegada(); k < tiempoActual; k++){
                  grafico[j][k] = " w ";
                }

                //Dibujamos en la matriz el proceso en cuestion siendo ejecutado
                while(tiempoActual - tiempoPrimeraEjecucion < pTemp.getRafaga()){
                  grafico[j][tiempoActual] = " 1 ";
                  tiempoActual++;
                }
              }

            }
        }

        // Mostrar el gráfico
        Utils.mostrarGrafico(grafico, procesos);

        // Calcular promedios
        Utils.calcularPromedios(totalTiempoEspera, totalTiempoRespuesta, procesos.size());

    }
}