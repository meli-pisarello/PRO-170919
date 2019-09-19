import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Asistencia {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Alumno> alumnosPresentes = new ArrayList<>();
    private LocalDateTime fecha;
    private String asignatura;

    public Asistencia(String asignatura) {
        this.fecha = LocalDateTime.now();
        this.asignatura = asignatura;
        tomarAsistencia();
    }

    public String getFecha() {
        return fecha.format(DateTimeFormatter.ofPattern("dd'/'MM'/'yy' - 'kk':'mm"));
    }

    public String getAsignatura() {
        return asignatura;
    }

    public ArrayList<Alumno> getAlumnosPresentes() {
        return alumnosPresentes;
    }

    private void tomarAsistencia() {
        if (Programa.alumnos.size() == 0) {
            System.out.println("Primero debe cargar alumnos");
            Programa.separador();
            return;
        }
        Programa.alumnos.forEach(alumno -> {
            sc = new Scanner(System.in);
            System.out.println(alumno.getNombre() + " " + alumno.getApellido());
            System.out.print("<s/n>: ");
            if (sc.next().charAt(0) == 's')
                alumnosPresentes.add(new Alumno(alumno.getNombre(), alumno.getApellido(), alumno.getLegajo()));
        });
        Programa.separador();
    }
}
