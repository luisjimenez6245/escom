import com.sun.j3d.utils.picking.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.behaviors.mouse.*;
import javax.vecmath.*;
import java.awt.*;
import javax.swing.*;

public class Stan implements Movible {
    private static final float HEIGHT_BODY=0.5f;
    private static final float TOP_BODY=0.35f;
    private static final float BOTTOM_BODY=0.40f;
    private static final float HEIGHT_LEGS=0.2f;
    private static final float WIDTH_LEGS=0.185f;
    private static final float HEIGHT_ARMS=0.22f;
    private static final float WIDTH_ARMS=0.09f;
    private static final float WIDTH_HEAD=0.5f;
    private static final float WIDTH_EYES=0.3f;
    private static final float WIDTH_HANDS=0.1f;
    private static final float WIDTH_FINGERS=0.0525f;
    private static final float WIDTH_SHOES=0.28f;
    private static final float HEIGHT_SHOES=0.05f;
    private static final float WIDTH_OPEN_MOUTH=0.1f;
    private static final float WIDTH_BUTTONS=0.0525f;
    private static final float SPACE_BETWEEN_BUTTONS=0.12f;
    private static final float WIDTH_BOTTOM_BONNET=0.525f;
    private static final float HEIGHT_BOTTOM_BONNET=0.12f;
    private static final float WIDTH_BONNET=0.52f;
    private static final float WIDTH_PUPILS=0.03f;
    private static final float WIDTH_POMPON=0.12f;
    private BranchGroup group;
    private static Texture texture;
    private Appearance appearance;
    private TextureLoader loader;
    TransformGroup rotacion= new TransformGroup();
    TransformGroup tran;
    Text2D textObject;
    Appearance ap;
    Frame frame1;
    Sphere cab;
    float x, y, z;
    private TransformGroup tg2Tron;
    private TransformGroup tg2HD;
    private TransformGroup tg2HI;
    private double nAnguloDoor=Math.PI*2;
    int orientacion;
    private Transform3D t3d, toMove, toRot;   
    private TransformGroup viewerTG;
    public final static float MOVERATE = 0.3f;
    private Point3d bobPosn;

public Appearance set_skin_material(){    
    Appearance a = new Appearance();
    Color3f eColor = new Color3f( 0.59f,0.44f,0.41f);
    Color3f sColor = new Color3f( 1.0f, 1.0f, 1.0f);
    Color3f oColor = new Color3f( 1.0f,0.79f, 0.68f);
    Material m = new Material(oColor, eColor, eColor, sColor, 100.0f);
    m.setLightingEnable(true);
    a.setMaterial(m);
    return a;    
    }    
public Appearance set_shirt_material(){    
    Appearance a = new Appearance();
    //Color3f eColor = new Color3f( 0.5f, 0.45f, 0.3f);
    Color3f eColor = new Color3f(0.5f, 0.45f, 0.3f);
    Color3f sColor = new Color3f( 0.8f, 0.8f, 0.8f);
    Color3f oColor = new Color3f( 1.0f, 1.0f, 1.0f);
    Material m = new Material(oColor, eColor, eColor, sColor, 50.0f);
    m.setLightingEnable(true);
    a.setMaterial(m);
    return a;
}
public Appearance set_blue_material (){
    Appearance a = new Appearance();
    Color3f eColor = new Color3f(0.2f, 0.2f, 0.6f);
    Color3f sColor = new Color3f(0.8f, 0.8f, 0.8f);
    Color3f oColor = new Color3f(1.0f,1.0f,1.0f);
    Material m = new Material(oColor, eColor, eColor, sColor, 50.0f);
    m.setLightingEnable(true);
    a.setMaterial(m);
    return a;
}

public Appearance set_red_material (){
    Appearance a = new Appearance();
    Color3f eColor = new Color3f(0.8f,0.05f,0.15f);
    Color3f sColor = new Color3f(0.4f,0.4f,0.4f);
    Color3f oColor = new Color3f(1.0f,1.0f,1.0f);
    Material m = new Material(oColor, eColor, eColor, sColor, 50.0f);
    m.setLightingEnable(true);
    a.setMaterial(m);
    return a;    
    }
public void moveForward(){ 
    moveBy(0.0, MOVERATE); 
}

public void moveBackward(){ 
    moveBy(0.0, -MOVERATE); 
}

