package atividade;

public class CalculadoraIngressos {

    /**
     * Calcula o custo de uma compra de ingressos.
     * Retorna -1 se a quantidade de ingressos for inválida (> 5).
     */
    public int calcularValorIngresso(int idade, int qtdIngressos) {
        
        // 1. Validação de Restrição (Qtd. Máxima)
        if (qtdIngressos > 5) {
            return -1; // Sinalizador de erro para quantidade excessiva
        }
        
        int precoUnitario;
        
        // 2. Cálculo do Preço Unitário baseado na idade
        if (idade <= 12) {
            precoUnitario = 10;
        } else if (idade <= 59) {
            precoUnitario = 30;
        } else { // idade >= 60
            precoUnitario = 15;
        }
        
        return precoUnitario * qtdIngressos;
    }
}
