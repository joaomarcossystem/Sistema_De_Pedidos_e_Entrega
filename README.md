# Ordering And Delivery System

Sistema desenvolvido em Java para demonstrar a utilização dos padrões de projeto **Factory Method** e **Abstract Factory** em um sistema simplificado de pedidos, pagamentos e entregas.

O projeto foi desenvolvido como atividade acadêmica da disciplina de **Padrões de Projeto de Software**.

---

## Tecnologias utilizadas

- Java 17 ou superior
- Biblioteca padrão do Java
- Programação Orientada a Objetos
- Factory Method
- Abstract Factory

O projeto não utiliza Spring ou qualquer outro framework externo.

---

## Objetivo

O sistema representa um fluxo simplificado de processamento de pedidos, envolvendo:

- Criação de pedidos;
- Validação de pagamentos;
- Emissão de recibos;
- Diferentes formas de pagamento;
- Diferentes formas de entrega;
- Cálculo do prazo estimado de entrega.

Os padrões **Abstract Factory** e **Factory Method** foram utilizados para separar a criação dos objetos concretos das classes que utilizam esses objetos.

---

# Estrutura do sistema

## Model

A classe `Pedido` representa os dados de um pedido.

Ela possui os seguintes atributos:

- Número do pedido;
- Cliente;
- Endereço;
- Valor.

---

## Abstract Factory

O padrão **Abstract Factory** é utilizado para a criação das famílias de produtos relacionados ao pagamento.

A interface `PagamentoAbstractFactory` define os métodos responsáveis por criar:

- `ValidadorPagamento`;
- `EmissorRecibo`.

As fábricas concretas são:

- `PixAbstractFactory`;
- `CartaoAbstractFactory`;
- `BoletoAbstractFactory`.

Cada fábrica cria os produtos correspondentes à sua forma de pagamento.

### Família PIX

```text
PixAbstractFactory
├── ValidadorPix
└── ReciboPix
```

### Família Cartão

```text
CartaoAbstractFactory
├── ValidadorCartao
└── ReciboCartao
```

### Família Boleto

```text
BoletoAbstractFactory
├── ValidadorBoleto
└── ReciboBoleto
```

A classe `ServicoPagamento` utiliza a abstração `PagamentoAbstractFactory`, sem precisar conhecer diretamente as classes concretas de cada pagamento.

---

## Factory Method

O padrão **Factory Method** é utilizado para a criação dos diferentes tipos de entrega.

A classe abstrata `CentralEntrega` define o método de fábrica:

```java
protected abstract Entrega criarEntrega();
```

As classes concretas são responsáveis por decidir qual tipo de entrega será criado.

### Entrega por moto

```text
CentralEntregaMotoFactory
└── EntregaMoto
```

### Entrega por bicicleta

```text
CentralEntregaBicicletaFactory
└── EntregaBicicleta
```

### Retirada no estabelecimento

```text
CentralEntregaRetiradaFactory
└── EntregaRetirada
```

A classe `CentralEntrega` mantém o fluxo comum de processamento do pedido, enquanto as subclasses definem qual objeto concreto de entrega será criado.

---


# Extensões implementadas

Além dos fluxos principais, foram implementadas duas extensões solicitadas:

- Pagamento por boleto;
- Retirada no estabelecimento.

Essas extensões foram adicionadas sem alterar o funcionamento das principais abstrações já existentes.

---

# Questões de análise

## 1. Onde o Factory Method foi utilizado?

O **Factory Method** foi utilizado no sistema de entregas.

A classe abstrata `CentralEntrega` possui o método:

```java
protected abstract Entrega criarEntrega();
```

Esse método é sobrescrito pelas fábricas concretas:

- `CentralEntregaMotoFactory`;
- `CentralEntregaBicicletaFactory`;
- `CentralEntregaRetiradaFactory`.

Cada uma dessas classes decide qual implementação concreta de `Entrega` será criada.

Por exemplo, `CentralEntregaMotoFactory` cria um objeto `EntregaMoto`, enquanto `CentralEntregaBicicletaFactory` cria um objeto `EntregaBicicleta`.

Dessa forma, a classe `CentralEntrega` não precisa conhecer diretamente as implementações concretas de entrega.

---

## 2. Onde o Abstract Factory foi utilizado?

O **Abstract Factory** foi utilizado no sistema de pagamentos.

A interface `PagamentoAbstractFactory` define os métodos:

```java
ValidadorPagamento criarValidadorPagamento();
EmissorRecibo criarEmissorRecibo();
```

As fábricas concretas são:

- `PixAbstractFactory`;
- `CartaoAbstractFactory`;
- `BoletoAbstractFactory`.

