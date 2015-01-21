package am.ik.codepoints;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public interface CodePoints {
    boolean containsAll(String s);

    public static class Wrapper implements CodePoints {
        private final Set<Integer> set;

        protected Wrapper(Integer... codePoints) {
            Set<Integer> set = new HashSet<>(codePoints.length);
            for (Integer codePoint : codePoints) {
                set.add(codePoint);
            }
            this.set = Collections.unmodifiableSet(set);
        }

        @Override
        public boolean containsAll(String s) {
            if (s == null) {
                return false;
            }
            // http://www.ibm.com/developerworks/jp/ysl/library/java/j-unicode_surrogate/
            int len = s.length();
            for (int i = 0; i < len; i = s.offsetByCodePoints(i, 1)) {
                Integer codePoint = s.codePointAt(i);
                if (!set.contains(codePoint)) {
                    return false;
                }
            }
            return true;
        }
    }
}
