# 📒 Agenda de Contatos (Java + SQLite)

Uma aplicação simples de gerenciamento de contatos via linha de comando (CLI), desenvolvida em Java puro utilizando SQLite para persistência de dados.

Este projeto foi desenvolvido como atividade acadêmica para demonstrar o uso de **JDBC** e manipulação de banco de dados SQL sem a necessidade de servidores complexos.

## 🚀 Funcionalidades

* **Adicionar Contato:** Registra nome e telefone no banco de dados.
* **Listar Contatos:** Exibe todos os registros salvos com seus respectivos IDs.
* **Persistência de Dados:** Os dados são salvos em um arquivo local (`meus_contatos.db`), mantendo as informações mesmo após fechar o programa.
* **Driver Standalone:** Utiliza uma versão do driver SQLite que não exige dependências de logging externas (SLF4J).

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 8+)
* **Banco de Dados:** SQLite
* **Driver JDBC:** `sqlite-jdbc-3.30.1.jar`
* **IDE/Editor:** VS Code

## 📂 Estrutura do Projeto

```text
AgendaJava/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java                # Código Fonte Principal
│           └── sqlite-jdbc-3.30.1.jar   # Driver do Banco de Dados
└── README.md
