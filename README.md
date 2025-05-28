
# 🚚 Entrega Fácil – Sistema de Gestão de Transportadora

## 📖 Descrição

O **Entrega Fácil** é um sistema desenvolvido em **Java**, com interface via **terminal**, e banco de dados **MySQL**, voltado para o gerenciamento de transportadoras de cargas. Este projeto foi desenvolvido com foco acadêmico, aplicando conceitos de **Programação Orientada a Objetos (POO)** e operações de banco de dados utilizando **JDBC puro**.

## ⚙️ Funcionalidades Principais

- ✅ Gerenciamento de **Clientes**
- ✅ Gerenciamento de **Funcionários** e **Motoristas** (herança aplicada)
- ✅ Controle de **Veículos**
- ✅ Cadastro de **Cargas**
- ✅ Controle de **Entregas**
- ✅ Ações de **CRUD** completo para todas as entidades
- ✅ Relacionamento entre entidades no banco e no código Java

## 🛠️ Tecnologias Utilizadas

- **Java** (POO)
- **MySQL** (Banco de Dados Relacional)
- **JDBC** (Conexão Java com banco)
- **Eclipse IDE**
- **Terminal/Console** (Interface textual)

## 🗄️ Configuração do Banco de Dados

- O projeto contém um arquivo **`script.sql`**, responsável pela criação do banco e de todas as tabelas necessárias.
- As tabelas **não são criadas automaticamente** pelo sistema.  
É necessário executar manualmente o script no MySQL antes de utilizar o sistema.

## 🚀 Como Executar o Projeto

1. Clone o repositório para sua máquina.
2. No MySQL, execute o arquivo **`script.sql`**.
3. Abra o projeto no **Eclipse**.
4. Adicione o driver **`mysql-connector-java`** ao Build Path do projeto.
5. Configure as credenciais na classe **`Conexao.java`**:

```java
private static final String URL = "jdbc:mysql://localhost:3306/entrega_facil";
private static final String USUARIO = "seu_usuario";
private static final String SENHA = "sua_senha";
```

6. Execute a classe **`Main.java`** para iniciar o sistema.

## 💻 Interface do Usuário

- Operação via **menu no console**, com opções numéricas para navegar entre as funcionalidades.

## 🎯 Objetivo do Projeto

Projeto de caráter **exclusivamente acadêmico**, com o intuito de:

- Praticar os conceitos de **POO** (Herança, Encapsulamento, Polimorfismo).
- Aprender e aplicar manipulação de banco de dados via **JDBC**.
- Desenvolver a lógica de CRUD e relacionamento entre entidades.

## 👨‍💻 Autor

- Desenvolvido por **Victor Augusto**.

## ⚠️ Licença

- Projeto acadêmico.  
- **Sem licença de distribuição.**
