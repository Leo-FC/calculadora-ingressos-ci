# Calculadora de Ingressos com CI/CD

Este é um projeto simples em Java que simula uma "Calculadora de Ingressos", criado com o objetivo principal de demonstrar um pipeline de Integração Contínua (CI/CD) utilizando **GitHub Actions**.

O workflow valida automaticamente o código, compila o projeto e executa os testes unitários a cada novo `push` ou `pull request` na branch `main`, garantindo que novas alterações não quebrem a funcionalidade existente.

## Tecnologias Utilizadas 🚀

  * **Linguagem:** `Java 11`
  * **Gerenciador de Build:** `Maven`
  * **Testes:** `JUnit 5`
  * **CI/CD:** `GitHub Actions`

-----

## O Pipeline de Integração Contínua

O "coração" deste projeto é o arquivo `.github/workflows/main.yaml`. Ele define um workflow que roda automaticamente nos servidores do GitHub e executa os seguintes passos:

1.  **Gatilho (Trigger):** O workflow é acionado automaticamente em duas situações:

      * Quando um `push` é feito para a branch `main`.
      * Quando um `pull_request` é aberto (ou atualizado) tendo a `main` como alvo.

2.  **Ambiente (Runner):** O pipeline configura uma máquina virtual `ubuntu-latest`.

3.  **Checkout:** O código-fonte do repositório é baixado para a máquina virtual.

4.  **Setup Java:** O ambiente é configurado com o `JDK 11` (a mesma versão usada no desenvolvimento, definida no `pom.xml`).

5.  **Build & Test:** O comando `mvn clean test` é executado. Este único comando faz o seguinte:

      * `clean`: Limpa compilações anteriores (a pasta `target/`).
      * `compile`: Compila o código-fonte (`.java` -\> `.class`).
      * `test`: O plugin **Maven Surefire** localiza e executa todos os testes escritos com `JUnit 5` (neste caso, os 6 testes da classe `CalculadoraIngressosTest`).

Se qualquer um dos testes falhar, o Maven retorna um erro, o build é marcado como "Falha" (X vermelho) e o merge (se for um PR) é desencorajado.

### O Arquivo de Workflow (`main.yaml`) 📜

Este é o arquivo que faz toda a mágica acontecer:

```yaml
name: Java CI com Maven e JUnit 5

# Define os gatilhos (triggers)
on:
  # Dispara no push para a branch 'main'
  push:
    branches: [ main ]
    
  # Dispara no pull request que tem como alvo a branch 'main'
  pull_request:
    branches: [ main ]

# Define os trabalhos (jobs)
jobs:
  build-e-test:
    # O tipo de máquina virtual para rodar o job
    runs-on: ubuntu-latest

    steps:
      # 1. Faz o checkout do seu código no runner
      - name: Checkout do código
        uses: actions/checkout@v4

      # 2. Configura o JDK 11
      - name: Configurar o JDK 11
        uses: actions/setup-java@v4
        with:
          java-version: '11'
          distribution: 'temurin'
          cache: 'maven' # Opcional: acelera os builds futuros

      # 3. Compila e roda testes JUnit
      - name: Compilar e rodar testes JUnit
        run: mvn clean test
```
