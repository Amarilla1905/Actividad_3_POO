import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Operaciones extends JFrame implements ActionListener {
    private JTextField inputField;
    private JTextArea outputArea;
    private JTextArea numerosIngresadosArea;
    private List<Integer> numerosIngresados;

    public Operaciones() {
        setTitle("Calculadora de Números");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new FlowLayout());

        numerosIngresados = new ArrayList<>();

        JLabel inputLabel = new JLabel("Ingrese un número entero positivo:");
        inputField = new JTextField(10);
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        JLabel numerosLabel = new JLabel("Números ingresados:");
        numerosIngresadosArea = new JTextArea(10, 30);
        numerosIngresadosArea.setEditable(false);

        add(inputLabel);
        add(inputField);
        add(calcularButton);
        add(new JScrollPane(outputArea));
        add(numerosLabel);
        add(new JScrollPane(numerosIngresadosArea));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Operaciones();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calcular")) {
            String input = inputField.getText();
            try {
                int numero = Integer.parseInt(input);
                if (numero >= 0) {
                    numerosIngresados.add(numero);
                    calcularNumeros(numero);
                    mostrarNumerosIngresados();
                    inputField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese un número entero positivo.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número entero válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void calcularNumeros(int numero) {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Raíz cuadrada de ").append(numero).append(": ").append(Math.sqrt(numero)).append("\n");
        resultado.append("Cuadrado de ").append(numero).append(": ").append(Math.pow(numero, 2)).append("\n");
        resultado.append("Cubo de ").append(numero).append(": ").append(Math.pow(numero, 3));

        outputArea.setText(resultado.toString());
    }

    private void mostrarNumerosIngresados() {
        StringBuilder numeros = new StringBuilder();
        for (Integer numero : numerosIngresados) {
            numeros.append(numero).append("\n");
        }
        numerosIngresadosArea.setText(numeros.toString());
    }
}
