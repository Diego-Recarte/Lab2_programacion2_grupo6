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
public class FrameGestion extends JFrame implements ActionListener {

    JTextField tCodigo = new JTextField();
    JTextField tNombre = new JTextField();
    JTextField tSalarioB = new JTextField();
    JTextField tHoras = new JTextField();
    JTextField tfechaFcontrato = new JTextField();
    JTextField tTcomision = new JTextField();
    JTextField tMontoVenta = new JTextField();

    JLabel Foto = new JLabel("No existe Foto");
    JButton btnFoto = new JButton("Elegir Foto");
    JButton btnVenta = new JButton("Registrar Venta");
    JButton btnContrato = new JButton("Actualizar Contrato");
    JButton btnReporte = new JButton("Generar Reporte");
    JButton btnAgregar = new JButton("Agregar Empleado");
    JButton btnHoras = new JButton("Registrar Horas");

    JTextArea tSalida = new JTextArea();

    JDateChooser FechaContratacion = new JDateChooser();

    String rutaFoto = "";
    JRadioButton eEstandar = new JRadioButton("Estandar", true);
    JRadioButton eTemporal = new JRadioButton("Temporal");
    JRadioButton eVentas = new JRadioButton("Ventas");
    ButtonGroup grupoTipo = new ButtonGroup();

    public FrameGestion() {
        this.setTitle("Gestion de empleados");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(700, 700);
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

        JPanel Panel = new JPanel(new GridLayout(0, 2, 5, 5));

        Panel.add(new JLabel("Codigo:"));
        Panel.add(tCodigo);
        Panel.add(new JLabel("Nombre:"));
        Panel.add(tNombre);
        Panel.add(new JLabel("Fecha de contratacion:"));
        Panel.add(FechaContratacion);
        Panel.add(new JLabel("Salario base:"));
        Panel.add(tSalarioB);
        Panel.add(new JLabel("Horas trabajadas:"));
        Panel.add(tHoras);
        Panel.add(new JLabel("Fecha fin contrato (si es Temporal):"));
        Panel.add(tfechaFcontrato);
        Panel.add(new JLabel("Tasa comision % (si es Ventas):"));
        Panel.add(tTcomision);
        Panel.add(new JLabel("Monto de venta (para registrar venta):"));
        Panel.add(tMontoVenta);

        JPanel panelFoto = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFoto.add(new JLabel("Foto:"));
        panelFoto.add(btnFoto);
        panelFoto.add(Foto);

        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.add(panelTipo, BorderLayout.NORTH);
        panelNorte.add(Panel, BorderLayout.CENTER);
        panelNorte.add(panelFoto, BorderLayout.SOUTH);
        add(panelNorte, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAgregar);
        panelBotones.add(btnHoras);
        panelBotones.add(btnVenta);
        panelBotones.add(btnContrato);
        panelBotones.add(btnReporte);
        add(panelBotones, BorderLayout.SOUTH);

        tSalida.setEditable(false);
        JScrollPane scroll = new JScrollPane(tSalida);
        add(scroll, BorderLayout.CENTER);

        btnFoto.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnHoras.addActionListener(this);
        btnVenta.addActionListener(this);
        btnContrato.addActionListener(this);
        btnReporte.addActionListener(this);

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

            tSalida.append("Empleado agregado (" + tipo + "): " + tCodigo.getText() + " - " + tNombre.getText() + "\n");

        }

        if (e.getSource() == btnHoras) {

            tSalida.append("Horas registradas para: " + tCodigo.getText() + " -> " + tHoras.getText() + "\n");
        }

        
        
        if (e.getSource() == btnVenta) {

            tSalida.append("Venta registrada para: " + tCodigo.getText() + " -> " + tMontoVenta.getText() + "\n");
        }

        
        
        if (e.getSource() == btnContrato) {

            tSalida.append("Contrato actualizado para: " + tCodigo.getText() + " -> " + tfechaFcontrato.getText() + "\n");
        }

        
        
        if (e.getSource() == btnReporte) {
            tSalida.append(" Reporte generado \n");
        }

        
        
        
    }

}
