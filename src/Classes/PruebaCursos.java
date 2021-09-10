package Classes;


import org.w3c.dom.CDATASection;

public class PruebaCursos {

    public static void main(String[] args) {System.out.println("Hola Mundo soy nuevo en Java");
        System.out.println("Me llamo Ericka");

        int cantidad = 0;
        boolean seguir = false;
        double precio = 0;

//-----------------------------------------------------------------------------------------------

        String nombre = null;
        Curso miCurso = null;   // declaraciÃ³n de una instancia, variable de tipo Curso
        miCurso = new Curso("Programacion Orientada a Objetos", "IC2101", 3);   //  instanciaciÃ³n del objeto
        System.out.println(Curso.getNOTA_APROBACION());
        System.out.println(miCurso.getCodigo() + "-" + miCurso.getNombre() + "-" + miCurso.getCreditos()+"\n");
        System.out.println("-----------------------------------------------------------------------------------------------\n");

//-----------------------------------------------------------------------------------------------

        Curso cursoED = new Curso();   // declaracion e instanciacion del objeto Curso
        cursoED.setCodigo("IC2001");
        cursoED.setNombre("Estructuras de Datos");
        cursoED.setCreditos(4);
        cursoED.setHoras(4);
        cursoED.setAsistenciaObligatoria(true);

        cursoED.agregarRubro(01, "Tarea 1", 5, TEvaluacion.TAREA);
        cursoED.agregarRubro(02, "Tarea 2", 5, TEvaluacion.TAREA);
        cursoED.agregarRubro(03, "Quiz 1", 2, TEvaluacion.QUIZ);
        cursoED.agregarRubro(04, "Quiz 2", 2, TEvaluacion.QUIZ);
        cursoED.agregarRubro(05, "Quiz 3", 2, TEvaluacion.QUIZ);
        System.out.println(cursoED+"\n");
        cursoED.getPorcentajePorTipo(TEvaluacion.QUIZ);
        System.out.println("-----------------------------------------------------------------------------------------------\n");

//-----------------------------------------------------------------------------------------------

        Curso cursoCDI = new Curso();   // declaracion e instanciacion del objeto Curso
        cursoCDI.setCodigo("MA5001"); //En realidad no me sÃ© el codigo del curso
        cursoCDI.setNombre("CÃ¡lculo Diferencial e Integral");
        cursoCDI.setCreditos(4);
        cursoCDI.setHoras(4);
        cursoCDI.setAsistenciaObligatoria(false);

        cursoCDI.agregarRubro(01, "Tarea 1", 4, TEvaluacion.TAREA);
        cursoCDI.agregarRubro(02, "Tarea 2", 3, TEvaluacion.TAREA);
        cursoCDI.agregarRubro(03, "Quiz 1", 5, TEvaluacion.QUIZ);
        cursoCDI.agregarRubro(04, "Quiz 2", 5, TEvaluacion.QUIZ);
        cursoCDI.agregarRubro(05, "Quiz 3", 5, TEvaluacion.QUIZ);
        System.out.println(cursoCDI+"\n");
        cursoCDI.getPorcentajePorTipo(TEvaluacion.TAREA);
        System.out.println("-----------------------------------------------------------------------------------------------\n");

//-----------------------------------------------------------------------------------------------

        Rubro_Evaluacion rubro = cursoED.consultarRubro(05, "Quiz 2");
        if (rubro != null){
            System.out.println("los detalles del rubro encontrado son " + rubro.toString());
        }
        else{
            System.out.println("El rubro solicitado no se encuentra registrado"+"\n");
        }
        cursoED.modificarRubro(05, "Quiz 3", 5);

        cursoED.eliminarRubro(03, "Quiz 1");

        System.out.println(cursoED);
        System.out.println("-----------------------------------------------------------------------------------------------\n");


//-----------------------------------------------------------------------------------------------

        Estudiante estud=new Estudiante();
        estud.setCarne(2021138547);
        estud.setNombre("Kevin Salazar");
        estud.setCelular("70398013");
        estud.setEstado(TEstado.ACTIVO);
        estud.setPromedio(80);
        System.out.println(estud+"\n");
        System.out.println("-----------------------------------------------------------------------------------------------\n");

        Estudiante estud2=new Estudiante();
        estud2.setCarne(2020345833);
        estud2.setNombre("Ada Rosan");
        estud2.setCelular("86403735");
        estud2.setEstado(TEstado.ACTIVO);
        estud2.setPromedio(70);
        System.out.println(estud2+"\n");
        System.out.println("-----------------------------------------------------------------------------------------------\n");

        Estudiante estud3=new Estudiante();
        estud3.setCarne(2019846840);
        estud3.setNombre("Esteban Mendez");
        estud3.setCelular("84096478");
        estud3.setEstado(TEstado.ACTIVO);
        estud3.setPromedio(76);
        System.out.println(estud3+"\n");
        System.out.println("-----------------------------------------------------------------------------------------------\n");

//-----------------------------------------------------------------------------------------------

        Profesor profe=new Profesor(105340770, "Ericka Solano", "programacion", TGrado.MASTER);
        System.out.println(profe);
        System.out.println("-----------------------------------------------------------------------------------------------\n");

        Profesor profeCDI=new Profesor(243532876, "Randall Guerrero", "Matematicas", TGrado.LICENCIADO);
        System.out.println(profeCDI);
        System.out.println("-----------------------------------------------------------------------------------------------\n");

//-----------------------------------------------------------------------------------------------

        Grupo estDatos=new Grupo(40, 32, profe, cursoED);
        estDatos.agregarEstudiante(estud);
        estDatos.agregarEstudiante(estud2);
        estDatos.agregarEstudiante(estud3);

        Grupo Calculo=new Grupo(60, 32, profeCDI, cursoCDI);
        Calculo.agregarEstudiante(estud);
        Calculo.agregarEstudiante(estud2);
        Calculo.agregarEstudiante(estud3);

//-----------------------------------------------------------------------------------------------

        if((estDatos.registrarNota(2021138547, "Quiz 3", TEvaluacion.QUIZ, 75))==true){
            System.out.println("\nNota agregada exitosamente\n");
        }
        else{
            System.out.println("\nError: las notas no se pueden repetir\n");
        }
        //----------------------------------------------------------------------------
        
        if((estDatos.registrarNota(2020345833, "Quiz 3", TEvaluacion.QUIZ, 70))==true){
            System.out.println("\nNota agregada exitosamente\n");
        }
        else{
            System.out.println("\nError: las notas no se pueden repetir\n");
        }
        //----------------------------------------------------------------------------
        
        if((estDatos.registrarNota(2019846840, "Quiz 3", TEvaluacion.QUIZ, 85))==true){
            System.out.println("\nNota agregada exitosamente\n");
        }
        else{
            System.out.println("\nError: las notas no se pueden repetir\n");
        }
        //----------------------------------------------------------------------------
        
        if((estDatos.registrarNota(2021138547, "Quiz 3", TEvaluacion.QUIZ, 75))==true){
            System.out.println("\nNota agregada exitosamente\n");
        }
        else{
            System.out.println("\nError: las notas no se pueden repetir\n");
        }
        //----------------------------------------------------------------------------
        System.out.println("-----------------------------------------------------------------------------------------------\n");
        

//-----------------------------------------------------------------------------------------------

        System.out.println(estDatos+"\n");
        System.out.println("-----------------------------------------------------------------------------------------------\n");

        System.out.println(Calculo+"\n");
        System.out.println("-----------------------------------------------------------------------------------------------\n");
        //System.out.println(estDatos.getResultados());
        System.out.println("-----------------------------------------------------------------------------------------------\n");
                                            
//---------------------------------------------------------------------------------------------------

        System.out.println("Validacion de porcentajes");
        System.out.printf("--- Curso CDI ---\n");
        cursoCDI.validarPorcentaje();
        System.out.printf("---------------------------------------------------------------------------- \n");
        System.out.printf("--- Curso ED --- \n");
        cursoED.validarPorcentaje();
        System.out.printf("------------------------------------------------------------------------------ \n");

//---------------------------------------------------------------------------------------------------------------

        System.out.printf("Buscar rubro \n");
        cursoCDI.obtenerInformacionRubro(TEvaluacion.QUIZ, "Quiz 3");

        System.out.println("------------------------------------------------------------------------------------ \n");

    }
    
}
