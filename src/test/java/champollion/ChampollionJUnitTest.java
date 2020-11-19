package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                
	}
	
	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testHeuresPrevues(){
            untel.ajouteEnseignement(uml, 1, 1, 1);
            untel.ajouteEnseignement(java, 1, 1, 1);
            
            assertEquals(4, untel.heuresPrevues(),"L'enseignant doit réaliser 4h" );
        }
        
        @Test
        public void testHeuresPlanifiees(){
            Salle s = new Salle ("Salle 1", 25);
            Intervention e = new Intervention (s, uml, untel, new Date(), 2, TypeIntervention.TD);
            untel.ajouteInterventions(e);
            assertEquals(2, untel.heuresPlanifiees(), "L'enseignant doit réaliser 2h");
        }
        
        @Test 
        public void testEnSousService(){
            untel.ajouteEnseignement(uml, 1, 1, 1);
            assertEquals(true, untel.enSousService(), "L'enseignant est en sous service");
            
            untel.ajouteEnseignement(uml, 100, 50, 50);
            assertEquals(true, untel.enSousService(), "L'enseignant n'est pas en sous service");
            
        }
	
}