  public void moveLeft()
  { 
    moveBy(-MOVERATE,0.0); 
  }

  public void moveRight()
  { 
    moveBy(MOVERATE,0.0); 
  }

  public Point3d getCurrLoc()
  {        
    tran.getTransform( t3d );
    Vector3d trans = new Vector3d();
    t3d.get( trans );
    // printTuple(trans, "currLoc");
    return new Point3d( trans.x, trans.y, trans.z);
  } 
   
   public void moveBy(double x, double z)
  /* Move the sprite by offsets x and z, but only if within the floor
     and there is no obstacle nearby. */
  {
        doMove( new Vector3d(x, 0, z) );  
        //viewerMove(); 
  }  // end of moveBy()
  public void doMove1(Vector3d theMove)
  // Move the sprite by the amount in theMove
  {
    tran.getTransform( t3d );
    t3d.setTranslation(theMove);    // overwrite previous trans
    //t3d.mul(toMove);
    //tran.setTransform(t3d);
  }  
    private void doMove(Vector3d theMove)
  // Move the sprite by the amount in theMove
  {
    tran.getTransform( t3d );
    toMove.setTranslation(theMove);    // overwrite previous trans
    t3d.mul(toMove);
    tran.setTransform(t3d);
  }  // end of doMove()
    
  private void viewerMove()
  // Updates the view point by the translation change of the sprite
  {
    Point3d newLoc = getCurrLoc();
    // printTuple(newLoc, "newLoc");
    Vector3d trans = new Vector3d( newLoc.x - bobPosn.x,
								0, newLoc.z - bobPosn.z);
    viewerTG.getTransform( t3d );
    toMove.setTranslation(trans);  // overwrites previous translation
    t3d.mul(toMove);
    viewerTG.setTransform(t3d);

    bobPosn = newLoc;   // save for next time
  }  


