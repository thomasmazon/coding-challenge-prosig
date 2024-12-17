package com.prosigliere.challenge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.prosigliere.challenge.repository.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
@Entity
@Table(name = "post")
//@Access(value=AccessType.FIELD)
@SuppressWarnings("serial")
public class BlogPost  extends BaseAudit  {

    @Id
    @GenericGenerator(name = Constants.UUID_GENERATOR_NAME, strategy = Constants.UUID_GENERATOR_STRATEGY)
    @GeneratedValue(generator = Constants.UUID_VALUE_GENERATOR)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;
    
    @Builder.Default
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    @OrderBy("created_at DESC")
    private List<BlogComment> comments = new ArrayList<>();

}
