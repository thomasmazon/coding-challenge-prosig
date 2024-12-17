package com.prosigliere.challenge.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prosigliere.challenge.model.BlogPost;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {
}
