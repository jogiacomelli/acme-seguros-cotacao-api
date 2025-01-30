package br.com.acme.seguros.cotacao.api.core.gateway;

import br.com.acme.seguros.cotacao.api.core.domain.Oferta;
import br.com.acme.seguros.cotacao.api.core.domain.Produto;

import java.util.Optional;

public interface CatalogGateway {

    Optional<Oferta> consultarOferta(String offerId);
    Optional<Produto> consultarProduto(String productId);
}
