/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #5
Eliazar Canastuj
carnet: 23384
*/


public class jugador{
    protected String nombre;
    protected String pais;
    protected int errores;
    protected int aces;
    protected int total_servicios;


    public jugador(String nombre, String pais, int errores, int aces, int total_servicios){
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.total_servicios = total_servicios;
    }

    //get 
    public String getNombre(){
        return this.nombre;
    }

    public String getPais(){
        return this.pais;
    }

    public int getErrores(){
        return this.errores;
    }

    public int getAces(){
        return this.aces;
    }

    public int getServicios(){
        return this.total_servicios;
    }


    public String toString() {
        return "Jugador: " + this.nombre;
    }
}