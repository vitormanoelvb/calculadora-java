import java.sql.Connection;
import java.sql.PreparedStatement;

public class CalculadoraDAO {

    public static void salvarOperacao(String expressao, String resultado) {
        String sql = "INSERT INTO operacoes (expressao, resultado) VALUES (?, ?)";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, expressao);
            stmt.setString(2, resultado);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao salvar operação: " + e.getMessage());
        }
    }
}