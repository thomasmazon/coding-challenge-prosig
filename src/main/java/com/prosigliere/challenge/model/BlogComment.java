package com.prosigliere.challenge.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.prosigliere.challenge.repository.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
@Entity
@Table(name = "comment")
//@Access(value=AccessType.FIELD)
@SuppressWarnings("serial")
public class BlogComment extends BaseAudit {

    @Id
    @GenericGenerator(name = Constants.UUID_GENERATOR_NAME, strategy = Constants.UUID_GENERATOR_STRATEGY)
    @GeneratedValue(generator = Constants.UUID_VALUE_GENERATOR)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "content", nullable = false)
    private String content;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", updatable = false)
    private BlogPost post;
    

}
