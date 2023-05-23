import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioAB extends JFrame implements ActionListener {
    // Componentes de la interfaz gráfica
    private JTextField txtA;
    private JTextField txtB;
    private JButton btnComparar;
    private JLabel lblResultado;

    public EjercicioAB() {
        // Configurar la ventana
        setTitle("Comparacion de numeros");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear y configurar los componentes
        txtA = new JTextField(10);
        txtB = new JTextField(10);
        btnComparar = new JButton("Comparar");
        btnComparar.addActionListener(this);
        lblResultado = new JLabel("");

        // Crear el panel y agregar los componentes
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Valor de A:"));
        panel.add(txtA);
        panel.add(new JLabel("Valor de B:"));
        panel.add(txtB);
        panel.add(new JLabel(""));
        panel.add(btnComparar);
        panel.add(lblResultado);

        // Agregar el panel a la ventana
        add(panel);

        // Mostrar la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnComparar) {
            // Obtener los valores de A y B ingresados por el usuario
            int a = Integer.parseInt(txtA.getText());
            int b = Integer.parseInt(txtB.getText());

            // Comparar los valores de A y B
            if (a > b) {
                lblResultado.setText("A es mayor que B");
            } else if (a < b) {
                lblResultado.setText("A es menor que B");
            } else {
                lblResultado.setText("A es igual a B");
            }
        }
    }

    public static void main(String[] args) {

        new EjercicioAB();

    }
}
