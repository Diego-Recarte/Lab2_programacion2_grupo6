/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2_6;

import java.time.LocalDate;

public abstract class Empleado {

    protected String id;
    protected String nombre;
    protected double tarifaPorHora;

    public Empleado(String id, String nombre, double tarifaPorHora) {
        this.id = id;
        this.nombre = nombre;
        this.tarifaPorHora = tarifaPorHora;
    }

    public String getId() {
        return id;

    }

    public String getNombre() {
        return nombre;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    
    public String mostrarInformacion() {
        return "ID: " + id + " | Nombre: " + nombre;
    }

    
    public abstract double calcularPago(double horasTrabajadas);
}
