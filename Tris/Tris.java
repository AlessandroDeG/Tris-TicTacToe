import java.util.Scanner;
import java.util.Random;

class Tris{

public static void main(String args[]){
Random random=new Random();
Scanner in= new Scanner(System.in);
int[][] grid= new int[3][3];
int i=0;
int j=0;
int movecounter=0;
int movecounterBot=0;

int modchoice=34126938;

while(modchoice<1 ||modchoice>3){

System.out.println("TRIS:\n\n SELECT GAME MODE:\n 1:PVP\n 2:PVE(easy)\n 3:PVE(hard)\n");
int choice=in.nextInt();

if(choice==1){modchoice=1;}
else if (choice==2){modchoice=2;}
else if(choice==3){modchoice=3;}
else{System.out.println("ERROR: Try again");}

}




for(i=0;i<3;i++){
  for(j=0;j<3;j++){ 
   
  String index = Integer.toString(i+1)+Integer.toString(j+1);
  
  grid[i][j]=Integer.parseInt(index);
  }
  
}

  


	System.out.println("SELECT GRID COORDINATES:");
printGrid(grid);
  
boolean winwin=false;

while(winwin==false){

boolean overwrite=false;



while (overwrite==false){
	
System.out.print("Player 1\n");
int P1r=in.nextInt();
int P1c=in.nextInt();

boolean cheat=false;


if(grid[P1r-1][P1c-1]==1 || grid[P1r-1][P1c-1]==0){overwrite=false;System.out.println("ERROR: Try again P1");}
else{grid[P1r-1][P1c-1]=1;
System.out.print("\n");
printGrid(grid);
System.out.print("\n");
overwrite=true;

winwin=isWin(grid);
movecounter++;
}
	

}
if(winwin==true){System.out.println("Player 1 Wins");}                    
else{overwrite=false;
	
if(movecounter<5){
while (overwrite==false){


if(modchoice==1){

System.out.print("Player 2\n");
int P2r=in.nextInt();
int P2c=in.nextInt();
if(grid[P2r-1][P2c-1]==1 || grid[P2r-1][P2c-1]==0){overwrite=false;System.out.println("ERROR: Try again P2");}
else{grid[P2r-1][P2c-1]=0;
overwrite=true;
System.out.print("\n");
printGrid(grid);
System.out.print("\n");
winwin=isWin(grid);}

}
else if(modchoice==2){
	System.out.print("Player 2(PVE easy)\n");

	grid=SmartBot.isWinMove(grid);
    winwin=isWin(grid);
if(winwin==true){overwrite=true;}
else{grid=SmartBot.antiWinMove(grid);overwrite=true;}
movecounterBot=ismovecounterBot(grid);


if ((movecounterBot==(movecounter-1))&&winwin==false){


int P2r=random.nextInt(3);
int P2c=random.nextInt(3);
P2r++;
P2c++;
if(grid[P2r-1][P2c-1]==1 || grid[P2r-1][P2c-1]==0){overwrite=false;}
else{grid[P2r-1][P2c-1]=0;
overwrite=true;
winwin=isWin(grid);}
	
}
System.out.print("\n");
printGrid(grid);
System.out.print("\n");
}
else if(modchoice==3){
	System.out.print("Player 2(PVE Hard)\n");
    boolean centermove=SmartBot.iscenterMove(grid);
	System.out.println("centermove"+centermove);
	boolean edgemove=SmartBot.isedgeMove(grid);
	System.out.println("edgemove"+edgemove);
	boolean cornermove=SmartBot.iscornerMove(grid);
	System.out.println("cornenmove"+cornermove);
	int movecounterhardBot=0;
	
	
	grid=SmartBot.isWinMove(grid);
    winwin=isWin(grid);
if(winwin==true){overwrite=true;}
else if(winwin==false && centermove==true) {
	movecounterBot=ismovecounterBot(grid);
	if(movecounterBot==0){grid=SmartBot.cornerMove(grid);overwrite=true;}
	else if(((edgemove==true)||(cornermove==true))&&(movecounterBot!=0)){
		                                  movecounterhardBot=movecounterBot;
										  System.out.println("counterBot" +movecounterBot);
										  System.out.println("counterBothard" +movecounterhardBot);
										  grid=SmartBot.antiWinMove(grid);
										  movecounterBot=ismovecounterBot(grid);
										  System.out.println("counterBot" +movecounterBot);
										  System.out.println("counterBothard" +movecounterhardBot);
										  if(movecounterhardBot==movecounterBot){grid=SmartBot.cornerMove(grid);System.out.println("cornermove");overwrite=true;}
										  else{overwrite=true;}
										  
										}
										
}
else if(winwin==false && cornermove==true){
	movecounterBot=ismovecounterBot(grid);
	if(movecounterBot==0){grid=SmartBot.centerMove(grid);overwrite=true;}
	else if((cornermove==true)&& (movecounterBot!=0)){
		                                  movecounterhardBot=movecounterBot;
										  grid=SmartBot.antiWinMove(grid);
										  movecounterBot=ismovecounterBot(grid);
										  if(movecounterhardBot==movecounterBot){grid=SmartBot.edgeMove(grid);overwrite=true;}
										  else{overwrite=true;}
		
		
	}
	
}
else if(winwin==false && edgemove==true){
	movecounterBot=ismovecounterBot(grid);
	if(movecounterBot==0){grid=SmartBot.centerMove(grid);overwrite=true;}
	else{ 
                                          movecounterhardBot=movecounterBot;
										  grid=SmartBot.antiWinMove(grid);
										  movecounterBot=ismovecounterBot(grid);
										  if(movecounterhardBot==movecounterBot){grid=SmartBot.cornerMove(grid);overwrite=true;}
										  else{overwrite=true;}		
	}
	
	
}



movecounterBot=ismovecounterBot(grid);
movecounter=ismovecounter(grid);

if ((movecounterBot==(movecounter-1))&&(winwin==false)){


int P2r=random.nextInt(3);
int P2c=random.nextInt(3);
P2r++;
P2c++;
if(grid[P2r-1][P2c-1]==1 || grid[P2r-1][P2c-1]==0){overwrite=false;}
else{grid[P2r-1][P2c-1]=0;
overwrite=true;
winwin=isWin(grid);}
	
}
System.out.print("\n");
printGrid(grid);
System.out.print("\n");
	
	
}

if(winwin==true){System.out.println("Player 2 Wins");overwrite=true;}
}
}
else{overwrite=true;winwin=true;System.out.println("TIE!");}
	
}

}

System.out.print("END!!");

}



public static boolean isWin(int[][]grid){
	
	int i=0;
	int j=0;
int p1Win=0;
int p2Win=0;

boolean win=false;

 
 for(i=0;i<3;i++){  //win r
  for(j=0;j<3;j++){ 
  
     if(grid[i][j]==1){p1Win++;}
	 else if(grid[i][j]==0){p2Win++;}
	 
  
   }
   if(p1Win==3){win=true;}
     else if(p2Win==3){win=true;}
	 else{p1Win=0;p2Win=0;}
  }
  
  for(j=0;j<3;j++){        //win c
  for(i=0;i<3;i++){ 
  
     if(grid[i][j]==1){p1Win++;}
	  else if(grid[i][j]==0){p2Win++;}
	 
  
   }
   if(p1Win==3){win=true;}
     else if(p2Win==3){win=true;}
	 else{p1Win=0;p2Win=0;}
  }
  
  for(i=0;i<3;i++){        //win diag
  for(j=0;j<3;j++){ 
  
     if(i==j && grid[i][j]==1){p1Win++;}
	 else if(i==j && grid[i][j]==0){p2Win++;}
	 
   }
   if(p1Win==3){win=true;}
     else if(p2Win==3){win=true;}
	 
  }
  p1Win=0;
	p2Win=0;
  
  
   for(i=0;i<3;i++){    //win diag    
  for(j=0;j<3;j++){ 
  
     if(((i==2 && j==0)||(i==1 && j==1)||(i==0&&j==2))&&grid[i][j]==1){p1Win++;};
	 if(((i==2 && j==0)||(i==1 && j==1)||(i==0&&j==2))&&grid[i][j]==0){p2Win++;};
   }
   if(p1Win==3){win=true;}
     else if(p2Win==3){win=true;}
	 
  }
  	p1Win=0;
	p2Win=0;
if(win==true){return true;}
else{return false;}

}
public static void printGrid(int[][]grid){
	 for(int i=0;i<3;i++){
  for(int j=0;j<3;j++){ 
  if(grid[i][j]==1){System.out.print("X   ");}
  else if(grid[i][j]==0){System.out.print("O    ");}
  else{
  System.out.print(grid[i][j]+ "  ");}
 
 }
 System.out.print("\n");
 }
}

public static int  ismovecounterBot(int[][]grid){
	int movecounter=0;
	
	 for(int i=0;i<3;i++){
  for(int j=0;j<3;j++){ 
	 
	 if(grid[i][j]==0){movecounter++;}
	 }
	}
	return movecounter;
		
}
public static int  ismovecounter(int[][]grid){
	int movecounter=0;
	
	 for(int i=0;i<3;i++){
  for(int j=0;j<3;j++){ 
	 
	 if(grid[i][j]==1){movecounter++;}
	 }
	}
	return movecounter;
		
}
}













