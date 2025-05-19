package annac_coding.caixa_eletronico_springboot;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONTACORRENTE")
public class ContaCorrente extends RepresentationModel <ContaCorrente> implements Serializable{
	
	@Id
	private long numero;
	private double saldo;
	
	public ContaCorrente() {} // Construtor sem argumentos necessário para o JPA

    public ContaCorrente(long numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        
    }
	
	
	public void setNumero(int numero) {
		
		this.numero=numero;
	}
	
	public void setSaldo(double saldo) {
		
		this.saldo=saldo;
		
	}

	public double getSaldo() {
		
		return this.saldo;
	}

	public long getNumero() {
		
		return this.numero;
	}
}
