import java.awt.*;
import java.awt.Event;

public class Practica4 extends JFrame implements ActionListener, Runnable{
	Thread hilo;
	int index;
	JLabel pregunta, resultado;
	String[] preguntas, respuestasUsuario;
	String[][] respuestas;
	JRadioButton[] respuestasBotones;
	
	
	public Practica4{
		index = -1;
		preguntas = new String[2];
		respuestas = new String[2][2];
		respuestasUsuario = new String[2];
		respuestasBotones = new JRadioButton[2];
		hilo = new Thread(this);
		
		preguntas[0] = "¿2 + 2 es igual a?";
		preguntas[1] = "¿3 + 3 es igual a?";
		respuestas[0][0] = "4";
		respuestas[0][1] = "5";
		respuestas[1][0] = "6";
		respuestas[1][1] = "10";
		respuestasBotones[0] = new JRadioButton("");
		respuestasBotones[1] = new JRadioButton("");
		pregunta = new JLabel("");
		resultado = new JLabel("");
		
		respuestasBotones[0].addActionListener(this);
		respuestasBotones[1].addActionListener(this);

		getContentPane().add("North",pregunta);
		getContentPane().add("East", respuestasBotones[0]);
		getContentPane().add("West", respuestasBotones[1]);
		getContentPane().add("South", resultado);
		setSize(500, 500);
		setVisible(true);		

		hilo.start();
	}
	
	private void cambiarPregunta(){
		index++;
		pregunta.setText(preguntas[index]);

		if (((int)Math.random() * 1.9) == 0){
			respuestasBotones[0].setText(preguntas[index][0]);
			respuestasBotones[1].setText(preguntas[index][1]);
		} else {
			respuestasBotones[0].setText(preguntas[index][1]);
			respuestasBotones[1].setText(preguntas[index][0]);
		}
		
	}

	private void guardarRespuesta(){
		if (respuestasBotones[0].isSelected()){
			respuestasUsuario[index] = respuestasBotones[0].getText();
		} else if (respuestasBotones[0].isSelected()) {
			respuestasUsuario[index] = respuestasBotones[1].getText();
		} else {
			respuestasUsuario[index] = "";
		}
	}

	private void terminarCuestionario(){
		int correctas = contarRespuestas();
		
		resultado.setText("Tuviste " + correctas + " respuestas correctas.");
	}

	private int contarRespuestas(){
		int contadorCorrectas = 0;

		for (int i = 0; i <= index; i++){
			if (respuestas[i][0].equals(respuestasUsuario[i])){
				contadorCorrectas++;
			}
		}

		return contadorRespuestas;
	}
	
	public void run(){
		if (index < preguntas.length){
			guardarRespuesta();
			cambiarPregunta();
		} else {
			terminarCuestionario();
		}

		try{
			hilo.sleep(5000);
		} catch (Exception e){
			
		}
	}

	public void ActionListener(Event e){
		if (((RadioButton) e.getSource).equals(respuestasBotones[0])){
			respuestasBotones[1].setSelected(false);
		} else {
			respuestasBotones[0].setSelected(false);
		}
	}
	
	public static void main(String args[]){
		new Practiac4();
	}
}