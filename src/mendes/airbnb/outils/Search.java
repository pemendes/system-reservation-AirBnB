package mendes.airbnb.outils;

import java.util.List;
import java.util.function.Predicate;
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

	public List<Logement> result() {

		return AirBnBData.getInstance().getListLogements().stream()
				     .filter(predicateNbVoyageurs()
				            .and(predicateTarif())
				            .and(predicatePiscine())
				            .and(predicateJardin())
				            .and(predicateBalcon()))
				     .collect(Collectors.toList());
	}

	private Predicate<Logement> predicateNbVoyageurs() {
		return logement -> nbVoyageurs <= logement.getNbVoyageursMax();
	}

	private Predicate<Logement> predicateTarif() {
		return logement -> logement.getTarifParNuit() >= tarifMinParNuit
				&& logement.getTarifParNuit() <= tarifMaxParNuit;
	}

	private Predicate<Logement> predicatePiscine() {

		if (possedePiscine == YES) {
			return logement -> logement instanceof Maison && ((Maison) logement).hasPiscine();
		} else if (possedePiscine == NO) {
			return logement -> logement instanceof Maison && !((Maison) logement).hasPiscine()
					|| !(logement instanceof Maison);
		} else {
			return logement -> true;
		}
	}
	
	private Predicate<Logement> predicateJardin() {

		if (possedeJardin == YES) {
			return logement -> logement instanceof Maison && ((Maison) logement).getSuperficieJardin() > 0;
		} else if (possedeJardin == NO) {
			return logement -> logement instanceof Maison && ((Maison) logement).getSuperficieJardin() == 0
					|| !(logement instanceof Maison);
		} else {
			return logement -> true;
		}
	}
	
	private Predicate<Logement> predicateBalcon() {

		if (possedeBalcon == YES) {
			return logement -> logement instanceof Appartement && ((Appartement) logement).getSuperficieBalcon() > 0;
		} else if (possedeBalcon == NO) {
			return logement -> logement instanceof Appartement && ((Appartement) logement).getSuperficieBalcon() == 0
					|| !(logement instanceof Appartement);
		} else {
			return logement -> true;
		}
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