package fr.mistral.batchxmltodb.processor;


import fr.mistral.batchxmltodb.model.Commande;
import org.springframework.batch.item.ItemProcessor;

public class CommandeItenProcessor implements ItemProcessor<Commande, Commande> {

	@Override
	public Commande process(Commande cmd) throws Exception {
		return cmd;
	}
}
