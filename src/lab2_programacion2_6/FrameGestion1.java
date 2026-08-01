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

            tSalida.append("Empleado agregado (" + tipo + "): " + tCodigoAgregar.getText() + " - " + tNombreAgregar.getText() + "\n");

        }

        if (e.getSource() == btnHoras) {

            tSalida.append("Horas registradas para: " + tCodigoHoras.getText() + " -> " + tHoras.getText() + "\n");
        }

        if (e.getSource() == btnVenta) {

            tSalida.append("Venta registrada para: " + tCodigoVenta.getText() + " -> " + tMontoVenta.getText() + "\n");
        }

        if (e.getSource() == btnContrato) {

            tSalida.append("Contrato actualizado para: " + tCodigoContrato.getText() + "\n");
        }

        if (e.getSource() == btnCalcularP) {
            tSalida.append(" Calculando pago mensual para " + tCodigoPago.getText() + "\n");
        }

        if (e.getSource() == btnBuscar) {
            tSalida.append(" Buscando empleado codigo: " + tCodigoBuscar.getText() + "\n");
        }

        if (e.getSource() == btnReporte) {
            tSalida.append("---- Reporte generado ----\n");
        }

    }

}