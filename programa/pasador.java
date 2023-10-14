/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #5
Eliazar Canastuj
carnet: 23384
*/

public class pasador extends jugador{
    private int pases;
    private int fintas;


    public pasador(String nombre, String pais, int errores, int aces, int total_servicios, int pases, int fintas){
        super(nombre, pais, errores, aces, total_servicios);
        this.pases = pases;
        this.fintas = fintas;
    }

//GETTERS
    public int getPases(){
        return this.pases;
    }

    public int getFintas(){
        return this.fintas;
    }

//         ((pases + fintas – errores) * 100 / (pases + fintas + errores)) + aces * 100 / servicios
    public float efectividad(){
        return (((this.pases + this.fintas - this.errores) * 100 / (this.pases + this.fintas + this.errores)) + this.aces * 100 / this.total_servicios);
    }

}