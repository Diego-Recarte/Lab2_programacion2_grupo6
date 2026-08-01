/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2_6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */


    public class EmpleadoTemporal extends Empleado {

        private LocalDate fechaFinContrato;

        private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public EmpleadoTemporal(String id, String nombre, double tarifaPorHora, LocalDate fechaFinContrato) {
            super(id, nombre, tarifaPorHora);
            this.fechaFinContrato = fechaFinContrato;
        }

        @Override
        public double calcularPago(double horasTrabajadas) {
            LocalDate fechaActual = LocalDate.now();

            if (fechaActual.isAfter(this.fechaFinContrato)) {
                System.out.println("El contrato ha vencido. Pago asignado: $0.00");
                return 0.0;
            }

            return this.tarifaPorHora * horasTrabajadas;
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
                    + " | Fin de Contrato: " + fechaFinContrato.format(FORMATO_FECHA)
                    + " | Estado: " + (esContratoVigente() ? "Vigente" : "Vencido");
        }

        public boolean esContratoVigente() {
            return !LocalDate.now().isAfter(this.fechaFinContrato);
        }

        public LocalDate getFechaFinContrato() {
            return fechaFinContrato;
        }

        public void setFechaFinContrato(LocalDate fechaFinContrato) {
            this.fechaFinContrato = fechaFinContrato;
        }
    }

