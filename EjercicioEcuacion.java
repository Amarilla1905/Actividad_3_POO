import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioEcuacion extends JFrame {
    private JTextField coeficienteATextField;
    private JTextField coeficienteBTextField;
    private JTextField coeficienteCTextField;
    private JTextArea solucionesTextArea;

    public EjercicioEcuacion() {
        setTitle("Solver de Ecuación de Segundo Grado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel coeficienteALabel = new JLabel("Coeficiente A:");
        coeficienteATextField = new JTextField();
        JLabel coeficienteBLabel = new JLabel("Coeficiente B:");
        coeficienteBTextField = new JTextField();
        JLabel coeficienteCLabel = new JLabel("Coeficiente C:");
        coeficienteCTextField = new JTextField();

        JButton resolverButton = new JButton("Resolver");
        resolverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resolverEcuacion();
            }
        });

        JLabel solucionesLabel = new JLabel("Soluciones:");
        solucionesTextArea = new JTextArea();
        solucionesTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(solucionesTextArea);

        panel.add(coeficienteALabel);
        panel.add(coeficienteATextField);
        panel.add(coeficienteBLabel);
        panel.add(coeficienteBTextField);
        panel.add(coeficienteCLabel);
        panel.add(coeficienteCTextField);
        panel.add(resolverButton);
        panel.add(solucionesLabel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);
    }

    private void resolverEcuacion() {
        double a = Double.parseDouble(coeficienteATextField.getText());
        double b = Double.parseDouble(coeficienteBTextField.getText());
        double c = Double.parseDouble(coeficienteCTextField.getText());

        double discriminante = b * b - 4 * a * c;
        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            solucionesTextArea.setText("x1 = " + x1 + "\nx2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            solucionesTextArea.setText("x = " + x);
        } else {
            solucionesTextArea.setText("No hay soluciones reales.");
        }
    }

    public static void main(String[] args) {
        EjercicioEcuacion interfazSolver = new EjercicioEcuacion();
        interfazSolver.setVisible(true);
    }
}
