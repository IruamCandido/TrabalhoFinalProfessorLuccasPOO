README
# Sistema de Gestão de Estacionamento - POO

## Integrantes
- Geovani Iruam Delfino Candido
- Diego Rossi
-Elizabete de Mendonça Eurico
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