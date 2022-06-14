package ludoogame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LudoBoard {
    String[][] kare = new String[15][15];
    String[][] sinir = new String[16][15];
    Piece[][][] parcaKayit = new Piece[15][15][4];

    int[][] gEv = {{2, 2}, {2, 3}, {3, 2}, {3, 3}};
    int[][] yEv = {{2, 11}, {2, 12}, {3, 11}, {3, 12}};
    int[][] rEv = {{11, 2}, {11, 3}, {12, 2}, {12, 3}};
    int[][] bEv = {{11, 11}, {11, 12}, {12, 11}, {12, 12}};
    Map<String, int[][]> positionMap;
    int[][] yesilYol = {{6, 1}, {6, 2}, {6, 3}, {6, 4}, {6, 5},
    {5, 6}, {4, 6}, {3, 6}, {2, 6}, {1, 6}, {0, 6},
    {0, 7}, {0, 8}, {2, 8}, {3, 8}, {4, 8}, {5, 8},
    {6, 9}, {6, 10}, {6, 11}, {6, 12}, {6, 13}, {6, 14},
    {7, 14}, {8, 14}, {8, 12}, {8, 11}, {8, 10}, {8, 9},
    {9, 8}, {10, 8}, {11, 8}, {12, 8}, {13, 8}, {14, 8},
    {14, 7}, {14, 6}, {12, 6}, {11, 6}, {10, 6}, {9, 6},
    {8, 5}, {8, 4}, {8, 3}, {8, 2}, {8, 1}, {8, 0},
    {7, 0}, {7, 1}, {7, 2}, {7, 3}, {7, 4}, {7, 5}, {7, 6}};
    int[][] sariYol = {{1, 8}, {2, 8}, {3, 8}, {4, 8}, {5, 8},
    {6, 9}, {6, 10}, {6, 11}, {6, 12}, {6, 13}, {6, 14},
    {7, 14}, {8, 14}, {8, 12}, {8, 11}, {8, 10}, {8, 9},
    {9, 8}, {10, 8}, {11, 8}, {12, 8}, {13, 8}, {14, 8},
    {14, 7}, {14, 6}, {12, 6}, {11, 6}, {10, 6}, {9, 6},
    {8, 5}, {8, 4}, {8, 3}, {8, 2}, {8, 1}, {8, 0},
    {7, 0}, {6, 0}, {6, 2}, {6, 3}, {6, 4}, {6, 5},
    {5, 6}, {4, 6}, {3, 6}, {2, 6}, {1, 6}, {0, 6},
    {0, 7}, {1, 7}, {2, 7}, {3, 7}, {4, 7}, {5, 7}, {6, 7}};

    int[][] kirmiziYol = {{13, 6}, {12, 6}, {11, 6}, {10, 6}, {9, 6},
    {8, 5}, {8, 4}, {8, 3}, {8, 2}, {8, 1}, {8, 0},
    {7, 0}, {6, 0}, {6, 2}, {6, 3}, {6, 4}, {6, 5},
    {5, 6}, {4, 6}, {3, 6}, {2, 6}, {1, 6}, {0, 6},
    {0, 7}, {0, 8}, {2, 8}, {3, 8}, {4, 8}, {5, 8},
    {6, 9}, {6, 10}, {6, 11}, {6, 12}, {6, 13}, {6, 14},
    {7, 14}, {8, 14}, {8, 12}, {8, 11}, {8, 10}, {8, 9},
    {9, 8}, {10, 8}, {11, 8}, {12, 8}, {13, 8}, {14, 8},
    {14, 7}, {13, 7}, {12, 7}, {11, 7}, {10, 7}, {9, 7}, {8, 7}};
    int[][] maviYol = {{8, 13}, {8, 12}, {8, 11}, {8, 10}, {8, 9},
    {9, 8}, {10, 8}, {11, 8}, {12, 8}, {13, 8}, {14, 8},
    {14, 7}, {14, 6}, {12, 6}, {11, 6}, {10, 6}, {9, 6},
    {8, 5}, {8, 4}, {8, 3}, {8, 2}, {8, 1}, {8, 0},
    {7, 0}, {6, 0}, {6, 2}, {6, 3}, {6, 4}, {6, 5},
    {5, 6}, {4, 6}, {3, 6}, {2, 6}, {1, 6}, {0, 6},
    {0, 7}, {0, 8}, {2, 8}, {3, 8}, {4, 8}, {5, 8},
    {6, 9}, {6, 10}, {6, 11}, {6, 12}, {6, 13}, {6, 14},
    {7, 14}, {7, 13}, {7, 12}, {7, 11}, {7, 10}, {7, 9}, {7, 8}};
    Map<String, int[][]> pathMap;
    LudoBoard() {
        positionMap = new HashMap<String, int[][]>();
        positionMap.put("Green", gEv);
        positionMap.put("Yellow", yEv);
        positionMap.put("Red", rEv);
        positionMap.put("Blue", bEv);

        
        pathMap = new HashMap<String, int[][]>();
        pathMap.put("Green", yesilYol);
        pathMap.put("Yellow", sariYol);
        pathMap.put("Red", kirmiziYol);
        pathMap.put("Blue", maviYol);
        for (int i = 0; i < parcaKayit.length; i++) {
            parcaKayit[i] = new Piece[15][4];
            for (int j = 0; j < parcaKayit[i].length; j++) {
                parcaKayit[i][j] = new Piece[4];
                for (int k = 0; k < parcaKayit[i][j].length; k++) {
                    parcaKayit[i][j][k] = null;
                }
            }
        }

        kare[0][0] = "|Green";
        kare[0][1] = "      ";
        kare[0][2] = "      ";
        kare[0][3] = "      ";
        kare[0][4] = "      ";
        kare[0][5] = "     |";
        kare[0][6] = "|    |";
        kare[0][7] = "|    |";
        kare[0][8] = "|    |";
        kare[0][9] = "|     ";
        kare[0][10] = "      ";
        kare[0][11] = "      ";
        kare[0][12] = "      ";
        kare[0][13] = "     Y";
        kare[0][14] = "ellow|";
        kare[1][0] = "|    |";
        kare[1][1] = "|     ";
        kare[1][2] = "      ";
        kare[1][3] = "      ";
        kare[1][4] = "     |";
        kare[1][5] = "|    |";
        kare[1][6] = "|    |";
        kare[1][7] = "|    |";
        kare[1][8] = "|    |";
        kare[1][9] = "|    |";
        kare[1][10] = "|     ";
        kare[1][11] = "      ";
        kare[1][12] = "      ";
        kare[1][13] = "     |";
        kare[1][14] = "|    |";
        kare[2][0] = "|    |";
        kare[2][1] = "|    |";
        kare[2][2] = "|    |";
        kare[2][3] = "|    |";
        kare[2][4] = "|    |";
        kare[2][5] = "|    |";
        kare[2][6] = "|    |";
        kare[2][7] = "|    |";
        kare[2][8] = "|    |";
        kare[2][9] = "|    |";
        kare[2][10] = "|    |";
        kare[2][11] = "|    |";
        kare[2][12] = "|    |";
        kare[2][13] = "|    |";
        kare[2][14] = "|    |";
        kare[3][0] = "|    |";
        kare[3][1] = "|    |";
        kare[3][2] = "|    |";
        kare[3][3] = "|    |";
        kare[3][4] = "|    |";
        kare[3][5] = "|    |";
        kare[3][6] = "|    |";
        kare[3][7] = "|    |";
        kare[3][8] = "|    |";
        kare[3][9] = "|    |";
        kare[3][10] = "|    |";
        kare[3][11] = "|    |";
        kare[3][12] = "|    |";
        kare[3][13] = "|    |";
        kare[3][14] = "|    |";
        kare[4][0] = "|    |";
        kare[4][1] = "|     ";
        kare[4][2] = "      ";
        kare[4][3] = "      ";
        kare[4][4] = "     |";
        kare[4][5] = "|    |";
        kare[4][6] = "|    |";
        kare[4][7] = "|    |";
        kare[4][8] = "|    |";
        kare[4][9] = "|    |";
        kare[4][10] = "|     ";
        kare[4][11] = "      ";
        kare[4][12] = "      ";
        kare[4][13] = "     |";
        kare[4][14] = "|    |";
        kare[5][0] = "|     ";
        kare[5][1] = "      ";
        kare[5][2] = "      ";
        kare[5][3] = "      ";
        kare[5][4] = "      ";
        kare[5][5] = "     |";
        kare[5][6] = "|    |";
        kare[5][7] = "|    |";
        kare[5][8] = "|    |";
        kare[5][9] = "|     ";
        kare[5][10] = "      ";
        kare[5][11] = "      ";
        kare[5][12] = "      ";
        kare[5][13] = "      ";
        kare[5][14] = "     |";
        kare[6][0] = "|    |";
        kare[6][1] = "|    |";
        kare[6][2] = "|    |";
        kare[6][3] = "|    |";
        kare[6][4] = "|    |";
        kare[6][5] = "|    |";
        kare[6][6] = "|     ";
        kare[6][7] = "      ";
        kare[6][8] = "     |";
        kare[6][9] = "|    |";
        kare[6][10] = "|    |";
        kare[6][11] = "|    |";
        kare[6][12] = "|    |";
        kare[6][13] = "|    |";
        kare[6][14] = "|    |";
        kare[7][0] = "|    |";
        kare[7][1] = "|    |";
        kare[7][2] = "|    |";
        kare[7][3] = "|    |";
        kare[7][4] = "|    |";
        kare[7][5] = "|    |";
        kare[7][6] = "|     ";
        kare[7][7] = "      ";
        kare[7][8] = "     |";
        kare[7][9] = "|    |";
        kare[7][10] = "|    |";
        kare[7][11] = "|    |";
        kare[7][12] = "|    |";
        kare[7][13] = "|    |";
        kare[7][14] = "|    |";
        kare[8][0] = "|    |";
        kare[8][1] = "|    |";
        kare[8][2] = "|    |";
        kare[8][3] = "|    |";
        kare[8][4] = "|    |";
        kare[8][5] = "|    |";
        kare[8][6] = "|     ";
        kare[8][7] = "      ";
        kare[8][8] = "     |";
        kare[8][9] = "|    |";
        kare[8][10] = "|    |";
        kare[8][11] = "|    |";
        kare[8][12] = "|    |";
        kare[8][13] = "|    |";
        kare[8][14] = "|    |";
        kare[9][0] = "|     ";
        kare[9][1] = "      ";
        kare[9][2] = "      ";
        kare[9][3] = "      ";
        kare[9][4] = "      ";
        kare[9][5] = "     |";
        kare[9][6] = "|    |";
        kare[9][7] = "|    |";
        kare[9][8] = "|    |";
        kare[9][9] = "|     ";
        kare[9][10] = "      ";
        kare[9][11] = "      ";
        kare[9][12] = "      ";
        kare[9][13] = "      ";
        kare[9][14] = "     |";
        kare[10][0] = "|    |";
        kare[10][1] = "|     ";
        kare[10][2] = "      ";
        kare[10][3] = "      ";
        kare[10][4] = "     |";
        kare[10][5] = "|    |";
        kare[10][6] = "|    |";
        kare[10][7] = "|    |";
        kare[10][8] = "|    |";
        kare[10][9] = "|    |";
        kare[10][10] = "|     ";
        kare[10][11] = "      ";
        kare[10][12] = "      ";
        kare[10][13] = "     |";
        kare[10][14] = "|    |";
        kare[11][0] = "|    |";
        kare[11][1] = "|    |";
        kare[11][2] = "|    |";
        kare[11][3] = "|    |";
        kare[11][4] = "|    |";
        kare[11][5] = "|    |";
        kare[11][6] = "|    |";
        kare[11][7] = "|    |";
        kare[11][8] = "|    |";
        kare[11][9] = "|    |";
        kare[11][10] = "|    |";
        kare[11][11] = "|    |";
        kare[11][12] = "|    |";
        kare[11][13] = "|    |";
        kare[11][14] = "|    |";
        kare[12][0] = "|    |";
        kare[12][1] = "|    |";
        kare[12][2] = "|    |";
        kare[12][3] = "|    |";
        kare[12][4] = "|    |";
        kare[12][5] = "|    |";
        kare[12][6] = "|    |";
        kare[12][7] = "|    |";
        kare[12][8] = "|    |";
        kare[12][9] = "|    |";
        kare[12][10] = "|    |";
        kare[12][11] = "|    |";
        kare[12][12] = "|    |";
        kare[12][13] = "|    |";
        kare[12][14] = "|    |";
        kare[13][0] = "|    |";
        kare[13][1] = "|     ";
        kare[13][2] = "      ";
        kare[13][3] = "      ";
        kare[13][4] = "     |";
        kare[13][5] = "|    |";
        kare[13][6] = "|    |";
        kare[13][7] = "|    |";
        kare[13][8] = "|    |";
        kare[13][9] = "|    |";
        kare[13][10] = "|     ";
        kare[13][11] = "      ";
        kare[13][12] = "      ";
        kare[13][13] = "     |";
        kare[13][14] = "|    |";
        kare[14][0] = "|Red  ";
        kare[14][1] = "      ";
        kare[14][2] = "      ";
        kare[14][3] = "      ";
        kare[14][4] = "      ";
        kare[14][5] = "     |";
        kare[14][6] = "|    |";
        kare[14][7] = "|    |";
        kare[14][8] = "|    |";
        kare[14][9] = "|     ";
        kare[14][10] = "      ";
        kare[14][11] = "      ";
        kare[14][12] = "      ";
        kare[14][13] = "      ";
        kare[14][14] = " Blue|";

        sinir[0][0] = "------";
        sinir[0][1] = "------";
        sinir[0][2] = "------";
        sinir[0][3] = "------";
        sinir[0][4] = "------";
        sinir[0][5] = "------";
        sinir[0][6] = "------";
        sinir[0][7] = "------";
        sinir[0][8] = "------";
        sinir[0][9] = "------";
        sinir[0][10] = "------";
        sinir[0][11] = "------";
        sinir[0][12] = "------";
        sinir[0][13] = "------";
        sinir[0][14] = "------";
        sinir[1][0] = "      ";
        sinir[1][1] = "------";
        sinir[1][2] = "------";
        sinir[1][3] = "------";
        sinir[1][4] = "------";
        sinir[1][5] = "      ";
        sinir[1][6] = "------";
        sinir[1][7] = "------";
        sinir[1][8] = "------";
        sinir[1][9] = "      ";
        sinir[1][10] = "------";
        sinir[1][11] = "------";
        sinir[1][12] = "------";
        sinir[1][13] = "------";
        sinir[1][14] = "      ";
        sinir[2][0] = "      ";
        sinir[2][1] = "      ";
        sinir[2][2] = "------";
        sinir[2][3] = "------";
        sinir[2][4] = "      ";
        sinir[2][5] = "      ";
        sinir[2][6] = "------";
        sinir[2][7] = "------";
        sinir[2][8] = "------";
        sinir[2][9] = "      ";
        sinir[2][10] = "      ";
        sinir[2][11] = "------";
        sinir[2][12] = "------";
        sinir[2][13] = "      ";
        sinir[2][14] = "      ";
        sinir[3][0] = "      ";
        sinir[3][1] = "      ";
        sinir[3][2] = "------";
        sinir[3][3] = "------";
        sinir[3][4] = "      ";
        sinir[3][5] = "      ";
        sinir[3][6] = "------";
        sinir[3][7] = "------";
        sinir[3][8] = "------";
        sinir[3][9] = "      ";
        sinir[3][10] = "      ";
        sinir[3][11] = "------";
        sinir[3][12] = "------";
        sinir[3][13] = "      ";
        sinir[3][14] = "      ";
        sinir[4][0] = "      ";
        sinir[4][1] = "      ";
        sinir[4][2] = "------";
        sinir[4][3] = "------";
        sinir[4][4] = "      ";
        sinir[4][5] = "      ";
        sinir[4][6] = "------";
        sinir[4][7] = "------";
        sinir[4][8] = "------";
        sinir[4][9] = "      ";
        sinir[4][10] = "      ";
        sinir[4][11] = "------";
        sinir[4][12] = "------";
        sinir[4][13] = "      ";
        sinir[4][14] = "      ";
        sinir[5][0] = "      ";
        sinir[5][1] = "------";
        sinir[5][2] = "------";
        sinir[5][3] = "------";
        sinir[5][4] = "------";
        sinir[5][5] = "      ";
        sinir[5][6] = "------";
        sinir[5][7] = "------";
        sinir[5][8] = "------";
        sinir[5][9] = "      ";
        sinir[5][10] = "------";
        sinir[5][11] = "------";
        sinir[5][12] = "------";
        sinir[5][13] = "------";
        sinir[5][14] = "      ";
        sinir[6][0] = "------";
        sinir[6][1] = "------";
        sinir[6][2] = "------";
        sinir[6][3] = "------";
        sinir[6][4] = "------";
        sinir[6][5] = "------";
        sinir[6][6] = "------";
        sinir[6][7] = "------";
        sinir[6][8] = "------";
        sinir[6][9] = "------";
        sinir[6][10] = "------";
        sinir[6][11] = "------";
        sinir[6][12] = "------";
        sinir[6][13] = "------";
        sinir[6][14] = "------";
        sinir[7][0] = "------";
        sinir[7][1] = "------";
        sinir[7][2] = "------";
        sinir[7][3] = "------";
        sinir[7][4] = "------";
        sinir[7][5] = "------";
        sinir[7][6] = "      ";
        sinir[7][7] = "      ";
        sinir[7][8] = "      ";
        sinir[7][9] = "------";
        sinir[7][10] = "------";
        sinir[7][11] = "------";
        sinir[7][12] = "------";
        sinir[7][13] = "------";
        sinir[7][14] = "------";
        sinir[8][0] = "------";
        sinir[8][1] = "------";
        sinir[8][2] = "------";
        sinir[8][3] = "------";
        sinir[8][4] = "------";
        sinir[8][5] = "------";
        sinir[8][6] = "      ";
        sinir[8][7] = "      ";
        sinir[8][8] = "      ";
        sinir[8][9] = "------";
        sinir[8][10] = "------";
        sinir[8][11] = "------";
        sinir[8][12] = "------";
        sinir[8][13] = "------";
        sinir[8][14] = "------";
        sinir[9][0] = "------";
        sinir[9][1] = "------";
        sinir[9][2] = "------";
        sinir[9][3] = "------";
        sinir[9][4] = "------";
        sinir[9][5] = "------";
        sinir[9][6] = "------";
        sinir[9][7] = "------";
        sinir[9][8] = "------";
        sinir[9][9] = "------";
        sinir[9][10] = "------";
        sinir[9][11] = "------";
        sinir[9][12] = "------";
        sinir[9][13] = "------";
        sinir[9][14] = "------";
        sinir[10][0] = "      ";
        sinir[10][1] = "------";
        sinir[10][2] = "------";
        sinir[10][3] = "------";
        sinir[10][4] = "------";
        sinir[10][5] = "      ";
        sinir[10][6] = "------";
        sinir[10][7] = "------";
        sinir[10][8] = "------";
        sinir[10][9] = "      ";
        sinir[10][10] = "------";
        sinir[10][11] = "------";
        sinir[10][12] = "------";
        sinir[10][13] = "------";
        sinir[10][14] = "      ";
        sinir[11][0] = "      ";
        sinir[11][1] = "      ";
        sinir[11][2] = "------";
        sinir[11][3] = "------";
        sinir[11][4] = "      ";
        sinir[11][5] = "      ";
        sinir[11][6] = "------";
        sinir[11][7] = "------";
        sinir[11][8] = "------";
        sinir[11][9] = "      ";
        sinir[11][10] = "      ";
        sinir[11][11] = "------";
        sinir[11][12] = "------";
        sinir[11][13] = "      ";
        sinir[11][14] = "      ";
        sinir[12][0] = "      ";
        sinir[12][1] = "      ";
        sinir[12][2] = "------";
        sinir[12][3] = "------";
        sinir[12][4] = "      ";
        sinir[12][5] = "      ";
        sinir[12][6] = "------";
        sinir[12][7] = "------";
        sinir[12][8] = "------";
        sinir[12][9] = "      ";
        sinir[12][10] = "      ";
        sinir[12][11] = "------";
        sinir[12][12] = "------";
        sinir[12][13] = "      ";
        sinir[12][14] = "      ";
        sinir[13][0] = "      ";
        sinir[13][1] = "      ";
        sinir[13][2] = "------";
        sinir[13][3] = "------";
        sinir[13][4] = "      ";
        sinir[13][5] = "      ";
        sinir[13][6] = "------";
        sinir[13][7] = "------";
        sinir[13][8] = "------";
        sinir[13][9] = "      ";
        sinir[13][10] = "      ";
        sinir[13][11] = "------";
        sinir[13][12] = "------";
        sinir[13][13] = "      ";
        sinir[13][14] = "      ";
        sinir[14][0] = "      ";
        sinir[14][1] = "------";
        sinir[14][2] = "------";
        sinir[14][3] = "------";
        sinir[14][4] = "------";
        sinir[14][5] = "      ";
        sinir[14][6] = "------";
        sinir[14][7] = "------";
        sinir[14][8] = "------";
        sinir[14][9] = "      ";
        sinir[14][10] = "------";
        sinir[14][11] = "------";
        sinir[14][12] = "------";
        sinir[14][13] = "------";
        sinir[14][14] = "      ";
        sinir[15][0] = "------";
        sinir[15][1] = "------";
        sinir[15][2] = "------";
        sinir[15][3] = "------";
        sinir[15][4] = "------";
        sinir[15][5] = "------";
        sinir[15][6] = "------";
        sinir[15][7] = "------";
        sinir[15][8] = "------";
        sinir[15][9] = "------";
        sinir[15][10] = "------";
        sinir[15][11] = "------";
        sinir[15][12] = "------";
        sinir[15][13] = "------";
        sinir[15][14] = "------";
    }
    void ekranaBas() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(sinir[i][j]);
            }
            System.out.println();
            if (i == 15) {
                break;
            }
            for (int j = 0; j < 15; j++) {
                System.out.print(blokİsle(i, j));
            }
            System.out.println();
        }
    }
    //blokları oluşturma yöntemi
    private String blokİsle(int yCoord, int xCoord) {
        String defaultBlock = kare[yCoord][xCoord];
        Piece[] pieceArray = parcaKayit[yCoord][xCoord];
        String contents = "";
        for (int i = 0; i < pieceArray.length; i++) {
            Piece piece = pieceArray[i];
            if (piece == null) {
                break;
            }
            if (contents.length() == 0) {
                String color = piece.getColor();
                contents += color.substring(0, 1) + piece.getPieceNumber();
            } 
            else {
                contents += piece.getPieceNumber();
            }
        }
        String renderedBlock = defaultBlock.substring(0, 1) + contents + defaultBlock.substring(contents.length() + 1);
        return renderedBlock;
    }
    //oyun başlarken koordinatlar yükleniyor
    void yükle(Player player) {
        String color = player.getColor();
        int[][] coords = positionMap.get(color);
        for (int i = 0; i < 4; i++) {
            int yCoord = coords[i][0];
            int xCoord = coords[i][1];
            setKoordinat(player.getPiece(i), yCoord, xCoord);
        }
    }
    //oyunu tamamladığında çalıştır
    boolean disarıCikar(Piece piece) {
        if (piece.isTakenOut()) {
            return false;
        }
        boolean successfullyMoved = hareketEttir(piece, 6);
        if (successfullyMoved) {
            piece.setTakenOut(true);
            return true;
        }
        return false;
    }
    //hareket edicek yer var mı kontrolü
    boolean hareketEttir(Piece piece, int howManySquares) {
        if (!piece.isTakenOut() && howManySquares != 6) {
            return false;
        }
        String color = piece.getColor();
        int[][] path = pathMap.get(color);
        int currentY = piece.getY();
        int currentX = piece.getX();
        int currentBlock = 0;
        for (int i = 0; i < path.length; i++) {
            if (path[i][0] == currentY && path[i][1] == currentX) {
                currentBlock = i;
                break;
            }
        }
        int endPosition = currentBlock + howManySquares;
        if (endPosition >= path.length) {
            return false; 
        }
        for (int i = currentBlock + 1; i <= endPosition; i++) {
            if (isBlock(piece, path[i][0], path[i][1])) {
                return false; 
            }
        }
        if (yemeyiceriyormu(piece, path[endPosition][0], path[endPosition][1])) {
            yemeVakti(path[endPosition][0], path[endPosition][1]);
        }
        if (!piece.isTakenOut()) {
            setKoordinat(piece, path[endPosition - 1][0], path[endPosition - 1][1]);
            piece.setTakenOut(true);

        } else {
            setKoordinat(piece, path[endPosition][0], path[endPosition][1]);
        }
        if (endPosition + 1 == path.length) {
            piece.setCompleted(true);
        }
        return true;
    }
    boolean gidisVarmi(Player player, int numberRolled) {
        if (numberRolled == 6) {
            for (int i = 0; i < 4; i++) {
                Piece piece = player.getPiece(i);
                if (cikisVarmi(piece)) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            Piece piece = player.getPiece(i);
            if (hareketEdiyor(piece, numberRolled)) {
                return true;
            }
        }
        return false;
    }
    //parça çıkabilir
    private boolean cikisVarmi(Piece piece) {
       if (piece.isTakenOut()) {
            return false;
        }
        boolean canMove = hareketEdiyor(piece, 6);
        if (canMove) {
            return true;
        }
        return false;
    }
    //hareket edebiliyor mu diye bakıyoru<
    private boolean hareketEdiyor(Piece piece, int howManySquares) {
        if (!piece.isTakenOut() && howManySquares != 6) {
            return false;
        }
        String color = piece.getColor();
        int[][] path = pathMap.get(color);
        int currentY = piece.getY();
        int currentX = piece.getX();
        int currentBlock = 0;
        for (int i = 0; i < path.length; i++) {
            //evdeyse 0 
            if (path[i][0] == currentY && path[i][1] == currentX) {
                currentBlock = i;
                break;
            }
        }
        int endPosition = currentBlock + howManySquares;
        if (endPosition >= path.length) {
            return false;
        }
        for (int i = currentBlock + 1; i <= endPosition; i++) {
            if (isBlock(piece, path[i][0], path[i][1])) {
                return false;
            }
        }
        return true;
    }
    //düşmana ait bir parça olduğu tespit edildi
    private void yemeVakti(int yCoord, int xCoord) {
        Piece piece = parcaKayit[yCoord][xCoord][0];
        String color = piece.getColor();
        int[][] homeCoords = positionMap.get(color);
        for (int i = 0; i < 4; i++) {
            int homeY = homeCoords[i][0];
            int homeX = homeCoords[i][1];
            if (parcaKayit[homeY][homeX][0] == null) {
                piece.setTakenOut(false);
                setKoordinat(piece, homeY, homeX);
                break;

            }
        }
    }
    //düşman parca var mı hareket ettiği yerde bunu kontrol ediyoruz
    boolean yemeyiceriyormu(Piece piece, int yCoord, int xCoord) {
        List<Piece> pieceList = new ArrayList<Piece>();
        for (int i = 0; i < 4; i++) {
            Piece currentPiece = parcaKayit[yCoord][xCoord][i];
            if (currentPiece != null && currentPiece.getColor().equals(piece.getColor())) {
                return false;
            } else if (currentPiece != null) {
                pieceList.add(currentPiece);
            } else {
                break;
            }
        }
        if (pieceList.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
    //hareket ettiği noktada bir sorun var mı kontrolü
    boolean isBlock(Piece piece, int yCoord, int xCoord) {
        List<Piece> pieceList = new ArrayList<Piece>();
        for (int i = 0; i < 4; i++) {
            Piece currentPiece = parcaKayit[yCoord][xCoord][i];
            if (currentPiece != null && currentPiece.getColor().equals(piece.getColor())) {
                return false;
            } else if (currentPiece != null) {
                pieceList.add(currentPiece);
            } else {
                break;
            }
        }
        if (pieceList.size() > 1) {
            return true;
        } else {
            return false;
        }
    }
    //parça kayıta göre bir parçanın koordinatlarını belirliyoruz
    void setKoordinat(Piece piece, int yCoord, int xCoord) {
        boolean notInitialized = piece.getX() == 0 && piece.getY() == 0;
        if (notInitialized) {
            parcaKayit[yCoord][xCoord][0] = piece;
            piece.setY(yCoord);
            piece.setX(xCoord);
        } else {
            int currentY = piece.getY();
            int currentX = piece.getX();
            for (int i = 0; i < parcaKayit[currentY][currentX].length; i++) {
                if (parcaKayit[currentY][currentX][i] == piece) {
                    parcaKayit[currentY][currentX][i] = null;
                    düzenleme(currentY, currentX);
                    break;
                }

            }
            parcaKayit[yCoord][xCoord][3] = piece;
            piece.setY(yCoord);
            piece.setX(xCoord);
            düzenleme(yCoord, xCoord);

        }

    }
    //parçaları düzende tutuyor 4213 değilde 1234 gibi
    private void düzenleme(int yCoord, int xCoord) {
        List<Piece> pieceList = new ArrayList<Piece>();
        for (int i = 0; i < 4; i++) {
            Piece piece = parcaKayit[yCoord][xCoord][i];
            if (piece != null) {
                pieceList.add(piece);
                parcaKayit[yCoord][xCoord][i] = null;
            }
        }
        if (pieceList.size() != 0) {
            int numberOfPieces = pieceList.size();
           for (int i = 0; i < numberOfPieces; i++) {
                int lowestPieceNumber = 5;
                int lowestPieceIndex = 5;
               for (int j = i; j < numberOfPieces; j++) {
                    int nextPieceNumber = pieceList.get(j).getPieceNumber();
                    boolean isLower = nextPieceNumber < lowestPieceNumber;
                    if (isLower) {
                        lowestPieceNumber = nextPieceNumber;
                        lowestPieceIndex = j;
                    }
                    lowestPieceNumber = isLower ? nextPieceNumber : lowestPieceNumber;
                }
                parcaKayit[yCoord][xCoord][i] = pieceList.get(lowestPieceIndex);
            }
        }
    }
}
