# Alura Stickers 🤿 ☕
Aplicação de estudo desenvolvida seguindo os passos da [Imersão JAVA da Alura](https://www.alura.com.br/imersao-java?gclid=Cj0KCQjwuLShBhC_ARIsAFod4fKRsDlGaeB6PJSsEp61yE_Ah7s6Hrew6UZz7_XzpclhZKyy2L0l2mcaArdzEALw_wcB "API").

## 🛠️ Tecnologias utilizadas:
* JAVA 17
* MONGODB
* POSTMAN
* SPRING FRAMEWORK

## Neste projeto pude praticar os conhecimentos de:
### Java
* Como consumir uma API com Java
  * Endpoints
  * Filtragem via RegEx dos dados recebidos 
  * Chaves de acesso de uma API
  * Variáveis de ambiente 
  * Métodos HTTP
* Manipulação de imagens
  * Como manipular a proporção de uma imagem com Java
  * Graphics2D
  * InputStream
  * Como adicionar texto a uma imagem usando Java
* Como manipular diretórios para o output do projeto
* Refatoração de código
  * POO
  * Desacoplamento
  * Classes 
  * Interfaces
  * Tratamento de exceções no código


## 📚 Sobre o projeto
Projeto de imersão backend com a linguagem Java, visa criar uma aplicação que irá consumir dados da API da NASA, IMDb e uma API própria em localhost que foi desenvolvida durante a imersão e gere stickers personalizado para enviar por WhatsApp.
## 📒 Conteúdos da Imersão
**Aula 1**: Consumir a API do IMDb e exibir os filmes mais populares, destacando os seus pôsteres e visualizando a sua classificação sem usar nenhuma biblioteca externa.

**Aula 2**: Criar um gerador de figurinhas explorando bibliotecas nativas do Java como java.awt, javax.imageio e java.io.

**Aula 3**: Melhorar o código com as refatorações necessárias para torná-lo mais flexível e fácil de entender.

**Aulas 4 e 5**: [Criar uma API REST](https://github.com/SrWillxD/linguagens-api) e gerar figurinhas a partir do conteúdo dessa nossa API.

# 👀 Observações 
* As figurinhas serão geradas no diretório "output" na raiz, o código irá gerar esse diretório se ele não existir.
* Na classe App contem 3 pares de url+extratores comentados, o primeiro par se refere a API do IMDb, o segundo se refere a API da NASA e o terceiro se refere a uma  [API em localhost](https://github.com/SrWillxD/linguagens-api) que criamos para tambem gerar figurinhas, o código apresenta erro, pois todas estão comentadas, retire o comentário da linha que deseja usar.
* As URLs por inteiro estão em forma de variáveis de ambiente, você terá que adiciona-las, IMDB-KEY e NASA-URL, confira a documentação das APIs para mais detalhes.
* Na classe StickerGenerator você consegue alterar as propriedades de campo de transparencia da imagem,fonte e tamanho, cor do texto, o texto, posição do texto no eixo x, eixo y, respectivamente nas linhas 20, 30, 31, 36, 42 e 43.
* No campo output foram dadas alguns exemplos em grupos de 3 figurinhas, mas a quantidade de figurinhas que podem ser geradas "beiram ao infinito" 😂, você só precisa alterar o ```FOR``` da linha 29 da classe App.

# 📷 Output
## Resultado usando a API desenvolvida durante a imersão
![figurinhas](/resource/img/linguagem.jpg)
## Resultado usando a API da NASA
![figurinhas](/resource/img/nasa.jpg)
## Resultado usando a API do IMDb
![figurinhas](/resource/img/imdb.jpg)
## Claro que não poderia deixar os professores "passarem batido" 😂
![figurinhas](/resource/img/prof.jpg)