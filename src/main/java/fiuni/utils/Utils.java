package fiuni.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;

import fiuni.model.BCP;

public class Utils {
   
  // Obtener el tiempo total del grafico
   static public int obtenerTiempoTotal(List<BCP> procesos) {
    int tiempoTotal = 0;
    for (BCP proceso : procesos) {
        tiempoTotal += proceso.getRafaga();
    }
    return tiempoTotal;
   }

   // Crear matriz para representar el gráfico
   static public String[][] dibujarTablaProcesos(List<BCP> procesos, int tiempoTotal) {
    String[][] grafico = new String[procesos.size()][tiempoTotal];
    for (String[] row : grafico) {
        for (int i = 0; i < row.length; i++) {
            row[i] = " 0 ";
        }
    }
    return grafico;
   }


   // Mostrar el gráfico
   static public void mostrarGrafico(String[][] grafico, List<BCP> p) {
    System.out.println("\nGráfico:");
    for (int i = 0; i < grafico.length; i++) {
        System.out.print("P" + p.get(i).getNombre() + ": ");
        for (String c : grafico[i]) {
            System.out.print(c);
        }
        System.out.println();
    }
   }

   //Calcular promedios
   static public void calcularPromedios(int tiempoEsperaTotal, int tiempoRespuestaTotal, int procesosCant){
        // Calcular promedios
        double promedioEspera = (double) tiempoEsperaTotal / procesosCant;
        double promedioRespuesta = (double) tiempoRespuestaTotal / procesosCant;

        System.out.printf("\nTiempo promedio de espera: %.2f \n", promedioEspera);
        System.out.printf("Tiempo promedio de respuesta: %.2f \n", promedioRespuesta);
   }

   static public boolean reiniciarRafagasEjecutadas(List<BCP> procesos){
    for(BCP p : procesos){
        try{
            p.setRafagasEjecutadas(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    return true;
   }

   
   /**
    * Ordena la lista de procesos por tiempo de llegada
    */
   private static class BCPComparatorTiempoLlegada implements Comparator<BCP> {
        @Override
        public int compare(BCP p1, BCP p2) {
        // Compare based on arrival time
        return p1.getTiempoLlegada() - p2.getTiempoLlegada();
        }
    }

    /**
     * Ordena la lista de procesos por tiempo de llegada
     * @param procesos La lista de procesos que seran procesados
     * @return La lista de procesos ordenada por tiempo de llegada
     */
   static public List<BCP> ordenarPorLlegada(List<BCP> procesos){
       procesos.sort(new BCPComparatorTiempoLlegada());
       return procesos;
   }

   static public boolean mandarPrimerProcesoAlFondo(Queue<BCP> procesos){
        BCP primerProceso = procesos.poll();
        return procesos.add(primerProceso);
   }
   

       
}
