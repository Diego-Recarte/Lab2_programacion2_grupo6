package lab2_programacion2_6;

import java.io.File;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Empleado {

    protected String codigo;
    protected String nombre;

    protected LocalDate fechaContratacion;
    protected double salarioBase = 1400;
    protected int horasTrabajadas;
    protected File foto;

    private static Scanner leer = new Scanner(System.in);

    public Empleado(String codigo, String nombre, LocalDate fechaContratacion, int horasTrabajadas, File foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaContratacion = fechaContratacion;
        this.horasTrabajadas = horasTrabajadas;
        this.foto = foto;
    }

    public int registrarHTrabajadas() {
        boolean horasAceptadas = false;
        do {
            System.out.println("Registre las horas trabajadas por el mes actual del empleado:");
            try {
                this.horasTrabajadas = leer.nextInt();
                if (this.horasTrabajadas < 0) {
                    System.out.println("No puede ingresar horas negativas.");
                } else {
                    horasAceptadas = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese horas válidas.");
                leer.next(); // Limpia el buffer del Scanner correctamente
            }
        } while (!horasAceptadas);
        return this.horasTrabajadas;
    }

    public double calcularPago(double horas) {
        if (horas > 160) {
            System.out.println("Horas sobrepasan el limite. Se calcula con el maximo de 160hrs.");
            horas = 160;
        }
        double subtotal = (horas / 160.0) * salarioBase; // 160.0 para evitar división entera
        double deduccion = salarioBase * 0.035;
        return subtotal - deduccion;
    }

    public String mostrarInformacion() {
        System.out.println("------DATOS DEL EMPLEADO----");
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Fecha de contratacion: " + fechaContratacion;
    }

    public void actualizarFechaFinContrato(LocalDate nuevaFecha) {

    }

    public boolean esContratoVigente() {
        return true;
    }

    public LocalDate getFechaFinContrato() {

        return fechaContratacion;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
    }

    public void registrarVenta(int mes, double monto) {
    }

    public double calcularPagoPorMes(double horasTrabajadas, int mes) {
        int pagoMes = 0;
        return pagoMes;
    }

    public void reiniciarVentasAnuales() {
    }

    public double obtenerTotalVentasAnuales() {
        int totalVentas = 0;
        return totalVentas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
}
