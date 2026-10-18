# Declaração de Uso de Inteligência Artificial (IA)

## 1. Objetivo do Uso
Auxílio no scaffold inicial do projeto, estruturação do `pom.xml` compatível com Java 25, e geração preliminar da suíte de testes de unidade para validação de invariantes.

## 2. Partes do Projeto Afetadas
- Configuração do Maven (`pom.xml`).
- Esqueleto de testes de unidade (`PeriodoTest.java` e `ReservaTest.java`).

## 3. Validação e Ajustes Feitos pela Equipe
- Execução do comando `.\mvnw.cmd clean test` em terminal para garantir a compilação.
- Validação das regras de negócio do domínio e revisão de tipos imutáveis (`record`).