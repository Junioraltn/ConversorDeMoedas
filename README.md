# Conversor de Moedas em Tempo Real
![Designer](https://github.com/user-attachments/assets/018b06b3-5392-47bd-89be-10da61838729)
*Imagem criada por Microsoft Copilot*
<p>Um conversor de moedas simples e eficiente, desenvolvido em Java, que utiliza a API Exchange Rate API para fornecer taxas de câmbio atualizadas. Além disso, o conversor armazena um histórico das cotações realizadas, permitindo que você acompanhe a evolução das taxas ao longo do tempo.</p>

## Badges
[![Java](https://img.shields.io/badge/java-latest-brightgreen.svg)](https://www.java.com/)
[![API](https://img.shields.io/badge/API-Exchange%20Rate%20API-blue.svg)](https://exchangerate-api.com/)
[![GitHub](https://img.shields.io/badge/GitHub-code-gray.svg)](https://github.com/Junioraltn/ConversorDeMoedas)


## Índice

* **Descrição do Projeto**
* **Funcionalidades**
* **Tecnologias Utilizadas**
* **Como Utilizar**
* **Histórico de Cotações**
* **Contribuições**
* **Licença**

## Descrição do Projeto
Este projeto tem como objetivo fornecer uma ferramenta simples e eficaz para converter valores entre diferentes moedas, utilizando as taxas de câmbio mais atualizadas disponíveis. Ele oferece duas opções de conversão e armazena um histórico das cotações realizadas.
<p>Trata-se de um desafio para conclusão de um curso back-end ministrado pela #Alura e #One.</p>

## Funcionalidades
* **Conversão de moedas:** Permite converter valores entre diversas moedas, incluindo Dólar, Real, Euro, etc.
* **Taxas de câmbio em tempo real:** Utiliza a API Exchange Rate API para garantir que as taxas de câmbio estejam sempre atualizadas.
* **Duas opções de conversão:** Oferece a opção de consultar a taxa de câmbio para cada par de moedas ou utiliza taxas de cada moeda em função do dólar.
* **Interface de usuário simples:** A interface do console é intuitiva e fácil de usar.
* **Histórico de cotações:** Armazena as cotações realizadas para consulta posterior em um arquivo de texto (historico.txt) localizado na pasta src.

## Tecnologias Utilizadas
* **Java:** Linguagem de programação utilizada para desenvolver o projeto.
* **Exchange Rate API:** API utilizada para obter as taxas de câmbio.
* **Gson:** Biblioteca utilizada para converter JSON em Map.
* **JsonObject:** Biblioteca utilizada para converter JSON em objeto Java. 
* **HttpClient:** Biblioteca utilizada para fazer requisições HTTP para a API.
* **LocalDateTime:** Classe para obter a data e horário local.
* **FileReader:** Classe para ler o arquivo .txt.
* **FileWriter:** Classe para escrever no arquivo .txt.

## Como Utilizar
1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/Junioraltn/ConversorDeMoedas](https://github.com/Junioraltn/ConversorDeMoedas)
2. **Altere a chave de acesso a API presente no arquivo Acessos.java para o programa funcionar.**
3. **Compile o código:**
   ```bash
   javac Principal.java
4. **Execute o programa:**
5. *Siga as Instruções que aparece no console.*

* <p>Abaixo segue uma imagem da tela do console que solicita que o usuário escolha a forma como pretende realizar a conversão de um valor entre duas moedas. Existe apenas três opções e o usuário só avança se for escolhido as opções sugeridas.</p>
![Introdução](https://github.com/user-attachments/assets/53289d51-da3b-4cb7-982a-e76943c80b58)

* <p>A imagem abaixo é o menu que contém as moedas pré-definidas disponíveis para conversão de valores. O usuário pode inserir o número correspondente da moeda, o nome ou o código para selecionar a moeda base e de destino. No caso em que o usuário seleciona o modo 2 de conversão, o usuário pode ter acesso a uma lista diferente da pré-definida para realizar suas conversões</p>
![Da a opção do usuário esolher entre converter entre as moedas da lista pré-definida](https://github.com/user-attachments/assets/11aaf0a6-3ff2-4234-a77d-5aca08c4d852)

* <p>A imagem abaixo mostra um recorte da lista ampliada de código de moedas que o usuário tem acesso para realizar conversão de valores.</p>
![Mostra a lista ampliada de código de moedas para conversão](https://github.com/user-attachments/assets/7b1c331b-3652-4e02-9894-c76138213f34)

* <p>A imagem abaixo mostra a taxa entre as moedas selecionadas para converter o valor, o valor que o usuário quis converter e o valor convertido. Neste momento o usuário é convidado a escolher continuar podendo digitar S ou s, mas sairá caso contrário.</p>
![Fim da Conversão](https://github.com/user-attachments/assets/6097c3eb-6814-429f-8da2-0518d10988b7)

* <p>A imagem abaixo mostra como o historio será mostrado no console.</p>
![Histórico de Conversões](https://github.com/user-attachments/assets/60190784-e133-45fb-81bf-1cff26c721cd)

## Licença:
Este projeto está licenciado sob a licença MIT.

Ailton Júnior - 04/10/2024
