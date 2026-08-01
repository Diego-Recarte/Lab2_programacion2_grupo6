/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2_6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author aluk
 */
public class FrameGestion1 extends JFrame implements ActionListener {

    JTextField tCodigoAgregar = new JTextField();
    JTextField tNombreAgregar = new JTextField();
    JTextField tSalarioBAgregar = new JTextField();
    JTextField tTcomisionAgregar = new JTextField();
    JTextField tCodigoHoras = new JTextField();
    JTextField tHoras = new JTextField();
    JTextField tCodigoVenta = new JTextField();
    JTextField tMontoVenta = new JTextField();
    JTextField tCodigoContrato = new JTextField();
    JTextField tCodigoBuscar = new JTextField();
    JTextField tCodigoPago = new JTextField();

    JTextArea tReporteEstandar = new JTextArea();
    JTextArea tReporteTemporal = new JTextArea();
    JTextArea tReporteVentas = new JTextArea();

    Empresa empresa = new Empresa();

    JLabel Foto = new JLabel("No existe Foto");
    JButton btnFoto = new JButton("Elegir Foto");
    JButton btnVenta = new JButton("Registrar Venta");
    JButton btnContrato = new JButton("Actualizar Contrato");
    JButton btnReporte = new JButton("Generar Reporte");
    JButton btnAgregar = new JButton("Agregar Empleado");
    JButton btnHoras = new JButton("Registrar Horas");
    JButton btnCalcularP = new JButton("Calcular Pago Mensual");
    JButton btnBuscar = new JButton("Buscar Empleado");

    JTextArea tSalida = new JTextArea();

    JDateChooser FechaContratacion = new JDateChooser();
    JDateChooser FechaFinContratoAgregar = new JDateChooser();
    JDateChooser FechaFinContratoNueva = new JDateChooser();

    String rutaFoto = "";
    JRadioButton eEstandar = new JRadioButton("Estandar", true);
    JRadioButton eTemporal = new JRadioButton("Temporal");
    JRadioButton eVentas = new JRadioButton("Ventas");
    ButtonGroup grupoTipo = new ButtonGroup();

