package br.com.acme.seguros.cotacao.api.core.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.List;

@Data
public class Cotacao {
    private Long id;
    private Long insurancePolicyId;
    private String productId;
    private String offerId;
    private String category; // TODO Criar Enum
    private Double totalMonthlyPremiumAmount;
    private Double totalCoverageAmount;
    private Map<String, Double> coverages;
    private List<String> assistance; // TODO criar Enum
    private Customer customer;

    public void validate(Produto produto, Oferta oferta) {

        if (!produto.getOffers().contains(this.offerId)) {
            throw new IllegalArgumentException("Offer is not valid for the given product.");
        }

        this.getCoverages().forEach((coverageKey, coverageValue) -> {
            if (!oferta.getCoverages().containsKey(coverageKey)) {
                throw new IllegalArgumentException("Coverage " + coverageKey + " is not valid for the given offer.");
            }
            if (coverageValue > oferta.getCoverages().get(coverageKey)) {
                throw new IllegalArgumentException("Coverage value for " + coverageKey + " exceeds the limit for the given offer.");
            }
        });

        var isValidAssistance = new HashSet<>(oferta.getAssistances()).containsAll(this.assistance);
        if(!isValidAssistance) {
            throw new IllegalArgumentException("Assistance are not valid for the given offer.");
        }

        if (this.totalMonthlyPremiumAmount > oferta.getMonthlyPremiumAmount().getMaxAmount()) {
            throw new IllegalArgumentException("Total monthly premium amount exceeds the limit for the given product.");
        }

        if (this.totalMonthlyPremiumAmount < oferta.getMonthlyPremiumAmount().getMinAmount()) {
            throw new IllegalArgumentException("Total monthly premium amount is below the limit for the given product.");
        }

        if(!this.totalCoverageAmount.equals(this.coverages.values().stream().reduce(0.0, Double::sum))) {
            throw new IllegalArgumentException("Total coverage amount does not match the sum of the coverages.");
        }
    }
}