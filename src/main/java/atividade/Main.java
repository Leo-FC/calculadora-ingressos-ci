package atividade;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Instancia a classe de lógica de negócios
        CalculadoraIngressos calculadora = new CalculadoraIngressos();
        
        int idade;
        int qtdIngressos;
        int valorTotalAcumulado = 0;
        String resposta;
        
        System.out.println("--- Sistema de Compra de Ingressos ---");
        
        while (true) {
            System.out.println("\nInforme a idade do visitante: ");
            idade = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Informe a quantidade de bilhetes (máx 5): ");
            qtdIngressos = sc.nextInt();
            sc.nextLine();
            
            // Chama o método da unidade de teste
            int valorCompraAtual = calculadora.calcularValorIngresso(idade, qtdIngressos);
            
            if (valorCompraAtual == -1) {
                // Condição de Qtd > 5 (tratada pela CalculadoraIngressos)
                System.out.println("É possível comprar apenas 5 bilhetes por pessoa. Tente novamente.");
                continue; // volta para pedir de novo
            }
            
            valorTotalAcumulado += valorCompraAtual;
            
            System.out.println("Valor total parcial: R$" + valorTotalAcumulado);
            System.out.println("Deseja continuar comprando? [S/N]");
            resposta = sc.nextLine();
            
            if (resposta.equalsIgnoreCase("N")) {
                break;
            }
        }
        
        System.out.println("\nValor total final da compra: R$" + valorTotalAcumulado);
        sc.close();
    }
}