    public FrameGestion1() {
        this.setTitle("Gestion de empleados");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        grupoTipo.add(eEstandar);
        grupoTipo.add(eTemporal);
        grupoTipo.add(eVentas);
        JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTipo.add(new JLabel("Tipo de empleado: "));
        panelTipo.add(eEstandar);
        panelTipo.add(eTemporal);
        panelTipo.add(eVentas);

        JPanel PanelAgregar = new JPanel(new GridLayout(0, 2, 5, 5));
        PanelAgregar.add(new JLabel("Codigo:"));
        PanelAgregar.add(tCodigoAgregar);
        PanelAgregar.add(new JLabel("Nombre:"));
        PanelAgregar.add(tNombreAgregar);
        PanelAgregar.add(new JLabel("Fecha de contratacion:"));
        PanelAgregar.add(FechaContratacion);
        PanelAgregar.add(new JLabel("Salario base:"));
        PanelAgregar.add(tSalarioBAgregar);
        PanelAgregar.add(new JLabel("Tasa comision % (si es Ventas):"));
        PanelAgregar.add(tTcomisionAgregar);
        PanelAgregar.add(new JLabel("Fecha fin contrato (si es Temporal):"));
        PanelAgregar.add(FechaFinContratoAgregar);

        JPanel panelFoto = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFoto.add(new JLabel("Foto:"));
        panelFoto.add(btnFoto);
        panelFoto.add(Foto);

        JPanel panelNorteAgregar = new JPanel(new BorderLayout());
        panelNorteAgregar.add(panelTipo, BorderLayout.NORTH);
        panelNorteAgregar.add(PanelAgregar, BorderLayout.CENTER);
        panelNorteAgregar.add(panelFoto, BorderLayout.SOUTH);

        JPanel panelBtnAgregar = new JPanel(new FlowLayout());
        panelBtnAgregar.add(btnAgregar);

        JPanel tabAgregar = new JPanel(new BorderLayout());
        tabAgregar.add(panelNorteAgregar, BorderLayout.NORTH);
        tabAgregar.add(panelBtnAgregar, BorderLayout.SOUTH);

        JPanel PanelHoras = new JPanel(new GridLayout(0, 2, 5, 5));
        PanelHoras.add(new JLabel("Codigo:"));
        PanelHoras.add(tCodigoHoras);
        PanelHoras.add(new JLabel("Horas trabajadas:"));
        PanelHoras.add(tHoras);

        JPanel tabHoras = new JPanel(new BorderLayout());
        tabHoras.add(PanelHoras, BorderLayout.CENTER);
        JPanel panelBtnHoras = new JPanel(new FlowLayout());
        panelBtnHoras.add(btnHoras);
        tabHoras.add(panelBtnHoras, BorderLayout.SOUTH);

        JPanel PanelVenta = new JPanel(new GridLayout(0, 2, 5, 5));
        PanelVenta.add(new JLabel("Codigo:"));
        PanelVenta.add(tCodigoVenta);
        PanelVenta.add(new JLabel("Monto de venta:"));
        PanelVenta.add(tMontoVenta);

        JPanel tabVenta = new JPanel(new BorderLayout());
        tabVenta.add(PanelVenta, BorderLayout.CENTER);
        JPanel panelBtnVenta = new JPanel(new FlowLayout());
        panelBtnVenta.add(btnVenta);
        tabVenta.add(panelBtnVenta, BorderLayout.SOUTH);

        JPanel PanelContrato = new JPanel(new GridLayout(0, 2, 5, 5));
        PanelContrato.add(new JLabel("Codigo:"));
        PanelContrato.add(tCodigoContrato);
        PanelContrato.add(new JLabel("Nueva fecha fin contrato:"));
        PanelContrato.add(FechaFinContratoNueva);

        JPanel tabContrato = new JPanel(new BorderLayout());
        tabContrato.add(PanelContrato, BorderLayout.CENTER);
        JPanel panelBtnContrato = new JPanel(new FlowLayout());
        panelBtnContrato.add(btnContrato);
        tabContrato.add(panelBtnContrato, BorderLayout.SOUTH);

        JPanel PanelBuscar = new JPanel(new GridLayout(0, 2, 5, 5));
        PanelBuscar.add(new JLabel("Codigo:"));
        PanelBuscar.add(tCodigoBuscar);

        JPanel tabBuscar = new JPanel(new BorderLayout());
        tabBuscar.add(PanelBuscar, BorderLayout.CENTER);
        JPanel panelBtnBuscar = new JPanel(new FlowLayout());
        panelBtnBuscar.add(btnBuscar);
        tabBuscar.add(panelBtnBuscar, BorderLayout.SOUTH);

        JPanel PanelPago = new JPanel(new GridLayout(0, 2, 5, 5));
        PanelPago.add(new JLabel("Codigo:"));
        PanelPago.add(tCodigoPago);

        JPanel tabPago = new JPanel(new BorderLayout());
        tabPago.add(PanelPago, BorderLayout.CENTER);
        JPanel panelBtnPago = new JPanel(new FlowLayout());
        panelBtnPago.add(btnCalcularP);
        tabPago.add(panelBtnPago, BorderLayout.SOUTH);

        JPanel tabReporte = new JPanel(new FlowLayout());
        tabReporte.add(btnReporte);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Agregar Empleado", tabAgregar);
        tabs.addTab("Registrar Horas", tabHoras);
        tabs.addTab("Registrar Venta", tabVenta);
        tabs.addTab("Actualizar Contrato", tabContrato);
        tabs.addTab("Buscar Empleado", tabBuscar);
        tabs.addTab("Calcular Pago", tabPago);
        tabs.addTab("Reporte", tabReporte);

        add(tabs, BorderLayout.CENTER);

        tSalida.setEditable(false);
        JScrollPane scroll = new JScrollPane(tSalida);
        add(scroll, BorderLayout.SOUTH);

        btnFoto.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnHoras.addActionListener(this);
        btnVenta.addActionListener(this);
        btnContrato.addActionListener(this);
        btnReporte.addActionListener(this);
        btnCalcularP.addActionListener(this);
        btnBuscar.addActionListener(this);

        this.setVisible(true);

    }

   

