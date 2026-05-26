# Banco POO

Projeto de simulação de um sistema bancário desenvolvido em Java utilizando Programação Orientada a Objetos.

## Descrição

Este projeto simula operações básicas de um banco, como criação de usuários, abertura de contas e transações financeiras. O objetivo principal é praticar conceitos de POO como:

- Classes e objetos
- Encapsulamento
- Herança
- Polimorfismo
- Abstração

## Funcionalidades

- Criar usuários
- Listar usuários cadastrados
- Abrir conta corrente ou poupança
- Realizar depósitos
- Realizar saques
- Transferências entre contas
- Encerrar contas

## Estrutura do projeto

O sistema é dividido em classes principais:

- Usuario: representa o cliente do banco
- Conta: classe abstrata base para contas bancárias
- ContaCorrente: implementação de conta corrente
- ContaPoupanca: implementação de conta poupança
- Banco: responsável pela gestão dos usuários e contas
- Interfaces para padronização de regras do sistema

## Regras do sistema

- Operações só podem ser realizadas com contas ativas
- Transferências exigem pelo menos duas contas válidas
- Usuários devem ser maiores de idade para abertura de conta

## Como executar

1. Clonar o repositório
2. Abrir o projeto em uma IDE Java (IntelliJ, Eclipse ou NetBeans)
3. Executar a classe principal (Main)
4. Interagir pelo terminal

## Objetivo do projeto

Projeto desenvolvido com foco em prática de Programação Orientada a Objetos em Java, simulando regras básicas de um sistema bancário.
