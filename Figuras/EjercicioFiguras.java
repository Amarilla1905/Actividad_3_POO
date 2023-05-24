package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioFiguras extends JFrame {

    private JTextField txtRadio;
    private JTextField txtBase;
    private JTextField txtAltura;
    private JTextField txtLado;
    private JTextArea txtResultado;
    private JComboBox<String> comboFiguras;

    public EjercicioFiguras() {
        setTitle("Figuras Geométricas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(16, 2));

        JLabel lblFigura = new JLabel("Figura:");
        comboFiguras = new JComboBox<>(new String[] { "Círculo", "Rectángulo", "Cuadrado", "Triángulo" });
        JLabel lblRadio = new JLabel("Radio:");
        txtRadio = new JTextField();
        JLabel lblBase = new JLabel("Base:");
        txtBase = new JTextField();
        JLabel lblAltura = new JLabel("Altura:");
        txtAltura = new JTextField();
        JLabel lblLado = new JLabel("Lado:");
        txtLado = new JTextField();

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String figuraSeleccionada = (String) comboFiguras.getSelectedItem();
                double area = 0;
                double perimetro = 0;

                if (figuraSeleccionada.equals("Círculo")) {
                    double radio = Double.parseDouble(txtRadio.getText());
                    Circulo circulo = new Circulo(radio);
                    area = circulo.calcularArea();
                    perimetro = circulo.calcularPerimetro();
                } else if (figuraSeleccionada.equals("Rectángulo")) {
                    double base = Double.parseDouble(txtBase.getText());
                    double altura = Double.parseDouble(txtAltura.getText());
                    Rectangulo rectangulo = new Rectangulo(base, altura);
                    area = rectangulo.calcularArea();
                    perimetro = rectangulo.calcularPerimetro();
                } else if (figuraSeleccionada.equals("Cuadrado")) {
                    double lado = Double.parseDouble(txtLado.getText());
                    Cuadrado cuadrado = new Cuadrado(lado);
                    area = cuadrado.calcularArea();
                    perimetro = cuadrado.calcularPerimetro();
                } else if (figuraSeleccionada.equals("Triángulo")) {
                    double base = Double.parseDouble(txtBase.getText());
                    double altura = Double.parseDouble(txtAltura.getText());
                    TrianguloRectangulo triangulo = new TrianguloRectangulo(base, altura);
                    area = triangulo.calcularArea();
                    perimetro = triangulo.calcularPerimetro();
                }

                txtResultado.setText("Área: " + area + "\nPerímetro: " + perimetro);
            }
        });

        JLabel lblResultado = new JLabel("Resultado:");
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultado);

        add(lblFigura);
        add(comboFiguras);
        add(lblRadio);
        add(txtRadio);
        add(lblBase);
        add(txtBase);
        add(lblAltura);
        add(txtAltura);
        add(lblLado);
        add(txtLado);
        add(btnCalcular);
        add(lblResultado);
        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new EjercicioFiguras();
    }

    private class Circulo {
        private double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        public double calcularArea() {
            return Math.PI * Math.pow(radio, 2);
        }

        public double calcularPerimetro() {
            return 2 * Math.PI * radio;
        }
    }

    private class Rectangulo {
        private double base;
        private double altura;

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        public double calcularArea() {
            return base * altura;
        }

        public double calcularPerimetro() {
            return 2 * (base + altura);
        }
    }

    private class Cuadrado {
        private double lado;

        public Cuadrado(double lado) {
            this.lado = lado;
        }

        public double calcularArea() {
            return Math.pow(lado, 2);
        }

        public double calcularPerimetro() {
            return 4 * lado;
        }
    }

    private class TrianguloRectangulo {
        private double base;
        private double altura;

        public TrianguloRectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        public double calcularArea() {
            return (base * altura) / 2;
        }

        public double calcularPerimetro() {
            double hipotenusa = calcularHipotenusa();
            return base + altura + hipotenusa;
        }

        public double calcularHipotenusa() {
            return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
        }
    }
}
