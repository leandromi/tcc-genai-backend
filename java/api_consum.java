package com.exemplo.cadastro.service;

import com.exemplo.cadastro.model.CadastroClienteRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class CadastroClienteService {

    private final WebClient webClient;

    public CadastroClienteService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.parceirofinanceiro.com/v1").build();
    }

    public String cadastrarCliente(CadastroClienteRequest request, String token) {
        try {
            return webClient.post()
                    .uri("/cadastro/cliente")
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .body(Mono.just(request), CadastroClienteRequest.class)
                    .retrieve()
                    .onStatus(status -> status.value() == 400,
                            resp -> resp.bodyToMono(String.class)
                                    .map(body -> new RuntimeException("Erro 400 - Bad Request: " + body)))
                    .onStatus(status -> status.value() == 401,
                            resp -> resp.bodyToMono(String.class)
                                    .map(body -> new RuntimeException("Erro 401 - Unauthorized: " + body)))
                    .onStatus(status -> status.value() == 422,
                            resp -> resp.bodyToMono(String.class)
                                    .map(body -> new RuntimeException("Erro 422 - Análise de crédito reprovada: " + body)))
                    .onStatus(status -> status.value() == 500,
                            resp -> resp.bodyToMono(String.class)
                                    .map(body -> new RuntimeException("Erro 500 - Servidor: " + body)))
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException e) {
            return "Erro HTTP: " + e.getStatusCode() + " - " + e.getResponseBodyAsString();
        } catch (Exception e) {
            return "Erro inesperado: " + e.getMessage();
        }
    }
}
