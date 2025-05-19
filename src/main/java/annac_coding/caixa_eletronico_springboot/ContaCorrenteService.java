package annac_coding.caixa_eletronico_springboot;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaCorrenteService {
	
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	@Autowired
	private MockHardware mockHard;
	
	ContaCorrente contaCorrente = new ContaCorrente();
	
/************************ MÉTODO ADICIONARCONTA***************************/
	
	public String adicionarConta(ContaCorrenteDTO contaDTO) throws Exception {
		
			ContaCorrente conta = new ContaCorrente(contaDTO.getNumeroContaDto(), 0);
			Optional<ContaCorrente> contaExistente = contaCorrenteRepository.findByNumero(contaDTO.getNumeroContaDto());
		
			if(!(contaExistente.isEmpty()))
				throw new Exception("Essa conta já existe");
			
			contaCorrenteRepository.save(conta);
			return "Conta adicionada com sucesso";		
	}
	
/************************ MÉTODO LOGIN***************************/
	
	public String login() throws Exception{
		
			long numeroConta = mockHard.lerNumeroDaContaCartao();
			Optional<ContaCorrente> contaExistente = contaCorrenteRepository.findByNumero(numeroConta);
				
			if (contaExistente.isEmpty()) 
				throw new Exception("Conta não encontrada.");
		         
			this.contaCorrente = contaExistente.get();
			return "Usuário Autenticado";
	}
	
/************************ MÉTODO SALDO ***************************/	
	
	public String saldo() throws Exception {
		
		if (contaCorrente == null) 
			throw new Exception("Erro: Usuário não autenticado.");
			
		Double saldoAtualizado = contaCorrenteRepository.buscarSaldo(contaCorrente.getNumero());
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
		return "O saldo é" + formatoMoeda.format(saldoAtualizado) + ".";
	}
	
/************************ MÉTODO DEPOSITAR***************************/		
	
	public String depositar() throws Exception {
	    	   
		if (contaCorrente == null) 
			throw new Exception("Erro: Usuário não autenticado.");
		
		Double valorDeposito;
	    try {
	    	valorDeposito = mockHard.lerEnvelope();
	    	
	    }catch(Exception ex) {
	    	
	    	 throw new Exception("" + ex.getMessage());
	    }
	    contaCorrente.setSaldo(contaCorrente.getSaldo() + valorDeposito);
	    contaCorrenteRepository.save(contaCorrente);

		return "Depósito de " + valorDeposito + " recebido com sucesso.";
	 }

/************************ MÉTODO SACAR ***************************/	
	public String sacar(OperacaoDTO saque) throws Exception{
		
		if (contaCorrente == null) 
			throw new Exception("Erro: Usuário não autenticado.");
			
		Double valorSaque = saque.getValor();
			
		if (valorSaque == null || valorSaque <= 0) 
			throw new Exception("Valor de saque inválido.");
				
		if (valorSaque > contaCorrente.getSaldo()) 
			throw new Exception("Saldo insuficiente.");
				
		try {	
			mockHard.entregarDinheiro();
		}catch(Exception ex) {
			
			throw new Exception("" + ex.getMessage());
		}
				
		contaCorrente.setSaldo(contaCorrente.getSaldo() - valorSaque);
		contaCorrenteRepository.save(contaCorrente);
				
		return "Retire seu dinheiro";
					
   }

/************************ MÉTODO SETMOCK***************************/	
	
    public String setMock(MockHardware mockHard) throws Exception {
    	
    	Long numeroConta = mockHard.getNumeroConta();
    	if (numeroConta == null) 
    		throw new Exception("Erro: número da conta não pode ser nulo.");
    	
    	boolean falha = mockHard.getFalha();
    	mockHard.setNumeroConta(numeroConta);
        mockHard.setFalha(falha);
        
        return ("Mock atualizado com sucesso! \nNúmero da Conta: " + numeroConta + "\nFalha no Hardware: " + falha);
    }

 /************************ MÉTODO GETMOCK ***************************/
    public String getMock(){
    	
    	return "MOCK: falha: " + mockHard.getFalha() + ", numero: " + mockHard.getNumeroConta();
    }
    
}

