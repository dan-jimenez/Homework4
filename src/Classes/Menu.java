package Classes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    public static void main(String[] args) {
        principal();
    }

    public static void principal(){
        int opcion;
        Scanner escaner = new Scanner(System.in);

        do{
            System.out.printf("Bienvenido al menu del programa, digite la opcion a la que desea ingresar");
            System.out.printf("1. Registrar curso");
            System.out.printf("2. Registrar grupo");
            System.out.printf("3. Registrar estudiante en un grupo");
            System.out.printf("4. Agregar rubro de evaluacion a curso");
            System.out.printf("5. Consultar rubro de evaluacion a curso");
            System.out.printf("6. Modificar rubro de evaluacion a curso");
            System.out.printf("7. Eliminar rubro de evaluacion a curso");
            System.out.printf("8. Validar el porcentaje de las evaluaciones de un curso");
            System.out.printf("9. Obtener porcentaje de un tipo de evaluacion");
            System.out.printf("10. Obtener informacion de un rubro");
            System.out.printf("11. Obtener lista de rubros de un tipo");
            System.out.printf("12. Consultar estudiante");
            System.out.printf("13. Modificar promedio del estudiante");
            System.out.printf("14. Eliminar estudiante");
            System.out.printf("15. Registrar nota del estudiante");
            System.out.printf("16. Consultar promedio de un estudiante");
            System.out.printf("17. Desglosar el promedio de un estudiante");
            System.out.printf("0. Salir del programa");
            opcion = escaner.nextInt();

            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    registrarCurso();
                    break;
                case 2:
                    registrarGrupo();
                    break;
                case 3:
                    registrarEstudiante();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;

                default:
                    System.out.printf("Opcion invalida");
            }

        }while (opcion != 0);

    }

    public static void registrarCurso(){
        String codigo;
        String nombre;
        String deAsistenciaObligatoria;
        int creditos;
        int horas;
        boolean asistenciaObligatoria;
        Scanner escaner = new Scanner(System.in);
        Curso nuevoCurso;

        System.out.print("Digite el codigo del curso: ");
        codigo = escaner.nextLine();
        System.out.print("Digite el nombre del curso: ");
        nombre = escaner.nextLine();
        System.out.print("Digite el numero de creditos del curso: ");
        creditos = escaner.nextInt();
        System.out.printf("Digite el numero de horas del curso: ");
        horas = escaner.nextInt();
        System.out.printf("¿Es de asistencia obligatoria?");
        deAsistenciaObligatoria = escaner.nextLine();

        if(!deAsistenciaObligatoria.isEmpty()){
            if(!codigo.isEmpty()){
                if(!nombre.isEmpty()){
                    if(creditos!=0){
                        if(horas!=0){

                            deAsistenciaObligatoria.toUpperCase();
                            if(deAsistenciaObligatoria == "SI"){
                                nuevoCurso = new Curso();
                            }else if(deAsistenciaObligatoria == "NO"){

                            }else{

                            }
                        }
                    }
                }
            }
        }


    }
    
    public static void registrarGrupo(){
        do{
            int numero;
            int cupo;
            String elProfesor;
            String elCurso;
            Scanner escaner = new Scanner(System.in);
            System.out.print("Digite el numero del grupo: ");
            numero = escaner.nextInt();
            System.out.print("Indique el cupo del grupo: ");
            cupo = escaner.nextInt();
            System.out.print("Indique el ID del profesor: ");
            elProfesor = escaner.nextLine();
            System.out.print("Indique el nombre del profesor: ");
            elCurso = escaner.nextLine();
            if(numero!=0 && cupo!=0 && !elProfesor.isEmpty() && !elCurso.isEmpty()){
                Grupo nuevoGrupo = new Grupo(numero, cupo, null, null);
            }
            else{
                System.out.println("Error: existen parámetros en blanco");
            }
        } while(true);
        
    }
    
    public static void registrarEstudiante(){
        do{
            Scanner escaner = new Scanner(System.in);
            int carne;
            String nombre;
            String correo;
            String telefono;
            double promedio;
            String estado;
            TEstado estado1;
            System.out.println("Ingrese el carne del estudiante: ");
            carne = escaner.nextInt();
            System.out.println("Ingrese el nombre del estudiante: ");
            nombre=escaner.nextLine();
            System.out.println("Ingrese el correo electronico del estudiante: ");
            correo=escaner.nextLine();
            System.out.println("Ingrese el teléfono del estudiante: ");
            telefono=escaner.nextLine();
            System.out.println("Ingrese el promedio del estudiante: ");
            promedio=escaner.nextDouble();
            System.out.println("Ingrese el estado del estudiante: ");
            estado=escaner.nextLine();
            
            Pattern Email = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mailAddress = Email.matcher(correo);
            if(mailAddress.find()){
               if(!nombre.isEmpty() && carne !=0 && promedio!=0 && !estado.isEmpty()){
                   if(estado.contains("ACTIVO")){
                       estado1=TEstado.ACTIVO;
                       Estudiante nuevoEstud=new Estudiante();
                       nuevoEstud.setCarne(carne);
                       nuevoEstud.setNombre(nombre);
                       nuevoEstud.setCelular(telefono);
                       nuevoEstud.setCorreo(correo);
                       nuevoEstud.setEstado(estado1);
                       nuevoEstud.setPromedio(promedio);
                   }
                   if(estado.contains("BLOQUEADO")){
                       estado1=TEstado.BLOQUEADO;
                       Estudiante nuevoEstud=new Estudiante();
                       nuevoEstud.setCarne(carne);
                       nuevoEstud.setNombre(nombre);
                       nuevoEstud.setCelular(telefono);
                       nuevoEstud.setCorreo(correo);
                       nuevoEstud.setEstado(estado1);
                       nuevoEstud.setPromedio(promedio);
                   }
                   if(estado.contains("INACTIVO")){
                       estado1=TEstado.INACTIVO;
                       Estudiante nuevoEstud=new Estudiante();
                       nuevoEstud.setCarne(carne);
                       nuevoEstud.setNombre(nombre);
                       nuevoEstud.setCelular(telefono);
                       nuevoEstud.setCorreo(correo);
                       nuevoEstud.setEstado(estado1);
                       nuevoEstud.setPromedio(promedio);
                   }
                   if(estado.contains("SUSPENDIDO")){
                       estado1=TEstado.SUSPENDIDO;
                       Estudiante nuevoEstud=new Estudiante();
                       nuevoEstud.setCarne(carne);
                       nuevoEstud.setNombre(nombre);
                       nuevoEstud.setCelular(telefono);
                       nuevoEstud.setCorreo(correo);
                       nuevoEstud.setEstado(estado1);
                       nuevoEstud.setPromedio(promedio);
                   }
                   else{
                       System.out.println("Estado no valido");
                   }
               }
               else{
                   System.out.println("Error: parametros en blanco o no validos");
               }
            }
            else{
                System.out.println("Error: Correo invalido");
            }
        }while(true);
    }
}
