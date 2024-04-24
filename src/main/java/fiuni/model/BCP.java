package fiuni.model;

public class BCP {
  
  private String nombre = null;
  private int tiempoLlegada = 0;
  private int rafaga = 0;
  private int prioridad = 0;
  private int estado = 0;
  private int rafagasEjecutadas = 0;

  public BCP(String nombre, int tiempoLlegada, int rafaga, int prioridad, int estado, int rafagasEjecutadas) {
    this.nombre = nombre;
    this.tiempoLlegada = tiempoLlegada;
    this.rafaga = rafaga;
    this.prioridad = prioridad;
    this.estado = estado;
    this.rafagasEjecutadas = rafagasEjecutadas;
  }

  //Constructor para procesos que no tengan prioridad
  public BCP(String nombre, int tiempoLlegada, int rafaga) {
    this(nombre, tiempoLlegada, rafaga, 0, 0, 0); 
  }

  //Constructor para procesos que no tengan prioridad
  public BCP(String nombre, int tiempoLlegada, int rafaga, int prioridad) {
    this(nombre, tiempoLlegada, rafaga, prioridad, 0, 0); 
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

  public int getEstado() {
    return this.estado;
  }

  public void setPrioridad(int prioridad) {
    this.prioridad = prioridad;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setTiempoLlegada(int tiempoLlegada) {
    this.tiempoLlegada = tiempoLlegada;
  }

  public void setRafaga(int rafaga) {
    this.rafaga = rafaga;
  }

  public String toString() {
    return this.getNombre() + " | " + this.getTiempoLlegada() + " | " + this.getRafaga() + " | " + this.getPrioridad() + " | " + this.getEstado();
  }

  public int getRafagasEjecutadas() {
    return rafagasEjecutadas;
  }

  public void setRafagasEjecutadas(int rafagasEjecutadas) {
    this.rafagasEjecutadas = rafagasEjecutadas;
  }
}
