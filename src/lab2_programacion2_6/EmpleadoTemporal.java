/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2_6;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */

public class EmpleadoTemporal extends Empleado {

    private LocalDate fechaFinContrato;
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public EmpleadoTemporal(String codigo, String nombre, LocalDate fechaContratacion, int horasTrabajadas, File foto, LocalDate fechaFinContrato) {
        super(codigo, nombre, fechaContratacion, horasTrabajadas, foto);
        this.fechaFinContrato = fechaFinContrato;
    }

    @Override
    public double calcularPago(double horasTrabajadas) {
        if (!esContratoVigente()) {
            System.out.println("El contrato ha vencido. Pago asignado: $0.00");
            return 0.0;
        }
        return super.calcularPago(horasTrabajadas);
    }

    public void actualizarFechaFinContrato(LocalDate nuevaFecha) {
        if (nuevaFecha != null) {
            this.fechaFinContrato = nuevaFecha;
        }
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + " | Tipo: Temporal"
                + " | Fin de Contrato: " + (fechaFinContrato != null ? fechaFinContrato.format(FORMATO_FECHA) : "Sin definir")
                + " | Estado: " + (esContratoVigente() ? "Vigente" : "Vencido");
    }

    public boolean esContratoVigente() {
        if (this.fechaFinContrato == null) return false;
        return !LocalDate.now().isAfter(this.fechaFinContrato);
    }

    public LocalDate getFechaFinContrato() { return fechaFinContrato; }
    public void setFechaFinContrato(LocalDate fechaFinContrato) { this.fechaFinContrato = fechaFinContrato; }
}
