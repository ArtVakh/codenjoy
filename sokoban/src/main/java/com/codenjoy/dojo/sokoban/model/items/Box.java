package com.codenjoy.dojo.sokoban.model.items;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.State;
import com.codenjoy.dojo.sokoban.model.Elements;
import com.codenjoy.dojo.sokoban.model.Field;
import com.codenjoy.dojo.sokoban.model.Player;

/**
 * Boxes to push
 */
public class Box extends PointEnriched<Field> implements State<Elements, Player> {
    private boolean alive;
    private Direction direction;
    private boolean isBlocked;
    private boolean isOnMark;


    public Box(Point xy) {
        super(xy);
        direction = null;
        alive = true;
    }


    @Override
    public void init(Field field) {
        this.field = field;
    }


    public void tick() {

        if (this.field!=null) {
            if (this.field.isMark(x, y)) {
                isOnMark = true;
            } else {
                isOnMark = false;
            }
        }
}


    @Override
    public Elements state(Player player, Object... alsoAtPoint) {
        return Elements.BOX;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isOnMark() {
        return isOnMark;
    }

    public void setOnMark(boolean onMark) {
        isOnMark = onMark;
    }


}
