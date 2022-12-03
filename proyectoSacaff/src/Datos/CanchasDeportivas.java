/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Datos;


/**
 *
 * @author Vichosty
 */


//Creación de la clase CanchasDeportivas





//definicion de los datos de cancha para trabajar con su clase 

public class CanchasDeportivas {
    private int idCancha;
    private String nombreCancha;
    private String tipoCancha;
    private int costoPorHora;


    public CanchasDeportivas() {
    }

    public CanchasDeportivas(int idCancha, String nombreCancha, String tipoCancha, int costoPorHora, String estado) {
        this.idCancha = idCancha;
        this.nombreCancha = nombreCancha;
        this.tipoCancha = tipoCancha;
        this.costoPorHora = costoPorHora;

    }

    public int getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public String getNombreCancha() {
        return nombreCancha;
    }

    public void setNombreCancha(String nombreCancha) {
        this.nombreCancha = nombreCancha;
    }

    public String getTipoCancha() {
        return tipoCancha;
    }

    public void setTipoCancha(String tipoCancha) {
        this.tipoCancha = tipoCancha;
    }

    public int getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(int costoPorHora) {
        this.costoPorHora = costoPorHora;
    }

}