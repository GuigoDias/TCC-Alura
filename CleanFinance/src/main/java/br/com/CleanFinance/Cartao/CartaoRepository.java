package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao,Long> {
    Cartao findByNumero(String numero);
}