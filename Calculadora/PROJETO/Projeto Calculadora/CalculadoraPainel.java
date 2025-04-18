import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraPainel extends JPanel {
    private JTextField display;
    private CalculadoraController controller;

    public CalculadoraPainel() {
        controller = new CalculadoraController();
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel botoesPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.addActionListener(new BotaoListener());
            botoesPanel.add(botao);
        }

        add(botoesPanel, BorderLayout.CENTER);
    }

    private class BotaoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            if (comando.equals("C")) {
                controller.limpar();
            } else if (comando.equals("=")) {
                controller.calcular();
            } else {
                controller.adicionarEntrada(comando);
            }

            display.setText(controller.getExpressao());
        }
    }
}