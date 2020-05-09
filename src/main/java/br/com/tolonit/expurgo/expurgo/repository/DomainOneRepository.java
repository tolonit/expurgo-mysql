package br.com.tolonit.expurgo.expurgo.repository;

import br.com.tolonit.expurgo.expurgo.domain.DomainOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainOneRepository extends JpaRepository<DomainOne, Integer> {
}
