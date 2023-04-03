# 🤿 Mergulhando em Java

Este projeto foi realizado através das aulas da [imersão alura](https://www.alura.com.br/imersao-java/).

# ⏰ Cronograma da Imersão Alura

* Aula 1 - Consumindo uma API de filmes com Java

* Aula 2 - Gerando figurinhas para WhatsApp

* Aula 3 - Ligando as pontas, refatoração e orientação a objetos

* Aula 4 - Criando nossa própria API com Spring

* Aula 5 - Publicando nossa API na Cloud

## 👨‍🏫 Professores

* Paulo Silveira
* Alexandre Aquiles
* Jacqueline Oliveira

## ✔️ Técnicas e tecnologias utilizadas

- ``Java 17``
- ``InteliJ IDEA``
- ``Paradigma de orientação a objetos``
- ``Spring Boot``
- ``MongoDB``
- ``Postman``

# Aula 1 - CONSUMINDO UMA API DE FILMES COM JAVA

Consumir a API do IMDb e exibir:

* Filmes mais top, mais populares e Tv's mais populares;
* Título do filme;
* Link de imagem;
* Classificação do filme.
* Decorar o terminal

Inicialmente, é feito o cadastro no site [IMDb API](https://imdb-api.com/api) para obter a chave. Com a chave obtida,
é criado o arquivo de configuração key.properties para a fim de separar o código conforme o exemplo abaixo:

https://imdb-api.com/en/API/Top250Movies/[sua-chave]

⚠️ troque sua-chave pela API Key obtida no IMDb!

Contudo, durante a imersão, o site da IMDB ficou instável e os intrutores criaram os links alternativos, escolhi os seguintes links:

* [TopMovies](https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json)
* [MostPopularMovies](https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json)
* [MostPopularTVs](https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json)

Para decorar o terminal, segue o link de dicas: [decore o terminal](https://www.alura.com.br/artigos/decorando-terminal-cores-emojis).

## Resultado da Aula 1

<p align="center"><img width="650" alt="resultadoAula1" src="https://user-images.githubusercontent.com/76624588/229360331-20caf522-13ad-4955-af3c-d5deb0b79526.jpg"></p>

# Aula 2 - GERANDO FIGURINHAS PARA WHATSAPP

Gerar figurinhas a partir de uma imagem de uma url da Imdb e exibir:

* Redimensionar a imagem;
* Colocar uma palavra abaixo da imagem, de acordo com a sua classificação;
* Customizar a palavra.

## Resultado da Aula 2

<p align="center">
<img  width="200" heigth="400" alt="resultadoAula1" src="https://user-images.githubusercontent.com/76624588/229361431-c43e777b-3d99-4702-89aa-f58878419729.png"></img><img width="200" heigth="400" alt="resultadoAula1" src="https://user-images.githubusercontent.com/76624588/229361439-5c806664-c163-4e32-a965-70c9c15860e9.png"></img></p>

# Aula 3 - LIGANDO AS PONTAS: REFATORAÇÃO E ORIENTAÇÃO A OBJETOS

Buscar a API da Nasa e refatorar o código aplicando a Orientação à objeto:

* Transformar a classe que representa o conteúdos em um Record;
* Criação de um Enum para unir a URL da API e o extrator utilizado;
* Usar o Streams e Lambdas para mapear a lista;
* Criar uma nova exceção para ser utilizada na classe que implementa cliente HTTP.

API NASA se encontra nesse site [NASA API](https://api.nasa.gov/), também deverá ser feito o cadastro para obter a chave.

## Resultado da Aula 3

<p align="center"><img width="400" alt="resultadoAula1" src="https://user-images.githubusercontent.com/76624588/229364259-fe0e0a4e-88ce-4101-b140-85687949a44c.png"></p>

# Aula 4 - CRIANDO A PRÓPRIA API COM SPRING

Construir uma API REST para expor nosso próprio conteúdo, utilizando ferramentas profissionais como Spring Boot, Maven, PostMan e MongoDB. desenvolvendo as seguintes funcionalidades:

* Implementar o CRUD (Create, Read, Update e Delete);
* Ordenar a lista conforme ranking;
* Quando for cadastrado através do POST, retornar o status 201;
 
Para testar o funcionamento do CRUD, poderá ser baixado webservice [Postman ](https://www.postman.com/) e, após a instalação, adicionar o link do localhost gerado pelo servidor da aplicação: http://localhost:8080/linguagens e adicionando as requisições para:

* GET para consulta;
* POST para adicionar;
* PUT para alteração;
* DELETE para excluir.

Além da acima, também poderá instalar o banco de dados não relacional [MongoDB](https://www.mongodb.com/cloud/atlas/lp/try4?utm_source=google&utm_campaign=search_gs_pl_evergreen_atlas_core_prosp-brand_gic-null_amers-br_ps-all_desktop_eng_lead&utm_term=mongodb&utm_medium=cpc_paid_search&utm_ad=e&utm_ad_campaign_id=12212624308&adgroup=115749706023&cq_cmp=12212624308&gclid=EAIaIQobChMImMebuqOM_gIVz0FIAB22hg1kEAAYASAAEgIP6fD_BwE) ou se preferir, acessar diretamente no site oficial para registrar e utilizar o mesmo em cloud.

## Resultado da Aula 4
 Após codar a aplicação Spring Boot, link localhost exibiu informações de linguagens conforme a imagem:
 
<p align="center"><img width="600" alt="localhost" src="https://user-images.githubusercontent.com/76624588/229383622-ecf74b7e-6006-4e53-938a-e1dfb8a6a4f9.jpg"></p> 


 ⚠️ O json está formatado para deixar o visual mais agradável, é só instalar a extensão [JSON Viewer](https://chrome.google.com/webstore/detail/json-viewer/efknglbfhoddmmfabeihlemgekhhnabb?hl=pt-BR no navegador).
 
 
Banco de dados não relacional MongoDB retornou:

<p align="center"><img width="600" alt="mongoDB" src="https://user-images.githubusercontent.com/76624588/229383800-e135799e-dc40-4b14-94bf-ae496dbd791d.jpg"></p> 

Resultado do teste CRUD através do webservice Postman as seguintes requisições:

1 - Consulta:

<p align="center"><img width="600" alt="consultaAula4" src="https://user-images.githubusercontent.com/76624588/229383887-4f4e8e01-19b5-43fe-a4ad-476d0cf576af.jpg"></p> 
 
 2 - Consulta por id:
 
<p align="center"><img width="600" alt="consultaPorIdAula4" src="https://user-images.githubusercontent.com/76624588/229383915-c717db68-355f-4622-a3c6-08386e9237b8.jpg"></p> 
 
3 - Cadastro:

<p align="center"><img width="600" alt="cadastroAula4" src="https://user-images.githubusercontent.com/76624588/229383959-e4d7900d-49f0-42d2-a189-03b12eae8091.jpg"></p> 
  
4 - Atualização:

<p align="center"><img width="600" alt="cadastroAula4" src="https://user-images.githubusercontent.com/76624588/229384017-6b12ea43-6db7-446b-81af-c4bf45a94467.jpg"></p> 

5 - Exclusão:

<p align="center"><img width="600" alt="cadastroAula4" src="https://user-images.githubusercontent.com/76624588/229384037-ffd4e87a-90e2-415d-b497-daeb3c895dce.jpg"></p>

Agora, vamos para projeto alura-stickers para gerar as figurinhas de linguagens. Para isso, foi necessária algumas mudanças como a remoção de api IMDB e da NASA e deixar somente API de linguagens conforme o projeto linguagens-api desenvolvido. Além disso, foi necessária o redimensionamento da imagem e posicionamento da palavra abaixo da figurinha. Resultou as seguintes figurinhas:

<p align="center">
<img  width="150" heigth="250" alt="java" src="https://user-images.githubusercontent.com/76624588/229385915-63fd5187-f4a5-4d38-ab72-9d325ee2ffc0.png"></img><img width="150" heigth="250" alt="c#" src="https://user-images.githubusercontent.com/76624588/229386020-2faaeaf2-403b-4535-bb05-c772a154449e.png"></img><img width="150" heigth="250" alt="python" src="https://user-images.githubusercontent.com/76624588/229386035-b54714b0-48e3-4852-85e3-c8fcef639892.png"></img></p>

# Aula 5 - PUBLICANDO A NOSSA API NO CLOUD

<h4 align="center"> 
    :construction:  Projeto em construção  :construction:
</h4>

## Resultado da Aula 5

<h4 align="center"> 
    :construction:  Projeto em construção  :construction:
</h4>


# 📁 Acesso ao projeto

Você poderá acessar neste projeto [alura-stickers](https://github.com/GuiAgost/alura-stickers) e baixar conforme a imagem:

<p align="center"><img width="650" alt="exemplo" src="https://user-images.githubusercontent.com/76624588/229376907-8e315579-1088-434c-9298-9c006e017feb.png"></p>

Ou se preferir, poderá também utilizar o git baixando o projeto para seu repositório.

# 🛠️ Abrir e rodar o projeto

Poderá abrir o projeto através IDE de sua preferência (Vscode, Intellij IEDA, Eclipse...), após, é só dar o run!! 😀

⚠️ O projeto linguagens-api está dentro do pacote da "Aula 4" e deverá ser separado, pois se trata do projeto spring boot web.
