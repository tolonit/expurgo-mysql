package br.com.tolonit.expurgo.expurgo.repository;

import br.com.tolonit.expurgo.expurgo.domain.DomainThree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DomainThreeRepository extends JpaRepository<DomainThree, String> {

    @Modifying
    @Query(value = "delete domain_three FROM domain_three " +
            "inner join domain_two " +
            "where domain_three.id_domain_two = domain_two.id " +
            "and domain_two.id_domain_one = :id " +
            "and domain_two.creation_date_time < :data ", nativeQuery = true)
    Integer excluirEntries(@Param("id") Integer id, @Param("data") Date parse);
}
