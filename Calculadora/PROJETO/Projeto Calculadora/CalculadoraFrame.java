import javax.swing.*;
import java.awt.event.*;

public class CalculadoraFrame extends JFrame {

    private CalculadoraPainel painel;

    public CalculadoraFrame() {
        setTitle("Calculadora");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        painel = new CalculadoraPainel();
        add(painel);

        // Ao clicar no X, mostrar tela de encerramento
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Fecha a calculadora
                dispose();
        
                // Cria nova thread para mostrar a tela final
                new Thread(() -> {
                    FinalSplashScreen splashFinal = new FinalSplashScreen();
                    splashFinal.mostrarEncerramento(); // esta função exibe a imagem
                }).start();
            }
        });        
    }
}