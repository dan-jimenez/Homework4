package Classes;

import java.util.ArrayList;

public class Curso {
    
    private String codigo;
    private String nombre;
    private int creditos;
    private int horas;
    private boolean asistenciaObligatoria;
    
    private final static double NOTA_APROBACION = 67.5;
    // private/public es un modificador de acceso que define la visibilidad del atributo
    // static es un modificador de acceso que define un atributo global
    // final es un modificador de acceso que define un atributo constante
    
    private ArrayList<Rubro_Evaluacion> evaluaciones = new ArrayList();
    // el ArrayList representa una colección de objetos y debe declararse e instanciarse.
    
    
    public Curso(){
        // constructor default
    }

    public Curso(String codigo, String nombre, int p_creditos) {
        // constructor sobrecargado
        this.codigo = codigo;
        this.nombre = nombre;
        creditos = p_creditos;
    }
    
    public Curso(int p_creditos, String codigo, String nombre) {
        // constructor sobrecargado con igual cantidad de parámetros, distinto orden
        this.codigo = codigo;
        this.nombre = nombre;
        creditos = p_creditos;
    }

    public Curso(String codigo, String nombre, int creditos, int horas, boolean asistenciaObligatoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas = horas;
        this.asistenciaObligatoria = asistenciaObligatoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isAsistenciaObligatoria() {
        return asistenciaObligatoria;
    }

    public void setAsistenciaObligatoria(boolean asistenciaObligatoria) {
        this.asistenciaObligatoria = asistenciaObligatoria;
    }

    public static double getNOTA_APROBACION() {
        return NOTA_APROBACION;
    }

    @Override
    public String toString() {
        String listaRubros = "";
        for (Rubro_Evaluacion rubro : evaluaciones) {
            listaRubros += rubro.toString();
        }
        return "Curso:" + "codigo=" + codigo + ", nombre=" + nombre + 
               ", creditos=" + creditos + ", horas=" + horas + 
               ", asistenciaObligatoria=" + asistenciaObligatoria + 
               ", nota de aprobación " + NOTA_APROBACION + '\n' +
               "Lista de Rubros " + listaRubros;
    }
    
    public boolean agregarRubro( int elId, String nombre, double porc, TEvaluacion tipoR){        
        int posicion = 0;
        Rubro_Evaluacion actual ;
        while ( posicion < evaluaciones.size() ){
            actual = evaluaciones.get(posicion);
            if ( actual.getNum() == elId || actual.getNombre().equals(nombre) ){
                return false;
            }
            else{
                posicion = posicion + 1;
            }
        }
        Rubro_Evaluacion rubro = new Rubro_Evaluacion(elId, nombre, porc, tipoR);
        evaluaciones.add(rubro);
        return true;
    }
    
    public Rubro_Evaluacion consultarRubro(int elId, String nombre){
    
        for (int i = 0; i < evaluaciones.size(); i++) {
            Rubro_Evaluacion actual = evaluaciones.get(i);
            if ( actual.getNum() == elId && actual.getNombre().equals(nombre) ){
                return actual;
            }
        }
        return null; // el objeto NO fue encontrado
    }
   
    public boolean modificarRubro(int elId, String nombre, double nuevoPorc){
       for (int i = 0; i < evaluaciones.size(); i++) {
            Rubro_Evaluacion actual = evaluaciones.get(i);
            if ( actual.getNum() == elId && actual.getNombre().equals(nombre) ){
                actual.setPorcentaje(nuevoPorc);
                return true;
            }
        }
        return false; // el objeto NO fue encontrado       
    }
    
     public boolean modificarRubro(double nuevoPorc, int elId, String nombre){
      
         Rubro_Evaluacion rubro = consultarRubro(elId, nombre);
         if (rubro != null){    // asegurarse que el objeto fue recuperado
             rubro.setPorcentaje(nuevoPorc);
             return true;
         }
        return false; // el objeto NO fue encontrado       
    }
       
    public boolean eliminarRubro(String nombre, int elId){
        
        Rubro_Evaluacion rubro = consultarRubro(elId, nombre);
         if (rubro != null){    // asegurarse que el objeto fue recuperado
             evaluaciones.remove(rubro);
             return true;
         }
        return false; // el objeto NO fue encontrado       
    }
        
    public boolean eliminarRubro(int elId, String nombre){
        for (Rubro_Evaluacion actual : evaluaciones) {
            if ( actual.getNum() == elId && actual.getNombre().equals(nombre) ){
                evaluaciones.remove(actual);
                return true;
            }            
        }
        return false;
    }

    /*---------------------------------------------------------------------------
    Instrucciones de la funcion:
    E: tipo de evaluacion de un curso
    S: la suma de los porcentajes (del tipo) registrados en el curso*/

    public Rubro_Evaluacion getPorcentajePorTipo(TEvaluacion tipoR){
        double resultado=0;
        for (int i = 0; i < evaluaciones.size(); i++) {
            Rubro_Evaluacion actual = evaluaciones.get(i);
            if (actual.getTipo().equals(tipoR) ){
                resultado+=actual.getPorcentaje();
            }
        }
        if(resultado!=0){
            System.out.println(">>Porcentaje de evaluaciones de tipo "+tipoR+": "+resultado);
        }
        return null;//no se encontro nada relacionado al tipo
    }

    //--------------------------------------------------------------------------

    public double validarPorcentaje(){
        double porcentajeMaximo = 100.00;
        double acumulador = 0;
        for(Rubro_Evaluacion actual: evaluaciones){
            acumulador += actual.getPorcentaje();
        }

        if(acumulador == porcentajeMaximo){
            System.out.println("La suma de los rubros completa el 100%");
            return (porcentajeMaximo - acumulador);
        } else if (acumulador < porcentajeMaximo) {
            System.out.println("La suma de los rubros es " + acumulador + "%\n");
            System.out.println("Le faltan " + (porcentajeMaximo - acumulador) + "% para llegar al 100%");
            return (porcentajeMaximo - acumulador);
        }else{
            System.out.println("La suma de los rubros es " + acumulador + "%\n");
            System.out.println("Tiene un exceso de " + (acumulador-porcentajeMaximo) + "%");
            return (acumulador-porcentajeMaximo);
        }
    }

    //---------------------------------------------------------------------------------------------
    // Editar para que no haga prints

    public Rubro_Evaluacion obtenerInformacionRubro(TEvaluacion tipoRubro, String nombre){
        for(Rubro_Evaluacion actual: evaluaciones){
            if(actual.getTipo() == tipoRubro){
                if(actual.getNombre() == nombre){
                    System.out.printf(actual.toString());
                    System.out.printf("\n");
                    return actual;
                }
            }
        }
        System.out.printf("No se encontro el rubro");
        return null;
    }
    //----------------------------------------------------------------------------------------------------------
}
