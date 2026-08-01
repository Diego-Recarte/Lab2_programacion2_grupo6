/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2_6;
import java.time.LocalDate;

public class EmpleadoVentas extends Empleado {

   
    private double[] ventasMensuales;
    private double porcentajeComision;

    
    public EmpleadoVentas(String id, String nombre, double tarifaPorHora, double porcentajeComision) {
        super(id, nombre, tarifaPorHora);
        this.ventasMensuales = new double[12];
        this.porcentajeComision = porcentajeComision;
    }

   
    public void registrarVenta(int mes, double monto) {
        if (mes >= 1 && mes <= 12) {
            if (monto > 0) {
                
                this.ventasMensuales[mes - 1] += monto;
            } else {
                System.out.println("El monto de la venta debe ser mayor a cero.");
            }
        } else {
            System.out.println("Mes inválido. Debe ser un número del 1 al 12.");
        }
    }

    
    @Override
    public double calcularPago(double horasTrabajadas) {
        
        int mesActual = LocalDate.now().getMonthValue();
        return calcularPagoPorMes(horasTrabajadas, mesActual);
    }

  
    public double calcularPagoPorMes(double horasTrabajadas, int mes) {
        if (mes < 1 || mes > 12) {
            System.out.println("Mes no válido.");
            return 0.0;
        }

        double salarioBase = this.tarifaPorHora * horasTrabajadas;
        double ventasDelMes = this.ventasMensuales[mes - 1];
        double comision = ventasDelMes * this.porcentajeComision;

        return salarioBase + comision;
    }

    
    public void reiniciarVentasAnuales() {
        this.ventasMensuales = new double[12];
        System.out.println("Registro de ventas anuales reiniciado para " + this.nombre + ".");
    }

    
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + " | Tipo: Ventas"
                + " | Comisión: " + (porcentajeComision * 100) + "%"
                + " | Total Ventas Anual: $" + obtenerTotalVentasAnuales();
    }

    
    public double obtenerTotalVentasAnuales() {
        double total = 0.0;
        for (double venta : ventasMensuales) {
            total += venta;
        }
        return total;
    }

    
    public double[] getVentasMensuales() {
        return ventasMensuales;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }
}