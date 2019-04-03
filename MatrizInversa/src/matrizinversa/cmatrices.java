/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizinversa;

/**
 *
 * @author marco
 */
public class cmatrices {
    // Declaramos método para hallar nuestra determinante
    //le hacemos llegar nuestra matriz y especificamos la fila de la matriz
    public double determinanteMatriz (int i, double [][] matriz)
    {       // el primer if es por si es una matriz de 2 x 2
    	if (matriz.length==2)
        {
                double deter = matriz[0][0]*matriz[1][1] - matriz[0][1]*matriz[1][0];
        	return deter;
        	
        }
        else{ // aqui es para matrices de orden n x n igual o superior a 3
        	double deter=0;
        	for (int j=0;j<matriz.length;j++)
        	{
        		double [][] temp = this.MatrizNueva(i,j,matriz);
        		deter= (double) (deter+Math.pow(-1,i+j)*matriz[i][j]*this.determinanteMatriz(0, temp));
        	}//for
        	return deter;
        }
        	
    }
    
  // método para poder hacer la eliminación de fila y columna de la matriz
    private double[][] MatrizNueva(int i, int j, double[][] matriz) {
    	double [][] temp = new double [matriz.length-1][matriz.length-1];
    	int count1=0;
    	int count2=0;
    	
    	for (int k =0; k < matriz.length;k++){
    		if (k!=i)
    		{
    			count2=0;
    			for(int l =0; l< matriz.length;l++)
    			{
    				if(l!=j)
    				{
    					temp[count1][count2]=matriz[k][l];
    					count2++;
    				}
    			}//2for
    			count1++;
    		}
    	}//llave for
    	
    	
    	
    	
    	return temp;
    	
    }
    // método para la adjunta
    public double [][] Adjunta(double[][] matriz){
        double [][]tempAdjunta = new double [matriz.length][matriz.length];
        if(tempAdjunta.length == 2){ 
            double adjunta = matriz[0][0];
            for(int i = 0; i <tempAdjunta.length;i++)
            {
                for (int j =0; j < tempAdjunta.length;j++)
                {//Método submatriz
                    if((i == 0 && j==0)){
                        tempAdjunta[i][j]=matriz[1][1];
                    }
                    if((i == 0 && j==1) || (i == 1 && j==0)) {
                        tempAdjunta[i][j]=matriz[i][j]*-1;
                    }
                    if ((i == 1 && j==1)){
                            tempAdjunta[i][j]=adjunta;
                    }
                    
                }//for2
            }//for1         
        } else
        {
            for(int i = 0; i <tempAdjunta.length;i++)
            {
                for (int j =0; j < tempAdjunta.length;j++)
                {
                    //Método submatriz
                    double [][] temp = this.MatrizNueva(i, j, matriz);
                    double adjunta=(double) (Math.pow(-1, i+j)* this.determinanteMatriz(0, temp));
                    tempAdjunta[i][j]=adjunta;
                }//for2
            }//for1
        }     
        return tempAdjunta;
    }
    //método para la transpuesta
     public double [][] Transpuesta(double[][] matriz){
         //definimo el tamaño de la transpuesta conforme al tamaño que le llega
        double [][]tempTranspuesta = new double [matriz.length][matriz.length];
        for(int i = 0; i <tempTranspuesta.length;i++)
        {
            for (int j =0; j < tempTranspuesta.length;j++)
            { 
                // convertimos filas en columnas y viceversa
               tempTranspuesta[i][j]=matriz[j][i];
            }//for2
        }//for1
        return tempTranspuesta;
    }
    
}
