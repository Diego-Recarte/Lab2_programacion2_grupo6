/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2_6;

/**
 *
 * @author user
 */




import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTextArea;
import java.io.File;

public class Empresa {

    private ArrayList<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public int registrarEmpleados(String nombre, String id, Calendar contratacion,
            double salarioBase, int horasT, File foto,
            String tipo, double tasa, Calendar finContrato) {

        if (buscarEmpleado(id) != -1) {
            return 0; 
        }

        switch (tipo) {
            case "Estandar":
                empleados.add(new Empleado(id, nombre, contratacion, salarioBase, horasT, foto));
                return 1;

            case "Temporal":
                empleados.add(new EmpleadoTemporal(id, nombre, contratacion, salarioBase, horasT, foto, finContrato));
                return 2;

            case "Ventas":
                empleados.add(new EmpleadoVentas(id, nombre, contratacion, salarioBase, horasT, foto, tasa));
                return 3;
            default:
                return 4;

            
        }
        
    }

    public int registrarHorasTrabajadas(String id, int horasT) {
        int index = buscarEmpleado(id);

        if (index == -1) {
            return -1;
        }

        empleados.get(index).registrarHorasTrabajadas(horasT);
        return 1;
    }

    public int registrarVentas(String id, double monto) {
        int index = buscarEmpleado(id);

        if (index == -1) {
            return -1;
        }

        try {
            empleados.get(index).registrarVenta(monto);
            return 1;
        } catch (UnsupportedOperationException e) {
            return 0; // no es empleado de ventas
        }
    }

    public int actualizarFechaDeFinDeContrato(String id, Calendar actualizado) {
        int index = buscarEmpleado(id);

        if (index == -1) {
            return -1;
        }

        try {
            empleados.get(index).actualizarFechaFinContrato(actualizado);
            return 1;
        } catch (UnsupportedOperationException e) {
            return 0; // no es temporal
        }
    }

    public int buscarEmpleado(String id) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getID().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Empleado obtenerEmpleado(String id) {
        int index = buscarEmpleado(id);
        if (index == -1) {
            return null;
        }
        return empleados.get(index);
    }

    public double calcularPagoMensual(String id) {
        Empleado emp = obtenerEmpleado(id);

        if (emp == null) {
            return -1;
        }

        return emp.calcularPago();
    }

    public String buscarEmpleadoPorCodigo(String id) {
        Empleado emp = obtenerEmpleado(id);

        if (emp == null) {
            return "Empleado no encontrado.";
        }

        return emp.mostrarInformacion();
    }

    public void generarReportes(JTextArea area1, JTextArea area2, JTextArea area3) {
        

        int contEstandar = 0;
        int contTemporal = 0;
        int contVentas = 0;

        for (Empleado emp : empleados) {
            String info = emp.generarLineaReporte() + "\n----------------------------\n";

            switch (emp.getTipo()) {
                case "Estandar":
                    area1.append(info);
                    contEstandar++;
                    break;

                case "Temporal":
                    area2.append(info);
                    contTemporal++;
                    break;

                case "Ventas":
                    area3.append(info);
                    contVentas++;
                    break;
            }
        }

        area1.append("Total estándar: " + contEstandar);
        area2.append("Total temporales: " + contTemporal);
        area3.append("Total ventas: " + contVentas);
    }
}
