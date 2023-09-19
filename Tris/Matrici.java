import java.util.Random;
import java.util.Scanner;

class Matrici
{
  public static void printM(int[][]M){ //stampa matrice
  for(int i=0;i<M.length;i++){
   for(int j=0;j<M[0].length;j++){
      System.out.print(M[i][j]);
   }
 System.out.println();
 }
  }
  
  public static int[][] matR(int nr,int nc, int maxR) //Matrice casuale
  {
   
     
	 int[][] mat1= new int[nr][nc];
  
     int i=0;
	 int j=0;
     Random rand = new Random();
  
     for(i=0;i<nr;i++)
     {
	   for(j=0;j<nc;j++)
       {
	   mat1[i][j]=rand.nextInt(maxR); 
       }	 
     }
	  return mat1;
  }
  
  public static boolean isQuadrata(int[][] mat) //Matrice Q?
  {
	 int r,c;
     r=mat.length;
	 c=mat[0].length;
	 
	 if(r==c){return true;}
	 else {return false;}  
  }

  public static int[][] scanM(){  //Inserire Matrice
	   
 Scanner in = new Scanner(System.in);
 
 System.out.print("Num righe: ");
 int nr=in.nextInt();
 
 System.out.print("Num colonne: ");
 int nc=in.nextInt();
 int[][] m= new int[nr][nc];
 
 for(int i=0;i<nr;i++){
   for(int j=0;j<nc;j++){
      System.out.print("Inserire elemento("+i+","+j+"):");
	  m[i][j]=in.nextInt();  
   }	  
 } return m; 
  }  
  public static int[][]ridCol(int[][]M,int C){ //Elimina colonna 
	 int r=M.length;
	 int c=M[0].length;
	 int[][]M1=new int[r][c-1];
	 int i1=0;
	 int j1=0;
	 
	 for(int i=0;i<r;i++)
	 {	  
         j1=0;
		 for(int j=0;j<c;j++)
		 {
			 if(j!=C){M1[i1][j1]=M[i][j];j1++;} 
		 }
		 i1++;
	 }
	 return M1;
 }

 public static int[][]ridRig(int[][]M, int R){ //Elimina riga 
	 int r=M.length;
	 int c=M[0].length;
	 int[][]M1=new int[r-1][c];
	 int i1=0;
	 int j1=0;
	 
	 for(int i=0;i<r;i++)
	 {
		 if(i!=R)
		 {
			 j1=0;	  
		   for(int j=0;j<c;j++)
		   {
			 M1[i1][j1]=M[i][j];j1++;
		   }
		   i1++;
		 }
	 }
	 return M1;
 }
 public static int[][]ridM(int[][]M, int R,int C){ //Elimina riga e colonna 
	 int r=M.length;
	 int c=M[0].length;
	 int[][]M1=new int[r-1][c-1];
	 int i1=0;
	 int j1=0;
	 
	 for(int i=0;i<r;i++)
	 {
		 if(i!=R){j1=0;	  
		 for(int j=0;j<c;j++)
		 {
			 if(j!=C){M1[i1][j1]=M[i][j];j1++;} 
		 }
		   i1++;
		 }
	 }
	 return M1;
 }
 
 public static int[][]aggC(int[][]M,int[][]N){ //aggiungi colonna
int r=M.length;
int c=M[0].length;
int[][]M1=new int[r][c+1];
for(int i=0;i<r;i++){
for(int j=0;j<c+1;j++){
	if(j<c){M1[i][j]=M[i][j];}
	else{M1[i][j]=N[i][0];}
    }
}
return M1;
}

		 
 public static int compA(int[][]M,int i1,int j1){   //complemento algebrico 
	 int segno;
	 int comp;
	 
	 if((((i1+1)+(j1+1))%2)==0){segno=1;}else{segno=-1;};
	 
	 comp = segno*M[i1][j1]*detM(ridM(M,i1,j1));
	 return comp;
 }
 
 public static int detM(int[][]M){ //determinante
 int det=0;
 int compl;
  
  try{
  
  int r=M.length;
  int c=M[0].length;

  
  if(r!=c){System.out.println("Matrice non Quadrata");return 0;}
  else if(r==1 && c==1){det=M[0][0];return det;}
  else{
	  if(r==2 && c==2){det=M[0][0]*M[1][1]-M[0][1]*M[1][0];return det;}
	  else if(r==3 && c==3){
  det=M[0][0]*M[1][1]*M[2][2]+M[0][1]*M[1][2]*M[2][0]+M[0][2]*M[1][0]*M[2][1]-M[0][2]*M[1][1]*M[2][0]-M[0][0]*M[1][2]*M[2][1]-M[0][1]*M[1][0]*M[2][2];
   return det;}
	else{
		for(int j=0;j<c;j++){
			int i=0;
			compl=compA(M,i,j);
			det=det+compl;	
		}
			return det;
		
		}    
  }  
  }catch(ArrayIndexOutOfBoundsException exc){System.out.print("Matrice non valida:");System.out.println(exc);return 0;}
 }
 
 
public static int rangM(int[][]M){ //rango matrice (m,n)
int rA=0;	
	Matrici m=new Matrici();	
int r=M.length;
int c=M[0].length;
int conta0=0;

for(int i=0;i<r;i++){
	for(int j=0;j<c;j++){
		if(M[i][j]!=0){conta0++;}
	}
}

if(conta0!=0){
	if((r==1 && c==1)&& M[0][0]!=0){rA=1;}
	else{

int maxMin=0;

if(r>c){
   maxMin=r-(r-c);
   int[][]M1=new int[maxMin][maxMin];
   if(r-maxMin==1){
        for(int i=0;i<=maxMin;i++){
			M1=m.ridRig(M,i);
			  if(m.detM(M1)!=0){
			   rA=maxMin;
			   return rA;
			  }
			  else{rA=rangM(M1);}
         }
	}
}
else if(c>r){
   maxMin=c-(c-r);
   int[][]M1=new int[maxMin][maxMin];
   if(c-maxMin==1){
        for(int i=0;i<=maxMin;i++){
			M1=m.ridCol(M,i);
             if(m.detM(M1)!=0){ 
			   rA=maxMin;
			   return rA;
			 }
			 else{rA=rangM(M1);}			   
         }
    }
}
else if(r==c){
	int[][]M1=new int[r-1][c-1];
	if(m.detM(M)==0){
	for(int i=0;i<r;i++){
		for(int j=0;j<c;j++){
			M1=m.ridM(M,i,j);
			if(m.detM(M1)!=0){ 
			  rA=M1.length; 
			  return rA;
			}
		 else{rA=rangM(M1);}
	    }  
	} 
}else{rA=M.length; }	
	}
}
}else{return 0;}
return rA;
}

}
 
 
 
 
 
 
 
 
  
  
  
  
  
  
  
  