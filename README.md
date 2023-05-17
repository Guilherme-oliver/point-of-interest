# point-of-interest
É um desafio baseado em coordenadas entre dois eixos e um destino.
Na pasta root chamada "Challenge" terá um arquivo em PDF com mais detalhes sobre o desafio e suas regras de negócios.
Foi usado a linguagem Java na versão 17 lts junto com o framework Spring na sua versão 3.0.6 e o Maven na versão 4.0.0
Foi utilizado o Intellij como ferramenta por ser uma das mais utilizadas no mercado e o banco de dados H2 por ser apenas um desafio.
A ferramenta de teste usada nesse desafio foi o Postman.
Todas as ferramentas usadas nesse projeto são Open-Source.

Para utilizar essa aplicação, será necessario instalar o Java na versão 17 lts, junto com o Intellij e postman;
faça o donwload deste repositório;
Abra a pasta com o Intellij e rode o arquivo "Application";
Abra o programa Postman, na sessão Get, passe o caminho "localhost:8080/ponto-de-interesse" para achar todos os pontos;
"localhost:8080/ponto-de-interesse/3" para achar o objeto com o Id:3 mas podendo trocar o Id de acordo com o usuário;
"localhost:8080/ponto-de-interesse/name/Test" para achar o objeto por nome podendo trocar o "Test" por um outro nome que esteja criado;
"localhost:8080/ponto-de-interesse/params?coordX=1&coordY=1&distance=100" para achar os pontos que estejam relacionados com as coordenadas,
podendo trocar as coordenadas e olhando se há ou não um retorno dos objeto(s);

Foi desenvolvido por Guilherme Rodrigues de Oliveira
