import java.util.Random;
import java.util.Scanner;

public class AlbertGarrido {
    public static void main(String[] args) {
        int equip[][] = new int[32][5];
        String[] nombreEquips = {"Napoli", "Ajax", "Liverpool", "Rangers", "Oporto", "Brujas", "Bayer04", "A.Madrid", "FC Bayern", "Inter", "FC Barcelona", "Viktoria plzen", "Spurs", "Eintracht", "S.Portugal", "Marseille", "Chelsea", "AC Milan", "Salzburgo", "D.Zagreb", "R.Madrid", "RB Leipzig", "Shaktar D.", "Celtic", "Man. City", "B.Dortmund", "Sevilla", "Copenhagen", "Benfica", "PSG", "Juventus", "Maccabi Haifa"};

        j1(equip,nombreEquips);

       /* int transferibles[][] = new int[3][5];
        transferibles[0][0]=1;
        transferibles[0][1]= Integer.parseInt("Bernardo Silva");
        transferibles[0][2]=50;
        transferibles[1][0]=2;
        transferibles[1][1]= Integer.parseInt("Earling Haland");
        transferibles[1][2]=200;
        transferibles[2][0]=3;
        transferibles[2][1]= Integer.parseInt("Ibrahimovic");
        transferibles[2][2]=5;
        transferibles[3][0]= 4;
        transferibles[3][1]= Integer.parseInt("Mohamed Salah");
        transferibles[3][2]= 50;



        Scanner llegir = new Scanner(System.in);
        int equipSeleccionat = 0;
        int presupost = 100;
        int preuJugador = 20;

*/
    }

    /**Métode per mostrar un missatge parametritzat per pantalla i mostrar un menú funcional.
     *
     */
    private static void menuTransferibles(){
        seleccionarEquip();
        final String MISSATGE = "(1)Comprar Jugadors\n(2)Vendre Jugadors \n(3)Iniciar temporada \n(4)Veure grups";
        int opcio = 0;
        int min = 0;
        int max = 3;

        do {
            opcio = llegirInt(MISSATGE, min,max);

            switch (opcio) {
                case 1://Transferibles
                   int opcioTransferibles = llegirInt(MISSATGE,min,max);
                    switch (opcioTransferibles){
                        case 1://Comprar
                            //comprarJugador();
                            break;
                        case 2://Vendre
                            //vendreJugador(int presupost)
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }while (opcio !=3);
    }

    private static void menuTemporada(){
        final String MISSATGE_TEMPORADA = "(1)Jugar partit \n (2)Canviar alineació \n (3)Mostrar resultats";
        int min = 1;
        int max = 3;
        boolean exit;
        int[][] grupA = new int[4][5];
        int opcioTemporada = llegirInt(MISSATGE_TEMPORADA,min,max);
        switch (opcioTemporada){
            case 1://métode jugar partit
                //j1(grupA);
                exit = true;
                break;
            case 2://canviar alineacio
                break;
            case 3://veure resultats
        }
    }



    /**
     * Aquest mètode llegeix un enter per teclat dins d'un domini determinat
     * @param missatge parametritzat per a mostrar a l'usuari@
     * @param min valor min acceptat
     * @param max valor max acceptat
     * @return retorna un int
     * @since 1.0
     */
    private static int llegirInt(String missatge, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.println(missatge);
            valorCorrecte = llegir.hasNextInt();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no enter.");
                llegir.nextLine();
            }else{ // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
                    valorCorrecte = false;
                }
            }
        }while(!valorCorrecte);

