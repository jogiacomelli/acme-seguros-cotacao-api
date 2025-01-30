package br.com.acme.seguros.cotacao.api.core.usecase;

import br.com.acme.seguros.cotacao.api.core.domain.Cotacao;
import br.com.acme.seguros.cotacao.api.core.gateway.CotacaoGateway;

public class ConsultarCotacaoUseCase {
    private final CotacaoGateway cotacaoGateway;

    public ConsultarCotacaoUseCase(CotacaoGateway cotacaoGateway) {
        this.cotacaoGateway = cotacaoGateway;
    }

    public Cotacao consultarCotacao(Long cotacaoId) {
        return cotacaoGateway.consultarCotacao(cotacaoId);
    }
}
