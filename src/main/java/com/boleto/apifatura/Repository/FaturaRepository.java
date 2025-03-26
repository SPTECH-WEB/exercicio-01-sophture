package com.boleto.apifatura.Repository;

import com.boleto.apifatura.Model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {
}
