package annac_coding.caixa_eletronico_springboot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long>{
	
	Optional<ContaCorrente> findByNumero(long numero);
	
	@Query("SELECT c.saldo FROM ContaCorrente c WHERE c.numero = :numeroConta")
    Double buscarSaldo(@Param("numeroConta") Long numeroConta);
}
