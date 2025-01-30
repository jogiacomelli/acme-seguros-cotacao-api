package br.com.acme.seguros.cotacao.api.core.domain;

import lombok.Data;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Data
public class Oferta {
    private String id;
    private String productId;
    private String name;
    private ZonedDateTime createdAt;
    private boolean active;
    private Map<String, Double> coverages;
    private List<String> assistances;
    private MonthlyPremiumAmount monthlyPremiumAmount;

    @Data
    public static class MonthlyPremiumAmount {
        private double maxAmount;
        private double minAmount;
        private double suggestedAmount;
    }
}