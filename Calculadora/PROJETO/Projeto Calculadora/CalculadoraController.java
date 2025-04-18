public class CalculadoraController {
    private StringBuilder expressao;

    public CalculadoraController() {
        expressao = new StringBuilder();
    }

    public void adicionarEntrada(String entrada) {
        expressao.append(entrada);
    }

    public void calcular() {
        try {
            String original = expressao.toString(); // salva antes do cálculo
    
            double resultado = AvaliadorExpressao.avaliar(original);
    
            String formatado;
            if (resultado % 1 == 0) {
                formatado = String.valueOf((int) resultado);
            } else {
                formatado = String.valueOf(resultado);
            }
    
            expressao = new StringBuilder(formatado);
    
            // Salva no banco
            CalculadoraDAO.salvarOperacao(original, formatado);
    
        } catch (Exception e) {
            expressao = new StringBuilder("Erro");
        }
    }

    public void limpar() {
        expressao.setLength(0);
    }

    public String getExpressao() {
        return expressao.toString();
    }
}