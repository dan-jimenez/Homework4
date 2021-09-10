package Classes;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Menu {
    public static Curso cursos[];



    public static void main(String[] args) {
        principal();
    }

    public static void principal(){
        int opcion;
        Scanner escaner = new Scanner(System.in);

        do{
            System.out.printf("-------------------------------------------------------------------------------- \n");
            System.out.printf("Bienvenido al menu del programa, digite la opcion a la que desea ingresar \n");
            System.out.printf("-------------------------------------------------------------------------------- \n");
            System.out.printf("1. Registrar curso \n");
            System.out.printf("2. Registrar grupo \n");
            System.out.printf("3. Registrar estudiante en un grupo \n");
            System.out.printf("4. Agregar rubro de evaluacion a curso \n");
            System.out.printf("5. Consultar rubro de evaluacion a curso \n");
            System.out.printf("6. Modificar rubro de evaluacion a curso \n");
            System.out.printf("7. Eliminar rubro de evaluacion a curso \n");
            System.out.printf("8. Validar el porcentaje de las evaluaciones de un curso \n");
            System.out.printf("9. Obtener porcentaje de un tipo de evaluacion \n");
            System.out.printf("10. Obtener informacion de un rubro \n");
            System.out.printf("11. Obtener lista de rubros de un tipo \n");
            System.out.printf("12. Consultar estudiante \n");
            System.out.printf("13. Modificar promedio del estudiante \n");
            System.out.printf("14. Eliminar estudiante \n");
            System.out.printf("15. Registrar nota del estudiante \n");
            System.out.printf("16. Consultar promedio de un estudiante \n");
            System.out.printf("17. Desglozar el promedio de un estudiante \n");
            System.out.printf("------------------------------------------------------------------------------- \n");
            opcion = escaner.nextInt();

            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    registrarCurso();
                    break;
                case 2:

                    break;
                case 3:

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
                    System.out.printf("Opcion invalida \n \n");
            }

        }while (opcion != 0);

    }

    public static void registrarEstudiante(){

    }
    public static void registrarCurso(){
        String codigo;
        String nombre;
        String deAsistenciaObligatoria;
        String respuestaCorta;
        int creditos;
        int horas;
        boolean asistenciaObligatoria;
        Scanner escaner = new Scanner(System.in);
        Curso nuevoCurso;

        boolean creado = false;
        while(!creado){
            System.out.print("Digite el codigo del curso: ");
            codigo = escaner.nextLine();
            System.out.print("Digite el nombre del curso: ");
            nombre = escaner.nextLine();
            System.out.printf("¿Es de asistencia obligatoria? Escriba SI o NO: ");
            deAsistenciaObligatoria = escaner.nextLine();
            System.out.print("Digite el numero de creditos del curso: ");
            creditos = escaner.nextInt();
            System.out.printf("Digite el numero de horas del curso: ");
            horas = escaner.nextInt();
            System.out.printf("Se esta creando el curso \n");

            if(!deAsistenciaObligatoria.isEmpty()){
                if(!codigo.isEmpty()){
                    if(!nombre.isEmpty()){
                        if(creditos!=0){
                            if(horas!=0){
                                deAsistenciaObligatoria.toUpperCase();
                                if(deAsistenciaObligatoria.equals("SI")){
                                    nuevoCurso = new Curso(codigo, nombre,creditos, horas, true);
                                    creado = true;
                                    System.out.printf("¡Curso creado! \n");
                                }else if(deAsistenciaObligatoria.equals("NO")){
                                    nuevoCurso = new Curso(codigo, nombre,creditos, horas, false);
                                    creado = true;
                                    System.out.printf("!Curso creado! \n");
                                }else{
                                    System.out.printf("No se creo el curso porque un parametro fue invalido \n");
                                    System.out.printf("¿Quieres salir al menu principal? Escriba SI o NO: \n");
                                    respuestaCorta = escaner.nextLine();
                                    respuestaCorta.toUpperCase();
                                    if(respuestaCorta == "SI"){
                                        break;
                                    }
                                }
                            }else System.out.printf("El curso tiene 0 horas, esto es invalido");
                        }else System.out.printf("El curso no tiene creditos");
                    }else System.out.printf("Nombre de curso no vacio");
                } else System.out.printf("El curso no posee codigo");
            } else System.out.printf("No se ingreso si el tipo de asistencia es obligatoria o no");

        }

        principal();
    }






}