    public void giraTron(float angulo){
    try{
      if(angulo < Math.PI ){
          angulo+=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotY(-angulo);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2Tron.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
     public void giraHD(float angulo){
    try{
      if(angulo < Math.PI ){
          angulo+=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotX(-angulo);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2HD.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
    public void rotaHD(){
    try{
      while(nAnguloDoor > 3* (Math.PI/2) ){
          Thread.sleep(100);
          nAnguloDoor-=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotX(nAnguloDoor);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2HD.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
  public void giraHI(float angulo){
    try{
      if(angulo < Math.PI ){
          angulo+=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotX(-angulo);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2HI.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
    public void rotaHI(){
    try{
      while(nAnguloDoor > 3* (Math.PI/2) ){
          Thread.sleep(100);
          nAnguloDoor-=0.2f;
          Transform3D t3d2=new Transform3D();
          t3d2.rotX(nAnguloDoor);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          tg2HI.setTransform(t3d2);
      }
    }catch(Exception e){
    }
  }
    public Sphere getCab(){
	return cab;
    }
    public Stan(float x, float y, float z,String nombre_mostrar,boolean movimiento,Frame frame,String img, TransformGroup vTG){
	 this.x=x; this.y=y;this.z=z;
         group=new BranchGroup();
         t3d = new Transform3D();
         toMove = new Transform3D();
         viewerTG = vTG;
         bobPosn=new Point3d(x,y,z);
         Appearance apa2 = new Appearance();
         TextureLoader loader2=new TextureLoader("fondo.jpg", frame);
         Texture texture2=loader2.getTexture();
         apa2.setTexture(texture2);
         frame1=frame;
         Transform3D pompon=new Transform3D();
         Transform3D cabeza=new Transform3D();
         Transform3D cuello=new Transform3D();
         Transform3D tronco=new Transform3D();
         Transform3D homizq=new Transform3D();
         Transform3D homder=new Transform3D();
         Transform3D braizq=new Transform3D();
         Transform3D pieizq=new Transform3D();
         Transform3D pieder=new Transform3D();
         Vector3f pospompon =new Vector3f(x ,y+0.9f, z);
         Vector3f poscabeza =new Vector3f(0f,y+0.5f, z);
         
         
         //Material
	 Appearance apa = new Appearance();
         loader=new TextureLoader(img+".jpg",frame1);
         texture=loader.getTexture();
         apa.setTexture(texture);
   
         Appearance apa1 = new Appearance();
         TextureLoader loader1=new TextureLoader("tra.jpg",frame1);
         Texture texture1=loader1.getTexture();
         apa1.setTexture(texture1);
         tran= new TransformGroup();
         tran.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         tran.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);  
         //Cabeza    
         pompon.setTranslation(pospompon);
         TransformGroup transformacion0= new TransformGroup(pompon);
         int primflags = Primitive.GENERATE_NORMALS
        + Primitive.GENERATE_TEXTURE_COORDS;
         Sphere pomp=new Sphere( WIDTH_POMPON, primflags, 32, set_red_material());
	 transformacion0.addChild(pomp);
         tran.addChild(transformacion0); 
         cabeza.setTranslation(poscabeza);
         TransformGroup transformacion1= new TransformGroup(cabeza);
         
         cab=new Sphere( WIDTH_HEAD, primflags, 32, apa /*set_skin_material()*/);
         cab.setCapability(Primitive.ENABLE_APPEARANCE_MODIFY);
         ap = cab.getAppearance();
         ap.setCapability(Appearance.ALLOW_TEXTURE_ATTRIBUTES_WRITE);
         ap.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
         ap.setCapability(Appearance.ALLOW_MATERIAL_WRITE);
         transformacion1.addChild(cab);
         //tran.addChild(transformacion1);
         BoundingSphere bounds = new BoundingSphere(new Point3d(),0.0);
         //if(movimiento){
         tran.setCapability(TransformGroup.ALLOW_AUTO_COMPUTE_BOUNDS_READ);
         tran.setCapability(TransformGroup.ALLOW_AUTO_COMPUTE_BOUNDS_WRITE);
         tran.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         tran.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         
         MouseRotate rotator=new MouseRotate(tran);
         rotator.setSchedulingBounds(bounds);
         MouseTranslate t=new MouseTranslate(tran);
         t.setSchedulingBounds(bounds);
         tran.addChild(t);
         tran.addChild(rotator);
         //}
         //Cuello
         Vector3f poscuello =new Vector3f(x,y-0.0f,z);
         Material yellowSphMaterial = new Material();
         yellowSphMaterial.setDiffuseColor(0.85f, 0.85f, 0.85f);
         Appearance yellowSphAppearance = new Appearance();
         yellowSphAppearance.setMaterial(yellowSphMaterial);

         cuello.setTranslation(poscuello);
         TransformGroup transformacion2= new TransformGroup(cuello);
         // rotated circle: a torus
    Color3f eColor = new Color3f(0.8f,0.05f,0.15f);
    Color3f brown = new Color3f( 0.3f, 0.2f, 0.0f);
    Color3f darkBrown = new Color3f(0.1f, 0.0f, 0.0f);
    //double xsIn[] = {1, 1.5, 1, 0.5, 1};
    //double ysIn[] = {0, 0.5, 1, 0.5, 0};
    double xsIn[] = {0.33, 0.5, 0.33, 0.17, 0.33};
    //double xsIn[] = {0.25, 0.375, 0.25, 0.125, 0.25};
    double ysIn[] = {0, 0.125, 0.25, 0.125, 0};
    LatheShape3D ls = new LatheShape3D( xsIn, ysIn, darkBrown, eColor);
    
    /*Transform3D t3d = new Transform3D();
    t3d.set( new Vector3f(-7.0f,1.5f, 0)); 
    TransformGroup tg1 = new TransformGroup(t3d);
    tg1.addChild( ls ); */



         Cylinder cue=new Cylinder(0.025f,0.05f ,yellowSphAppearance);
         //transformacion2.addChild(cue);
         transformacion2.addChild(ls);
         tran.addChild(transformacion2);

         //Tronco       
    Vector3f postronco =new Vector3f(x, y-0.1f , z);
    Transform3D t3d3Tron=new Transform3D();
    t3d3Tron.set(1, postronco);
    TransformGroup tg3Tron=new TransformGroup(t3d3Tron);
    Transform3D t3d2Tron=new Transform3D();
    t3d2Tron.rotX(nAnguloDoor);
    tg2Tron=new TransformGroup(t3d2Tron);
    tg2Tron.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    Transform3D t3d1Tron=new Transform3D();
    t3d1Tron.set(1,new Vector3d(0.0f,0,0));
    TransformGroup tg1Tron=new TransformGroup(t3d1Tron);
    Cylinder tron=new Cylinder(TOP_BODY, HEIGHT_BODY,primflags , set_shirt_material ());
    tg1Tron.addChild(tron);
    tran.addChild(tg3Tron);
    tg3Tron.addChild(tg2Tron);
    tg2Tron.addChild(tg1Tron);

         //Hombro Derecho
//=====Vector3f poshizq =new Vector3f(x-0.47f,y+0.115f,z);
         //======Vector3f poshder =new Vector3f(x+0.47f,y+0.115f,z);
    Vector3f poshder =new Vector3f(0.47f, 0.115f, 0);
    Transform3D t3d3HD=new Transform3D();
    t3d3HD.set(1,poshder);
    TransformGroup tg3HD=new TransformGroup(t3d3HD);
    Transform3D t3d2HD=new Transform3D();
    t3d2HD.rotX(nAnguloDoor);
    tg2HD=new TransformGroup(t3d2HD);
    tg2HD.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    Transform3D t3d1HD=new Transform3D();
    t3d1HD.set(1,new Vector3d(0.0f,0,0));
    TransformGroup tg1HD=new TransformGroup(t3d1HD);
Sphere hder=new Sphere(WIDTH_ARMS, Primitive.GENERATE_NORMALS, 32, set_shirt_material ());
    tg1HD.addChild(hder);
    tg3HD.addChild(tg2HD);
    tg2HD.addChild(tg1HD);

    tg1Tron.addChild(tg3HD);
    tg1Tron.addChild(transformacion1);
    //Brazo Derecho
    Vector3f posbder =new Vector3f(0.0f,-0.075f,0f);
    Transform3D t3d11HD=new Transform3D();
    t3d11HD.set(1,posbder);
    TransformGroup tg11HD=new TransformGroup(t3d11HD);
    Cylinder bder=new Cylinder( WIDTH_ARMS, HEIGHT_ARMS , set_shirt_material ());
    tg11HD.addChild(bder);
    tg1HD.addChild(tg11HD);
    Vector3f posmander =new Vector3f(0.0f, -HEIGHT_ARMS, 0f);
    Transform3D t3d11HDman=new Transform3D();
    t3d11HDman.set(1,posmander);
    TransformGroup tg11HDman=new TransformGroup(t3d11HDman);
    Sphere mander=new Sphere( WIDTH_ARMS+0.02f, primflags, 32, 
                               set_red_material ());
    tg11HDman.addChild(mander);
    tg1HD.addChild(tg11HDman);
//Hombro Izquierdo
    Vector3f poshizq =new Vector3f(-0.47f, 0.115f, 0);
    Transform3D t3d3HI=new Transform3D();
    t3d3HI.set(1,poshizq);
    TransformGroup tg3HI=new TransformGroup(t3d3HI);
    Transform3D t3d2HI=new Transform3D();
    t3d2HI.rotX(nAnguloDoor);
    tg2HI=new TransformGroup(t3d2HI);
    tg2HI.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    Transform3D t3d1HI=new Transform3D();
    t3d1HI.set(1,new Vector3d(0.0f,0,0));
    TransformGroup tg1HI=new TransformGroup(t3d1HI);
 Sphere hizq=new Sphere(WIDTH_ARMS, Primitive.GENERATE_NORMALS, 32, set_shirt_material ());

/*
tg1HD.addChild(hder);
    tg3HD.addChild(tg2HD);
    tg2HD.addChild(tg1HD);
    tg1Tron.addChild(tg3HD);*/

    tg1HI.addChild(hizq);
    tg3HI.addChild(tg2HI);
    tg2HI.addChild(tg1HI);
    tg1Tron.addChild(tg3HI);

    //Brazo Izquierdo
    Vector3f posbizq =new Vector3f(0.0f,-0.075f,0f);
    Transform3D t3d11HI=new Transform3D();
    t3d11HI.set(1,posbizq);
    TransformGroup tg11HI=new TransformGroup(t3d11HI);
    Cylinder bizq=new Cylinder( WIDTH_ARMS, HEIGHT_ARMS , set_shirt_material ());
    tg11HI.addChild(bizq);
    tg1HI.addChild(tg11HI);
    
    
    Vector3f posmanizq =new Vector3f(0.0f, -HEIGHT_ARMS, 0f);
    Transform3D t3d11HIman=new Transform3D();
    t3d11HIman.set(1,posmanizq);
    TransformGroup tg11HIman=new TransformGroup(t3d11HIman);
    Sphere manizq=new Sphere( WIDTH_ARMS+0.02f, primflags, 32, 
                       set_red_material ());
    tg11HIman.addChild(manizq);
    tg1HI.addChild(tg11HIman);
         /*Hombro Izquiedo
         homizq.setTranslation(poshizq);
         TransformGroup transformacion5= new TransformGroup(homizq);
         Sphere hizq=new Sphere(.03f,Primitive.GENERATE_NORMALS, 32,yellowSphAppearance);
         transformacion5.addChild(hizq);       
         tran.addChild(transformacion5);

         Brazo Izquierdo
         braizq.setTranslation(posbizq);
         TransformGroup transformacion7= new TransformGroup(braizq);
         Cylinder bizq=new Cylinder(0.0125f,0.15f ,yellowSphAppearance);
         transformacion7.addChild(bizq);
         tran.addChild(transformacion7);
*/
         //Pierna Derecha
         
         Vector3f pospder =new Vector3f(0.19f,y-HEIGHT_BODY+0.15f, z);
         pieder.setTranslation(pospder);
         TransformGroup transformacion8= new TransformGroup(pieder);
         Cylinder pder=new Cylinder( WIDTH_LEGS, HEIGHT_LEGS,set_blue_material());
         transformacion8.addChild(pder);
	 tg1Tron.addChild(transformacion8);
         //Pierna Izquierda
         Vector3f pospizq =new Vector3f(-0.19f,y-HEIGHT_BODY+0.15f, z);
         pieizq.setTranslation(pospizq);
         TransformGroup transformacion9= new TransformGroup(pieizq);
         Cylinder pizq=new Cylinder( WIDTH_LEGS, HEIGHT_LEGS,set_blue_material());
         transformacion9.addChild(pizq);
         tg1Tron.addChild(transformacion9);
         texto(nombre_mostrar, new Vector3f(x-0.085f,y-0.33f,z), 24);
         mensaje("chat chat chat");
         group.addChild(tran);
         if(movimiento){
         transformacion2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         transformacion2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         //transformacion3.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         //transformacion3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         //transformacion4.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         //transformacion4.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         //transformacion5.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         //transformacion5.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         tg2HD.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         tg2HD.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         tg2HI.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         tg2HI.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         transformacion8.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         transformacion8.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         transformacion9.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
         transformacion9.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         //transformacion10.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
         MouseTranslate t2=new MouseTranslate(transformacion2);
         //MouseTranslate t3=new MouseTranslate(transformacion3);
         //MouseTranslate t4=new MouseTranslate(transformacion4);
         //MouseTranslate t5=new MouseTranslate(transformacion5);
         MouseTranslate t6=new MouseTranslate(tg2HD);
         MouseTranslate t7=new MouseTranslate(tg2HI);
         MouseTranslate t8=new MouseTranslate(transformacion8);
         MouseTranslate t9=new MouseTranslate(transformacion9);
         //MouseTranslate t10=new MouseTranslate(transformacion10);
         t2.setSchedulingBounds(bounds);
         tran.addChild(t2);
         //t3.setSchedulingBounds(bounds);
         //tran.addChild(t3);
         //t4.setSchedulingBounds(bounds);
         //tran.addChild(t4);
         //t5.setSchedulingBounds(bounds);
         //tran.addChild(t5);
         t6.setSchedulingBounds(bounds);
         tran.addChild(t6);
         t7.setSchedulingBounds(bounds);
         tran.addChild(t7);
         t8.setSchedulingBounds(bounds);
         tran.addChild(t8);
         t9.setSchedulingBounds(bounds);
         tran.addChild(t9);
         //t10.setSchedulingBounds(bounds);
         //tran.addChild(t10); 
        }
    }
    public BranchGroup myBody(){
        return group;
    }
    public void texto(String mensaje, Vector3f v, int tam) {     
         Text2D textObject = new Text2D(mensaje, new Color3f(.4f, 0.4f, 0.6f),
        "Serif", tam, Font.ITALIC);
    Transform3D textTranslation = new Transform3D();
    textTranslation.setTranslation(v);
    TransformGroup textTranslationGroup = new TransformGroup(textTranslation);
    textTranslationGroup.addChild(textObject);
    tran.addChild(textTranslationGroup);
    }
    public void mensaje(String mensaje) {
          
         textObject = new Text2D(mensaje, new Color3f(.4f, 0.4f, 0.6f),
        "Serif", 28, Font.ITALIC);
    Appearance ap = textObject.getAppearance();
    ap.setCapability(Appearance.ALLOW_TEXTURE_ATTRIBUTES_WRITE);
    ap.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
    ap.setCapability(Appearance.ALLOW_MATERIAL_WRITE);
    Transform3D textTranslation = new Transform3D();
    textTranslation.setTranslation(new Vector3f(x-0.4f,y+0.25f,z));
    TransformGroup textTranslationGroup = new TransformGroup(textTranslation);
    textTranslationGroup.addChild(textObject);
    tran.addChild(textTranslationGroup);
    }
    public void aviso(String mensaje){	
	textObject.setString(mensaje) ;
    }
    public void addObjects1(String mensaje) {
		Font3D f3d = new Font3D(new Font("TestFont", Font.PLAIN, 2),
				new FontExtrusion());
		Text3D text = new Text3D(f3d, new String(mensaje), new Point3f(0f,0f,0f));	 
		text.setString(mensaje);
		Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
		Color3f blue = new Color3f(.2f, 0.2f, 0.6f);
		Appearance a = new Appearance();
		Material m = new Material(blue, blue, blue, white, 80.0f);
		m.setLightingEnable(true);
		a.setMaterial(m);

		Shape3D sh = new Shape3D();
		sh.setGeometry(text);
		sh.setAppearance(a);
		TransformGroup tg = new TransformGroup();
		Transform3D t3d = new Transform3D();
		Transform3D tDown = new Transform3D();
		Transform3D rot = new Transform3D();
		Vector3f v3f = new Vector3f(0.0f, 0.0f, 0.0f);
                //Vector3f v3f = new Vector3f(x-0.085f,y-0.33f,z);
		t3d.setTranslation(v3f);
		rot.rotX(Math.PI *0.0f);
		t3d.mul(rot);
		v3f = new Vector3f(0, 0f, 0f);
		tDown.setTranslation(v3f);
		t3d.mul(tDown);
		tg.setTransform(t3d);
		tg.addChild(sh);
		tran.addChild(tg);
		
	}
    public void changeTextureCab(Texture texture, String image) {
        loader = new TextureLoader(image, "RGB",frame1);
    	texture = loader.getTexture();
	texture.setBoundaryModeS(Texture.CLAMP_TO_BOUNDARY);
	texture.setBoundaryModeT(Texture.CLAMP_TO_BOUNDARY);
	texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.5f, 0f));
	TextureAttributes texAttr = new TextureAttributes();
	texAttr.setTextureMode(TextureAttributes.REPLACE);
	ap.setTextureAttributes(texAttr);
	ap.setTexture(texture);
    }
}
