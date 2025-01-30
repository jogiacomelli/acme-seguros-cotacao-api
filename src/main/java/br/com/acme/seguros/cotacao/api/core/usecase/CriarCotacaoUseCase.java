package br.com.acme.seguros.cotacao.api.core.usecase;

import br.com.acme.seguros.cotacao.api.core.domain.Cotacao;
import br.com.acme.seguros.cotacao.api.core.domain.Oferta;
import br.com.acme.seguros.cotacao.api.core.domain.Produto;
import br.com.acme.seguros.cotacao.api.core.gateway.CatalogGateway;
import br.com.acme.seguros.cotacao.api.core.gateway.CotacaoGateway;

public class CriarCotacaoUseCase {
    private  final CotacaoGateway cotacaoGateway;
    private final CatalogGateway catalogGateway;

    public CriarCotacaoUseCase(CotacaoGateway cotacaoGateway, CatalogGateway catalogGateway) {
        this.cotacaoGateway = cotacaoGateway;
        this.catalogGateway = catalogGateway;
    }

    public Cotacao criarCotacao(Cotacao cotacao) {
        Produto product = catalogGateway.consultarProduto(cotacao.getProductId())
                .orElseThrow(); // TODO Criar exception
        Oferta offer = catalogGateway.consultarOferta(cotacao.getOfferId())
                .orElseThrow(); // TODO Criar exception

        cotacao.validate(product, offer);

        return cotacaoGateway.criarCotacao(cotacao);

    }
}
