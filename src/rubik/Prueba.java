package rubik;

public class Prueba {
 public static void main(String[] args) {
	 EstadoRubik estado = new EstadoRubik(true);
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO L");
	 estado.makeL();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO LP");
	 estado.makeLp();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO F");
	 estado.makeF();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO FP");
	 estado.makeFp();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO R");
	 estado.makeR();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO RP");
	 estado.makeRp();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO B");
	 estado.makeB();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO BP");
	 estado.makeBp();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO U");
	 estado.makeU();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO UP");
	 estado.makeUp();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO D");
	 estado.makeD();
	 System.out.println(estado);
	 System.out.println("MOVIMIENTO DP");
	 estado.makeDp();
	 System.out.println(estado);
 }

}