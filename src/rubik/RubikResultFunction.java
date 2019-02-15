package rubik;

import aima.core.agent.Action;
import aima.core.search.framework.ResultFunction;

public class RubikResultFunction implements ResultFunction{

	@Override
	public Object result(Object s, Action a) {
		EstadoRubik estado = (EstadoRubik) s;
		if (EstadoRubik.L.equals(a)) {
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeL();
			return nuevoEstado;
		}
		else if(EstadoRubik.Lp.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeLp();
			return nuevoEstado;
		}
		else if(EstadoRubik.F.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeF();
			return nuevoEstado;
		}
		else if(EstadoRubik.Fp.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeFp();
			return nuevoEstado;
		}
		else if(EstadoRubik.R.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeR();
			return nuevoEstado;
		}
		else if(EstadoRubik.Rp.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeRp();
			return nuevoEstado;
		}
		else if(EstadoRubik.B.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeB();
			return nuevoEstado;
		}
		else if(EstadoRubik.Bp.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeBp();
			return nuevoEstado;
		}
		else if(EstadoRubik.U.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeU();
			return nuevoEstado;
		}
		else if(EstadoRubik.Up.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeUp();
			return nuevoEstado;
		}
		else if(EstadoRubik.D.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeD();
			return nuevoEstado;
		}
		else if(EstadoRubik.Dp.equals(a)){
			EstadoRubik nuevoEstado = new EstadoRubik(estado);
			nuevoEstado.makeDp();
			return nuevoEstado;
		}
		// The Action is not understood or is a NoOp
		// the result will be the current state.
		return s;
	}

}

