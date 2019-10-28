package practica3;

import org.jogamp.java3d.utils.geometry.*;

import org.jogamp.java3d.utils.geometry.Primitive;
import org.jogamp.java3d.utils.image.TextureLoader;
import org.jogamp.java3d.utils.universe.SimpleUniverse;
import java.awt.GraphicsConfiguration;
import org.jdesktopmedia.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.vecmath.Vector3f;

public class SistemaSolar {

    public SistemaSolar() {
        BranchGroup group = new BranchGroup();
        Appearance solAppearance = new Appearance();
        Appearance earthAppearance = new Appearance();
        Appearance appearence1 = new Appearance();
        Appearance appearance2 = new Appearance();

        TextureLoader tex = new TextureLoader("TIERRA.JPG", null);
        solAppearance.setTexture(tex.getTexture());
        tex = new TextureLoader("SOL.JPG", null);
        earthAppearance.setTexture(tex.getTexture());
        tex = new TextureLoader("JUPITER.JPEG", null);
        appearence1.setTexture(tex.getTexture());
        tex = new TextureLoader("SATURNO.JPEG", null);
        appearance2.setTexture(tex.getTexture());

        Sphere earth = new Sphere(0.035f, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 32, solAppearance);
        Sphere sol = new Sphere(0.25f, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 32, earthAppearance);
        Sphere planeta1 = new Sphere(0.0435f, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 32, appearence1);
        Sphere planeta2 = new Sphere(0.035f, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 32, appearance2);

        TransformGroup earthRotXformGroup = MovimientosEje.rotar(earth, new Alpha(-1, 1050));
        TransformGroup mercurioRotXformGroup = MovimientosEje.rotar(planeta1, new Alpha(-1, 850));
        TransformGroup venusRotXformGroup = MovimientosEje.rotar(planeta2, new Alpha(-1, 950));
        TransformGroup solRotXformGroup = MovimientosEje.rotar(sol, new Alpha(-1, 600));

        TransformGroup earthTransXformGroup = MovimientosEje.transladar(earthRotXformGroup,
                new Vector3f(0.0f, 0.0f, 0.4f));
        TransformGroup mercurioTransXformGroup = MovimientosEje.transladar(mercurioRotXformGroup,
                new Vector3f(0.3f, 0.2f, 0.8f));
        TransformGroup venusTransXformGroup = MovimientosEje.transladar(venusRotXformGroup,
                new Vector3f(0.8f, 0.1f, 1.2f));

        TransformGroup earthRotGroupXformGroup = MovimientosEje.rotar(earthTransXformGroup, new Alpha(-1, 5000));
        TransformGroup mercurioRotGroupXformGroup = MovimientosEje.rotar(mercurioTransXformGroup, new Alpha(-1, 5000));
        TransformGroup venusRotGroupXformGroup = MovimientosEje.rotar(venusTransXformGroup, new Alpha(-1, 5000));

        group.addChild(earthRotGroupXformGroup);
        group.addChild(mercurioRotGroupXformGroup);
        group.addChild(venusRotGroupXformGroup);
        group.addChild(solRotXformGroup);
        
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        canvas.setSize(400, 400);
        SimpleUniverse universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(group);
        JFrame f = new JFrame("Planetario");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(canvas);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String a[]) {
        SistemaSolar sistemaSolar = new SistemaSolar();
    }

}
