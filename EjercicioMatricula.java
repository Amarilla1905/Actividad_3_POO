import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioMatricula extends JFrame {

    private JLabel lblNumeroInscripcion;
    private JLabel lblNombres;
    private JLabel lblPatrimonio;
    private JLabel lblEstratoSocial;
    private JTextField txtNumeroInscripcion;
    private JTextField txtNombres;
    private JTextField txtPatrimonio;
    private JTextField txtEstratoSocial;

    private JLabel lblPagoMatriculaR;
    private JLabel lblNumeroInscripcionR;
    private JLabel lblNombresR;

    private JButton btnCalcular;

    public EjercicioMatricula() {
        // Crear la ventana
        setTitle("Pago de Matricula");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);

        // Crear los componentes
        lblNumeroInscripcion = new JLabel("Numero de inscripcion:");
        txtNumeroInscripcion = new JTextField(5);
        lblNombres = new JLabel("Nombres:");
        txtNombres = new JTextField(5);
        lblPatrimonio = new JLabel("Patrimonio:");
        txtPatrimonio = new JTextField(5);
        lblEstratoSocial = new JLabel("Estrato social:");
        txtEstratoSocial = new JTextField(5);
        lblNumeroInscripcionR = new JLabel("");
        lblNombresR = new JLabel("");
        lblPagoMatriculaR = new JLabel("");
        btnCalcular = new JButton("Calcular");

        // Agregar los componentes a la ventana
        JPanel panel = new JPanel(new GridLayout(12, 2));
        panel.add(lblNumeroInscripcion);
        panel.add(txtNumeroInscripcion);
        panel.add(lblNombres);
        panel.add(txtNombres);
        panel.add(lblPatrimonio);
        panel.add(txtPatrimonio);
        panel.add(lblEstratoSocial);
        panel.add(txtEstratoSocial);
        panel.add(lblNumeroInscripcionR);
        panel.add(lblNombresR);
        panel.add(lblPagoMatriculaR);

        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT)); // FlowLayout con alineación a la derecha
        panelBoton.add(btnCalcular);

        // Agregar el listener al botón de calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores ingresados por el usuario
                int numeroInscripcion = Integer.parseInt(txtNumeroInscripcion.getText());
                String nombres = txtNombres.getText();
                double patrimonio = Double.parseDouble(txtPatrimonio.getText());
                int estratoSocial = Integer.parseInt(txtEstratoSocial.getText());

                // Calcular el pago de matrícula
                double pagoMatricula = 50000; // Valor constante de matrícula
                if (patrimonio > 2000000 && estratoSocial > 3) {
                    pagoMatricula += patrimonio * 0.03; // Incrementar un 3% del patrimonio
                }

                // Mostrar el resultado en la etiqueta de resultado
                lblNumeroInscripcionR.setText("El estudiante con numero de inscripcion : " + numeroInscripcion);
                lblNombresR.setText("Nombres: " + nombres);
                lblPagoMatriculaR.setText("Debe pagar: $" + pagoMatricula);
            }
        });
        panel.add(panelBoton);
        add(panel);

        // Mostrar la ventana

        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear la interfaz gráfica
        new EjercicioMatricula();
    }
}
