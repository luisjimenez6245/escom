import com.sum.j3d.utils.universe.*;
import com.sum.j3d.utils.geometry.*;
import javax.media.j3d.*;

public class Planetario{
	public Planetario(){
		SimpleUniverse u = new SimpleUniverse();
		BranchGroup group = new BranchGroup();
		group.addChild(new ColorCube(0.3));
		u.getViewingPlattform().setNominalViewing();
		u.transform();
		u.addBranchGroup(group);
	}

	public static void main(String s[]){
		new Planetario();
	}
}