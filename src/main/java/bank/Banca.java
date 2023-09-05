package bank;

import java.util.ArrayList;

public class Banca {
	
	private ArrayList<ContoCorrente> conti;
	
	public Banca() {
		conti = new ArrayList<>();
		conti.add(new ContoCorrente("A001", "Mario Rossi", 1500));
		conti.add(new ContoCorrente("B131", "Flavia Verdi", 4500));
		conti.add(new ContoCorrente("A487", "Carlo Verdone", 11200));
	}

	public ArrayList<ContoCorrente> getConti() {
		return conti;
	}
	
	public boolean contoExists(String numero) {
		// ciclo su tutti conti
		for(ContoCorrente c : conti) {
			// se il numero l'ho trovato -> true
			if(c.getNumero().equals(numero)) {
				return true;
			}
		}
		// -> false
		return false;
	}

}
