import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();
    static ArrayList<Alumno> alumnos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc;
        System.out.println();
        separador();
        while (true) {
            sc = new Scanner(System.in);

            System.out.println("            ::: CONTROL DE ASISTENCIAS ::: ");
            separador();
            System.out.printf("\t1. Cargar alumnos\n\t2. Cargar Asistencias\n\t3. Ver Alumnos\n\t4. Ver Asistencias\n\t5. Salir\n\n");
            System.out.print("Opción: ");
            // MENU
            switch (sc.nextInt()) {
                case 1:
                    cargarAlumnos();
                    break;
                case 2:
                    cargarAsistencias();
                    break;
                case 3:
                    mostrarAlumnos();
                    break;
                case 4:
                    mostrarAsistencias();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("ERROR: valor incorrecto");
            }
        }
    }

    private static void cargarAlumnos() {
        String nombre, apellido, legajo;
        separador();
        System.out.println("              ::: CARGAR ALUMNOS ::: ");
        separador();
        while (true) {
            sc = new Scanner(System.in);
            System.out.println("Nombre: ");
            nombre = sc.next();
            System.out.println("Apellido: ");
            apellido = sc.next();
            System.out.println("Legajo: ");
            legajo = sc.next();
            alumnos.add(new Alumno(nombre, apellido, legajo));
            System.out.println("Desea cargar otro alumno? <s/n> :");
            if (sc.next().charAt(0) == 'n') {
                separador();
                return;
            }
        }
    }

    private static void cargarAsistencias() {
        sc = new Scanner(System.in);
        separador();
        System.out.println("              ::: CARGAR ASISTENCIAS ::: ");
        separador();
        System.out.print("Asignatura: ");
        asistencias.add(new Asistencia(sc.next()));
    }

    private static void mostrarAsistencias() {
        separador();
        System.out.println("            ::: LISTADO DE ASISTENCIAS ::: ");
        separador();
        if (Programa.asistencias.size() == 0) {
            System.out.println("ERROR: no se registraron asistencias");
            volver();
            return;
        }
        asistencias.forEach(asistencia -> {
            System.out.println("Fecha: " + asistencia.getFecha());
            System.out.println("Asignatura: "+ asistencia.getAsignatura());
            System.out.println("Alumnos Presentes:");
            if ( asistencia.getAlumnosPresentes().size() == 0)
                System.out.println("No hubo alumnos presentes");
            else {
                asistencia.getAlumnosPresentes().forEach(alumno -> {
                    System.out.println(alumno.getLegajo() + " - " + alumno.getNombre() + " " + alumno.getApellido());
                });
                separador();
            }
        });
        volver();
    }

    private static void mostrarAlumnos() {
        separador();
        System.out.println("              ::: LISTADO DE ALUMNOS ::: ");
        separador();
        if (Programa.alumnos.size() == 0) {
            System.out.println("ERROR: No se registraron alumnos");
            volver();
            return;
        }
        alumnos.forEach(alumno -> {
            System.out.println(alumno.getLegajo() + " - " + alumno.getNombre() + " " + alumno.getApellido());
        });
        volver();

    }

    static void separador() {
        System.out.println("-------------------------------------------------------");
    }

    static void volver() {
        sc = new Scanner(System.in);
        separador();
        System.out.println("Presione Enter para volver al menú");
        sc.nextLine();
        separador();
    }
}
