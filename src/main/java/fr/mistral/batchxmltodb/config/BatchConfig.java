package fr.mistral.batchxmltodb.config;


import fr.mistral.batchxmltodb.model.Commande;
import fr.mistral.batchxmltodb.processor.CommandeItenProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Bean
    public CommandeItenProcessor processor() {
        return new CommandeItenProcessor();
    }

    @Bean
    public StaxEventItemReader<Commande> reader() {
        StaxEventItemReader<Commande> reader = new StaxEventItemReader<Commande>();
        reader.setResource(new ClassPathResource("mistral.xml"));
        reader.setFragmentRootElementName("cmd");

        Map<String, String> aliasesMap = new HashMap<String, String>();
        aliasesMap.put("cmd", "fr.mistral.batchxmltodb.model.Commande");
        XStreamMarshaller marshaller = new XStreamMarshaller();
        marshaller.setAliases(aliasesMap);

        reader.setUnmarshaller(marshaller);
        return reader;
    }

    @Bean
    public JdbcBatchItemWriter<Commande> writer() {
        JdbcBatchItemWriter<Commande> writer = new JdbcBatchItemWriter<Commande>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO commande(origine,agence,bon,code_client,raison_sociale,ville,telephone,date_bon,copropriete,retrocession,forfait,commercial,date_livraison, stade,reference_client,reference_interne,lieu,objet_devis,retard_j,acompte,code_prospect,agent_1,agent_2,mode_paiement_1,echeance_1,terme_1,montant_echeance_1,echeance_prevue_1,mode_paiement_2, echeance_2,terme_2,montant_echeance_2, echeance_prevue_2,mode_paiement_3,echeance_3,terme_3,montant_echeance_3,echeance_prevue_3,mode_paiement_4,echeance_4,terme_4, montant_echeance_4,echeance_prevue_4,mode_paiement_5,echeance_5,terme_5,montant_echeance_5,echeance_prevue_5,mode_paiement_6, echeance_6,terme_6,montant_echeance_6,echeance_prevue_6,mode_paiement_7,echeance_7,terme_7,montant_echeance_7,echeance_prevue_7, mode_paiement_8,echeance_8,terme_8,montant_echeance_8,echeance_prevue_8,encours_a_facturer,montant,detail_lignes) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//               ,)" +

//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'\n" +
//                "\t\t '?', '?', '?', '?', '?', '?'" +


        writer.setItemPreparedStatementSetter(new CommandePreparedStatementSetter());
        return writer;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Commande, Commande>chunk(100).reader(reader()).processor(processor()).writer(writer()).build();
    }

    @Bean
    public Job exportPerosnJob() {
        return jobBuilderFactory.get("importPersonJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
    }
}
