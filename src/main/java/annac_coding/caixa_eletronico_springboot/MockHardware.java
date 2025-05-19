package annac_coding.caixa_eletronico_springboot;

import org.springframework.stereotype.Component;


public class MockHardware implements Hardware{
	
	private Long numeroContaMockada;
	private Double saque;
	private boolean falhaNoHardware;
	private Double valorEnvelope;
	
	public MockHardware() {
		this.numeroContaMockada = null;
		this.falhaNoHardware = false;
	}

	@Override
	public long lerNumeroDaContaCartao() throws Exception {
		
		if(this.numeroContaMockada == null) throw new Exception("Cartão danificado.");
		if(falhaNoHardware) throw new Exception("Falha no hardware.");
		
		return this.numeroContaMockada;
	}
	
	@Override
	public void entregarDinheiro() throws Exception {
		
		if(falhaNoHardware) throw new Exception("Falha ao entregar dinheiro.");
	}

	@Override 
	public Double lerEnvelope() throws Exception {

	   if (valorEnvelope==0) throw new Exception("Envelope vazio.");
	   if(falhaNoHardware) throw new Exception("Falha ao ler envelope.");
	   
	   return valorEnvelope;
	   
	  }

	public void setFalha(boolean falhaNoHardware) {
		
		this.falhaNoHardware = falhaNoHardware;
	}
	
	public boolean getFalha() {
		
		return falhaNoHardware;
	}
	
	public Long getNumeroConta() {
		
		return numeroContaMockada;
	}


	public void setNumeroConta(Long numeroConta) {
		
		this.numeroContaMockada = numeroConta;
	}
	
	
}
