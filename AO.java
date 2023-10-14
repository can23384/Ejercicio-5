/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #5
Eliazar Canastuj
carnet: 23384
*/

public class AO extends jugador{
    private int ataques;
    private int efectivos;
    private int fallidos;


    public AO(String nombre, String pais, int errores, int aces, int total_servicios, int ataques, int efectivos, int fallidos){
        super(nombre, pais, errores, aces, total_servicios);
        this.ataques = ataques;
        this.efectivos = efectivos;
        this.fallidos = fallidos;
    }

//GETTERS
    public int getAtaques(){
        return this.ataques;
    }

    public int getEfectivos(){
        return this.efectivos;
    }

    public int getFallidos(){
        return this.fallidos;
    }

//         ((ataques + bloqueos efectivos – bloqueos fallidos – errores) * 100 / (ataques + bloqueos efectivos + bloqueos fallidos + errores)) + aces * 100 / servicio
    public float efectividad(){
        return (((this.ataques + this.efectivos - this.fallidos - this.errores) * 100 / (this.ataques + this.efectivos + this.fallidos + this.errores)) + this.aces * 100 / this.total_servicios);
    }

}