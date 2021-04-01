package io.shapez.game;

import io.shapez.game.savegame.BasicSerializableObject;

import java.util.ArrayList;
import java.util.HashMap;

public class EntityManager extends BasicSerializableObject {
    private final GameRoot root;
    ArrayList<Entity> entities = new ArrayList<>();
    ArrayList<Entity> destroyList = new ArrayList<>();
    HashMap<String, ArrayList<Entity>> componentToEntity = new HashMap<>();
    int nextUid = 10000;

    public EntityManager(GameRoot root) {
        this.root = root;
    }

    @Override
    protected String getId() {
        return null;
    }
}