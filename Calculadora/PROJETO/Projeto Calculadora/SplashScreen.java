import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    private JProgressBar barraProgresso;

    public SplashScreen() {
        setUndecorated(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        // Carrega e redimensiona a imagem
        ImageIcon originalIcon = new ImageIcon("foto_calculadora.jpg");
        Image imagemEscalada = originalIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel fundo = new JLabel(new ImageIcon(imagemEscalada));
        fundo.setBounds(0, 0, getWidth(), getHeight());
        fundo.setLayout(null);
        setContentPane(fundo);

        // Painel de sobreposição para texto com transparência
        JPanel painelTexto = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g2d.setColor(Color.BLACK);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        painelTexto.setLayout(new GridBagLayout());
        painelTexto.setBounds(0, 0, 600, 350);
        painelTexto.setOpaque(false);

        JLabel texto = new JLabel("<html><div style='text-align: center;'>"
                + "<span style='font-size: 22pt; color: white;'>"
                + "DESENVOLVIDO POR VITOR MANOEL<br>"
                + "VM ENGINE DEVELOPMENT<br>"
                + "CALCULADORA"
                + "</span></div></html>");
        painelTexto.add(texto);
        fundo.add(painelTexto);

        // Barra de progresso
        barraProgresso = new JProgressBar();
        barraProgresso.setBounds(50, 360, 500, 20);
        barraProgresso.setStringPainted(true);
        barraProgresso.setForeground(Color.GREEN);
        fundo.add(barraProgresso);

        // Opacidade inicial (fade-in)
        setOpacity(0f);
    }

    public void mostrarSplash() {
        setVisible(true);

        // Fade-in
        for (float f = 0f; f <= 1f; f += 0.02f) {
            setOpacity(f);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Simula carregamento
        for (int i = 0; i <= 100; i++) {
            barraProgresso.setValue(i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        dispose(); // fecha splash
    }
}