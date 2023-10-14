/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #5
Eliazar Canastuj
carnet: 23384
*/


import java.util.*;
import java.io.*;


public class main{

    public static void main (String[] args){
        Scanner teclado = new Scanner(System.in);
        ArrayList<jugador> jugadores = new ArrayList<jugador>();
        //CARGAR ARCHIVO .CSV
        try{
            File archivo = new File("jugadores.csv");
            Scanner scanner = new Scanner(archivo);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(";");

                String nombre = campos[0];
                String pais = campos[1];
                int errores = Integer.parseInt(campos[2]);
                int aces = Integer.parseInt(campos[3]);
                int total_servicios = Integer.parseInt(campos[4]);
                int recibos = Integer.parseInt(campos[5]);
                int pases = Integer.parseInt(campos[6]);
                int fintas = Integer.parseInt(campos[7]);
                int ataques = Integer.parseInt(campos[8]);
                int efectivos = Integer.parseInt(campos[9]);
                int fallidos = Integer.parseInt(campos[10]);

                if (recibos > 0) {
                        jugadores.add(new liberos(nombre, pais, errores, aces, total_servicios, recibos));
                    }
                else if (pases > 0 || fintas > 0){
                        jugadores.add(new pasador(nombre, pais, errores, aces, total_servicios, pases, fintas));
                    }
                else if (ataques > 0 || efectivos > 0 || fallidos > 0){
                        jugadores.add(new AO(nombre, pais, errores, aces, total_servicios, ataques, efectivos, fallidos));
                    }else{
                        jugadores.add(new jugador(nombre, pais, errores, aces, total_servicios));
                    }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


/////////////////////////////////////////MENU////////////////////////////////////////////////////////////////
        boolean hola = true;
        while(hola){
            System.out.println("==============================");
            System.out.println("Elija una opcion: ");
            System.out.println("1. Registrar jugador");
            System.out.println("2. Mostrar todos los jugadores inscritos en el torneo");
            System.out.println("3. Los 3 mejores líberos");
            System.out.println("4. La cantidad de pasadores con más de un 80% de efectividad");
            System.out.println("5. salir");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println("==============================");

            switch(opcion){
                case 1:
                    System.out.println("Ingrese el tipo de jugador(Líbero, Pasador, Auxiliares/Opuestos): ");
                    String tipo = teclado.nextLine();

                    System.out.println("Ingrese el nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.println("Ingrese el pais: ");
                    String pais = teclado.nextLine();

                    System.out.println("Ingrese los errores: ");
                    int errores = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Ingrese los aces (puntos directos por servicios): ");
                    int aces = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Ingrese el total de servicios.: ");
                    int total_servicio = teclado.nextInt();
                    teclado.nextLine();


                    //LIBERO
                    if(tipo.equals("Libero")){
                        System.out.println("Ingrese los recibos efectivos: ");
                        int recibos = teclado.nextInt();
                        teclado.nextLine();

                        liberos liberos = new liberos(nombre, pais, errores, aces, total_servicio, recibos);
                        jugadores.add(liberos);
                    }
                    //Pasador   
                    else if(tipo.equals("Pasador")){
                        System.out.println("Ingrese los pases: ");
                        int pases = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("Ingrese las jugadas de engaño (fintas) efectivas: ");
                        int fintas = teclado.nextInt();
                        teclado.nextLine();

                        pasador pasador = new pasador(nombre, pais, errores, aces, total_servicio, pases, fintas);
                        jugadores.add(pasador);
                    }
                    //AUXILIAR   / OPUESTO
                    else if(tipo.equals("Auxiliar") || tipo.equals("Opuesto")){
                        System.out.println("Ingrese los ataques: ");
                        int ataques = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("Ingrese los bloqueos efectivos: ");
                        int BE = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("Ingrese los bloqueos fallidos: ");
                        int BF = teclado.nextInt();
                        teclado.nextLine();

                        AO AO = new AO(nombre, pais, errores, aces, total_servicio, ataques, BE, BF);
                        jugadores.add(AO);
                    }
                    
                    break;
                
                case 2:
                    for(jugador jugador : jugadores){
                        System.out.println(jugador);
                    }
                    break;

                case 3:
                    //VARIABLES PARA COMPARAR
                    String primero = "No hay otro jugador.";
                    float punteo_primero = 0;
                    String segundo = "No hay otro jugador.";
                    float punto_segundo = 0;
                    String tercero = "No hay otro jugador.";
                    float punteo_tercero = 0;

                    for(jugador jugador : jugadores){
                        if (jugador instanceof liberos) {

                            liberos portero = (liberos) jugador;

                            if(portero.efectividad() > punteo_primero){
                                punteo_primero = portero.efectividad();
                                primero = portero.getNombre();
                            }
                            else if(portero.efectividad() > punto_segundo){
                                punto_segundo = portero.efectividad();
                                segundo = portero.getNombre();
                            }
                            else if(portero.efectividad() > punteo_tercero){
                                punto_segundo = portero.efectividad();
                                tercero = portero.getNombre();
                            }
                        }
                    }

                    System.out.println("Jugador: "+primero+" Efectividad: "+punteo_primero);
                    System.out.println("Jugador: "+segundo+" Efectividad: "+punto_segundo);
                    System.out.println("Jugador: "+tercero+" Efectividad: "+punteo_tercero);

                    break;

                case 4:
                    for(jugador jugador : jugadores){
                        if (jugador instanceof pasador) {
                            pasador nose = (pasador) jugador;
                            if(nose.efectividad() > 80){
                                System.out.println("Jugador: "+nose.getNombre()+" Efectividad: "+nose.efectividad());
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Guardando datos....");
                    //guardar en el .csv
                    String nombreArchivo = "jugadores.csv";
                    String encabezado = "nombre;pais;errores;aces;total_servicios;recibos;pases;fintas;ataques;efectivos;fallidos";

                    try{
                        FileWriter escritor = new FileWriter(nombreArchivo, false);
                        escritor.write(encabezado + "\n");

                        for(jugador jugador : jugadores){
                            if (jugador instanceof liberos){
                                liberos libero = (liberos) jugador;
                                escritor.write(libero.getNombre() + ";"+ libero.getPais() + ";" + libero.getErrores() + ";" + libero.getAces() + ";" + libero.getServicios() + ";" + libero.getRecibos() + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0 + "\n");
                            }
                            else if (jugador instanceof pasador){
                                pasador pasado = (pasador) jugador;
                                escritor.write(pasado.getNombre() + ";"+ pasado.getPais() + ";" + pasado.getErrores() + ";" + pasado.getAces() + ";" + pasado.getServicios() + ";" + 0 + ";" + pasado.getPases() + ";" + pasado.getFintas() + ";" + 0 + ";" + 0 + ";" + 0 + "\n");
                            }
                            else if (jugador instanceof AO){
                                AO aux = (AO) jugador;
                                escritor.write(aux.getNombre() + ";"+ aux.getPais() + ";" + aux.getErrores() + ";" + aux.getAces() + ";" + aux.getServicios() + ";" + 0 + ";" + 0 + ";" + 0 + ";" + aux.getAtaques() + ";" + aux.getEfectivos() + ";" + aux.getFallidos() + "\n");
                            }else{
                                escritor.write(jugador.getNombre() + ";"+ jugador.getPais() + ";" + jugador.getErrores() + ";" + jugador.getAces() + ";" + jugador.getServicios() + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0 + "\n");
                            }
                        }
                        escritor.close();

                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    //YA SE GUARDO EL ARCHIVO
                    System.out.println("♫ Yo digo bye y nos vemos ♫");
                    hola = false;
                    break;

            }


        }

    }
}