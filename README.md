# 📌 Desafio FullStack

Aplicação para cadastro e gerenciamento de fornecedores de uma empresa. 
Você pode pesquisar por uma empresa seja pelo seu nome fantasia ou pelo seu CNPJ.
É apresentado as informações da empresa e de seus fornecedores.
É possível cadastrar novos fornecedores da empresa, seja pessoa física ou jurídica.

## 🚀 Tecnologias utilizadas

**Frontend**: Vue.js </br>
**Backend**: Spring Boot </br>
**Banco de Dados**: MySQL </br>

## 🔧 Como rodar o projeto

1. Clonar o repositório:</br>
    git clone https://github.com/DiasGomes/DesafioFullStack.git
2. Instalar as Tecnologias:</br>
    Vue.js, Spring Boot, Java JDK, Apache Maven e MySQL.
3. Criar base de dados:</br>
   Execute o arquivo "cria_base_dados.sql" no seu MySQL para gerar uma base de dados inicial
4. Rodar a aplicação:</br>
   Deixe o seu banco de dados local ligado </br> 
   Na pasta DesafioFullStack rode o comando: **mvn spring-boot:run** </br>
   Na pasta frontend rode o comando: **npm run dev** </br>

## ⚙️ ToDo

1. Criar variáveis de ambiente (esses valores ainda estão no código) </br>

FRONTEND_API_URL = 'http://localhost:5173'</br>
BACKEND_API_URL = 'http://localhost:8080</br>
BANCO_DE_DADOS_API_URL = 'jdbc:mysql://localhost:3306/DB_Desafio_Full_Stack'
BANCO_DE_DADOS_USERNAME = 'root'
BANCO_DE_DADOS_PASSWORD = PASSWORD
