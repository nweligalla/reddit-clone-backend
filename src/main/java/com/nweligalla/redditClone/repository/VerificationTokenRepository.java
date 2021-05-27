package com.nweligalla.redditClone.repository;

import com.nweligalla.redditClone.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
}
