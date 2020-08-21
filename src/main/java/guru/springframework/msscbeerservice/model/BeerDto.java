package guru.springframework.msscbeerservice.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class BeerDto {
    private UUID uuid;
    private int version;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String beerName;
    private BeerStyleEnum beerStyle;

    private long upc;
    private BigDecimal price;

    private int quantityOnHand;
}
