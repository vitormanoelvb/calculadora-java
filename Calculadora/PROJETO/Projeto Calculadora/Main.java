public class Main {
    public static void main(String[] args) {
        // Tela inicial
        SplashScreen splash = new SplashScreen();
        splash.mostrarSplash();

        // Depois chama a calculadora
        javax.swing.SwingUtilities.invokeLater(() -> {
            CalculadoraFrame frame = new CalculadoraFrame();
            frame.setVisible(true);
        });
    }
}