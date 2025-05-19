package annac_coding.caixa_eletronico_springboot;


public interface Hardware {
	
	long lerNumeroDaContaCartao() throws Exception;
	void entregarDinheiro() throws Exception;
	Double lerEnvelope() throws Exception;

}
