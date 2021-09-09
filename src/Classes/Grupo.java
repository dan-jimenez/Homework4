package Classes;


import java.util.ArrayList;
import Classes.Curso;
import Classes.Estudiante;
import Classes.Profesor;


public class Grupo {
    private int numero;
    private String horario;
    private int cupo;
    private String aula;
    private String sede;
    private Profesor elProfesor;    // declaracion que representa la asociacion con Profesor
    private Curso elCurso;          // declaracion que representa la asociacion con Curso
    private ArrayList<Estudiante> estudiantes = new ArrayList();
    private ArrayList<Calificacion> resultados = new ArrayList();
    
    

    public Grupo() {
    }

    public Grupo(int numero, int cupo, Profesor elProfesor, Curso elCurso) {
        this.numero = numero;
        this.cupo = cupo;
        this.elProfesor = elProfesor;
        this.elCurso = elCurso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Profesor getElProfesor() {
        return elProfesor;
    }

    public void setElProfesor(Profesor elProfesor) {
        this.elProfesor = elProfesor;
    }

    public Curso getElCurso() {
        return elCurso;
    }

    public void setElCurso(Curso elCurso) {
        this.elCurso = elCurso;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Grupo:" + "numero=" + numero + ", horario=" + horario + 
                ", cupo=" + cupo + ", aula=" + aula + ", sede=" + sede + 
                ", elProfesor=" + elProfesor + ", elCurso=" + elCurso + 
                ", estudiantes=" + estudiantes + '\n';
    }
    
    public boolean agregarEstudiante(Estudiante unEstudiante){
        
        for (int i = 0; i < estudiantes.size(); i++) {          // forl + TAB
            Estudiante actual = estudiantes.get(i);
            if (actual.getCarne() == unEstudiante.getCarne()){
                return false;
            }            
        }
        estudiantes.add(unEstudiante);
        return true;
    }
       
    public Estudiante consultar(int carne){
        for (Estudiante actual : estudiantes) {
            if (actual.getCarne() == carne){
                return actual;
            }
        }
        return null;  // null es para decir que no fue hallado
    }
    
    public boolean modificarEstudiante(int carne, double nuevoPromedio){
        for (Estudiante actual : estudiantes) {
            if (actual.getCarne() == carne){
                actual.setPromedio(nuevoPromedio);
                return true;
            }            
        }
        return false;
    }
    
    public boolean eliminarEstudiante(int carne){
        for (Estudiante actual : estudiantes) {
            if (actual.getCarne() == carne){
                estudiantes.remove(actual);
                return true;
            }            
        }
        return false;
    }

    /*--------------------------------------------------------------------------------------------------------
    E: id del estudiante, nombre del rubro, tipo de rubro y la nota obtenida 
    S: si la nota fue registrada o no (true o false)
    R: la nota no debe haber sido registrada anteriormente (no debe existir)*/
    public boolean registrarNota(int carne, String nombreRubro, TEvaluacion tipo, double nota){
        for (Calificacion actual2 : resultados){
            if(actual2.getUnEstudiante().getCarne()==carne && actual2.getUnaEvaluacion().getNombre()==nombreRubro && actual2.getNota()==nota){
                return false; //en el caso de existir registrado el resultado
            }
        }
        Estudiante unEstudiante=new Estudiante();
        for(Estudiante actual3 : estudiantes){
            if(actual3.getCarne()==carne){
                unEstudiante=actual3;
            }
        }
        Curso contenedor= getElCurso();
        Rubro_Evaluacion unRubro=new Rubro_Evaluacion();
        unRubro=contenedor.obtenerInformacionRubro(tipo, nombreRubro);
        
        Calificacion calif=new Calificacion(unRubro, unEstudiante, nota);
        resultados.add(calif);
        return true;
    }
    //--------------------------------------------------------------------------------------------------------

}
