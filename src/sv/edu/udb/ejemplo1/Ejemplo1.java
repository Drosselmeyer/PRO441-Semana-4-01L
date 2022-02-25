package sv.edu.udb.ejemplo1;
import javax.swing.*;

public class Ejemplo1 {

	public static void main(String[] args) {
		//Declaracion de variables
		String Nombre;
		String TipoContrato;
		double SueldoNominal;
		double Descuentos;
		double SueldoLiquido;
		
		Nombre = JOptionPane.showInputDialog(null,
				"Ingrese el nombre del empleado");
		
		TipoContrato = JOptionPane.showInputDialog(null,
				"Ingrese si el contrato es Fijo o Temporal");
		
		SueldoNominal = Double.parseDouble(
					JOptionPane.showInputDialog(null,
					"Ingrese el sueldo del empleado"));
		
		if(TipoContrato.equals("Temporal")) {
			Descuentos =  calculoRenta(TipoContrato,SueldoNominal);
		}
		else { 
			Descuentos = calculoAfp(SueldoNominal) +
						 calculoIsss(SueldoNominal)+
						 calculoRenta(TipoContrato,SueldoNominal);
		}
		
		SueldoLiquido = SueldoNominal - Descuentos;
		
		JOptionPane.showMessageDialog(null, 
				"El empleado "+Nombre+" con sueldo nominal de: "
				+SueldoNominal+" se le pagara: "+SueldoLiquido);
	}
	
	//Declarar las funciones que usaremos
	public static double calculoAfp(double sueldonominal) {
		//Declarar variable de proces
		double Afp = 0.0725;
		double descuento =0;
		
		descuento = sueldonominal*Afp;
		
		return descuento;
	}
	
	public static double calculoIsss(double sueldonominal) {
		//Declarar variable de proces
		double Isss = 0.04;
		double descuento =0;
		
		descuento = sueldonominal*Isss;
		
		return descuento;
	}
	
	public static double calculoRenta
	(String tipocontrato,double sueldonominal) {
		//Declaramos las variables
		double descuento=0;
		double sueldotemporal=0;
		
		if(tipocontrato.equals("Temporal")) {
			descuento = sueldonominal * 0.1;
			//return descuento;
		}
		else {
			sueldotemporal = sueldonominal - 
							 calculoAfp(sueldonominal) -
							 calculoIsss(sueldonominal);
			
			if(sueldotemporal<472.01) {
				//return 0;
			}
			else if(sueldotemporal<895.25) {
				descuento = 17.67 +
						    (sueldotemporal - 472) * 0.1;
				//return descuento;
			}
			else if(sueldotemporal<2038.11 ) {
				descuento = 60 +
					    (sueldotemporal - 895.24) * 0.2;
				//return descuento;
			}
			else {
				descuento = 288.57 +
					    (sueldotemporal - 2038.10 ) * 0.3;
				//return descuento;
			}
				
			
		}
		return descuento;
	}
}

	