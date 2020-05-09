package br.com.tolonit.expurgo.expurgo;

import br.com.tolonit.expurgo.expurgo.domain.DomainOne;
import br.com.tolonit.expurgo.expurgo.domain.DomainThree;
import br.com.tolonit.expurgo.expurgo.domain.DomainTwo;
import br.com.tolonit.expurgo.expurgo.repository.DomainOneRepository;
import br.com.tolonit.expurgo.expurgo.repository.DomainThreeRepository;
import br.com.tolonit.expurgo.expurgo.repository.DomainTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@RestController("/")
public class ExpurgoController {

    @GetMapping("cria-massa")
    public String criaMassa() {
        dataCreate_h2();
        return "OK";
    }

    @GetMapping("apaga-massa")
    @Transactional
    public String apagaMassa() {

        domainOneRepository.findAll().stream().forEach(domainOne -> {

            try {
                domainThreeRepository.excluirEntries(
                        domainOne.getId(),
                        Date.from(LocalDateTime.now().minusDays(domainOne.getValidityDays()).atZone(
                                ZoneId.systemDefault()).toInstant()
                        )
                );


            } catch (Exception e) {
                e.printStackTrace();
            }


        });


        return "OK";
    }


    // -- criar massa de Teste -- //

    @Autowired
    private DomainOneRepository domainOneRepository;
    @Autowired
    private DomainTwoRepository domainTwoRepository;
    @Autowired
    private DomainThreeRepository domainThreeRepository;

    public void dataCreate_h2() {

        // Domain One
        List<DomainOne> listDomainOne = new ArrayList<>();
        listDomainOne.add(new DomainOne(0, "Product A", 5));
        listDomainOne.add(new DomainOne(1, "Product B", 3));
        listDomainOne.add(new DomainOne(2, "Product C", 30));

        // Domain Two
        List<DomainTwo> listDomainTwo = new ArrayList<>();
        List<DomainThree> listDomainThree = new ArrayList<>();

        Random idDomainOne = new Random();
        Random daysRandom = new Random();
        LocalDateTime dateCreation = LocalDateTime.now().minusDays(daysRandom.nextInt(30));

        String domainTwoId = "";

        for (int i = 0; i < 5; i++) {
            dateCreation = LocalDateTime.now().minusDays(daysRandom.nextInt(30));
            domainTwoId = UUID.randomUUID().toString();

            listDomainTwo.add(
                    new DomainTwo(domainTwoId, idDomainOne.nextInt(3), dateCreation)
            );

            for (int j = 0; j < 3; j++) {
                listDomainThree.add(
                        new DomainThree(UUID.randomUUID().toString(), domainTwoId)
                );
            }
        }

        domainOneRepository.saveAll(listDomainOne);
        domainTwoRepository.saveAll(listDomainTwo);
        domainThreeRepository.saveAll(listDomainThree);
    }

}
