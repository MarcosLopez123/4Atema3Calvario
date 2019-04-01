/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizinversa;

/**
 *
 * @author m
 */
public class CalcularInversa {
    public String [][] Obtener(int fila, int columna, double [][] matriz)
    {
             
          String[][] Inversa = new String[fila][columna];
          cmatrices mat = new cmatrices();
          double determinante =mat.determinanteMatriz(0, matriz);
          
          double [][] MatAdjunta=mat.Adjunta(matriz);
          double [][] MatTrans=mat.Transpuesta(MatAdjunta);
          
          double res = 0;
          for (int i =0; i<MatTrans.length;i++)
          {
               for (int j =0; j<MatTrans.length;j++){
                    if(MatTrans[i][j]<0 && determinante<0){
                         Inversa[i][j]=(Math.abs(MatTrans[i][j])+ " / "+ Math.abs(determinante));
                    }
                    else if(MatTrans[i][j]>0 && determinante<0){
                         Inversa[i][j]=(-(MatTrans[i][j])+ " / "+ Math.abs(determinante));
                    }else if((MatTrans[i][j]==0 && determinante!=0) || (MatTrans[i][j]==0 && determinante==0)){
                        Inversa[i][j]=("0");
                    }else
                         Inversa[i][j]=(MatTrans[i][j]+ " / "+determinante);
               }
               
          }
         
             return Inversa;
        
    }
}
