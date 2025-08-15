package DesignPattern.FlyweightDesignPattern.TextEditor;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private Map<Character, CharacterFlyweight> flyweights = new HashMap<>();

    public CharacterFlyweight getCharacter(char c) {
        if (!flyweights.containsKey(c)) {
            flyweights.put(c, new CharacterImpl(c));
        }
        return flyweights.get(c);
    }
}
