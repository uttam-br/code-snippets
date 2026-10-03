
public class GoogleMaze {

    public static void main(String[] args) {

        char[][] mat = new char[5][5];

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                mat[i][j] = '.';
            }
        }

        // starting position
        mat[1][2] = 'X';

        // obstacles
        mat[0][0] = '#';
        mat[1][3] = '#';
        mat[2][1] = '#';
        mat[2][2] = '#';
        mat[4][4] = '#';

        int k = 5;

        System.out.println("Path: " + solve(mat, k));

    }

    private static final char[] DIRECTIONS = new char[]{'D', 'L', 'R', 'U'};

    private static String solve(char[][] mat, int k) {

        // find starting position and start search
        int startI = -1;
        int startJ = -1;

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (mat[i][j] == 'X') {
                    startI = i;
                    startJ = j;
                    break;
                }
            }
            if (startI != -1) {
                break;
            }
        }


        for (char direction : DIRECTIONS) {

        }


        String path = "";


        return path;
    }

}
