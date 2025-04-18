public class AvaliadorExpressao {

    public static double avaliar(String expressao) throws Exception {
        return resolver(expressao.replace(" ", ""));
    }

    private static double resolver(String expr) throws Exception {
        if (expr.isEmpty()) {
            throw new Exception("Expressão vazia");
        }

        // Suporta +, -, *, /
        char[] operadores = {'+', '-', '*', '/'};
        for (char op : operadores) {
            int idx = ultimoIndiceOperador(expr, op);
            if (idx > 0) {
                double esquerda = resolver(expr.substring(0, idx));
                double direita = resolver(expr.substring(idx + 1));
                switch (op) {
                    case '+': return esquerda + direita;
                    case '-': return esquerda - direita;
                    case '*': return esquerda * direita;
                    case '/':
                        if (direita == 0) throw new ArithmeticException("Divisão por zero");
                        return esquerda / direita;
                }
            }
        }

        return Double.parseDouble(expr);
    }

    private static int ultimoIndiceOperador(String expr, char operador) {
        // Ignora sinais negativos no início
        for (int i = expr.length() - 1; i > 0; i--) {
            char c = expr.charAt(i);
            if (c == operador) return i;
        }
        return -1;
    }
}