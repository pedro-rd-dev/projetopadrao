package com.senac.projetopadrao.schedulingtasks;

import com.senac.projetopadrao.models.Clima;
import com.senac.projetopadrao.repositorys.ClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {

    @Autowired
    ClimaRepository climaRepository;

    @Scheduled(fixedRate = 5000)
    public void checkClima() {

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        Clima[] climas =
                restTemplate.getForObject(
                        "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=a900609c17e775626610716ef9d8fd73",
                        Clima[].class);

        if(climas!=null){
            for (Clima clima : climas){

                Clima climaBanco = climaRepository.findByDate(clima.getDate());

                if(climaBanco != null){
                    if(!climaBanco.getText().equals(clima.getText())){
                        climaRepository.save(clima);
                    }
                }else {
                    climaRepository.save(clima);
                }


            }
        }
    }
}
