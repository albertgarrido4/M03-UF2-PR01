import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class AlbertGarrido {
    public static void main(String[] args) {

        int[][] equip = new int[32][5];
        String[] nombreEquips = {"Napoli", "Ajax", "Liverpool", "Rangers", "Oporto", "Brujas", "Bayer04", "A.Madrid", "FC Bayern", "Inter", "FC Barcelona", "Viktoria plzen", "Spurs", "Eintracht", "S.Portugal", "Marseille", "Chelsea", "AC Milan", "Salzburgo", "D.Zagreb", "R.Madrid", "RB Leipzig", "Shaktar D.", "Celtic", "Man. City", "B.Dortmund", "Sevilla", "Copenhagen", "Benfica", "PSG", "Juventus", "Maccabi Haifa"};
        ArrayList<String> bombo1Vuitens = new ArrayList<>(7);
        ArrayList<String> bombo2Vuitens = new ArrayList<>(7);
        String[] bomboQuarts = new String[8];
        String[] bomboSemis = new String[4];
        String[] bomboFinal = new String[2];

        menuPrincipal(equip, nombreEquips, bombo1Vuitens, bombo2Vuitens, bomboQuarts, bomboSemis, bomboFinal);
    }


    /**
     * Métode per mostrar un missatge parametritzat per pantalla i mostrar un menú funcional.
     *
     * @param equip
     * @param nombreEquips
     * @param bombo1Vuitens
     * @param bombo2Vuitens
     * @param bomboQuarts
     * @param bomboSemis
     * @param bomboFinal
     */
    private static void menuPrincipal(int[][] equip, String[] nombreEquips, ArrayList<String> bombo1Vuitens, ArrayList<String> bombo2Vuitens, String[] bomboQuarts, String[] bomboSemis, String[] bomboFinal) {
        final String MISSATGE = "Selecciona una opció: \n (1)Veure classificacio (2)Sortir (3)Jornada1 (4)Jornada2 (5)Jornada3 (6)Jornada4 (7)Jornada5 (8)Jornada6 (9)Vuitens (10)Quarts (11)Semis (12)Final";
        int min = 0;
        int max = 3;
        int opcio;
        System.out.println("Benvingut a la edició 22-23 de la UEFA Champions League");

        do {
            opcio = llegirInt(MISSATGE, min, max);

            switch (opcio) {
                case 1:
                    mostrarClassificacio(equip, nombreEquips);
                    System.out.println(" ");

                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Jornada1");
                    jornada1(equip, nombreEquips);
                    System.out.println(" ");
                    max = 4;
                    break;
                case 4:
                    System.out.println("Jornada2");
                    jornada2(equip, nombreEquips);
                    System.out.println(" ");
                    max = 5;
                    break;
                case 5:
                    System.out.println("Jornada3");
                    jornada3(equip, nombreEquips);
                    System.out.println(" ");
                    max = 6;
                    break;
                case 6:
                    System.out.println("Jornada4");
                    jornada4(equip, nombreEquips);
                    System.out.println(" ");
                    max = 7;
                    break;
                case 7:
                    System.out.println("Jornada5");
                    jornada5(equip, nombreEquips);
                    System.out.println(" ");
                    max = 8;
                    break;
                case 8:
                    System.out.println("Jornada6");
                    jornada6(equip, nombreEquips);
                    System.out.println(" ");
                    max = 9;
                    break;
                case 9:
                    System.out.println("Sorteig Vuitens:");
                    sorteigVuitens(equip, nombreEquips, bombo1Vuitens, bombo2Vuitens);
                    sorteigVuitens(bombo1Vuitens, bombo2Vuitens);
                    System.out.println(" ");
                    calcularGuanyadorVuitens(bombo1Vuitens, bombo2Vuitens, bomboQuarts);
                    max = 10;
                    break;
                case 10:
                    System.out.println("Sorteig Quarts: ");
                    sorteigQuarts(bomboQuarts);
                    System.out.println(" ");
                    calcularGuanyadorQuarts(bomboQuarts, bomboSemis);
                    max = 11;
                    break;
                case 11:
                    System.out.println("Sorteig semis");
                    enfrontamentSemis(bomboSemis);
                    System.out.println(" ");
                    calcularSemis(bomboSemis, bomboFinal);


                    max = 12;
                    break;
                case 12:
                    calcularFinal(bomboFinal);
                    break;
            }
        } while (opcio != 2);
    }


    /**
     * Aquest mètode llegeix un enter per teclat dins d'un domini determinat
     *
     * @param missatge parametritzat per a mostrar a l'usuari@
     * @param min      valor min acceptat
     * @param max      valor max acceptat
     * @return retorna un int
     * @since 1.0
     */
    private static int llegirInt(String missatge, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do {
            System.out.println(missatge);
            valorCorrecte = llegir.hasNextInt();
            if (!valorCorrecte) {
                System.out.println("ERROR: Valor no enter.");
                llegir.nextLine();
            } else { // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max) {
                    System.out.println("Opció no vàlida, encara no l'has desbloquejat");
                    valorCorrecte = false;
                }
            }
        } while (!valorCorrecte);

        return x;
    }

    /**
     * Métode que emmagatzema les dades necesaries de la fase de grups
     *
     * @return
     */
    private static int[][] mostrarGrups() {
        int[][] equip = new int[32][5];

        //GRUP A


        equip[0][0] = Integer.parseInt("Napoli");
        equip[0][1] = 0;//Victorias
        equip[0][2] = 0;//Empates
        equip[0][3] = 0;//Derrotas
        equip[0][4] = 0;//PTS

        equip[1][0] = Integer.parseInt("Ajax");
        equip[1][1] = 0;//Victorias
        equip[1][2] = 0;//Empates
        equip[1][3] = 0;//Derrotas
        equip[1][4] = 0;//PTS

        equip[2][0] = Integer.parseInt("Liverpool");
        equip[2][1] = 0;//Victorias
        equip[2][2] = 0;//Empates
        equip[2][3] = 0;//Derrotas
        equip[2][4] = 0;//PTS

        equip[3][0] = Integer.parseInt("Rangers");
        equip[3][1] = 0;//Victorias
        equip[3][2] = 0;//Empates
        equip[3][3] = 0;//Derrotas
        equip[3][4] = 0;//PTS

        //GRUP B
        equip[4][0] = Integer.parseInt("Oporto");
        equip[4][1] = 0;
        equip[4][2] = 0;
        equip[4][3] = 0;
        equip[4][4] = 0;

        equip[5][0] = Integer.parseInt("Brujas");
        equip[5][1] = 0;
        equip[5][2] = 0;
        equip[5][3] = 0;
        equip[5][4] = 0;

        equip[6][0] = Integer.parseInt("Bayern 04");
        equip[6][1] = 0;
        equip[6][2] = 0;
        equip[6][3] = 0;
        equip[6][4] = 0;

        equip[7][0] = Integer.parseInt("A.Madrid");
        equip[7][1] = 0;
        equip[7][2] = 0;
        equip[7][3] = 0;
        equip[7][4] = 0;

        //GRUP C
        equip[8][0] = Integer.parseInt("FC Bayern");
        equip[8][1] = 0;
        equip[8][2] = 0;
        equip[8][3] = 0;
        equip[8][4] = 0;

        equip[9][0] = Integer.parseInt("Inter");
        equip[9][1] = 0;
        equip[9][2] = 0;
        equip[9][3] = 0;
        equip[9][4] = 0;

        equip[10][0] = Integer.parseInt("FC Barcelona");
        equip[10][1] = 0;
        equip[10][2] = 0;
        equip[10][3] = 0;
        equip[10][4] = 0;

        equip[11][0] = Integer.parseInt("Viktoria plzen");
        equip[11][1] = 0;
        equip[11][2] = 0;
        equip[11][3] = 0;
        equip[11][4] = 0;

        //GRUP D
        //Spurs=12
        equip[12][0] = Integer.parseInt("Spurs");
        equip[12][1] = 0;
        equip[12][2] = 0;
        equip[12][3] = 0;
        equip[12][4] = 0;
        //Eintracht=13
        equip[13][0] = Integer.parseInt("Eintracht");
        equip[13][1] = 0;
        equip[13][2] = 0;
        equip[13][3] = 0;
        equip[13][4] = 0;
        //SPORTING PORTUGAL = 14
        equip[14][0] = Integer.parseInt("S.Portugal");
        equip[14][1] = 0;
        equip[14][2] = 0;
        equip[14][3] = 0;
        equip[14][4] = 0;
        //Marseille = 15
        equip[15][0] = Integer.parseInt("Marseille");
        equip[15][1] = 0;
        equip[15][2] = 0;
        equip[15][3] = 0;
        equip[15][4] = 0;

        //GRUP E
        //Chelsea = 16
        equip[16][0] = Integer.parseInt("Chelsea");
        equip[16][1] = 0;
        equip[16][2] = 0;
        equip[16][3] = 0;
        equip[16][4] = 0;
        //AC Milan = 17
        equip[17][0] = Integer.parseInt("AC Milan");
        equip[17][1] = 0;
        equip[17][2] = 0;
        equip[17][3] = 0;
        equip[17][4] = 0;
        //Salzburg = 18
        equip[18][0] = Integer.parseInt("Salzburg");
        equip[18][1] = 0;
        equip[18][2] = 0;
        equip[18][3] = 0;
        equip[18][4] = 0;
        //Dinamo Zagreb = 19
        equip[19][0] = Integer.parseInt("D.Zagreb");
        equip[19][1] = 0;
        equip[19][2] = 0;
        equip[19][3] = 0;
        equip[19][4] = 0;

        //GRUP F
        //Real Madrid = 20
        equip[20][0] = Integer.parseInt("R.Madrid");
        equip[20][1] = 0;
        equip[20][2] = 0;
        equip[20][3] = 0;
        equip[20][4] = 0;
        //RB Leipzig = 21
        equip[21][0] = Integer.parseInt("RB Leipzig");
        equip[21][1] = 0;
        equip[21][2] = 0;
        equip[21][3] = 0;
        equip[21][4] = 0;
        //Shaktar Donesk = 22
        equip[22][0] = Integer.parseInt("Shaktar D.");
        equip[22][1] = 0;
        equip[22][2] = 0;
        equip[22][3] = 0;
        equip[22][4] = 0;
        //Celtic = 23
        equip[23][0] = Integer.parseInt("Celtic");
        equip[23][1] = 0;
        equip[23][2] = 0;
        equip[23][3] = 0;
        equip[23][4] = 0;

        //GRUP G
        //Manchester City = 24
        equip[24][0] = Integer.parseInt("Man. City");
        equip[24][1] = 0;
        equip[24][2] = 0;
        equip[24][3] = 0;
        equip[24][4] = 0;
        //B.Dortmund = 25
        equip[25][0] = Integer.parseInt("B.Dortmund");
        equip[25][1] = 0;
        equip[25][2] = 0;
        equip[25][3] = 0;
        equip[25][4] = 0;
        //Sevilla = 26
        equip[26][0] = Integer.parseInt("Sevilla");
        equip[26][1] = 0;
        equip[26][2] = 0;
        equip[26][3] = 0;
        equip[26][4] = 0;
        //Copenhagen = 27
        equip[27][0] = Integer.parseInt("Copenhagen");
        equip[27][1] = 0;
        equip[27][2] = 0;
        equip[27][3] = 0;
        equip[27][4] = 0;

        //GRUP H
        //Benfica = 28
        equip[28][0] = Integer.parseInt("Benfica");
        equip[28][1] = 0;
        equip[28][2] = 0;
        equip[28][3] = 0;
        equip[28][4] = 0;
        //PSG = 29
        equip[29][0] = Integer.parseInt("PSG");
        equip[29][1] = 0;
        equip[29][2] = 0;
        equip[29][3] = 0;
        equip[29][4] = 0;
        //Juventus = 30
        equip[30][0] = Integer.parseInt("Juventus");
        equip[30][1] = 0;
        equip[30][2] = 0;
        equip[30][3] = 0;
        equip[30][4] = 0;
        //Maccabi Haifa = 31
        equip[31][0] = Integer.parseInt("Maccabi Haifa");
        equip[31][1] = 0;
        equip[31][2] = 0;
        equip[31][3] = 0;
        equip[31][4] = 0;

        return equip;
    }

    /**
     * Métode que simula la primera jornada de la fase de grups
     *
     * @param equip
     * @param nombreEquips
     */
    private static void jornada1(int[][] equip, String[] nombreEquips) {

        int equipLocal;
        int equipVisitant;

        //Dortmund-Copenhagen
        System.out.println(nombreEquips[25] + " VS " + nombreEquips[27]);
        equipLocal = 25;
        equipVisitant = 27;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Dinamo Zagreb-Chelsea
        System.out.println(nombreEquips[19] + " VS " + nombreEquips[16]);
        equipLocal = 19;
        equipVisitant = 16;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Benfica-Maccabi Haifa
        System.out.println(nombreEquips[28] + " VS " + nombreEquips[31]);
        equipLocal = 28;
        equipVisitant = 31;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Celtic-Real Madrid
        System.out.println(nombreEquips[23] + " VS " + nombreEquips[20]);
        equipLocal = 23;
        equipVisitant = 20;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Salzburg-AC Milan
        System.out.println(nombreEquips[18] + " VS " + nombreEquips[17]);
        equipLocal = 18;
        equipVisitant = 17;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //PSG-Juventus
        System.out.println(nombreEquips[29] + " VS " + nombreEquips[30]);
        equipLocal = 29;
        equipVisitant = 30;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //RB Leipzig-Shaktar D.
        System.out.println(nombreEquips[21] + " VS " + nombreEquips[22]);
        equipLocal = 21;
        equipVisitant = 22;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Sevilla-Man City
        System.out.println(nombreEquips[26] + " VS " + nombreEquips[24]);
        equipLocal = 26;
        equipVisitant = 24;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //AJAX-Rangers
        System.out.println(nombreEquips[1] + " VS " + nombreEquips[3]);
        equipLocal = 1;
        equipVisitant = 3;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Eintracht-S.Portugal
        System.out.println(nombreEquips[13] + " VS " + nombreEquips[14]);
        equipLocal = 13;
        equipVisitant = 14;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //A.Madrid-Oporto
        System.out.println(nombreEquips[7] + " VS " + nombreEquips[4]);
        equipLocal = 7;
        equipVisitant = 4;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //FC Barceclona-Viktoria Plzen
        System.out.println(nombreEquips[10] + " VS " + nombreEquips[11]);
        equipLocal = 10;
        equipVisitant = 11;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Brujas-Bayer04
        System.out.println(nombreEquips[5] + " VS " + nombreEquips[6]);
        equipLocal = 5;
        equipVisitant = 6;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Inter-FC Bayern
        System.out.println(nombreEquips[9] + " VS " + nombreEquips[8]);
        equipLocal = 9;
        equipVisitant = 8;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Napoli-Liverpool
        System.out.println(nombreEquips[0] + " VS " + nombreEquips[2]);
        equipLocal = 0;
        equipVisitant = 2;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //SPURS-Marseille
        System.out.println(nombreEquips[12] + " VS " + nombreEquips[15]);
        equipLocal = 12;
        equipVisitant = 15;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);


    }

    /**
     * Métode que simula la jornada 2 de la fase de grups
     *
     * @param equip
     * @param nombreEquips
     */
    public static void jornada2(int[][] equip, String[] nombreEquips) {

        int equipLocal;
        int equipVisitant;

        //S.Portugal-SPURS
        System.out.println(nombreEquips[14] + " VS " + nombreEquips[12]);
        equipLocal = 14;
        equipVisitant = 12;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Viktoria Plzen-Inter
        System.out.println(nombreEquips[11] + " VS " + nombreEquips[9]);
        equipLocal = 11;
        equipVisitant = 9;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Bayer04-A.Madrid
        System.out.println(nombreEquips[6] + " VS " + nombreEquips[7]);
        equipLocal = 6;
        equipVisitant = 7;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //FC Bayern-FC Barcelona
        System.out.println(nombreEquips[8] + " VS " + nombreEquips[10]);
        equipLocal = 8;
        equipVisitant = 10;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Oporto-Brujas
        System.out.println(nombreEquips[4] + " VS " + nombreEquips[5]);
        equipLocal = 4;
        equipVisitant = 5;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Liverpool-Ajax
        System.out.println(nombreEquips[2] + " VS " + nombreEquips[1]);
        equipLocal = 2;
        equipVisitant = 1;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Marseille-Eintracht
        System.out.println(nombreEquips[15] + " VS " + nombreEquips[13]);
        equipLocal = 15;
        equipVisitant = 13;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Milan-D.Zagreb
        System.out.println(nombreEquips[17] + " VS " + nombreEquips[19]);
        equipLocal = 17;
        equipVisitant = 19;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Shaktar-Celtic
        System.out.println(nombreEquips[22] + " VS " + nombreEquips[23]);
        equipLocal = 22;
        equipVisitant = 23;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Rangers-Napoli
        System.out.println(nombreEquips[3] + " VS " + nombreEquips[0]);
        equipLocal = 3;
        equipVisitant = 0;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Chelsea-Salzburg
        System.out.println(nombreEquips[16] + " VS " + nombreEquips[18]);
        equipLocal = 16;
        equipVisitant = 18;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Copenhagen-Sevilla
        System.out.println(nombreEquips[27] + " VS " + nombreEquips[26]);
        equipLocal = 27;
        equipVisitant = 26;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Juventus-Benfica
        System.out.println(nombreEquips[30] + " VS " + nombreEquips[28]);
        equipLocal = 30;
        equipVisitant = 28;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Maccabi Haifa-PSG
        System.out.println(nombreEquips[31] + " VS " + nombreEquips[29]);
        equipLocal = 31;
        equipVisitant = 29;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Man. City-B.Dortmund
        System.out.println(nombreEquips[24] + " VS " + nombreEquips[25]);
        equipLocal = 24;
        equipVisitant = 25;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //R.Madrid-RB Leipzig
        System.out.println(nombreEquips[20] + " VS " + nombreEquips[21]);
        equipLocal = 20;
        equipVisitant = 21;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

    }

    /**
     * Métode que simula la jornada 3 de la fase de grups
     *
     * @param equip
     * @param nombreEquips
     */
    public static void jornada3(int[][] equip, String[] nombreEquips) {

        int equipLocal;
        int equipVisitant;

        //FC Bayern-Viktoria Plzen
        System.out.println(nombreEquips[8] + " VS " + nombreEquips[11]);
        equipLocal = 8;
        equipVisitant = 11;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Marseille-S.Portugal
        System.out.println(nombreEquips[15] + " VS " + nombreEquips[14]);
        equipLocal = 15;
        equipVisitant = 14;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Ajax-Napoli
        System.out.println(nombreEquips[1] + " VS " + nombreEquips[0]);
        equipLocal = 1;
        equipVisitant = 0;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Brujas-A.Madrid
        System.out.println(nombreEquips[5] + " VS " + nombreEquips[7]);
        equipLocal = 5;
        equipVisitant = 7;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Eintacht-SPURS
        System.out.println(nombreEquips[13] + " VS " + nombreEquips[12]);
        equipLocal = 13;
        equipVisitant = 12;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Oporto-Bayer04
        System.out.println(nombreEquips[4] + " VS " + nombreEquips[6]);
        equipLocal = 4;
        equipVisitant = 6;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Inter-FC Barcelona
        System.out.println(nombreEquips[9] + " VS " + nombreEquips[10]);
        equipLocal = 9;
        equipVisitant = 10;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Liverpool-Rengers
        System.out.println(nombreEquips[2] + " VS " + nombreEquips[3]);
        equipLocal = 2;
        equipVisitant = 3;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Salzburg-D.Zagreb
        System.out.println(nombreEquips[18] + " VS " + nombreEquips[19]);
        equipLocal = 18;
        equipVisitant = 19;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //RB Leipzig-Celtic
        System.out.println(nombreEquips[21] + " VS " + nombreEquips[23]);
        equipLocal = 21;
        equipVisitant = 23;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Benfica-PSG
        System.out.println(nombreEquips[28] + " VS " + nombreEquips[29]);
        equipLocal = 28;
        equipVisitant = 29;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Chelsea-AC Milan
        System.out.println(nombreEquips[16] + " VS " + nombreEquips[17]);
        equipLocal = 16;
        equipVisitant = 17;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Juventus-Maccabi Haifa
        System.out.println(nombreEquips[30] + " VS " + nombreEquips[31]);
        equipLocal = 30;
        equipVisitant = 31;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Man City-Copenhagen
        System.out.println(nombreEquips[24] + " VS " + nombreEquips[27]);
        equipLocal = 24;
        equipVisitant = 27;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //R.Madrid-Shaktar D.
        System.out.println(nombreEquips[20] + " VS " + nombreEquips[22]);
        equipLocal = 20;
        equipVisitant = 22;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Sevilla-B.Dortmund
        System.out.println(nombreEquips[26] + " VS " + nombreEquips[25]);
        equipLocal = 26;
        equipVisitant = 25;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);


    }

    /**
     * Métode que simula la jornada 4 de la fase de grups
     *
     * @param equip
     * @param nombreEquips
     */
    public static void jornada4(int[][] equip, String[] nombreEquips) {

        int equipLocal;
        int equipVisitant;

        //Copenhagen-Man. City
        System.out.println(nombreEquips[27] + " VS " + nombreEquips[24]);
        equipLocal = 27;
        equipVisitant = 24;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Maccabi Haifa-Juventus
        System.out.println(nombreEquips[31] + " VS " + nombreEquips[30]);
        equipLocal = 31;
        equipVisitant = 30;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //B.Dortmund-Sevilla
        System.out.println(nombreEquips[25] + " VS " + nombreEquips[26]);
        equipLocal = 25;
        equipVisitant = 26;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Celtic-RB Leipzig
        System.out.println(nombreEquips[23] + " VS " + nombreEquips[21]);
        equipLocal = 23;
        equipVisitant = 21;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //D.Zagreb-Salzburg
        System.out.println(nombreEquips[19] + " VS " + nombreEquips[18]);
        equipLocal = 19;
        equipVisitant = 18;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //AC Milan-Chelsea
        System.out.println(nombreEquips[17] + " VS " + nombreEquips[16]);
        equipLocal = 17;
        equipVisitant = 16;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //PSG-Benfica
        System.out.println(nombreEquips[29] + " VS " + nombreEquips[28]);
        equipLocal = 29;
        equipVisitant = 28;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Shaktar D.-R.Madrid
        System.out.println(nombreEquips[22] + " VS " + nombreEquips[20]);
        equipLocal = 22;
        equipVisitant = 20;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //A.Madrid-Brujas
        System.out.println(nombreEquips[7] + " VS " + nombreEquips[5]);
        equipLocal = 7;
        equipVisitant = 5;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Napoli-Ajax
        System.out.println(nombreEquips[0] + " VS " + nombreEquips[1]);
        equipLocal = 0;
        equipVisitant = 1;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //FC Barcelona-Inter
        System.out.println(nombreEquips[10] + " VS " + nombreEquips[9]);
        equipLocal = 10;
        equipVisitant = 9;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Bayern04-Oporto
        System.out.println(nombreEquips[6] + " VS " + nombreEquips[4]);
        equipLocal = 6;
        equipVisitant = 4;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Rangers-Liverpool
        System.out.println(nombreEquips[3] + " VS " + nombreEquips[2]);
        equipLocal = 3;
        equipVisitant = 2;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //S.Portugal-Marseille
        System.out.println(nombreEquips[14] + " VS " + nombreEquips[15]);
        equipLocal = 14;
        equipVisitant = 15;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //SPURS-Eintracht
        System.out.println(nombreEquips[12] + " VS " + nombreEquips[13]);
        equipLocal = 12;
        equipVisitant = 13;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Viktoria Plzen-FC Bayern
        System.out.println(nombreEquips[11] + " VS " + nombreEquips[8]);
        equipLocal = 11;
        equipVisitant = 8;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);


    }

    /**
     * Métode que simula la jornada 5 de la fase de grups
     *
     * @param equip
     * @param nombreEquips
     */
    public static void jornada5(int[][] equip, String[] nombreEquips) {

        int equipLocal;
        int equipVisitant;

        //Salzburg-Chelsea
        System.out.println(nombreEquips[18] + " VS " + nombreEquips[16]);
        equipLocal = 18;
        equipVisitant = 16;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Sevilla-Copenhagen
        System.out.println(nombreEquips[26] + " VS " + nombreEquips[27]);
        equipLocal = 26;
        equipVisitant = 27;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Benfica-Juventus
        System.out.println(nombreEquips[28] + " VS " + nombreEquips[30]);
        equipLocal = 28;
        equipVisitant = 30;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //B.Dortmund-Man.City
        System.out.println(nombreEquips[25] + " VS " + nombreEquips[24]);
        equipLocal = 25;
        equipVisitant = 24;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Celtic-Shaktar D.
        System.out.println(nombreEquips[23] + " VS " + nombreEquips[22]);
        equipLocal = 23;
        equipVisitant = 22;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //D.Zagreb-AC Milan
        System.out.println(nombreEquips[19] + " VS " + nombreEquips[17]);
        equipLocal = 19;
        equipVisitant = 17;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //PSG-Maccabi Haifa
        System.out.println(nombreEquips[29] + " VS " + nombreEquips[31]);
        equipLocal = 29;
        equipVisitant = 31;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //RB Leipzig-R.Madrid
        System.out.println(nombreEquips[21] + " VS " + nombreEquips[20]);
        equipLocal = 21;
        equipVisitant = 20;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Brujas-Oporto
        System.out.println(nombreEquips[5] + " VS " + nombreEquips[4]);
        equipLocal = 5;
        equipVisitant = 4;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Inter-Viktoria Plzen
        System.out.println(nombreEquips[9] + " VS " + nombreEquips[11]);
        equipLocal = 9;
        equipVisitant = 11;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Ajax-Liverpool
        System.out.println(nombreEquips[1] + " VS " + nombreEquips[2]);
        equipLocal = 1;
        equipVisitant = 2;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //A.Madrid-Bayer04
        System.out.println(nombreEquips[7] + " VS " + nombreEquips[6]);
        equipLocal = 7;
        equipVisitant = 6;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //FC Barcelona-FC Bayern
        System.out.println(nombreEquips[10] + " VS " + nombreEquips[8]);
        equipLocal = 10;
        equipVisitant = 8;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Eintracht-Marseille
        System.out.println(nombreEquips[13] + " VS " + nombreEquips[15]);
        equipLocal = 13;
        equipVisitant = 15;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Napoli-Rangers
        System.out.println(nombreEquips[0] + " VS " + nombreEquips[3]);
        equipLocal = 0;
        equipVisitant = 3;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //SPURS-S.Portugal
        System.out.println(nombreEquips[12] + " VS " + nombreEquips[14]);
        equipLocal = 12;
        equipVisitant = 14;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);


    }

    /**
     * Métode que simula la jornada 6 de la fase de grups
     *
     * @param equip
     * @param nombreEquips
     */
    public static void jornada6(int[][] equip, String[] nombreEquips) {

        int equipLocal;
        int equipVisitant;

        //Bayer04-Brujas
        System.out.println(nombreEquips[6] + " VS " + nombreEquips[5]);
        equipLocal = 6;
        equipVisitant = 5;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Oporto-A.Madrid
        System.out.println(nombreEquips[4] + " VS " + nombreEquips[7]);
        equipLocal = 4;
        equipVisitant = 7;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //FC Bayern-Inter
        System.out.println(nombreEquips[8] + " VS " + nombreEquips[9]);
        equipLocal = 8;
        equipVisitant = 9;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Liverpool-Napoli
        System.out.println(nombreEquips[2] + " VS " + nombreEquips[0]);
        equipLocal = 2;
        equipVisitant = 0;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Marseille-SPURS
        System.out.println(nombreEquips[15] + " VS " + nombreEquips[12]);
        equipLocal = 15;
        equipVisitant = 12;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Rangers-Ajax
        System.out.println(nombreEquips[3] + " VS " + nombreEquips[1]);
        equipLocal = 3;
        equipVisitant = 1;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //S.Portugal-Eintracht
        System.out.println(nombreEquips[14] + " VS " + nombreEquips[13]);
        equipLocal = 14;
        equipVisitant = 13;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Viktoria Plzen- FC Barcelona
        System.out.println(nombreEquips[11] + " VS " + nombreEquips[10]);
        equipLocal = 11;
        equipVisitant = 10;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //R.Madrid-Celtic
        System.out.println(nombreEquips[20] + " VS " + nombreEquips[23]);
        equipLocal = 20;
        equipVisitant = 23;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Shaktar D.-RB Leipzig
        System.out.println(nombreEquips[22] + " VS " + nombreEquips[21]);
        equipLocal = 22;
        equipVisitant = 21;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Chelsea-D.Zagreb
        System.out.println(nombreEquips[16] + " VS " + nombreEquips[19]);
        equipLocal = 16;
        equipVisitant = 19;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Copenhagen-B.Dortmund
        System.out.println(nombreEquips[27] + " VS " + nombreEquips[25]);
        equipLocal = 27;
        equipVisitant = 25;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Juventus-PSG
        System.out.println(nombreEquips[30] + " VS " + nombreEquips[29]);
        equipLocal = 30;
        equipVisitant = 29;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Maccabi Haifa-Benfica
        System.out.println(nombreEquips[31] + " VS " + nombreEquips[28]);
        equipLocal = 31;
        equipVisitant = 28;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //Man.City-Sevilla
        System.out.println(nombreEquips[24] + " VS " + nombreEquips[26]);
        equipLocal = 24;
        equipVisitant = 26;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);

        //AC Milan-Salzburg
        System.out.println(nombreEquips[17] + " VS " + nombreEquips[18]);
        equipLocal = 17;
        equipVisitant = 18;
        calcularResultat(equip, equipLocal, equipVisitant, nombreEquips);


    }

    /**
     * Métode que mostrara la classificacio separant cada grup
     *
     * @param equip
     * @param nombreEquips
     */
    private static void mostrarClassificacio(int[][] equip, String[] nombreEquips) {
        //TODO MSTRAR LA CLASSIFICACIÓ SEPARA PER CADA GRUP I ORDENADA PER PUNTS.

        int contadorLineas = 1;
        for (int i = 0; i < equip.length; i++) {
            System.out.println(nombreEquips[i] + " - Victories: " + equip[i][1] + " - Empats: " + equip[i][2] + " - Derrotes: " + equip[i][3] + " - PTS: " + equip[i][4]);

            if (contadorLineas % 4 == 0) {
                System.out.println(" ");
            }
            contadorLineas++;
        }
    }

    /**
     * Métode decidira quins equips passen de grups. Compararà els equips de cada de grups depenent de quants punts hagin aconseguit i els dos primers pasaran de ronda.
     *
     * @param equip
     * @param nombreEquips
     * @param bombo1Vuitens
     * @param bombo2Vuitens
     */
    private static void sorteigVuitens(int[][] equip, String[] nombreEquips, ArrayList<String> bombo1Vuitens, ArrayList<String> bombo2Vuitens) {
        //TODO FER METODE. MATRIU<> QUE GUARDI ELS EQUIPS CLASSIFICATS
        //FER QUE ELS PRIMERS VAGIN DE 0AL7 Y ELS SEGONS DEL 8 AL 15 PER FER RANDOM DEL 1 AL 7 Y RANDOM DEL 8AAL15
        //TODO SORTEIG DELS GRUPS
        int contador = 0;
        do {


            for (int i = 0; i <= 3; i++) {


                if ((equip[i][4] >= equip[0][4] && equip[i][4] >= equip[1][4] && equip[i][4] >= equip[2][4] && equip[i][4] >= equip[3][4]) && contador == 0) {
                    bombo1Vuitens.add(nombreEquips[i]);
                    equip[i][4] = 0;
                    contador++;

                } else if (((equip[i][4] >= equip[0][4] && equip[i][4] >= equip[1][4] && equip[i][4] >= equip[2][4] && equip[i][4] >= equip[3][4]) && contador == 1)) {
                    bombo2Vuitens.add(nombreEquips[i]);
                    contador++;
                }
            }
        } while (contador < 2);

        contador = 0;
        do {


            for (int i = 4; i < 8; i++) {


                if ((equip[i][4] >= equip[4][4] && equip[i][4] >= equip[5][4] && equip[i][4] >= equip[6][4] && equip[i][4] >= equip[7][4]) && contador == 0) {
                    bombo1Vuitens.add(nombreEquips[i]);
                    equip[i][4] = 0;
                    contador++;

                } else if ((equip[i][4] >= equip[4][4] && equip[i][4] >= equip[5][4] && equip[i][4] >= equip[6][4] && equip[i][4] >= equip[7][4]) && contador == 1) {
                    bombo2Vuitens.add(nombreEquips[i]);
                    contador++;
                }
            }
        } while (contador < 2);

        contador = 0;
        do {
            for (int i = 8; i < 12; i++) {


                if ((equip[i][4] >= equip[8][4] && equip[i][4] >= equip[9][4] && equip[i][4] >= equip[10][4] && equip[i][4] >= equip[11][4]) && contador == 0) {
                    bombo1Vuitens.add(nombreEquips[i]);
                    equip[i][4] = 0;
                    contador++;

                } else if (((equip[i][4] >= equip[8][4] && equip[i][4] >= equip[9][4] && equip[i][4] >= equip[10][4] && equip[i][4] >= equip[11][4]) && contador == 1)) {
                    bombo2Vuitens.add(nombreEquips[i]);
                    contador++;
                }

            }
        } while (contador < 2);

        contador = 0;
        do {
            for (int i = 12; i < 16; i++) {


                if ((equip[i][4] >= equip[12][4] && equip[i][4] >= equip[13][4] && equip[i][4] >= equip[14][4] && equip[i][4] >= equip[15][4]) && contador == 0) {
                    bombo1Vuitens.add(nombreEquips[i]);
                    equip[i][4] = 0;
                    contador++;

                } else if ((equip[i][4] >= equip[12][4] && equip[i][4] >= equip[13][4] && equip[i][4] >= equip[14][4] && equip[i][4] >= equip[15][4]) && contador == 1) {
                    bombo2Vuitens.add(nombreEquips[i]);
                    contador++;

                }
            }
        } while (contador < 2);

        contador = 0;

        do {
            for (int i = 16; i < 20; i++) {


                if ((equip[i][4] >= equip[16][4] && equip[i][4] >= equip[17][4] && equip[i][4] >= equip[18][4] && equip[i][4] >= equip[19][4]) && contador == 0) {
                    bombo1Vuitens.add(nombreEquips[i]);
                    equip[i][4] = 0;
                    contador++;

                } else if ((equip[i][4] >= equip[16][4] && equip[i][4] >= equip[17][4] && equip[i][4] >= equip[18][4] && equip[i][4] >= equip[19][4]) && contador == 1) {
                    bombo2Vuitens.add(nombreEquips[i]);
                    contador++;
                }
            }
        } while (contador < 2);

        contador = 0;
        do {
            for (int i = 20; i < 24; i++) {


                if ((equip[i][4] >= equip[20][4] && equip[i][4] >= equip[21][4] && equip[i][4] >= equip[22][4] && equip[i][4] >= equip[23][4]) && contador == 0) {
                    bombo1Vuitens.add(nombreEquips[i]);
                    equip[i][4] = 0;
                    contador++;

                } else if ((equip[i][4] >= equip[20][4] && equip[i][4] >= equip[21][4] && equip[i][4] >= equip[22][4] && equip[i][4] >= equip[23][4]) && contador == 1) {
                    bombo2Vuitens.add(nombreEquips[i]);
                    contador++;
                }
            }
        } while (contador < 2);

        contador = 0;
        do {
            for (int i = 24; i < 28; i++) {


                if ((equip[i][4] >= equip[24][4] && equip[i][4] >= equip[25][4] && equip[i][4] >= equip[26][4] && equip[i][4] >= equip[27][4]) && contador == 0) {
                    bombo1Vuitens.add(nombreEquips[i]);
                    equip[i][4] = 0;
                    contador++;

                } else if ((equip[i][4] >= equip[24][4] && equip[i][4] >= equip[25][4] && equip[i][4] >= equip[26][4] && equip[i][4] >= equip[27][4]) && contador == 1) {
                    bombo2Vuitens.add(nombreEquips[i]);
                    contador++;
                }
            }
        } while (contador < 2);

        contador = 0;
        do {
            for (int i = 28; i < equip.length; i++) {


                if ((equip[i][4] >= equip[28][4] && equip[i][4] >= equip[29][4] && equip[i][4] >= equip[30][4] && equip[i][4] >= equip[31][4]) && contador == 0) {
                    bombo1Vuitens.add(nombreEquips[i]);
                    equip[i][4] = 0;
                    contador++;

                } else if ((equip[i][4] >= equip[28][4] && equip[i][4] >= equip[29][4] && equip[i][4] >= equip[30][4] && equip[i][4] >= equip[31][4]) && contador == 1) {
                    bombo2Vuitens.add(nombreEquips[i]);
                    contador++;
                }
            }
        } while (contador < 2);


    }


    /**
     * Métode per generar numeros random dins d'un index de valors
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;
    }

    /**
     * Métode que calcula els resultats de la fase de grups. Genera un random del 0 al 5 que seran els gols de cada equip.
     *
     * @param equip
     * @param equipLocal
     * @param equipVisitant
     * @param nombresEquips
     */
    public static void calcularResultat(int[][] equip, int equipLocal, int equipVisitant, String[] nombresEquips) {
        int min = 0;
        int max = 5;
        int golsEquipLocal = getRandomNumberUsingNextInt(min, max);
        int golsEquipVisitant = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocal + " - " + golsEquipVisitant);
        if (golsEquipLocal > golsEquipVisitant) {
            equip[equipLocal][4] = equip[equipLocal][4] + 3;
            equip[equipLocal][1] = equip[equipLocal][1] + 1;
            equip[equipVisitant][3] = equip[equipVisitant][3] + 1;


        } else if (golsEquipLocal < golsEquipVisitant) {
            equip[equipVisitant][4] = equip[equipVisitant][4] + 3;
            equip[equipVisitant][1] = equip[equipVisitant][1] + 1;
            equip[equipLocal][3] = equip[equipLocal][3] + 1;

        } else {//Empate
            equip[equipLocal][2] = equip[equipLocal][2] + 1;
            equip[equipVisitant][2] = equip[equipVisitant][2] + 1;
            equip[equipLocal][4] = equip[equipLocal][4] + 1;
            equip[equipVisitant][4] = equip[equipVisitant][4] + 1;

        }
    }

    /**
     * Métode que decidira els enfrontaments dels vuitens de final. Mitjançant la classe shufle barrejarà l'ordre dels equips per despres emparellar-los
     *
     * @param bombo1Vuitens
     * @param bombo2Vuitens
     */
    public static void sorteigVuitens(ArrayList<String> bombo1Vuitens, ArrayList<String> bombo2Vuitens) {
        //TODO mostrar el grups ordenats per punts
        //TODO dividir els equips en 2 bombos, els primers i segons de cada grup
        //TODO fer un métode per fer el sorteigs de vuitens de final

        Collections.shuffle(bombo1Vuitens);
        Collections.shuffle(bombo2Vuitens);
        for (int i = 0; i < bombo1Vuitens.size(); i++) {
            System.out.println(bombo1Vuitens.get(i) + " VS " + bombo2Vuitens.get(i) + "\n");
        }


    }

    /**
     * Métode que calcularà el guanyador dels vuitens de final i guardarà aquells que passin de ronda
     *
     * @param bombo1Vuitens
     * @param bombo2Vuitens
     * @param bomboQuarts
     * @return
     */
    public static String[] calcularGuanyadorVuitens(ArrayList<String> bombo1Vuitens, ArrayList<String> bombo2Vuitens, String[] bomboQuarts) {

        int min = 0;
        int max = 5;
        int golsEquipLocalAnada;
        int golsEquipVisitantAnada;

        int golsEquipLocalTornada;
        int golsEquipVisitantlTornada;


        //Si no funciona usar un vector normal.
        for (int i = 0; i < bomboQuarts.length; i++) {


            //Anada

            System.out.println(bombo1Vuitens.get(i) + " VS " + bombo2Vuitens.get(i));
            golsEquipLocalAnada = getRandomNumberUsingNextInt(min, max);
            golsEquipVisitantAnada = getRandomNumberUsingNextInt(min, max);
            System.out.println(golsEquipLocalAnada + " - " + golsEquipVisitantAnada);

            //Tornada
            golsEquipLocalTornada = getRandomNumberUsingNextInt(min, max);
            golsEquipVisitantlTornada = getRandomNumberUsingNextInt(min, max);
            System.out.println(golsEquipLocalTornada + " - " + golsEquipVisitantlTornada);


            //Local Win
            if (golsEquipLocalAnada + golsEquipLocalTornada >= golsEquipVisitantAnada + golsEquipVisitantlTornada) {
                System.out.println("Ha guanyat " + bombo1Vuitens.get(i) + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
                bomboQuarts[i] = bombo1Vuitens.get(i);
                //Visitant Win
            } else if (golsEquipLocalAnada + golsEquipLocalTornada < golsEquipVisitantAnada + golsEquipVisitantlTornada) {
                System.out.println("Ha guanyat " + bombo2Vuitens.get(i) + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
                bomboQuarts[i] = bombo2Vuitens.get(i);
            }
        }
        System.out.println("Els equips classificats són: ");
        for (int i = 0; i < bomboQuarts.length; i++) {


            System.out.println(bomboQuarts[i]);
        }

        return bomboQuarts;
    }

    /**
     * Métode que fara el sorteig dels quarts de final
     *
     * @param bomboQuarts
     */
    public static void sorteigQuarts(String[] bomboQuarts) {
        System.out.println("Enfrentaments quarts de final: ");
        for (int i = 0; i < bomboQuarts.length; i += 2) {
            System.out.println(bomboQuarts[i] + " VS " + bomboQuarts[i + 1]);
        }


    }

    /**
     * Métode que decidira el guanyador dels quarts i guardarà aquells que es classifiquin.
     *
     * @param bomboQuarts
     * @param bomboSemis
     */
    public static void calcularGuanyadorQuarts(String[] bomboQuarts, String[] bomboSemis) {
        int min = 0;
        int max = 5;
        int golsEquipLocalAnada;
        int golsEquipVisitantAnada;

        int golsEquipLocalTornada;
        int golsEquipVisitantlTornada;

        //Partit1


        //Anada

        System.out.println(bomboQuarts[0] + " VS " + bomboQuarts[1]);
        golsEquipLocalAnada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantAnada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalAnada + " - " + golsEquipVisitantAnada);

        //Tornada
        golsEquipLocalTornada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantlTornada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalTornada + " - " + golsEquipVisitantlTornada);

        //Local Win
        if (golsEquipLocalAnada + golsEquipLocalTornada >= golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboQuarts[0] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboSemis[0] = bomboQuarts[0];
            //Visitant Win
        } else if (golsEquipLocalAnada + golsEquipLocalTornada < golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboQuarts[1] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboSemis[0] = bomboQuarts[1];
        }


        //Partit


        //Anada

        System.out.println(bomboQuarts[2] + " VS " + bomboQuarts[3]);
        golsEquipLocalAnada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantAnada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalAnada + " - " + golsEquipVisitantAnada);

        //Tornada
        golsEquipLocalTornada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantlTornada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalTornada + " - " + golsEquipVisitantlTornada);

        //Local Win
        if (golsEquipLocalAnada + golsEquipLocalTornada >= golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboQuarts[2] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboSemis[1] = bomboQuarts[2];
            //Visitant Win
        } else if (golsEquipLocalAnada + golsEquipLocalTornada < golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboQuarts[3] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboSemis[1] = bomboQuarts[3];
        }

        //Partit3


        //Anada

        System.out.println(bomboQuarts[4] + " VS " + bomboQuarts[5]);
        golsEquipLocalAnada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantAnada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalAnada + " - " + golsEquipVisitantAnada);

        //Tornada
        golsEquipLocalTornada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantlTornada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalTornada + " - " + golsEquipVisitantlTornada);

        //Local Win
        if (golsEquipLocalAnada + golsEquipLocalTornada >= golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboQuarts[4] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboSemis[2] = bomboQuarts[4];
            //Visitant Win
        } else if (golsEquipLocalAnada + golsEquipLocalTornada < golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboQuarts[5] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboSemis[2] = bomboQuarts[5];
        }


        //Anada

        System.out.println(bomboQuarts[6] + " VS " + bomboQuarts[7]);
        golsEquipLocalAnada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantAnada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalAnada + " - " + golsEquipVisitantAnada);

        //Tornada
        golsEquipLocalTornada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantlTornada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalTornada + " - " + golsEquipVisitantlTornada);

        //Local Win
        if (golsEquipLocalAnada + golsEquipLocalTornada >= golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboQuarts[6] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboSemis[3] = bomboQuarts[6];
            //Visitant Win
        } else if (golsEquipLocalAnada + golsEquipLocalTornada < golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboQuarts[7] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboSemis[3] = bomboQuarts[7];
        }


        System.out.println("Els equips calssificats són: ");

        for (int i = 0; i < bomboSemis.length; i++) {
            System.out.println(bomboSemis[i]);
        }
    }

    /**
     * Métode que imprimirà els enforntaments de semis.
     *
     * @param bomboSemis
     */
    private static void enfrontamentSemis(String[] bomboSemis) {
        System.out.println(bomboSemis[0] + " VS " + bomboSemis[3]);
        System.out.println(" ");
        System.out.println(bomboSemis[1] + " VS " + bomboSemis[2]);
    }

    /**
     * Aquest métode calcularà el guanyador de cada eliminatoria i els emparellarà a la final
     *
     * @param bomboSemis
     * @param bomboFinal
     * @return
     */
    private static String[] calcularSemis(String[] bomboSemis, String[] bomboFinal) {
        int min = 0;
        int max = 5;
        int golsEquipLocalAnada;
        int golsEquipVisitantAnada;

        int golsEquipLocalTornada;
        int golsEquipVisitantlTornada;

        //Partit1


        //Anada

        System.out.println(bomboSemis[0] + " VS " + bomboSemis[3]);
        golsEquipLocalAnada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantAnada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalAnada + " - " + golsEquipVisitantAnada);

        //Tornada
        golsEquipLocalTornada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantlTornada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalTornada + " - " + golsEquipVisitantlTornada);

        //Local Win
        if (golsEquipLocalAnada + golsEquipLocalTornada >= golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboSemis[0] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboFinal[0] = bomboSemis[0];
            //Visitant Win
        } else if (golsEquipLocalAnada + golsEquipLocalTornada < golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboSemis[3] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboFinal[0] = bomboSemis[3];
        }
        //Partit1


        //Anada

        System.out.println(bomboSemis[1] + " VS " + bomboSemis[2]);
        golsEquipLocalAnada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantAnada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalAnada + " - " + golsEquipVisitantAnada);

        //Tornada
        golsEquipLocalTornada = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitantlTornada = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocalTornada + " - " + golsEquipVisitantlTornada);

        //Local Win
        if (golsEquipLocalAnada + golsEquipLocalTornada >= golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboSemis[1] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboFinal[1] = bomboSemis[1];
            //Visitant Win
        } else if (golsEquipLocalAnada + golsEquipLocalTornada < golsEquipVisitantAnada + golsEquipVisitantlTornada) {
            System.out.println("Ha guanyat " + bomboSemis[2] + " " + (golsEquipLocalAnada + golsEquipLocalTornada) + "-" + (golsEquipVisitantAnada + golsEquipVisitantlTornada) + "\n");
            bomboFinal[1] = bomboSemis[2];
        }
        return bomboFinal;
    }

    /**
     * Métode que calculara quin equip guanya la final i surt campió del torneig
     *
     * @param bomboFinal
     * @return
     */
    private static String calcularFinal(String[] bomboFinal) {
        int min = 0;
        int max = 5;
        int golsEquipLocal;
        int golsEquipVisitant;
        String guanyadorChampions = " ";
        int penalsLocal;
        int penalsVisitant;


        //Anada

        System.out.println(bomboFinal[0] + " VS " + bomboFinal[1]);
        golsEquipLocal = getRandomNumberUsingNextInt(min, max);
        golsEquipVisitant = getRandomNumberUsingNextInt(min, max);
        System.out.println(golsEquipLocal + " - " + golsEquipVisitant);


        //Local Win
        if (golsEquipLocal > golsEquipVisitant) {
            System.out.println("Ha guanyat " + bomboFinal[0] + " " + (golsEquipLocal) + "-" + (golsEquipVisitant));
            guanyadorChampions = bomboFinal[0];
            //Visitant Win
        } else if (golsEquipLocal < golsEquipVisitant) {
            System.out.println("Ha guanyat " + bomboFinal[1] + " " + (golsEquipLocal) + "-" + (golsEquipVisitant));
            guanyadorChampions = bomboFinal[1];
        } else {
            do {

                min = 0;
                max = 1000;
                penalsLocal = getRandomNumberUsingNextInt(min, max);
                penalsVisitant = getRandomNumberUsingNextInt(min, max);
                if (penalsLocal > penalsVisitant) {
                    guanyadorChampions = bomboFinal[0];
                } else if (penalsLocal < penalsVisitant) {
                    guanyadorChampions = bomboFinal[1];

                }
            } while (penalsLocal != penalsVisitant);
        }
        System.out.println("L'equip " + guanyadorChampions + " és el campió de la UEFA Champions League 22-23!");
        return guanyadorChampions;
    }
}


