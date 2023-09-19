import java.util.Random;

public class SmartBot extends Tris{


public static int[][] isWinMove(int[][] grid){
	boolean win=false;
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){			     
			if((grid[i][j] != 1 ) && (grid[i][j]!=0)){
				  grid[i][j]=0;			 
			      win=isWin(grid);
			    if(win==true){return grid;}
					else{				
				      String index = Integer.toString(i+1)+Integer.toString(j+1);
                       grid[i][j]=Integer.parseInt(index);
			    } 
			}
			
	    }
				
	}
			
	
 return grid;}

public static int[][] antiWinMove(int[][] grid){
	boolean win=false;
	boolean antiwin=true;
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
if((grid[i][j] != 1 ) && (grid[i][j]!=0)&& antiwin==true){
				  grid[i][j]=1;			 
			      win=isWin(grid);
			    if(win==true){grid[i][j]=0;return grid;}
					else{				
				      String index = Integer.toString(i+1)+Integer.toString(j+1);
                       grid[i][j]=Integer.parseInt(index);
			    } 
}

		}
}
return grid;}

public static int[][]centerMove(int[][]grid){   
	grid[1][1]=0;
	return grid;
}
public static boolean iscenterMove(int[][]grid){   
	boolean iscenter=false;
	if(grid[1][1]==1){iscenter=true;}
	else{iscenter=false;}
	return iscenter;
}

public static int[][] cornerMove(int[][] grid){
	Random random=new Random();
	     boolean overwrite=false;
		 int counter=0;
		 int counterhard=0;
		 int i=0;
		 do{	
                        i=random.nextInt(4);		 
		                counter=Tris.ismovecounterBot(grid);
						counterhard=counter;
						if((i==0)&&((grid[0][0]!=1 )&&(grid[0][0]!=0))){grid[0][0]=0;}
                        else if((i==1)&&((grid[2][0]!=1 )&&(grid[2][0]!=0))){grid[2][0]=0;}						
		                else if((i==2)&&((grid[0][2]!=1 )&&(grid[0][2]!=0))){grid[0][2]=0;}						
		                else if((i==3) && ((grid[2][2]!=1 )&&(grid[2][2]!=0))){grid[2][2]=0;}						  
						counter=Tris.ismovecounterBot(grid);
						if(counterhard==(counter-1)){overwrite=true;}
						else{System.out.println("bugbugbugcorner");}
		 }while(overwrite==false);
		 
return grid;	
}



public static boolean iscornerMove(int[][]grid){
	boolean cornermove=false;
	
	int cornercount=0;

		               if(grid[0][0] == 1 ){cornercount++;}						
                        else if(grid[2][0] == 1 ){cornercount++;}						
		                else if(grid[0][2] == 1 ){cornercount++;}
		                else if(grid[2][2] == 1 ){cornercount++;}						
								 	
if(cornercount>0){cornermove=true;}else{cornermove=false;}

return cornermove;		
}


public static int[][] edgeMove(int[][]grid){
	 Random random=new Random();
		int i=0;
	     boolean overwrite=false;
		  int counter=0;
		 int counterhard=0;
		 
		 do{
			 i=random.nextInt(4);
		                counter=Tris.ismovecounterBot(grid);
						counterhard=counter;
						if((i==0)&&(grid[1][0]>1 )||(grid[1][0]<0)){grid[1][0]=0;}                     
						else if((i==1)&&(grid[2][1]>1 )||(grid[2][1]<0)){grid[2][1]=0;}	                
						else if((i==2)&&(grid[0][1]>1 )||(grid[0][1]<0)){grid[0][1]=0;}		                
						else if((i==3)&&(grid[1][2]>1 )||(grid[1][2]<0)){grid[1][2]=0;}					
						counter=Tris.ismovecounterBot(grid);
						if(counterhard==(counter-1)){overwrite=true;}
						else{System.out.println("bugbugbugedge");}
						
	       }while(overwrite==false);  
		 
	return grid;
}
	
	


public static boolean isedgeMove(int[][]grid){
	boolean edgemove=false;
	
	int edgecount=0;

		               if(grid[1][0] == 1 ){edgecount++;}						
                        else if(grid[2][1] == 1 ){edgecount++;}						
		                else if(grid[0][1] == 1 ){edgecount++;}
		                else if(grid[1][2] == 1 ){edgecount++;}						
						
							 	
if(edgecount>0){edgemove=true;}else{edgemove=false;}

return edgemove;		
}








}
