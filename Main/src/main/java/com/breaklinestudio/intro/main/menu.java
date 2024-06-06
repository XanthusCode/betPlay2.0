package com.breaklinestudio.intro.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class menu {
    public void menu() throws ParseException {
        // Limpia la consola imprimiendo 25 líneas en blanco
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
        LigaBetPlay liga = new LigaBetPlay();
        try (Scanner sc = new Scanner(System.in)) {
            String opcion;

            do {
                System.out.println("\nMENU:");
                System.out.println("1. Registrar equipo");
                System.out.println("2. Registro del cuerpo Deportivo ");
                System.out.println("3. Registrar fecha");
                System.out.println("4. Mostrar reportes");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.next();

                switch (opcion) {
                    case "1" -> {
                        System.out.print("Ingrese el nombre del equipo: ");
                        String nombreEquipo = sc.next();
                        liga.registrarEquipo(nombreEquipo);
                    }
                    case "2" -> {
                        System.out.print("Ingrese el nombre del equipo: ");
                        String nombreEquipo = sc.next();
                        System.out.println();
                        System.out.println();

                        // Verificar si el equipo existe
                        if (!liga.existeEquipo(nombreEquipo)) {
                            System.out.println("El equipo ingresado no existe. Por favor ingrese un nombre de equipo válido.");
                        } else {
                             // Limpia la consola imprimiendo 25 líneas en blanco
                           // Limpia la consola imprimiendo 25 líneas en blanco
                            for (int i = 0; i < 15; i++) {
                                System.out.println();
                            }
                            System.out.println("Registro Deportivo:");
                            System.out.println("1. Jugador");
                            System.out.println("2. Miembro del equipo médico");
                            System.out.println("3. Miembro del equipo técnico");
                            System.out.print("Seleccione una opción: ");
                            int eleccion = sc.nextInt();

                            switch (eleccion) {
                                case 1 -> {
                                    // Agregar un jugador
                                    System.out.print("Ingrese el id del jugador: ");
                                    int id = sc.nextInt();
                                    System.out.print("Ingrese el nombre del jugador: ");
                                    String nombreJugador = sc.next();
                                    System.out.print("Ingrese el apellidos del jugador: ");
                                    String apellidoJugador = sc.next();
                                    System.out.print("Ingrese la edad del jugador: ");
                                    int edad = sc.nextInt();
                                    System.out.print("Ingrese el dorsal del jugador: ");
                                    int dorsal = sc.nextInt();
                                    System.out.print("Ingrese la posición del jugador: ");
                                    String posicion = sc.next();
                                    System.out.print("Ingrese la nacionalidad del jugador: ");
                                    String nacionalidad = sc.next();
                                    System.out.print("Ingrese la fecha de ingreso del jugador (en formato dd/mm/aaaa): ");
                                    String fechaIngresoStr = sc.next();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    Date fechaIngreso = dateFormat.parse(fechaIngresoStr);
                                    System.out.print("Ingrese los goles anotados por el jugador: ");
                                    int golesAnotados = sc.nextInt();
                                    System.out.print("Ingrese la cantidad de tarjetas rojas puestas al jugador: ");
                                    int totalTarjetasRojas = sc.nextInt();
                                    System.out.print("Ingrese la cantidad de tarjetas amarillas puestas al jugador: ");
                                    int totalTarjetasAmarillas = sc.nextInt();

                                    liga.registrarJugador(nombreEquipo,nombreJugador, dorsal, posicion, nacionalidad, fechaIngreso, golesAnotados, totalTarjetasRojas, totalTarjetasAmarillas, id,apellidoJugador, edad);
                                    System.out.println("Jugador agregado exitosamente.");
                                    System.out.println();

                                }
                                case 2 -> {
                                    // Agregar un miembro del equipo médico
                                    System.out.print("Ingrese el nombre del miembro del equipo médico: ");
                                    String nombreMedico = sc.next();
                                    System.out.print("Ingrese el rol del miembro del equipo médico: ");
                                    String rolMedico = sc.next();
                                    liga.agregarMiembroMedico(nombreEquipo, nombreMedico, rolMedico);
                                    System.out.println("Miembro del equipo médico agregado exitosamente.");
                                }
                                case 3 -> {
                                    // Agregar un miembro del equipo técnico
                                    System.out.print("Ingrese el nombre del miembro del equipo técnico: ");
                                    String nombreTecnico = sc.next();
                                    System.out.print("Ingrese el rol del miembro del equipo técnico: ");
                                    String rolTecnico = sc.next();
                                    
                                    liga.agregarMiembroTecnico(nombreEquipo, nombreTecnico, rolTecnico );
                                    System.out.println("Miembro del equipo técnico agregado exitosamente.");
                                }
                                default ->
                                        System.out.println("Opción no válida");
                            }
                        }
                    }
                    case "3" -> {
                        System.out.print("Ingrese el nombre del equipo local: ");
                        String local = sc.next();
                        System.out.print("Ingrese el nombre del equipo visitante: ");
                        String visitante = sc.next();
                        System.out.print("Ingrese los goles del equipo local: ");
                        int golesLocal = sc.nextInt();
                        System.out.print("Ingrese los goles del equipo visitante: ");
                        int golesVisitante = sc.nextInt();

                        if (liga.validarNombreEquipo(local) && liga.validarNombreEquipo(visitante)) {
                            liga.registrarFecha(local, visitante, golesLocal, golesVisitante);
                            System.out.println("El partido ha sido registrado.");
                        } else {
                            if (!liga.validarNombreEquipo(local)) {
                                System.out.println("El equipo local no se encuentra en la lista.");
                            }
                            if (!liga.validarNombreEquipo(visitante)) {
                                System.out.println("El equipo visitante no se encuentra en la lista.");
                            }
                        }
                    }
                    case "4" ->
                        liga.mostrarReportes();
                    case "5" ->
                        System.out.println("Adiosssss!!...");
                    default ->
                        System.out.println("Opción no válida");
                }
            } while (!opcion.equals("5"));
        }
    }
}