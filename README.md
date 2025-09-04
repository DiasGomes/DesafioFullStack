# 📌 Desafio FullStack

Aplicação para cadastro e gerenciamento de fornecedores de uma empresa. </br>
Você pode pesquisar por uma empresa seja pelo seu nome fantasia ou pelo seu CNPJ. </br>
É apresentado as informações da empresa e de seus fornecedores. </br>
É possível cadastrar novos fornecedores da empresa, seja pessoa física ou jurídica. </br>

## 🚀 Tecnologias utilizadas

**Frontend**: Vue.js </br>
**Backend**: Spring Boot </br>
**Banco de Dados**: MySQL </br>
**Outros**: Java JDK e Apache Maven </br>

## 🔧 Como rodar o projeto

1. ### Clonar o repositório:</br>
    git clone https://github.com/DiasGomes/DesafioFullStack.git
2. ### Instalar as Dependências:</br>
    Na pasta do frontend certifique se que os módulos estejam instalados: </br>
    * npm install </br>
    * npm add axios </br>
    * npm install vue-router </br>
    * npm install vue-3-mask </br>
3. ### Criar base de dados:</br>
   Execute o arquivo "cria_base_dados.sql" no seu MySQL para gerar uma base de dados inicial
4. ### Configurações: </br>

    * Acesse o arquivo "DesafioFullStack\src\main\resources\application.properties" e configure as variáveis:</br>

        **A porta da aplicação Backend** </br>
        server.port= <porta_do_backend> </br>

        **Configurações do Banco de dados MySQL**  </br>
        spring.datasource.url= <endereço_do_banco> </br>
        spring.datasource.username = <seu_usuario>  </br>
        spring.datasource.password = <seu_senha> </br>

        **local do frontend** </br>
        app.frontend-url= <endereço do frontend> </br>

    * Acesse o arquivo DesafioFullStack\frontend\\.env e configure a variável:</br>

        **local do backend** </br>
        VITE_API_URL= <endereço do backend> </br>
5. ### Rodar a aplicação:</br>
   Deixe o seu banco de dados local ligado </br> 
   Na pasta DesafioFullStack rode o comando: **mvn spring-boot:run** </br>
   Na pasta frontend rode o comando: **npm run dev** </br>