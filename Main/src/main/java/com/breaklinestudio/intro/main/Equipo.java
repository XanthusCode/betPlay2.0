package com.breaklinestudio.intro.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Equipo {

    private String nombre;
    private int id;
    private String apellidos;
    private int edad;
    private int PJ; // Partidos jugados
    private int PG; // Partidos ganados
    private int PE; // Partidos empatados.
    private int PP; // Partidos perdidos
    private int TP; // Total de puntos
    private int GF; // Goles a favor
    private int GC; // Goles en contra
    private List<Jugador> jugadores;
    private List<MiembroTecnico> cuerpoTecnico;
    private List<MiembroMedico> cuerpoMedico;

    public Equipo(String nombre, int id, String apellidos, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.apellidos = apellidos;
        this.edad = edad;
        this.jugadores = new ArrayList<>();
        this.cuerpoTecnico = new ArrayList<>();
        this.cuerpoMedico = new ArrayList<>();
    }

    // Métodos para agregar jugadores, miembros técnicos, etc.
    public void agregarJugador(String nombre, int dorsal, String posicion, String nacionalidad, Date fechaIngreso, int golesAnotados, int totalTarjetasRojas, int totalTarjetasAmarillas, int totalTarjetasRojas1, String nacionalidad1, int totalTarjetasAmarillas1) {
        Jugador jugador = new Jugador(nombre, dorsal, posicion, nacionalidad, fechaIngreso, golesAnotados, totalTarjetasRojas, totalTarjetasAmarillas, id, apellidos, edad);
        jugadores.add(jugador);
    }

    public void agregarMiembroTecnico(String nombre, String rol) {
        MiembroTecnico tecnico = new MiembroTecnico(nombre, rol, id, apellidos, edad);
        cuerpoTecnico.add(tecnico);
    }

    public void agregarMiembroMedico(String nombre, String rol) {
        MiembroMedico medico = new MiembroMedico(nombre, rol, id, apellidos, edad);
        cuerpoMedico.add(medico);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPJ() {
        return PJ;
    }

    public void setPJ(int PJ) {
        this.PJ = PJ;
    }

    public int getPG() {
        return PG;
    }

    public void setPG(int PG) {
        this.PG = PG;
    }

    public int getPE() {
        return PE;
    }

    public void setPE(int PE) {
        this.PE = PE;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public int getTP() {
        return TP;
    }

    public void setTP(int TP) {
        this.TP = TP;
    }

    public int getGF() {
        return GF;
    }

    public void setGF(int GF) {
        this.GF = GF;
    }

    public int getGC() {
        return GC;
    }

    public void setGC(int GC) {
        this.GC = GC;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<MiembroTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public void setCuerpoTecnico(List<MiembroTecnico> cuerpoTecnico) {
        this.cuerpoTecnico = cuerpoTecnico;
    }

    public List<MiembroMedico> getCuerpoMedico() {
        return cuerpoMedico;
    }

    public void setCuerpoMedico(List<MiembroMedico> cuerpoMedico) {
        this.cuerpoMedico = cuerpoMedico;
    }

    public int getPuntuacionTotal() {
        int puntuacionTotal = (this.PG * 3) + this.PE;
        return puntuacionTotal;
    }

}

// Clase Jugador
class Jugador extends Equipo {

    private int dorsal;
    private String posicion;
    private String nacionalidad;
    private Date fechaIngreso;
    private int golesAnotados;
    private int totalTarjetasRojas;
    private int totalTarjetasAmarillas;

    public Jugador(String nombre, int dorsal, String posicion, String nacionalidad, Date fechaIngreso, int golesAnotados, int totalTarjetasRojas, int totalTarjetasAmarillas, int id, String apellidos, int edad) {
        super(nombre, 0, "", 0);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.golesAnotados = golesAnotados;
        this.totalTarjetasRojas = totalTarjetasRojas;
        this.totalTarjetasAmarillas = totalTarjetasAmarillas;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getTotalTarjetasRojas() {
        return totalTarjetasRojas;
    }

    public void setTotalTarjetasRojas(int totalTarjetasRojas) {
        this.totalTarjetasRojas = totalTarjetasRojas;
    }

    public int getTotalTarjetasAmarillas() {
        return totalTarjetasAmarillas;
    }

    public void setTotalTarjetasAmarillas(int totalTarjetasAmarillas) {
        this.totalTarjetasAmarillas = totalTarjetasAmarillas;
    }

}

// Clase MiembroTecnico
class MiembroTecnico extends Equipo {

    private String rol;

    public MiembroTecnico(String nombre, String rol, int id, String apellidos, int edad) {
        super(nombre, 0, "", 0);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}

// Clase MiembroMedico
class MiembroMedico extends Equipo {

    private String rol;

    public MiembroMedico(String nombre, String rol, int id, String apellidos, int edad) {
        super(nombre, 0, "", 0);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
