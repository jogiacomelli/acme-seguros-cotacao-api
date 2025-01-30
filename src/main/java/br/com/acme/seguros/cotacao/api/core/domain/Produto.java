package br.com.acme.seguros.cotacao.api.core.domain;

import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Produto {
    private String id;
    private String name;
    private ZonedDateTime createdAt;
    private boolean active;
    private List<String> offers;
}