package Classes;

import java.util.Scanner;

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
            System.out.printf("17. Desglozar el promedio de un estudiante");
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
}
