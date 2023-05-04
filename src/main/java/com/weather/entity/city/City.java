package com.weather.entity.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.core.TechnicalFields;
import com.weather.entity.weather.Weather;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
@JsonIgnoreProperties(ignoreUnknown = true)
public class City extends TechnicalFields {

    @Id
    @SequenceGenerator(name = "city_sequence_id", sequenceName = "city_sequence_id", allocationSize = 1)
    @GeneratedValue(generator = "city_sequence_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "city")
    private Weather weather;
}
