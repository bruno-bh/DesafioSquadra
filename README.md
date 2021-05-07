# Desafio Squadra - Listagem usando filtro

## Descição do Desafio

*Criar um sistema que apresente um filtro para o usuario e ele possa pesquisar pelo filtro, alem de poder cadastrar uma nova entidade*

Fluxos esperados:
- O usuario acessará a pagina e irá visualizar todos os sistemas cadastrados em banco;
- Assim que acessar, ele irá pesquisar atravez de um filtro o sistema que deseja;
- Caso o sistema não exista irá cadastrar um para visualizar o mesmo;
- Ao final irá limpar o filtro atravez de um botão e finalizar o acesso.

### Imagem da tela criada
*Foi criado um cenario o qual a tela foi desenvolvida por uma empresa que busca pequenos negocios/empresas para investimento. Assim qualquer pessoa consegue acessar a enorme lista de contatos e caso queira entra no banco de dados só cadastrar o nome da empresa, email e link de site caso tenha.*

<p align="center">
  <img height="600px" src="https://github.com/bruno-bh/DesafioSquadra/blob/master/frontend/src/assets/images/homeDesafio.png" />
</p>


### Ferramentas gerais de desenvolvimento

- IDE backend: **IntelliJ IDEA**
- Versão java: **8**
- Frontend: **Visual Studio Code**
- Versão Angular CLI: **11.2**
- Versão Node: **14.2**
- Ferramentas para teste de API: **Postman**
- Database: **MySQL**

### Principas bibliotecas/frameworks utilizadas

- **SpingBoot**: Basicamente o core do backend;
- **Lombok**: É uma biblioteca compativel com o spring capaz de facilitar a programação. Atraves de anotações é possivel reduzir bastante o tamanho das entidades e facilitar na leitura.
- **Spring Data JPA**: Biblioteca de comunicação com o banco de dados, utilizando Spring Data e Hibernate;
- **MySQL Driver**: instalação dos drivers do MySQL, uma vez que o banco usado foi MySQL 5.7
- **Swagger**: fornece uma interface para os controllers dentro da API do backend;


### Resumo do desafio
## Backend

  - Foi utilizado IntelliJ como IDE por ser uma facilitadora de processos. Alem de um auto preenchimento muito dinâmico e inteligente, a IDE conta aba para banco de dados reduzindo o uso de ferramentas durante a programação.
  - A aplicação roda na porta :8080 e conta com um swagger implementado nos controllers, podendo ser acessado na rota
  *localhost:8080/swagger-ui.html*

## Frontend

- Utilizando o Angular CLI e sua documentação foi gerado um projeto angular e utilizado o VSCode para edição.
- Dentro da pasta *frontend* do projeto git, é possivel executar utilizando o comando **ng serve**.
- Finalizado o deploy a tela do desafio se encontra no *localhost:4200*

## Database

- Foi utilizado como banco de dados o MySQL versão 5.7