package rubik;
import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class EstadoRubik {
	/*	Numeracion caras
	  4
	0 1 2 3 
	  5
	  
	  	Movimientos(Sin p rotar cara en sentido horario.
	  	Con p rotar cara en sentido antihorario)
	  U
	L F R B
	  D	
	*/
	
	public static final int SIZE = 3;
	public static final int COLOURS = 6;
	
	private int [][][] cubo;	
	
	public static Action L = new DynamicAction("L");
	public static Action Lp = new DynamicAction("Lp");
	public static Action F = new DynamicAction("F");
	public static Action Fp = new DynamicAction("Fp");
	public static Action R = new DynamicAction("R");
	public static Action Rp = new DynamicAction("Rp");
	public static Action B = new DynamicAction("B");
	public static Action Bp = new DynamicAction("Bp");
	public static Action U = new DynamicAction("U");
	public static Action Up = new DynamicAction("Up");
	public static Action D = new DynamicAction("D");
	public static Action Dp = new DynamicAction("Dp");
	
	public EstadoRubik(boolean ini) {
		this.cubo = new int[COLOURS][SIZE][SIZE];
		for(int i = 0; i < COLOURS; i++) {
			for(int j = 0; j < SIZE; j++)
				for(int k = 0; k < SIZE; k++)
					this.cubo[i][j][k] = i;
		}
		
		if (ini){
			//Random r = new Random();
			switch(/*r.nextInt(6)*/3){		//Elegido 3 por razones practicas.
			case 0:
				this.makeB();
				break;
			case 1:
				this.makeB();
				this.makeU();
				break;
			case 2:
				this.makeB();
				this.makeU();
				this.makeL();
				break;
			case 3:
				this.makeB();
				this.makeU();
				this.makeL();
				this.makeF();
				break;
			case 4:
				this.makeB();
				this.makeU();
				this.makeL();
				this.makeF();
				this.makeR();
				break;
			case 5:
				this.makeB();
				this.makeU();
				this.makeL();
				this.makeF();
				this.makeR();
				this.makeU();
				break;
			default: break;
			}
		}
	}
	
	public EstadoRubik(EstadoRubik state) {
		this.cubo = new int[COLOURS][SIZE][SIZE];
		for(int i = 0; i < COLOURS; i++) {
			for(int j = 0; j < SIZE; j++){
				for(int k = 0; k < SIZE; k++){
					this.cubo[i][j][k] = state.getCasilla(i, j, k);
				}
			}
		}
	}
	
	public void makeL() {
		rotarCaraHorario(0);
		int[] temp = new int[SIZE];
		
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[4][i][0];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[4][i][0] = this.cubo[3][SIZE - i - 1][SIZE - 1];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[3][i][SIZE - 1] = this.cubo[5][SIZE - i - 1][0];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[5][i][0] = this.cubo[1][i][0];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[1][i][0] = temp[i];
		}
	}
	
	public void makeLp() {
		rotarCaraAntihorario(0);
		int[] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[4][i][0];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[4][i][0] = this.cubo[1][i][0];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[1][i][0] = this.cubo[5][i][0];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[5][i][0] = this.cubo[3][SIZE - i - 1][SIZE - 1];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[3][SIZE - i - 1][SIZE - 1] = temp[i];
		}
	}
	
	public void makeF() {
		rotarCaraHorario(1);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[4][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[4][2][i] = this.cubo[0][2 -i][2];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[0][i][2] = this.cubo[5][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[5][0][i] = this.cubo[2][2 - i][0];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[2][i][0] = temp[i];
		}
	}
	
	public void makeFp() {
		rotarCaraAntihorario(1);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[4][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[4][2][i] = this.cubo[2][i][0];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[2][i][0] = this.cubo[5][0][2 - i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[5][0][i] = this.cubo[0][i][2];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[0][i][2] = temp[2 - i];
		}
	}
	
	public void makeR() {
		rotarCaraHorario(2);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[4][i][2];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[4][i][2] = this.cubo[1][i][2];
		}
		for(int i = 0; i < SIZE; i++) {
			this.cubo[1][i][2] = this.cubo[5][i][2];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[5][i][2] = this.cubo[3][2 - i][0];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[3][i][0] = temp[2 - i];
		}
	}
	
	public void makeRp() {
		rotarCaraAntihorario(2);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[4][2 - i][2];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[4][i][2] = this.cubo[3][2 - i][0];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[3][i][0] = this.cubo[5][2 - i][2];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[5][i][2] = this.cubo[1][i][2];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[1][i][2] = temp[2 - i];
		}
	}
	
	public void makeB() {
		rotarCaraHorario(3);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[4][0][SIZE - i - 1];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[4][0][SIZE - i - 1] = this.cubo[2][SIZE - i - 1][2];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[2][SIZE - i - 1][2] = this.cubo[5][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[5][2][i] = this.cubo[0][i][0];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[0][i][0] = temp[i];
		}
	}
	
	public void makeBp() {
		rotarCaraAntihorario(3);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[4][0][SIZE - i - 1];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[4][0][i] = this.cubo[0][SIZE - i - 1][0];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[0][SIZE - i - 1][0] = this.cubo[5][2][SIZE - i - 1];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[5][2][SIZE - i - 1] = this.cubo[2][i][2];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[2][SIZE - i - 1][2] = temp[i];
		}
	}
	
	public void makeU() {
		rotarCaraHorario(4);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[0][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[0][0][i] = this.cubo[1][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[1][0][i] = this.cubo[2][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[2][0][i] = this.cubo[3][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[3][0][i] = temp[i];
		}
	}
	
	public void makeUp() {
		rotarCaraAntihorario(4);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[0][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[0][0][i] = this.cubo[3][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[3][0][i] = this.cubo[2][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[2][0][i] = this.cubo[1][0][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[1][0][i] = temp[i];
		}
	}
	
	public void makeD() {
		rotarCaraHorario(5);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[0][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[0][2][i] = this.cubo[3][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[3][2][i] = this.cubo[2][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[2][2][i] = this.cubo[1][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[1][2][i] = temp[i];
		}
	}
	
	public void makeDp() {
		rotarCaraAntihorario(5);
		int [] temp = new int[SIZE];
		for(int i = 0; i < SIZE; i ++) {
			temp[i] = this.cubo[0][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[0][2][i] = this.cubo[1][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[1][2][i] = this.cubo[2][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[2][2][i] = this.cubo[3][2][i];
		}
		for(int i = 0; i < SIZE; i ++) {
			this.cubo[3][2][i] = temp[i];
		}
	}
	
	private void rotarCaraHorario(int cara) {
		int nuevaCara[][] = new int [SIZE][SIZE];
		for(int i = 0; i < SIZE; ++i){
	        for(int j = 0; j < SIZE; ++j){
	            nuevaCara[i][j] = this.cubo[cara][SIZE - j - 1][i];
	        }
	    }
		this.cubo[cara] = nuevaCara;
	}
	
	private void rotarCaraAntihorario(int cara) {
		int nuevaCara[][] = new int [SIZE][SIZE];
		for(int i = 0; i < SIZE; ++i){
	        for(int j = 0; j < SIZE; ++j){
	            nuevaCara[i][j] = this.cubo[cara][j][SIZE - i -1];
	        }
	    }
		this.cubo[cara] = nuevaCara;
	}
	
	public int getCasilla(int i, int j,int k) {
		return this.cubo[i][j][k];
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		EstadoRubik otroEstado = (EstadoRubik) o;
		boolean igual = true;
		int i = 0, j, k;
		while (i < COLOURS && igual){
			j = 0;
			while (j < SIZE && igual){
				k = 0;
				while (k < SIZE && igual){
					if (this.cubo[i][j][k] != otroEstado.getCasilla(i, j, k))
						igual = false;
					else
						k++;
				}
				j++;
			}
			i++;
		}
		
		return igual;
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	public String toString() {
		  String result = new String();
		  for (int i = 0; i < 3; i++) {
			  result = result + "       ";
			  for (int j = 0; j < 3; j++) 
				  result = result  + this.cubo[4][i][j] + " ";
			  result = result + "\n";
		  }
		  for(int i = 0; i < SIZE; i++) {
			  for(int j = 0; j < 4; j++) {
				  for(int k = 0; k < SIZE; k++) {
					  result = result + this.cubo[j][i][k] + " ";
				  }
				  result = result + " ";
			  }
			  result = result + "\n";
		  }
		  	for (int i = 0; i < 3; i++) {
		  		result = result + "       ";
		  		for (int j = 0; j < 3; j++) 
		  			result = result + this.cubo[5][i][j] + " ";
		  		result = result + "\n";
		  }
		  return result;
	}
}
