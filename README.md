# tcc-genai-backend
Projeto TCC: Desenvolvimento Backend Acelerado por IA Generativa em Integrações de API

# CadastroClienteService

Serviço Java para cadastro de clientes via integração com API de parceiro financeiro, utilizando Spring WebFlux (WebClient).

## Descrição

Este serviço realiza o cadastro de clientes enviando requisições HTTP POST para o endpoint `/cadastro/cliente` da API do parceiro financeiro. Utiliza autenticação via token Bearer e trata diferentes códigos de erro HTTP.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring WebFlux (WebClient)
- Reactor

## Como Usar

1. **Configuração do WebClient**  
   O serviço já está configurado para acessar a base URL:  
   `https://api.parceirofinanceiro.com/v1`

2. **Cadastro de Cliente**

   Para cadastrar um cliente, utilize o método:

   ```java
   String resposta = cadastroClienteService.cadastrarCliente(request, token);
   ```

   - `request`: objeto do tipo `CadastroClienteRequest` com os dados do cliente.
   - `token`: token JWT de autenticação.

3. **Tratamento de Erros**

   O serviço trata os seguintes códigos de resposta:
   - `400`: Bad Request (dados inválidos)
   - `401`: Unauthorized (token inválido ou expirado)
   - `422`: Análise de crédito reprovada
   - `500`: Erro interno do servidor

   Em caso de erro, a mensagem retornada descreverá o problema.

## Exemplo de Uso

```java
CadastroClienteRequest request = new CadastroClienteRequest();
// preencha os campos do request

String token = "seu_token_jwt";
String resposta = cadastroClienteService.cadastrarCliente(request, token);
System.out.println(resposta);
```

## Estrutura do Projeto