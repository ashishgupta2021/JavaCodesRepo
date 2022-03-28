package code.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import code.springframework.model.Owner;
import code.springframework.model.Vet;
import code.springframework.services.OwnerService;
import code.springframework.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.err.println("----------------------");
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Ashish");
		owner1.setLastName("Gupta");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Manish");
		owner2.setLastName("Gupta");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owner...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Niraj");
		vet1.setLastName("Gupta");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Dhiraj");
		vet2.setLastName("Gupta");
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets...");
		
		
		
		
	}

}
