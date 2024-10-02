package com.mylearning.redisdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class GenericEntity<T extends Serializable> extends Auditable<String> {

    @Id
    @GenericGenerator(
            name = "sequence_gen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(
                            name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
                            value = "_id_sequence"
                    ),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })

    @GeneratedValue(generator = "sequence_gen")
    @Column(name = "id", nullable = false)
    private T id;

}
