package com.prosigliere.challenge.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prosigliere.challenge.model.BlogComment;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, UUID> {
}
