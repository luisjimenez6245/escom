/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Level extends Model {

    public int levelId;
    public boolean isActive;
    public boolean isPrincipal;
    public boolean isValid;
    public int number;
    public String name;

    public Level(int levelId) {
        this.levelId = levelId;
    }

    public Level build(boolean isActive, boolean isPrincipal, boolean isValid, int number, String name) {
        this.isActive = isActive;
        this.isPrincipal = isPrincipal;
        this.isValid = isValid;
        this.number = number;
        this.name = name;
        return this;
    }

}
