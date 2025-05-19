package annac_coding.caixa_eletronico_springboot;

public class OperacaoDTO {
    
    private double valor;

    public OperacaoDTO(double valor) {
        this.valor = valor;
    }

	public Double getValor() {
		
		return valor;
	}

}
