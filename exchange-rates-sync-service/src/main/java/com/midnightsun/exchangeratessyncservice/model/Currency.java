package com.midnightsun.exchangeratessyncservice.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "currencies")
public class Currency extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(generator = "currency_sequence_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "currency_sequence_generator", initialValue = 1000, allocationSize = 1)
    private Long id;

    @Column(name = "name_en")
    private String nameEN;

    @Column(name = "name_bg")
    private String nameBG;
}
