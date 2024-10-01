package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int[][] flatArray = new int[intArrayTri.length][intArrayTri[0].length];

        for (int i = 0; i < intArrayTri.length; i++) {
            for (int j = 0; j < intArrayTri[0].length; j++) {
                for (int k = 0; k < intArrayTri[0][0].length; k++){
                    flatArray[j][i] += intArrayTri[k][j][i];
                }
            }
        }
        return flatArray;
    }

    public static String getBidimensionalString(int[][] intArrayBi) {
        String result = "";
        for (int i = 0; i < intArrayBi[0].length; i++) {
            result += stringFlatMatrixRow(intArrayBi, i);
            if (intArrayBi[0].length - i > 1) {
                result += "\n";
            }
        }
        return result;
    }

    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder arrString = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            arrString.append(uniArray[i]);
            if (uniArray.length - i > 1) {
                arrString.append(" ");
            }
        }
        return arrString.toString();
    }

    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] intArray = new int[columns];
        for (int i = 0; i < columns; i++) {
            intArray[i] = (i+1);
        }
        return intArray;
    }


    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] intArray = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                intArray[j][i] = i + 1 + (j*columns);
            }
        }
        return intArray;
    }

    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] intArray = new int[rows][columns][depth];
        for (int i = 0; i < depth; i++) {
            for(int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    intArray[k][j][i] = (i + 1) + (j)*columns + (k)*rows*columns;
                }

            }
        }
        return intArray;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(3, 3);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