    private LocalDate convertirFecha(JDateChooser chooser) {
        if (chooser.getDate() == null) {
            return LocalDate.now();
        }
        return chooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFoto) {
            JFileChooser fc = new JFileChooser();
            int resultado = fc.showOpenDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = fc.getSelectedFile();
                rutaFoto = archivo.getAbsolutePath();
                Foto.setText(archivo.getName());

                ImageIcon icono = new ImageIcon(rutaFoto);
                Image imagenEscalada = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                Foto.setIcon(new ImageIcon(imagenEscalada));
                Foto.setText("");
            }
        }

        if (e.getSource() == btnAgregar) {
            String tipo = "";
            if (eEstandar.isSelected()) {
                tipo = "Estandar";
            } else if (eTemporal.isSelected()) {
                tipo = "Temporal";
            } else if (eVentas.isSelected()) {
                tipo = "Ventas";
            }

            String codigo = tCodigoAgregar.getText();
            String nombre = tNombreAgregar.getText();
            LocalDate fechaContratacion = convertirFecha(FechaContratacion);
            double salarioBase;
            double tasaComision = 0;
            LocalDate fechaFin = null;

            try {
                salarioBase = Double.parseDouble(tSalarioBAgregar.getText());
            } catch (NumberFormatException ex) {
                tSalida.append("Error: ingrese un salario base valido.\n");
                return;
            }

            if (tipo.equals("Ventas")) {
                try {
                    tasaComision = Double.parseDouble(tTcomisionAgregar.getText()) / 100.0;
                } catch (NumberFormatException ex) {
                    tSalida.append("Error: ingrese una tasa de comision valida.\n");
                    return;
                }
            }

            if (tipo.equals("Temporal")) {
                fechaFin = convertirFecha(FechaFinContratoAgregar);
            }

            File foto = rutaFoto.isEmpty() ? null : new File(rutaFoto);

            int resultado = empresa.registrarEmpleados(nombre, codigo, fechaContratacion, salarioBase, 0, foto, tipo, tasaComision, fechaFin);

            if (resultado == 0) {
                tSalida.append("Error: el codigo " + codigo + " ya existe.\n");
            } else if (resultado == 4) {
                tSalida.append("Error: seleccione un tipo de empleado valido.\n");
            } else {
                tSalida.append("Empleado agregado (" + tipo + "): " + codigo + " - " + nombre + "\n");
            }
        }

        if (e.getSource() == btnHoras) {
            String codigo = tCodigoHoras.getText();
            try {
                int horas = Integer.parseInt(tHoras.getText());
                int resultado = empresa.registrarHorasTrabajadas(codigo, horas);
                if (resultado == -1) {
                    tSalida.append("Error: empleado " + codigo + " no encontrado.\n");
                } else if (resultado == 0) {
                    tSalida.append("Error: las horas no pueden ser negativas.\n");
                } else {
                    tSalida.append("Horas registradas para: " + codigo + " -> " + horas + "\n");
                }
            } catch (NumberFormatException ex) {
                tSalida.append("Error: ingrese un numero de horas valido.\n");
            }
        }

        if (e.getSource() == btnVenta) {
            String codigo = tCodigoVenta.getText();
            try {
                double monto = Double.parseDouble(tMontoVenta.getText());
                int resultado = empresa.registrarVentas(codigo, monto);
                if (resultado == -1) {
                    tSalida.append("Error: empleado " + codigo + " no encontrado.\n");
                } else if (resultado == 0) {
                    tSalida.append("Error: no se pudo registrar la venta.\n");
                } else {
                    tSalida.append("Venta registrada para: " + codigo + " -> " + monto + "\n");
                }
            } catch (NumberFormatException ex) {
                tSalida.append("Error: ingrese un monto de venta valido.\n");
            }
        }

        if (e.getSource() == btnContrato) {
            String codigo = tCodigoContrato.getText();
            LocalDate nuevaFecha = convertirFecha(FechaFinContratoNueva);
            int resultado = empresa.actualizarFechaDeFinDeContrato(codigo, nuevaFecha);
            if (resultado == -1) {
                tSalida.append("Error: empleado " + codigo + " no encontrado.\n");
            } else {
                tSalida.append("Contrato actualizado para: " + codigo + "\n");
            }
        }

        if (e.getSource() == btnCalcularP) {
            String codigo = tCodigoPago.getText();
            double pago = empresa.calcularPagoMensual(codigo);
            if (pago == -1) {
                tSalida.append("Error: empleado " + codigo + " no encontrado.\n");
            } else {
                tSalida.append("Pago mensual para " + codigo + ": $" + String.format("%.2f", pago) + "\n");
            }
        }

        if (e.getSource() == btnBuscar) {
            String codigo = tCodigoBuscar.getText();
            String info = empresa.buscarEmpleadoPorCodigo(codigo);
            tSalida.append(info + "\n");
        }

        if (e.getSource() == btnReporte) {
            empresa.generarReportes(tSalida, tSalida, tSalida);
        }
    }

}
