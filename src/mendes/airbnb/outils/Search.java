package mendes.airbnb.outils;

import java.util.ArrayList;
import java.util.stream.Collectors;

import mendes.airbnb.logements.Appartement;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.logements.Maison;

public class Search {

	private static final int YES = 1;
	private static final int NO = 0;
	private static final int UNDEFINED = -1;
	
    private final int nbVoyageurs;
    private int tarifMinParNuit;
    private int tarifMaxParNuit;
    private int possedePiscine;
    private int possedeJardin;
    private int possedeBalcon;

    private Search(SearchBuilder searchBuilder) {
        nbVoyageurs = searchBuilder.nbVoyageursBuilder;
        tarifMinParNuit = searchBuilder.tarifMinParNuitBuilder;
        tarifMaxParNuit = searchBuilder.tarifMaxParNuitBuilder;
        possedePiscine = searchBuilder.possedePiscineBuilder;
        possedeJardin = searchBuilder.possedeJardinBuilder;
        possedeBalcon = searchBuilder.possedeBalconBuilder;
    }

    public ArrayList<Logement> result() {
        ArrayList<Logement> listResult = new ArrayList<>();

        for (Logement logement : AirBnBData.getInstance().getListLogements()) {

            // Test nombre de voyageur
            if (logement.getNbVoyageursMax() < nbVoyageurs)
                continue;

            // Test du tarif par nuit
            if (logement.getTarifParNuit() < tarifMinParNuit || logement.getTarifParNuit() > tarifMaxParNuit)
                continue;

            // Test pour la piscine
            if (possedePiscine == YES) {
                // Oui pour la piscine du coup c'est forcément une maison
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // La maison n'a pas de piscine, on ne la prend pas
                    if (!maison.hasPiscine())
                        continue;
                } else
                    continue;
                
            } else if (possedePiscine == NO) {
                // Non pour la piscine
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // Si la maison a une piscine, on ne la prend pas
                    if (maison.hasPiscine())
                        continue;
                }
            }

            // Test pour le jardin
            if (possedeJardin == YES) {
                // Oui pour le jardin du coup c'est forcément une maison
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // Si la maison n'a pas de jardin, on ne la prend pas
                    if (maison.getSuperficieJardin() == 0)
                        continue;
                } else
                    continue;
            } else if (possedeJardin == NO) {
                // Non pour le jardin
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // Si la maison a un jardin, on ne la prend pas
                    if (maison.getSuperficieJardin() != 0)
                        continue;
                }
            }

            // Test pour le balcon
            if (possedeBalcon == YES) {
                // Oui pour le balcon, c'est forcément un appartement
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement n'a pas de balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() == 0)
                        continue;
                } else
                    continue;
            } else if (possedeBalcon == NO) {
                // Non pour le balcon
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement a pas un balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() != 0)
                        continue;
                }

            }

            listResult.add(logement);
        }

        return listResult;
    }

    public static class SearchBuilder {

        private final int nbVoyageursBuilder;

        private int tarifMinParNuitBuilder;
        private int tarifMaxParNuitBuilder;
        private int possedeJardinBuilder;
        private int possedePiscineBuilder;
        private int possedeBalconBuilder;

        public SearchBuilder(int nbVoyageurs) {
            this.nbVoyageursBuilder = nbVoyageurs;
            tarifMinParNuitBuilder = 0;
            tarifMaxParNuitBuilder = Integer.MAX_VALUE;
            possedePiscineBuilder = UNDEFINED;
            possedeJardinBuilder = UNDEFINED;
            possedeBalconBuilder = UNDEFINED;
        }

        public SearchBuilder possedePiscine(boolean value) {
            if (value) {
                this.possedePiscineBuilder = YES;
            } else {
                this.possedePiscineBuilder = NO;
            }

            return this;
        }

        public SearchBuilder tarifMinParNuit(int value) {
            this.tarifMinParNuitBuilder = value;
            return this;
        }

        public SearchBuilder tarifMaxParNuit(int value) {
            this.tarifMaxParNuitBuilder = value;
            return this;
        }

        public SearchBuilder possedeJardin(boolean value) {
            if (value) {
                this.possedeJardinBuilder = YES;
            } else {
                this.possedeJardinBuilder = NO;
            }
            return this;
        }

        public SearchBuilder possedeBalcon(boolean value) {
            if (value) {
                this.possedeBalconBuilder = YES;
            } else {
                this.possedeBalconBuilder = NO;
            }
            return this;
        }

        public Search build() {
            return new Search(this);
        }
    }
}