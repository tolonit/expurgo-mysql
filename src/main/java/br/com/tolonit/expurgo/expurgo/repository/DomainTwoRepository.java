package br.com.tolonit.expurgo.expurgo.repository;

import br.com.tolonit.expurgo.expurgo.domain.DomainTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainTwoRepository extends JpaRepository<DomainTwo, String> {
}
