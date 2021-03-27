package io.shapez.core;

import io.shapez.game.Component;
import io.shapez.game.Entity;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Consumer;

public class StaleAreaDetector {
    private final String name;
    private final Consumer<Rectangle> recomputeMethod;
    Rectangle staleArea = null;

    public StaleAreaDetector(String name, Consumer<Rectangle> recomputeMethod) {
        this.name = name;
        this.recomputeMethod = recomputeMethod;
    }

    public void recomputeOnComponentsChanged(Component[] components, int tilesAround) {
        Object[] componentIds = Arrays.stream(components).map(Component::getId).toArray();

        Entity checker = new Entity();
        for (Object componentId : componentIds) {
            if (checker.components.get((String) componentId)) {
//                Rectangle area = checker.components.StaticMapEntity.getTileSpaceBounds().expandedInAllDirections(tilesAround);
//                this.invalidate(area);
                return;
            }
        }
    }

    private void invalidate(Rectangle area) {
        if (this.staleArea != null) {
            this.staleArea = this.staleArea.union(area);
        } else {
            this.staleArea = area;
        }
    }
}