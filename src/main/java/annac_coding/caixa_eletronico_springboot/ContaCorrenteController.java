package annac_coding.caixa_eletronico_springboot;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/caixaeletronico")
public class ContaCorrenteController {

	@Autowired
	ContaCorrenteService contaCorrenteService;
	@Autowired
	private MockHardware mockHard;
	
	
	@GetMapping
	public String testar() {
	    return "API funcionando!";
	}
	
	@PostMapping("/adicionarConta")
	public ResponseEntity<Object> adicionarConta(@RequestBody @Valid ContaCorrenteDTO contaDTO) {
		
	       try {
	            return ResponseEntity.ok(contaCorrenteService.adicionarConta(contaDTO));
	            
	        } catch (Exception ex) {
	            return ResponseEntity.status(500).body("Erro: " + ex.getMessage());
	        }
	 }
		
	@GetMapping("/login")
	public ResponseEntity<Object> buscarConta() {
		
		try {
            return ResponseEntity.ok(contaCorrenteService.login());
            
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Erro: " + ex.getMessage());
        }
	}
	
	@GetMapping("/saldo")
	public ResponseEntity<Object> saldo(){
		
		try {
			return ResponseEntity.ok(contaCorrenteService.saldo());
			
		}catch(Exception ex){
			
			return ResponseEntity.status(500).body("Erro: " + ex.getMessage());
		}	
	}
	
	@PostMapping("/depositar")
	public ResponseEntity<Object> depositar(){
		
		try {
			return ResponseEntity.ok(contaCorrenteService.depositar());
			
		}catch(Exception ex){
			
			return ResponseEntity.status(500).body("Erro: " + ex.getMessage());
		}	
	}
	
	@PostMapping("/sacar")
	public ResponseEntity<Object> sacar(@RequestBody @Valid OperacaoDTO saque){

		try {
			return ResponseEntity.ok(contaCorrenteService.sacar(saque));
			
		}catch(Exception ex){
			
			return ResponseEntity.status(500).body("Erro: " + ex.getMessage());
		}
	}
	
	@PostMapping("/setMock")
	public ResponseEntity<Object> setMock(@RequestBody MockHardware mockHard){

		try {
			return ResponseEntity.ok(contaCorrenteService.setMock(mockHard));
			
		}catch(Exception ex){
			
			return ResponseEntity.status(500).body("Erro: " + ex.getMessage());
		}
	}
	
	@PostMapping("/getMock")
	public ResponseEntity<Object> getMock(){

		try {
			return ResponseEntity.ok(contaCorrenteService.getMock());
			
		}catch(Exception ex){
			
			return ResponseEntity.status(500).body("Erro: " + ex.getMessage());
		}	
	}
	
}
