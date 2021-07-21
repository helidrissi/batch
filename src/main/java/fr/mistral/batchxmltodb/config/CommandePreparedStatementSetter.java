package fr.mistral.batchxmltodb.config;





import fr.mistral.batchxmltodb.model.Commande;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommandePreparedStatementSetter implements ItemPreparedStatementSetter<Commande> {

	@Override
	public void setValues(Commande person, PreparedStatement ps) throws SQLException {
		ps.setString(1, person.getOrigine());
		ps.setString(2, person.getAgence());
		ps.setString(3, person.getBon());
		ps.setString(4, person.getCode_client());
		ps.setString(5, person.getRaison_sociale());
		ps.setString(6, person.getVille());
		ps.setString(7, person.getTelephone());
		ps.setString(8, person.getDate_bon());
		ps.setBoolean(9, person.getCopropriete());
		ps.setBoolean(10, person.getRetrocession());
		ps.setBoolean(11, person.getForfait());
		ps.setString(12, person.getCommercial());
		ps.setString(13, person.getDate_livraison());
		ps.setString(14, person.getStade());
		ps.setString(15, person.getReference_client());
		ps.setString(16, person.getReference_interne());
		ps.setString(17, person.getLieu());
		ps.setString(18, person.getObjet_devis());
		ps.setString(19, person.getRetard_j());
		ps.setString(20, person.getAcompte());
		ps.setString(21, person.getCode_prospect());
		ps.setString(22, person.getAgent_1());
		ps.setString(23, person.getAgent_2());
		ps.setString(24, person.getMode_paiement_1());
		ps.setString(25, person.getEcheance_1());
		ps.setString(26, person.getTerme_1());
		ps.setString(27, person.getMontant_echeance_1());
		ps.setString(28, person.getEcheance_prevue_1());
		ps.setString(29, person.getMode_paiement_2());
		ps.setString(30, person.getEcheance_2());
		ps.setString(31, person.getTerme_2());
		ps.setString(32, person.getMontant_echeance_2());
		ps.setString(33, person.getEcheance_prevue_2());
		ps.setString(34, person.getMode_paiement_3());
		ps.setString(35, person.getEcheance_3());
		ps.setString(36, person.getTerme_3());
		ps.setString(37, person.getMontant_echeance_3());
		ps.setString(38, person.getEcheance_prevue_3());
		ps.setString(39, person.getMode_paiement_4());
		ps.setString(40, person.getEcheance_4());
		ps.setString(41, person.getTerme_4());
		ps.setString(42, person.getMontant_echeance_4());
		ps.setString(43, person.getEcheance_prevue_4());
		ps.setString(44, person.getMode_paiement_5());
		ps.setString(45, person.getEcheance_5());
		ps.setString(46, person.getTerme_5());
		ps.setString(47, person.getMontant_echeance_5());
		ps.setString(48, person.getEcheance_prevue_5());
		ps.setString(49, person.getMode_paiement_6());
		ps.setString(50, person.getEcheance_6());
		ps.setString(51, person.getTerme_6());
		ps.setString(52, person.getMontant_echeance_6());
		ps.setString(53, person.getEcheance_prevue_6());
		ps.setString(54, person.getMode_paiement_7());
		ps.setString(55, person.getEcheance_7());
		ps.setString(56, person.getTerme_7());
		ps.setString(57, person.getMontant_echeance_7());
		ps.setString(58, person.getEcheance_prevue_7());
		ps.setString(59, person.getMode_paiement_8());
		ps.setString(60, person.getEcheance_8());
		ps.setString(61, person.getTerme_8());
		ps.setString(62, person.getMontant_echeance_8());
		ps.setString(63, person.getEcheance_prevue_8());
		ps.setString(64, person.getEncours_a_facturer());
		ps.setString(65, person.getMontant());
		ps.setString(66, person.getDetail_lignes());


	}

}
