import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjercicioMinMax extends JFrame {
    private List<Integer> datos;

    private JTextField textField;
    private JButton agregarButton;
    private JButton calcularButton;
    private JLabel resultadoLabel;

    public EjercicioMinMax() {
        datos = new ArrayList<>();

        setTitle("Suma de máximo y mínimo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        agregarButton = new JButton("Agregar");
        calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDato();
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSuma();
            }
        });

        add(new JLabel("Ingrese un número positivo: "));
        add(textField);
        add(agregarButton);
        add(calcularButton);
        add(resultadoLabel);
    }

    private void agregarDato() {
        try {
            int dato = Integer.parseInt(textField.getText());
            if (dato >= 0) {
                datos.add(dato);
                textField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "¡Ingrese un número positivo!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "¡Ingrese un número válido!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularSuma() {
        if (datos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡Ingrese al menos un dato!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int maximo = Collections.max(datos);
            int minimo = Collections.min(datos);
            int suma = maximo + minimo;
            resultadoLabel.setText("Suma del máximo y mínimo: " + suma);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EjercicioMinMax().setVisible(true);
            }
        });
    }
}
