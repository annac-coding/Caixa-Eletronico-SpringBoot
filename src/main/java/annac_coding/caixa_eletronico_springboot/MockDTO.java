package annac_coding.caixa_eletronico_springboot;

public class MockDTO {

	private Long numeroContaMockada;
	private Double saque;
	private boolean falhaNoHardware;  
	private Double valorEnvelope;
	
	MockDTO(Long numeroContaMockada, Double saque, boolean falhaNoHarware, Double valorEnvelope){
		
		this.numeroContaMockada = numeroContaMockada;
		this.saque = saque;
		this.falhaNoHardware = falhaNoHardware;
		this.valorEnvelope = valorEnvelope;
	}
	
	public Long getNumeroContaMockada() {
		
		return numeroContaMockada;
	}
	
	public void setNumeroContaMockada(Long numeroContaMockada) {
	
		this.numeroContaMockada = numeroContaMockada;
	}

	
	public boolean getFalhaNoHardware() {
		
		return falhaNoHardware;
	}
	
	public void setFalhaNoHardware(boolean falhaNoHardware) {
	
		this.falhaNoHardware = falhaNoHardware;
	}
	
	public Double getValorEnvelope() {
		
		return valorEnvelope;
	}
	
	public void setValorEnvelope(Double valorEnvelope) {
	
		this.valorEnvelope = valorEnvelope;
		
	}
	
	public Double getSaque() {
		
		return saque;
	}
	
	public void setSaque(Double saque) {
	
		this.saque = saque;
		
	}
}



