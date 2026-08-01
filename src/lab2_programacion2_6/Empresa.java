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
import java.time.LocalDate;

public class Empresa {

    private ArrayList<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public int registrarEmpleados(String nombre, String codigo, LocalDate contratacion,
            double salarioBase, int horasT, File foto,
            String tipo, double tasa, LocalDate finContrato) {

        if (buscarEmpleado(codigo) != -1) {
            return 0;
        }

        switch (tipo) {
            case "Estandar":
                empleados.add(new Empleado(codigo, nombre, contratacion, horasT, foto));
                return 1;

            case "Temporal":
                empleados.add(new EmpleadoTemporal(codigo, nombre, contratacion, horasT, foto, finContrato));;
                return 2;

            case "Ventas":
                empleados.add(new EmpleadoVentas(codigo, nombre, contratacion, horasT, foto, tasa));
                return 3;

            default:
                return 4;
        }
    }

    public int registrarHorasTrabajadas(String codigo, int horasT) {
        int index = buscarEmpleado(codigo);

        if (index == -1) {
            return -1;
        }

        if (horasT < 0) {
            return 0;
        }

        empleados.get(index).horasTrabajadas += horasT;
        return 1;
    }

    public int registrarVentas(String codigo, double monto) {
        int index = buscarEmpleado(codigo);

        if (index == -1) {
            return -1;
        }

        try {
            int mesActual = Calendar.getInstance().get(Calendar.MONTH);
            empleados.get(index).registrarVenta(mesActual, monto);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int actualizarFechaDeFinDeContrato(String codigo, LocalDate actualizado) {
        int index = buscarEmpleado(codigo);

        if (index == -1) {
            return -1;
        }

        try {
            empleados.get(index).actualizarFechaFinContrato(actualizado);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int buscarEmpleado(String codigo) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCodigo(). equals( codigo)) {
                return i;
            }
        }
        return -1;
    }

    public Empleado obtenerEmpleado(String codigo) {
        int index = buscarEmpleado(codigo);

        if (index == -1) {
            return null;
        }

        return empleados.get(index);
    }

    public double calcularPagoMensual(String codigo) {
        Empleado emp = obtenerEmpleado(codigo);

        if (emp == null) {
            return -1;
        }

        return emp.calcularPago(emp.getHorasTrabajadas());
    }

    public String buscarEmpleadoPorCodigo(String codigo) {
        Empleado emp = obtenerEmpleado(codigo);

        if (emp == null) {
            return "Empleado no encontrado.";
        }

        return emp.mostrarInformacion();
    }

    public void generarReportes(JTextArea area1, JTextArea area2, JTextArea area3) {
        area1.setText("");
        area2.setText("");
        area3.setText("");

        int contEstandar = 0;
        int contTemporal = 0;
        int contVentas = 0;

        for (Empleado emp : empleados) {
            String info = emp.mostrarInformacion()
                    + "\nHoras trabajadas: " + emp.getHorasTrabajadas()
                    + "\nSalario base: " + emp.salarioBase
                    + "\nPago calculado: " + emp.calcularPago(emp.getHorasTrabajadas())
                    + "\n----------------------------\n";

            String nombreClase = emp.getClass().getSimpleName();

            switch (nombreClase) {
                case "Empleado":
                    area1.append(info);
                    contEstandar++;
                    break;

                case "EmpleadoTemporal":
                    area2.append(info);
                    contTemporal++;
                    break;

                case "EmpleadoVentas":
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
