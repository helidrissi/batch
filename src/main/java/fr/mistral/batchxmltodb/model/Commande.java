package fr.mistral.batchxmltodb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origine;
    private String agence;
    private String bon; //a mettre
    private String code_client; // a mettre
    private String raison_sociale;
    private String ville;
    private String telephone;
    private String date_bon;
    private Boolean copropriete;
    private Boolean retrocession;
    private Boolean forfait;
    private String commercial; // a mettre
    private String date_livraison;
    private String stade;
    private String reference_client;
    private String reference_interne;
    private String lieu;
    private String objet_devis;
    private String retard_j;
    private String acompte;
    private String code_prospect;
    private String agent_1; //a mettre
    private String agent_2;
    private String mode_paiement_1;
    private String echeance_1;
    private String terme_1;
    private String montant_echeance_1;
    private String echeance_prevue_1;
    private String mode_paiement_2;
    private String echeance_2;
    private String terme_2;
    private String montant_echeance_2;
    private String echeance_prevue_2;
    private String mode_paiement_3;
    private String echeance_3;
    private String terme_3;
    private String montant_echeance_3;
    private String echeance_prevue_3;
    private String mode_paiement_4;
    private String echeance_4;
    private String terme_4;
    private String montant_echeance_4;
    private String echeance_prevue_4;
    private String mode_paiement_5;
    private String echeance_5;
    private String terme_5;
    private String montant_echeance_5;
    private String echeance_prevue_5;
    private String mode_paiement_6;
    private String echeance_6;
    private String terme_6;
    private String montant_echeance_6;
    private String echeance_prevue_6;
    private String mode_paiement_7;
    private String echeance_7;
    private String terme_7;
    private String montant_echeance_7;
    private String echeance_prevue_7;
    private String mode_paiement_8;
    private String echeance_8;
    private String terme_8;
    private String montant_echeance_8;
    private String echeance_prevue_8;
    private String encours_a_facturer;
    private String montant;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String detail_lignes;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String commentaires;
    private String statut;
    private String nouvelle_date;
}
