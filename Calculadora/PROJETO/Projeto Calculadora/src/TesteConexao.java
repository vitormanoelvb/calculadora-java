import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/calculadora_db?useSSL=false&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";

        try {
            // Carregando o driver (opcional em versões novas, mas recomendado)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ CONECTADO com sucesso ao banco de dados!");
            conexao.close();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ NÃO CONECTADO ao banco de dados:");
            e.printStackTrace();
        }
    }
}