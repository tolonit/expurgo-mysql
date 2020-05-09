package br.com.tolonit.expurgo.expurgo.repository;

import br.com.tolonit.expurgo.expurgo.domain.DomainTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DomainTwoRepository extends JpaRepository<DomainTwo, String> {

    @Modifying
    @Query(value = "delete from domain_two " +
            "where domain_two.id_domain_one = :id " +
            "and domain_two.creation_date_time < :data ", nativeQuery = true)
    Integer excluirEntries(@Param("id") Integer id, @Param("data") Date parse);
}
