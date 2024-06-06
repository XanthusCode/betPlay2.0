package com.breaklinestudio.intro.main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class LigaBetPlay {
    private final List<Equipo> equipos;

    public LigaBetPlay() {
        this.equipos = new ArrayList<>();
    }

    public void registrarEquipo(String nombreEquipo) {
        if (!existeEquipo(nombreEquipo)) {
            equipos.add(new Equipo(nombreEquipo, 0, "", 0) {
            });
            System.out.println("Equipo " + nombreEquipo + " registrado exitosamente.");
        } else {
            System.out.println("El equipo " + nombreEquipo + " ya está registrado. Use otro nombre");
        }
    }

    public void registrarJugador(String nombreEquipo, String nombreJugador, int dorsal, String posicion, String nacionalidad, Date fechaIngreso, int golesAnotados, int totalTarjetasRojas, int totalTarjetasAmarillas, int id, String apellidoJugador, int edad) {
        Equipo equipo = encontrarEquipo(nombreEquipo);
        if (equipo != null) {
            equipo.agregarJugador(nombreJugador, dorsal, posicion, nacionalidad, fechaIngreso, golesAnotados, totalTarjetasRojas, totalTarjetasAmarillas, id, apellidoJugador, edad);
        } else {
            System.out.println("El equipo " + nombreEquipo + " no existe.");
        }
    }

    public void agregarMiembroMedico(String nombreEquipo, String nombreMedico, String rolMedico) {
        Equipo equipo = encontrarEquipo(nombreEquipo);
        if (equipo != null) {
            equipo.agregarMiembroMedico(nombreMedico, rolMedico);
        } else {
            System.out.println("El equipo " + nombreEquipo + " no existe.");
        }
    }

    public void agregarMiembroTecnico(String nombreEquipo, String nombreTecnico, String rolTecnico) {
        Equipo equipo = encontrarEquipo(nombreEquipo);
        if (equipo != null) {
            equipo.agregarMiembroTecnico(nombreTecnico, rolTecnico);
        } else {
            System.out.println("El equipo " + nombreEquipo + " no existe.");
        }
    }

    public boolean validarNombreEquipo(String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                return true;
            }
        }
        return false;
    }

    public void registrarFecha(String local, String visitante, int golesLocal, int golesVisitante) {
        Equipo equipoLocal = encontrarEquipo(local);
        Equipo equipoVisitante = encontrarEquipo(visitante);

        if (equipoLocal != null && equipoVisitante != null) {
            equipoLocal.setPJ(equipoLocal.getPJ() + 1);
            equipoVisitante.setPJ(equipoVisitante.getPJ() + 1);

            equipoLocal.setGF(equipoLocal.getGF() + golesLocal);
            equipoLocal.setGC(equipoLocal.getGC() + golesVisitante);
            equipoVisitante.setGF(equipoVisitante.getGF() + golesVisitante);
            equipoVisitante.setGC(equipoVisitante.getGC() + golesLocal);

            if (golesLocal > golesVisitante) {
                equipoLocal.setPG(equipoLocal.getPG() + 1);
                equipoLocal.setTP(equipoLocal.getTP() + 3);
                equipoVisitante.setPP(equipoVisitante.getPP() + 1);
            } else if (golesLocal < golesVisitante) {
                equipoVisitante.setPG(equipoVisitante.getPG() + 1);
                equipoVisitante.setTP(equipoVisitante.getTP() + 3);
                equipoLocal.setPP(equipoLocal.getPP() + 1);
            } else {
                equipoLocal.setPE(equipoLocal.getPE() + 1);
                equipoVisitante.setPE(equipoVisitante.getPE() + 1);
                equipoLocal.setTP(equipoLocal.getTP() + 1);
                equipoVisitante.setTP(equipoVisitante.getTP() + 1);
            }
        }
    }

    private Equipo encontrarEquipo(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    public void mostrarTablaPosiciones() {
        // Ordenar los equipos según su puntuación total
        Collections.sort(equipos, (equipo1, equipo2) -> equipo2.getPuntuacionTotal() - equipo1.getPuntuacionTotal());

        // Mostrar tabla de posiciones
        System.out.println("Tabla de posiciones:");
        for (int i = 0; i < equipos.size(); i++) {
            Equipo equipo = equipos.get(i);
            System.out.println((i + 1) + ". " + equipo.getNombre() + ": " + equipo.getPuntuacionTotal() + " puntos");
        }
    }

    public void listarCuerpoMedico() {
        // Iterar sobre cada equipo
        for (Equipo equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre());
            System.out.println("Cuerpo Médico:");

            for (MiembroMedico medico : equipo.getCuerpoMedico()) {
                System.out.println("- Nombre: " + medico.getNombre() + ", Rol: " + medico.getRol());
            }
            System.out.println();
        }
    }

    public void mostrarReportes() {
        if (!equipos.isEmpty()) {
            for (Equipo equipo : equipos) {
                System.out.println("Equipo: " + equipo.getNombre());
                System.out.println("Jugadores:");

                Jugador jugadorMasGoles = null;
                int maxGoles = 0;

                Jugador jugadorMasTarjetasRojas = null;
                int maxTarjetasRojas = 0;

                Jugador jugadorMasTarjetasAmarillas = null;
                int maxTarjetasAmarillas = 0;

                // Iterar sobre los jugadores de cada equipo
                for (Jugador jugador : equipo.getJugadores()) {
                    System.out.println("- Nombre: " + jugador.getNombre() + ", Dorsal: " + jugador.getDorsal() + ", Posición: " + jugador.getPosicion());
                    System.out.println();

                    // Actualizar jugador con más goles
                    if (jugador.getGolesAnotados() > maxGoles) {
                        maxGoles = jugador.getGolesAnotados();
                        jugadorMasGoles = jugador;
                    }

                    // Actualizar jugador con más tarjetas rojas
                    if (jugador.getTotalTarjetasRojas() > maxTarjetasRojas) {
                        maxTarjetasRojas = jugador.getTotalTarjetasRojas();
                        jugadorMasTarjetasRojas = jugador;
                    }

                    // Actualizar jugador con más tarjetas amarillas
                    if (jugador.getTotalTarjetasAmarillas() > maxTarjetasAmarillas) {
                        maxTarjetasAmarillas = jugador.getTotalTarjetasAmarillas();
                        jugadorMasTarjetasAmarillas = jugador;
                    }
                }
                // Mostrar resultados de estadísticas
                if (jugadorMasGoles != null) {
                    System.out.println("Jugador con más goles anotados: " + jugadorMasGoles.getNombre() + " (" + maxGoles + " goles)");
                    System.out.println();
                } else {
                    System.out.println("No se encontró ningún jugador con goles anotados.");
                }

                if (jugadorMasTarjetasRojas != null) {
                    System.out.println("Jugador con más tarjetas rojas recibidas: " + jugadorMasTarjetasRojas.getNombre() + " (" + maxTarjetasRojas + " tarjetas rojas)");
                    System.out.println();
                } else {
                    System.out.println("No se encontró ningún jugador con tarjetas rojas recibidas.");
                }

                if (jugadorMasTarjetasAmarillas != null) {
                    System.out.println("Jugador con más tarjetas amarillas recibidas: " + jugadorMasTarjetasAmarillas.getNombre() + " (" + maxTarjetasAmarillas + " tarjetas amarillas)");
                    System.out.println();
                } else {
                    System.out.println("No se encontró ningún jugador con tarjetas amarillas recibidas.");
                }
            }
            mostrarTablaPosiciones();
            listarCuerpoMedico();
        } else {
            System.out.println("La lista de equipos está vacía. No se pueden calcular los reportes.");

        }

    }

    public boolean existeEquipo(String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                return true;
            }
        }
        return false;
    }
}
