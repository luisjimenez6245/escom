import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import javax.vecmath.*;
public class Tamagochi extends JFrame  implements LeeRed {
static String preguntas []= { "COMO TE LLAMAS","DONDE VIVES"};
static String respuestas []= {"MI NOMBRE ES TAMAGOCHI","EN LA COMPU"};
private Canvas3D canvas3D;
private Appearance ap;
private static Texture texture;
private JPanel jp1, jp2;
private JButton benfermo, bfeliz, blisto, bserio, bsonrisa;
private EventHandler eh; 

private String nombres[][] = {
{"bob-esponja.jpg", "bobEnf.jpg", "listo.jpg", "serio.jpg", "sonrisa.jpg"},
};
private int turno;
//private Body body;
private Red r;
Body b;
BodyZoey bz;
BodyBob bb;
Movible movi;
Esfera e;
int avatar=0;
public Tamagochi(){
   super("Tamagochi 3D");
   turno=0;
   //setResizable(false); 
   setSize(600, 500);
   GraphicsConfiguration config =     
   SimpleUniverse.getPreferredConfiguration();
   canvas3D = new Canvas3D(config);
   canvas3D.setSize(300, 400);
   eh = new EventHandler();  
   bfeliz=new JButton("Feliz");
   benfermo=new JButton("Enfermo");
   blisto=new JButton("Listo");
   bsonrisa=new JButton("Sonrisa");
   bserio=new JButton("Serio");
   benfermo.addActionListener(eh); 
   blisto.addActionListener(eh); 
   bsonrisa.addActionListener(eh); 
   bserio.addActionListener(eh); 	
   bfeliz.addActionListener(eh);  
   
   jp1=new JPanel();
   jp1.add(bfeliz);  
   jp1.add(benfermo);
   jp1.add(blisto);
   jp1.add(bsonrisa);
   jp1.add(bserio);
   add("North", jp1); 
   add("Center",canvas3D); 
   setup3DGraphics();
   setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   setVisible(true);
   r=new Red(this);
}
void setup3DGraphics(){
    BranchGroup group=null;
   DirectionalLight light1;
   SimpleUniverse universe = new SimpleUniverse(canvas3D);
   universe.getViewingPlatform().setNominalViewingTransform();
   if(avatar== 0){
	movi=new Esfera(this);
        movi.changeTextureCab(texture, "Arizona.jpg");
        group = movi.myBody();
   }
   if(avatar== 1){
	movi=new Esfera(this);
        movi.changeTextureCab(texture, "carafeliz.jpg");
        group = movi.myBody();
   }
   if(avatar== 2){
      movi=new Body(-0.4f,0.0f,0.0f,"",true, this, "Avatar1");
      movi.changeTextureCab(texture, "carafeliz.jpg");
      group = movi.myBody();
   }
   if(avatar== 3){
      movi=new BodyBob(-0.4f,0.0f,0.0f,"",true, this, "bob-esponja.jpg");
      group = movi.myBody();
   }
   if(avatar== 4){
      movi=new BodyZoey(-0.4f,0.0f,0.0f,"",true, this, "cabeza.png");
      group = movi.myBody();
   }
   if(avatar== 5){
      movi=new Stan(-0.4f,0.0f,0.0f,"",true, this, "Avatar1", null);
      group= movi.myBody();
   }
   BoundingSphere bounds =new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
   Background fondo=new Background();
   fondo.setColor(1.0f,1.0f,1.0f);
   fondo.setApplicationBounds(bounds);
   group.addChild(fondo);
//SE DA LUZ A TODO EL ESCENARIO
   AmbientLight luz= new AmbientLight();
   luz.setInfluencingBounds(bounds);
   group.addChild(luz);
   universe.addBranchGraph(group);
}
public static void main(String[] args) { new Tamagochi(); }
class EventHandler implements ActionListener {  
  public void actionPerformed(ActionEvent e1) { 
     Object obj=e1.getSource();
     if(obj instanceof JButton){ 
     	JButton btn=(JButton)e1.getSource();
     	 if(btn==bfeliz){ turno=0; }
	 if(btn==benfermo){turno=1;}
	 if(btn==blisto){turno=2;}
	 if(btn==bserio){turno=3;}
	 if(btn==bsonrisa){turno=4;}
     }
        movi.changeTextureCab(texture, nombres[avatar][turno]); 
     	r.escribeRed(new Icono("Tamagochi", turno)); 
     }  
}
   public void leeRed(Object obj){
      if(obj instanceof Icono){   
         Icono i=(Icono)obj;
         int turno=i.getTurno();  
         System.out.println("Recibi"+i.getTurno());  
         movi.changeTextureCab(texture, nombres[avatar][turno]);      
      }
      if(obj instanceof Mensaje){ 
		System.out.println("Recibi "+(Mensaje)obj);
      }
   }
static String findMatch(String str) {
		String result = "";
		for(int i = 0; i < preguntas.length; ++i) {
			if(preguntas[i].equalsIgnoreCase(str)) {
				result = respuestas[i];
				break;
			}
		} 
		return result;
}
}
