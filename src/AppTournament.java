import controllers.TournamentController;
import models.Athlete;
import models.Club;
import models.Tournament;
import test.TournamentTestData;

public class AppTournament {
        // public static void main(String[] args) {
                
        
        // //**TournamentController controller = new TournamentController();
        // Tournament[] tournaments = TournamentTestData.createTournaments();
        // System.out.println("Original");
        // controller.sortSelectionDes(tournaments);
        // void imprimirTorneos(tournaments);
        // int res1 =70;
        // Tournament resultado1 = controller.binarySearchByTotalStarterPointsFilaB(tournaments, res1);
        // if(resultado1 != null){
        //         System.out.println("Encontrado" + resultado1.toString);
        // }else{
        //         System.out.println("No encontrado");

        // }
        // int res2 =33;
        // Tournament resultado2 = controller.binarySearchByTotalStarterPointsFilaB(tournaments, res2);
        // if(resultado2 != null){
        //         System.out.println("Encontrado" + resultado2.toString);
        // }else{
        //         System.out.println("No encontrado");

        // }
        
        // public void imprimirTorneos(Tournament[] arr){
        //         for(Tournament t : arr){
        //                 System.out.println("Torneo : Punto=" + t.getTotalStarterPoints());
        //         }
        // }

        
        public static Tournament[] getTournaments() {
                // Copa Andina = 45
                Athlete[] condorAthletes = {
                                new Athlete("A. Perez", 12, true),
                                new Athlete("B. Ruiz", 8, false),
                                new Athlete("C. Leon", 9, true)
                };
                Athlete[] quitoAthletes = {
                                new Athlete("D. Mena", 14, true),
                                new Athlete("E. Lara", 7, false),
                                new Athlete("F. Ayala", 10, true)
                };
                Tournament copaAndina = new Tournament("Copa Andina",
                                new Club[] { new Club("Condor FC", condorAthletes),
                                                new Club("Quito United", quitoAthletes) });

                // Liga del Pacifico = 61
                Athlete[] mantaAthletes = {
                                new Athlete("G. Solis", 20, true),
                                new Athlete("H. Vega", 9, false),
                                new Athlete("I. Navas", 12, true)
                };
                Athlete[] guayaquilAthletes = {
                                new Athlete("J. Moya", 17, true),
                                new Athlete("K. Cedeno", 6, false),
                                new Athlete("L. Quiroz", 12, true)
                };
                Tournament ligaPacifico = new Tournament("Liga del Pacifico",
                                new Club[] { new Club("Manta City", mantaAthletes),
                                                new Club("Guayaquil Stars", guayaquilAthletes) });

                // Torneo Altura = 53
                Athlete[] sierraAthletes = {
                                new Athlete("M. Pardo", 16, true),
                                new Athlete("N. Paz", 5, false),
                                new Athlete("O. Jara", 11, true)
                };
                Athlete[] volcanAthletes = {
                                new Athlete("P. Cora", 15, true),
                                new Athlete("Q. Rios", 7, false),
                                new Athlete("R. Neira", 11, true)
                };
                Tournament torneoAltura = new Tournament("Torneo Altura",
                                new Club[] { new Club("Sierra Norte", sierraAthletes),
                                                new Club("Volcan Rojo", volcanAthletes) });

                // Supercopa Capital = 39
                Athlete[] centroAthletes = {
                                new Athlete("S. Trujillo", 10, true),
                                new Athlete("T. Nunez", 6, false),
                                new Athlete("U. Valle", 9, true)
                };
                Athlete[] metroAthletes = {
                                new Athlete("V. Roma", 11, true),
                                new Athlete("W. Gale", 5, false),
                                new Athlete("X. Prada", 9, true)
                };
                Tournament supercopaCapital = new Tournament("Supercopa Capital",
                                new Club[] { new Club("Centro Atletico", centroAthletes),
                                                new Club("Metro Club", metroAthletes) });

                // Masters Nacional = 70
                Athlete[] titanAthletes = {
                                new Athlete("Y. Ordonez", 24, true),
                                new Athlete("Z. Arroyo", 10, false),
                                new Athlete("AA. Vera", 15, true)
                };
                Athlete[] campeonAthletes = {
                                new Athlete("AB. Bravo", 18, true),
                                new Athlete("AC. Cano", 9, false),
                                new Athlete("AD. Duque", 13, true)
                };
                Tournament mastersNacional = new Tournament("Masters Nacional",
                                new Club[] { new Club("Titanes", titanAthletes),
                                                new Club("Campeon FC", campeonAthletes) });

                // Copa Costa = 34
                Athlete[] bahiaAthletes = {
                                new Athlete("AE. Lema", 9, true),
                                new Athlete("AF. Mora", 6, false),
                                new Athlete("AG. Soria", 8, true)
                };
                Athlete[] olaAthletes = {
                                new Athlete("AH. Brito", 10, true),
                                new Athlete("AI. Vaca", 4, false),
                                new Athlete("AJ. Toala", 7, true)
                };
                Tournament copaCosta = new Tournament("Copa Costa",
                                new Club[] { new Club("Bahia Norte", bahiaAthletes),
                                                new Club("Ola Azul", olaAthletes) });

                // Liga Metropolitana = 48
                Athlete[] norteAthletes = {
                                new Athlete("AK. Ulloa", 13, true),
                                new Athlete("AL. Astudillo", 7, false),
                                new Athlete("AM. Sanz", 11, true)
                };
                Athlete[] surAthletes = {
                                new Athlete("AN. Freire", 12, true),
                                new Athlete("AO. Mite", 5, false),
                                new Athlete("AP. Mera", 12, true)
                };
                Tournament ligaMetro = new Tournament("Liga Metropolitana",
                                new Club[] { new Club("Norte SC", norteAthletes),
                                                new Club("Sur Deportivo", surAthletes) });

                // Copa Frontera = 42
                Athlete[] orienteAthletes = {
                                new Athlete("AQ. Erazo", 11, true),
                                new Athlete("AR. Celi", 6, false),
                                new Athlete("AS. Rada", 10, true)
                };
                Athlete[] occidenteAthletes = {
                                new Athlete("AT. Pita", 11, true),
                                new Athlete("AU. Quito", 5, false),
                                new Athlete("AV. Pazmino", 10, true)
                };
                Tournament copaFrontera = new Tournament("Copa Frontera",
                                new Club[] { new Club("Oriente FC", orienteAthletes),
                                                new Club("Occidente FC", occidenteAthletes) });

                return new Tournament[] {
                                copaAndina,
                                ligaPacifico,
                                torneoAltura,
                                supercopaCapital,
                                mastersNacional,
                                copaCosta,
                                ligaMetro,
                                copaFrontera
                };
        }

        public static void main(String[] args) {
                /**
                 * Aquí debe estar el código para ejecutar la aplicación, utilizando el
                 * TournamentController para mostrar los resultados de cada torneo.
                 */

        }
}

