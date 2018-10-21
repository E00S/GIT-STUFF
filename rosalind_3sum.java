import java.util.HashMap;

//This is the code written in class modified to make the program run faster
public class Rosalind3SUM {
    public static void triple(int col, HashMap<Integer, Integer> map, int[] data) {
        int temp;
        for (int k = 0; k < col; k++) {
            for (int c = k + 1; c < col; c++) {
                temp = -(data[k] + data[c]);
                if (map.containsKey(temp)) {
                    StdOut.println((k + 1) + " " + (c + 1) + " " + (map.get(temp) + 1));
                    return;
                }
            }
        }
        StdOut.println(-1);
    }
    public static void main(String[] args) {
        In in = new In("rosalind_3sum.txt");
        int row = in.readInt();
        int col = in.readInt();

        for (int i = 0; i < row; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] data= new int[col];
            for (int j =0; j < col; j++){
                data[j] = in.readInt();
                map.put(data[j], j);

            }
            triple(col, map, data);
        }


    }
}