        return x;
    }



    private static int mercatTransferibles() {
        Scanner llegir = new Scanner(System.in);
        System.out.println("Quin jugador vols comprar?");
        //TODO SOUT DEL MERCAT
        //fer una matriu dels jugadors
        int jugadorEscollit = llegir.nextInt();


        return jugadorEscollit;
    }

    private static void menuPrincipal(){
        int min = 1;
        int max = 3;
        int opcio = 0;
        String missatge= "Selecciona una opció: \n (1)Seleccionar equip (2)Fer plantilla (3)Continuar";
        opcio = llegirInt(missatge,min,max);
        switch (opcio){
            case 1:
                seleccionarEquip();
                break;
            case 2:
                mercatTransferibles();
            case 3:
                break;
        }


        //TODO
    }
    /**Mètode que s'executarà a l'iniciar el progrgama
     * servirà per fer que l'usuari seleccioni l'equip que vol
     * @return equip
     */
    private static int seleccionarEquip(){
        final String MISSATGE_SELECCIO_EQUIP = "selecciona l'equip amb el que vols jugar :\n (1)F.C.Barcelona\n(2)Real Madrid\n(3)Real Sociedad\n(4)Atlético de Madrid";
        int min = 0;
        int max = 4;
        int equipUsuari = 0;
        int opcioEquip = llegirInt(MISSATGE_SELECCIO_EQUIP,min,max);
        switch (opcioEquip){

            case 1://Barça
                opcioEquip = 1;
                System.out.println("Has escollit 'F.C.Barcelona'");
                equipUsuari = 1;
            case 2://Madrid
                opcioEquip = 2;
            case 3://Real Societat
                opcioEquip = 3;
            case 4://Atletico madrid
                opcioEquip = 4;
            case 5://Real sociedad
                opcioEquip = 5;
            case 6:
                //Athletic de bilbao
                opcioEquip = 6;
            case 7:


        }
        return opcioEquip;

    }
    private static int comprarJugador(int presupost, int jugadorEscollit, int[][]transferibles){
        presupost=presupost-transferibles[jugadorEscollit][3];
        System.out.println("Et queden "+presupost+"M");


        return presupost;
    }
    private static int vendreJugador(int presupost, int jugadorVenta){
        presupost = presupost + presupost;
        jugadorVenta = Integer.parseInt(null);


return presupost;
    }
    private static int[][] mostrarGrups(){
        //TODO Desenvolupar metode per fer el sorteig dels grups.
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

    private static void j1(int[][] equip,String[]nombreEquips){



        int equipLocal = 0;
        int equipVisitant = 0;

        //Dortmund-Copenhagen
        System.out.println(nombreEquips[25]+" VS "+nombreEquips[27]);
        equipLocal = 25;
        equipVisitant = 27;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Dinamo Zagreb-Chelsea
        System.out.println(nombreEquips[19]+" VS "+nombreEquips[16]);
        equipLocal = 25;
        equipVisitant = 27;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Benfica-Maccabi Haifa
        System.out.println(nombreEquips[28]+" VS "+nombreEquips[31]);
        equipLocal = 28;
        equipVisitant = 31;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Celtic-Real Madrid
        System.out.println(nombreEquips[23]+" VS "+nombreEquips[20]);
        equipLocal = 23;
        equipVisitant = 20;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Salzburg-AC Milan
        System.out.println(nombreEquips[18]+" VS "+nombreEquips[17]);
        equipLocal = 19;
        equipVisitant = 17;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //PSG-Juventus
        System.out.println(nombreEquips[29]+" VS "+nombreEquips[30]);
        equipLocal = 29;
        equipVisitant = 30;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //RB Leipzig-Shaktar D.
        System.out.println(nombreEquips[21]+" VS "+nombreEquips[22]);
        equipLocal = 21;
        equipVisitant = 22;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Sevilla-Man City
        System.out.println(nombreEquips[26]+" VS "+nombreEquips[24]);
        equipLocal = 26;
        equipVisitant = 24;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //AJAX-Rangers
        System.out.println(nombreEquips[1]+" VS "+nombreEquips[3]);
        equipLocal = 1;
        equipVisitant = 3;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Eintracht-S.Portugal
        System.out.println(nombreEquips[13]+" VS "+nombreEquips[14]);
        equipLocal = 13;
        equipVisitant = 14;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //A.Madrid-Oporto
        System.out.println(nombreEquips[7]+" VS "+nombreEquips[4]);
        equipLocal = 7;
        equipVisitant = 4;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //FC Barceclona-Viktoria Plzen
        System.out.println(nombreEquips[10]+" VS "+nombreEquips[11]);
        equipLocal = 10;
        equipVisitant = 11;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Brujas-Bayer04
        System.out.println(nombreEquips[5]+" VS "+nombreEquips[6]);
        equipLocal = 5;
        equipVisitant = 6;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Inter-FC Bayern
        System.out.println(nombreEquips[9]+" VS "+nombreEquips[8]);
        equipLocal = 9;
        equipVisitant = 8;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //Napoli-Liverpool
        System.out.println(nombreEquips[0]+" VS "+nombreEquips[2]);
        equipLocal = 0;
        equipVisitant = 2;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        //SPURS-Marseille
        System.out.println(nombreEquips[12]+" VS "+nombreEquips[15]);
        equipLocal = 12;
        equipVisitant = 15;
        calcularResultat(equip,equipLocal,equipVisitant,nombreEquips);

        for (int i = 0; i < equip.length; i++) {
            System.out.println(nombreEquips[i] + " - Victorias: " + equip[i][1] + " - Empates: " + equip[i][2] + " - Derrotas: " + equip[i][3] + " - PTS: " + equip[i][4]);
        }
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;
    }
    public static void calcularResultat(int[][] equip, int equipLocal, int equipVisitant, String[]nombresEquips){
        int min = 0;
        int max = 5;
        int golsEquipLocal = getRandomNumberUsingNextInt(min,max);
        int golsEquipVisitant = getRandomNumberUsingNextInt(min,max);
        System.out.println(golsEquipLocal+" - "+ golsEquipVisitant);
        if (golsEquipLocal > golsEquipVisitant){
            equip[equipLocal][4] = equip[equipLocal][4] + 3;
            equip[equipLocal][1] = equip[equipLocal][1] +1;
            equip[equipVisitant][3] = equip[equipVisitant][3] +1;


        } else if (golsEquipLocal < golsEquipVisitant) {
            equip[equipVisitant][4] = equip[equipVisitant][4] +3;
            equip[equipVisitant][1] = equip[equipVisitant][1] +1;
            equip[equipLocal][3] = equip[equipLocal][3]+1;

        }else {//Empate
            equip[equipLocal][2] = equip[equipLocal][2] +1;
            equip[equipVisitant][2] = equip[equipVisitant][2] +1;
            equip[equipLocal][4] = equip[equipLocal][4] +1;
            equip[equipVisitant][4] = equip[equipVisitant][4] +1;

        }
    }


}


