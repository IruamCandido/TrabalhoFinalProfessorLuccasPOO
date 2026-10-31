README
# Sistema de Gestão de Estacionamento - POO

## Integrantes
- Geovani Iruam Delfino Candido
- Diego Rossi
- Elizabete de Mendonça Eurico
- Ana Clara Veiga.

## Variante do Domínio
**Variante:** Gestão de Estacionamento
- **Recurso Disputado:** Vagas de estacionamento (Moto, Padrão, VIP/SUV).
- **Regras de Invariante Espacial/Atributo:** Impedir alocação de veículos cujo porte seja maior do que a capacidade permitida pela vaga.
- **Regras de Invariante Temporal:** Validação estrita de ordem cronológica do `Periodo` e bloqueio de sobreposição de horários na mesma vaga.

## Requisitos Executados no Checkpoint 1
- Modelagem imutável com `record` (`Periodo`, `Veiculo`).
- Validações de invariante em construtores lançando exceções de forma imediata.
- Cobertura por testes de unidade via JUnit 5/6.

## Como Executar
No terminal na raiz do projeto:
```cmd
.\mvnw.cmd clean test

## Processo de Evolução (Etapa 2)
1. **Evolução do Modelo e Invariantes:** Adicionada validação na classe `Estacionamento` para impedir a entrada de veículos nulos, protegendo o estado do sistema.
2. **Polimorfismo e Genéricos:** Transformação de `Veiculo` em classe abstrata com `calcularTaxa()` e criação da classe `Repositorio<T>` para gerenciar listas genéricas.
3. **Tratamento de Falhas:** Criação da `EstacionamentoException` para isolar os erros de regras de negócio.
4. **Testes de Evolução:** Criação do `EstacionamentoTest` usando JUnit para validar a invariante de veículo nulo.

## Checkpoint 3 e Entrega Final
* **Abstrações e Padrões:** Implementação do padrão *Strategy* (`CalculoTaxa`) para separar a lógica de preços da entidade `Veiculo`. Isso garante baixo acoplamento e facilita a adição de novas regras de cobrança.
* **Testes de Limites e Regressão:** Criação da suíte `LimitesTaxaTest` garantindo que o comportamento integrado não cobra taxas de veículos com zero horas de estadia e realiza o cálculo correto de regressão linear para estadias longas.
* **Robustez e Autoria:** Código refatorado sem regressões nos testes anteriores (100% de sucesso no Test Explorer).
* **Autoria Individual:** Desenvolvido integralmente com gestão de histórico para avaliação e demonstração da arquitetura POO.