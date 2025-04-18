import javax.swing.*;
import java.awt.*;

public class FinalSplashScreen extends JFrame {

    public FinalSplashScreen() {
        setUndecorated(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null); // layout manual para personalização total

        // Fundo com imagem redimensionada
        ImageIcon imagem = new ImageIcon("Calculadora Final.jpg");
        Image imagemRedimensionada = imagem.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel fundo = new JLabel(new ImageIcon(imagemRedimensionada));
        fundo.setBounds(0, 0, getWidth(), getHeight());
        fundo.setLayout(new GridBagLayout());

        // Painel transparente para centralizar o texto
        JPanel painelTexto = new JPanel(new GridBagLayout());
        painelTexto.setOpaque(false);
        painelTexto.setPreferredSize(new Dimension(getWidth(), getHeight()));

        // Texto centralizado
        JLabel texto = new JLabel("<html><div style='text-align: center;'>"
                + "<span style='font-size: 22pt; color: white;'>"
                + "Obrigado por utilizar a calculadora"
                + "</span></div></html>");

        painelTexto.add(texto);
        fundo.add(painelTexto);
        add(fundo);
    }

    public void mostrarEncerramento() {
        setVisible(true);
        try {
            Thread.sleep(3000); // mantém visível por 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dispose(); // fecha a tela
        System.exit(0); // encerra o programa
    }
}