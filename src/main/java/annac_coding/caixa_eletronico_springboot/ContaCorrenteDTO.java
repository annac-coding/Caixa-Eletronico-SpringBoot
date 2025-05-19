package annac_coding.caixa_eletronico_springboot;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ContaCorrenteDTO{
    
	@NotNull
    private long numeroContaDto;
	@Min(value = 0, message = "O saldo não pode ser negativo")
    private double saldoDto;

    public ContaCorrenteDTO(long numeroConta, double saldo) {
        
    	this.numeroContaDto = numeroConta;
    	this.saldoDto = saldo;
    }
    
    public Long getNumeroContaDto() {
		
		return numeroContaDto;
	}

}

