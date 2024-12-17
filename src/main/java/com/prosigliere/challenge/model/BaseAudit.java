package com.prosigliere.challenge.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners(AuditingEntityListener.class)
public class BaseAudit implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6298472599300661745L;


    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @ToString.Exclude
    protected LocalDateTime createdAt;


    @LastModifiedDate
    @Column(name = "updated_at")
    @ToString.Exclude
    protected LocalDateTime updatedAt;

}
