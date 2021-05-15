package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
