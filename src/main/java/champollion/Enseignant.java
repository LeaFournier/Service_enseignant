package champollion;

import java.util.ArrayList;
import java.util.LinkedList;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    ArrayList<ServicePrevu> serviceprevu = new ArrayList<>();
    LinkedList<Intervention> interventions = new LinkedList<>();
    
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int equivalentTD = 0;
        for (ServicePrevu servicep : serviceprevu){
            equivalentTD += 1.5 * servicep.getVolumeCM();
            equivalentTD += servicep.getVolumeTD();
            equivalentTD += 0.75 * servicep.getVolumeTP();
        }  
        return Math.round(equivalentTD);
        // TODO: Implémenter cette méthode
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        int equivalentTD_UE = 0;
        
        for (ServicePrevu servicep : serviceprevu){
            if (servicep.getUe() == ue){
            equivalentTD_UE += 1.5 * servicep.getVolumeCM();
            equivalentTD_UE += servicep.getVolumeTD();
            equivalentTD_UE += 0.75 * servicep.getVolumeTP();
        }
    }
        return Math.round(equivalentTD_UE);
    }
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu servicep = new ServicePrevu (volumeCM, volumeTD, volumeTP, ue, this);
        serviceprevu.add(servicep);
        // TODO: Implémenter cette méthode
    }
    
    public void ajouteInterventions(Intervention e){
        interventions.add(e);
        
    }
   
    
    public int heuresPlanifiees(){
        int heuresPlanifiees = 0;
        
        for (int i = 0; i < interventions.size(); i++){
            
            switch (interventions.get(i).getType()){
                
                case CM:
                    heuresPlanifiees += interventions.get(i).getDuree() * 1.5;
                    break;
                case TD: 
                    heuresPlanifiees += interventions.get(i).getDuree();
                    break;
                case TP:
                    heuresPlanifiees += interventions.get(i).getDuree() * 0.75;
                    break;
                default:
                    break;
            }
            
        }
        return Math.round(heuresPlanifiees);
    }
    
    public boolean enSousService(){
        if(heuresPlanifiees()>= 192){
            return false;
        }else{
            return true;
        }
      
    }
}