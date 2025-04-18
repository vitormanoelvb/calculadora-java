import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String URL = "jdbc:mysql://localhost:3306/calculadora_db";
    private static final String USUARIO = "root"; // ajuste se necessário
    private static final String SENHA = "root";       // coloque "root" se estiver usando senha

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}