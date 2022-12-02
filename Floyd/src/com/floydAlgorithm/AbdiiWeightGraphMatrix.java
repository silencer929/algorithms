package com.floydAlgorithm;

public class AbdiiWeightGraphMatrix {
    private static int I= 99999999; // represent infinity
    private static int aziMatrix[][]={
            {0,2,5,I,I,I},
            {I,0,7,1,I,I},
            {I,I,0,4,I,I},
            {I,I,I,0,3,I},
            {I,I,2,I,0,3},
            {I,5,I,2,4,0}
            };
    public static void printFormattedMatrix(int[][] matrix){
        System.out.println("------------------------------------------------------------------------\n");
        System.out.println("                   The matrix has "+ matrix.length+ " Vertices"           );
        System.out.println("                I represents infinity                 ");

        String formatedMatrix= """
                """;
        for (int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix.length;j++){
                if(aziMatrix[i][j]==I){
                    formatedMatrix+=(j!= matrix.length-1)? "I,"+" ": "I";
                }else{
                    formatedMatrix+= (j!=matrix.length-1)?matrix[i][j]+", ":matrix[i][j];
                }
            }
            formatedMatrix+="\n";
        }
        System.out.println(formatedMatrix);
        System.out.println("                I represents infinity                 ");
    }
    public static int[][] getAzimatrix(){
        return aziMatrix;
    }
}
