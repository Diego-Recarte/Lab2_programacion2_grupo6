
package lab2_programacion2_6;

import java.io.File;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Empleado {
    protected int codigo;
    protected  String nombre;
    protected LocalDate fechaContratacion;
    protected double salarioBase=14000;
    protected int horasTrabajadas;
    protected File foto;
    
    private static Scanner leer=new Scanner (System.in);

    public Empleado(int codigo, String nombre, LocalDate fechaContratacion, int horasTrabajadas, File foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaContratacion = fechaContratacion;
        this.horasTrabajadas = horasTrabajadas;
        this.foto = foto;
    }  
    public int registrarHTrabajadas(){
        boolean HorasAceptadas=false;
        do{
            System.out.println("Registre las horas trabajadas por el mes actual del empleado");
        
           try {
             
              horasTrabajadas=leer.nextInt();
              
              if(horasTrabajadas<0){
                  System.out.println("No puede ingresar horas negativas");
              }else{
                  HorasAceptadas=true;
              }
           }catch (InputMismatchException e){
               System.out.println("Ingrese horas validas");
               leer.nextInt();}
        }while(!HorasAceptadas);  
        return horasTrabajadas;
    }
    
    public double calcularPago(int horasTrabajadas){
        int horas=horasTrabajadas;
        double pagoTotal, subtotal, deduccion;
        
        if (horasTrabajadas>160){
            System.out.println("Horas sobrepasan el limite. Se calcula con el maximo de 160hrs");
            horas=160;
        }
            subtotal=(horas/160)*salarioBase;
            deduccion=salarioBase*0.035;
            pagoTotal=subtotal-deduccion;
            return pagoTotal;  
    }
    
    public String mostrarInformacion(){
        System.out.println("------DATOS DEL EMPLEADO----");
        return "Codigo: "+ codigo+", Nombre: "+nombre+", Fecha de contratacion: "+fechaContratacion;
    }
    
    public void actualizarFechaFinContrato(LocalDate nuevaFecha) {
    
    }
   
    public boolean esContratoVigente() {
        return true;
    }
    
    public LocalDate getFechaFinContrato() {
        
        return fechaContratacion;
    }
    
    public void setFechaFinContrato(LocalDate fechaFinContrato) {}
    
    public void registrarVenta(int mes, double monto) {
    }
    
    public double calcularPago(double horasTrabajadas) {
        int pago=0;
        return pago;
    }
    
    public double calcularPagoPorMes(double horasTrabajadas, int mes) {
        int pagoMes=0;
        return pagoMes;
    }
    
    public void reiniciarVentasAnuales() {
    }
    
    public double obtenerTotalVentasAnuales() {
        int totalVentas=0;
        return totalVentas;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaContracion() {
        return fechaContratacion;
    }

    public void setFechaContracion(LocalDate fechaContracion) {
        this.fechaContratacion = fechaContracion;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    
}
