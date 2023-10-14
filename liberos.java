/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #5
Eliazar Canastuj
carnet: 23384
*/

public class liberos extends jugador{
    private int recibos;


    public liberos(String nombre, String pais, int errores, int aces, int total_servicios, int recibos){
        super(nombre, pais, errores, aces, total_servicios);
        this.recibos = recibos;
    }

//GETTERS
    public int getRecibos(){
        return this.recibos;
    }

//((recibos – errores) * 100 / (recibos + errores)) + aces * 100 / servicios
    public float efectividad(){
        return (((this.recibos - this.errores) * 100 / (this.recibos + this.errores)) + this.aces * 100 / this.total_servicios);
    }


}