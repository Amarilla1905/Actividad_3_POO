import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioSalario extends JFrame {
    private JTextField nombreField;
    private JTextField salarioField;
    private JTextField horasField;
    private JButton calcularButton;
    private JTextArea resultadoTextArea;

    public EjercicioSalario() {
        setTitle("Cálculo de Salario Mensual");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nombreLabel = new JLabel("Nombre del empleado: ");
        nombreField = new JTextField(15);

        JLabel salarioLabel = new JLabel("Salario básico por hora: ");
        salarioField = new JTextField(15);

        JLabel horasLabel = new JLabel("Número de horas trabajadas: ");
        horasField = new JTextField(15);

        calcularButton = new JButton("Calcular");
        resultadoTextArea = new JTextArea();

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEjercicioSalario();
            }
        });
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(salarioLabel);
        panel.add(salarioField);
        panel.add(horasLabel);
        panel.add(horasField);
        panel.add(calcularButton);
        panel.add(resultadoTextArea);

        getContentPane().add(panel, BorderLayout.CENTER);

    }

    private void calcularEjercicioSalario() {
        String nombre = nombreField.getText();
        double salarioPorHora = Double.parseDouble(salarioField.getText());
        int horasTrabajadas = Integer.parseInt(horasField.getText());

        double EjercicioSalario = salarioPorHora * horasTrabajadas;

        if (EjercicioSalario > 450000) {
            resultadoTextArea.setText("Nombre: " + nombre + "\nSalario Mensual: $" + EjercicioSalario);
            ;
        } else {
            resultadoTextArea.setText("Nombre: " + nombre);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EjercicioSalario().setVisible(true);
            }
        });
    }
}
