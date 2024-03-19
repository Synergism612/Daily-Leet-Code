package question36;


public class Solution {
    public static boolean check(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] != '.' && chars[i] == chars[j])
                    return true;
            }
        }
        return false;
    }

    public static boolean one(char[][] board) {
        int length = 9;
        char[][] rows = new char[length][length];
        char[][] cols = new char[length][length];
        char[][][] blocks = new char[length][3][3];

        // 分配行、列、块
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                rows[i][j] = board[i][j];
                cols[j][i] = board[i][j];
                blocks[(i / 3) * 3 + j / 3][i % 3][j % 3] = board[i][j];
            }
        }

        // 检查
        for (char[] row : rows) {
            if (check(row)) return false;
        }
        for (char[] row : cols) {
            if (check(row)) return false;
        }
        for (char[][] block : blocks) {
            char [] b = new char[9];
            int index = 0;
            for (char[] chars : block) {
                for (char aChar : chars) {
                    b[index++] = aChar;
                }
            }
            if (check(b)) return false;
        }
        return true;
    }

    /**
     * 使用数组记录行、列、块中 1-9 数字出现的次数
     * 每次向数组中使用[第几行、列、块][数字-1]定位位置并将该位置自增
     * 由于块稍复杂些，故而转换为三维数组
     * 由于int数组初始化默认全为0，故而如果只是出现一次，这个位置的值一定会<=1
     */
    public static boolean two(char[][] board){
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] block = new int[3][3][9];
        for (int i =0;i <9;i++){
            for(int j = 0;j<9;j++){
                char number = board[i][j];
                if (number !='.'){
                    //定位并让其位置的值自增

                    // 由数字-1获得[][数字-1]
                    int index = number-'1';
                    // 由i获得行[第i行]中的[数字-1]
                    row[i][index]++;
                    // 由j获得列[第j列]中的[数字-1]
                    column[j][index]++;
                    // 由i/3获得从左到右第几个
                    // 由j/3获得从上到下第几个
                    // 故得唯一块[i/3][j/3]中的[数字-1]
                    block[i/3][j/3][index]++;

                    // 检查这三个位置的值是否>1
                    if (row[i][index]>1||column[j][index]>1||block[i/3][j/3][index]>1) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board1 = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'}
                , {'.', '4', '.', '3', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '3', '.', '.', '1'}
                , {'8', '.', '.', '.', '.', '.', '.', '2', '.'}
                , {'.', '.', '2', '.', '7', '.', '.', '.', '.'}
                , {'.', '1', '5', '.', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '2', '.', '.', '.'}
                , {'.', '2', '.', '9', '.', '.', '.', '.', '.'}
                , {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        System.out.println(one(board2));
    }
}
