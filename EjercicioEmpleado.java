import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioEmpleado extends JFrame implements ActionListener {
    // Componentes de la interfaz gráfica
    private JTextField txtCodigo;
    private JTextField txtNombres;
    private JTextField txtHorasTrabajadas;
    private JTextField txtValorHora;
    private JTextField txtPorcentajeRetencion;
    private JButton btnCalcular;
    private JLabel lblNombre;
    private JLabel lblCodigo;
    private JLabel lblSalarioBruto;
    private JLabel lblSalarioNeto;

    public EjercicioEmpleado() {
        // Configurar la ventana
        setTitle("Calculadora de Salario de Empleado");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear y configurar los componentes
        txtCodigo = new JTextField(10);
        txtNombres = new JTextField(10);
        txtHorasTrabajadas = new JTextField(10);
        txtValorHora = new JTextField(10);
        txtPorcentajeRetencion = new JTextField(10);
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        lblCodigo = new JLabel("Codigo empleado");
        lblNombre = new JLabel("Nombre del Empleado");
        lblSalarioBruto = new JLabel("Salario Bruto: ");
        lblSalarioNeto = new JLabel("Salario Neto: ");

        // Crear el panel y agregar los componentes
        JPanel panel = new JPanel(new GridLayout(12, 1));
        panel.add(new JLabel("Codigo del Empleado:"));
        panel.add(txtCodigo);
        panel.add(new JLabel("Nombres:"));
        panel.add(txtNombres);
        panel.add(new JLabel("Horas Trabajadas al Mes:"));
        panel.add(txtHorasTrabajadas);
        panel.add(new JLabel("Valor Hora Trabajada:"));
        panel.add(txtValorHora);
        panel.add(new JLabel("Porcentaje de Retenci0n en la Fuente:"));
        panel.add(txtPorcentajeRetencion);
        panel.add(new JLabel(""));
        panel.add(btnCalcular);
        // panel.add(new JLabel(""));
        panel.add(lblCodigo);
        panel.add(new JLabel(""));
        panel.add(lblNombre);
        panel.add(new JLabel(""));
        panel.add(lblSalarioBruto);
        panel.add(new JLabel(""));
        panel.add(lblSalarioNeto);

        // Agregar el panel a la ventana
        add(panel);

        // Mostrar la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            // Obtener los datos ingresados por el usuario
            String codigo = txtCodigo.getText();
            String nombres = txtNombres.getText();
            double horasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());
            double valorHora = Double.parseDouble(txtValorHora.getText());
            double porcentajeRetencion = Double.parseDouble(txtPorcentajeRetencion.getText());

            // Calcular el salario bruto y neto
            double salarioBruto = horasTrabajadas * valorHora;
            double retencion = salarioBruto * (porcentajeRetencion / 100);
            double salarioNeto = salarioBruto - retencion;

            // Actualizar las etiquetas de salario bruto y neto
            lblCodigo.setText("Codigo: " + codigo);
            lblNombre.setText("Nombre: " + nombres);
            lblSalarioBruto.setText("Salario Bruto: $" + salarioBruto);
            lblSalarioNeto.setText("Salario Neto: $" + salarioNeto);
        }
    }

    public static void main(String[] args) {
        new EjercicioEmpleado();

    }
}
