package am.ik.codepoints;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CodePointsHolder {
    private static final ConcurrentMap<Class<? extends CodePoints>, CodePoints> map = new ConcurrentHashMap<>();

    public static CodePoints get(Class<? extends CodePoints> clazz) {
        if (map.containsKey(clazz)) {
            return map.get(clazz);
        }
        try {
            CodePoints codePoints = clazz.newInstance();
            map.put(clazz, codePoints);
            return codePoints;
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("exception occurred while initializing", e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("default constructor not found", e);
        }
    }
}
