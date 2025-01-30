package br.com.acme.seguros.cotacao.api.core.gateway;

import br.com.acme.seguros.cotacao.api.core.domain.Cotacao;

public interface CotacaoGateway {

    Cotacao criarCotacao(Cotacao cotacao);
    Cotacao consultarCotacao(Long cotacaoId);
}
