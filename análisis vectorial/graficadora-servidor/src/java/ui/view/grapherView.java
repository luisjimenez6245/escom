package ui.view;

/**
 *
 * @author luis
 */

public interface grapherView  extends iView{
    
    public void showRes(String res,  String name);
    
    public void on3dGraph();
    
    public void on2dGraph();
    
    
    public void onSurfaceGraph();
    
    public void showError(String res);
    
}