Cada fábrica cria uma família de produtos relacionados.

Por exemplo, `PixAbstractFactory` cria:

```text
ValidadorPix
ReciboPix
```

Enquanto `CartaoAbstractFactory` cria:

```text
ValidadorCartao
ReciboCartao
```

E `BoletoAbstractFactory` cria:

```text
ValidadorBoleto
ReciboBoleto
```

A classe `ServicoPagamento` trabalha somente com as abstrações `ValidadorPagamento` e `EmissorRecibo`, não precisando instanciar diretamente os produtos concretos.

---

## 3. Qual é a diferença entre o produto criado pelo Factory Method e a família criada pelo Abstract Factory?

No **Factory Method**, uma fábrica é responsável pela criação de um determinado tipo de produto.

No sistema, o produto criado pelo Factory Method é uma implementação da interface `Entrega`.

Por exemplo:

```text
CentralEntregaMotoFactory
        |
        +-- EntregaMoto
```

Já o **Abstract Factory** é responsável pela criação de uma família de produtos relacionados.

No sistema, uma fábrica de pagamento cria dois produtos relacionados:

```text
PixAbstractFactory
       |
       +-- ValidadorPix
       |
       +-- ReciboPix
```

Portanto:

- **Factory Method:** concentra-se na criação de um produto.
- **Abstract Factory:** concentra-se na criação de uma família de produtos relacionados.

---

## 4. O que precisou ser alterado para adicionar o pagamento por boleto?

Para adicionar o pagamento por boleto, foram criadas três novas classes:

```text
BoletoAbstractFactory
ValidadorBoleto
ReciboBoleto
```

A classe `BoletoAbstractFactory` implementa `PagamentoAbstractFactory` e cria os produtos `ValidadorBoleto` e `ReciboBoleto`.

Não foi necessário alterar a classe `ServicoPagamento` para que ela pudesse trabalhar com boleto.

A nova família de produtos passou a utilizar as mesmas interfaces já existentes:

```text
PagamentoAbstractFactory
        |
        +-- BoletoAbstractFactory
                |
                +-- ValidadorBoleto
                |
                +-- ReciboBoleto
```

Isso demonstra como o padrão Abstract Factory permite adicionar uma nova família de produtos sem alterar o código responsável pelo processamento do pagamento.

---

## 5. O que precisou ser alterado para adicionar a retirada no estabelecimento?

Para adicionar a retirada no estabelecimento, foram criadas duas novas classes:

```text
EntregaRetirada
CentralEntregaRetiradaFactory
```

A classe `EntregaRetirada` implementa a interface `Entrega`.

A classe `CentralEntregaRetiradaFactory` estende `CentralEntrega` e implementa o Factory Method, retornando uma nova instância de `EntregaRetirada`.

```text
CentralEntregaRetiradaFactory
        |
        +-- EntregaRetirada
```

Não foi necessário modificar o fluxo da classe `CentralEntrega`.

A nova forma de entrega foi adicionada utilizando as abstrações já existentes.

---

## 6. Quais classes permaneceram inalteradas durante a extensão do sistema?

Durante a extensão do sistema, as principais abstrações e classes responsáveis pelo funcionamento geral permaneceram inalteradas.

Para adicionar o **pagamento por boleto**, não foi necessário modificar:

- `ServicoPagamento`;
- `PagamentoAbstractFactory`;
- `ValidadorPagamento`;
- `EmissorRecibo`.

Para adicionar a **retirada no estabelecimento**, não foi necessário modificar:

- `CentralEntrega`;
- `Entrega`.

Isso demonstra uma característica importante dos padrões utilizados: novas funcionalidades podem ser adicionadas por meio de novas implementações, reduzindo a necessidade de alterar o código existente.

---

# Conclusão

A implementação demonstra como os padrões **Factory Method** e **Abstract Factory** podem ser utilizados para organizar a criação de objetos em um sistema orientado a objetos.

O **Factory Method** foi utilizado para permitir diferentes tipos de entrega, enquanto o **Abstract Factory** foi utilizado para criar famílias de produtos relacionados aos diferentes meios de pagamento.

O sistema também demonstra a facilidade de extensão dos padrões. Foi possível adicionar o pagamento por boleto e a retirada no estabelecimento sem modificar as principais abstrações e serviços existentes.

Dessa forma, o projeto demonstra os conceitos de:

- Encapsulamento;
- Polimorfismo;
- Abstração;
- Programação orientada a objetos;
- Factory Method;
- Abstract Factory;
- Separação de responsabilidades;
- Extensibilidade do código.

- Feito por: **João Marcos Moura**
- Unileste
````
