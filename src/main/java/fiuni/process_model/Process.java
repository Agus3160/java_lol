package fiuni.process_model;

public class Process {
  
  private String nombre = null;
  private int tiempoLlegada = 0;
  private int rafaga = 0;
  private int prioridad = 0;

  public Process(String nombre, int tiempoLlegada, int rafaga, int prioridad) {
    this.nombre = nombre;
    this.tiempoLlegada = tiempoLlegada;
    this.rafaga = rafaga;
    this.prioridad = prioridad;
  }

  //Constructor para procesos que no tengan prioridad
  public Process(String nombre, int tiempoLlegada, int rafaga) {
    this(nombre, tiempoLlegada, rafaga, 0); 
  }

  public String getNombre() {
    return this.nombre;
  }

  public int getTiempoLlegada() {
    return this.tiempoLlegada;
  }

  public int getRafaga() {
    return this.rafaga;
  }

  public int getPrioridad() {
    return this.prioridad;
  }
}
