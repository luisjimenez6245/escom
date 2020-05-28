package repositories;

import objects.Parametrics;

/**
 *
 * @author luis
 */
public interface repositoryConsole {

    public String test(String exec);

    public String get3d(Parametrics param, String name);

    public String get2d(Parametrics param, String name);

    public String getSurface(Parametrics param, String name);

    public void get3dAsync(Parametrics param, String name);

    public void get2dAsync(Parametrics param, String name);

    public void getSurfaceAsync(Parametrics param, String name);

}
