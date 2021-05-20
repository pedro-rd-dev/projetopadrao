package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Clima;
import com.senac.projetopadrao.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimaRepository extends JpaRepository<Clima, Long> {

    Clima findByDate(String date);
}
