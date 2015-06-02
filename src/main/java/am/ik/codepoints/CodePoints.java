package am.ik.codepoints;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public interface CodePoints {
    boolean containsAll(String s);

    boolean containsAny(String s);

    CodePoints union(CodePoints codePoints);

    CodePoints subtract(CodePoints codePoints);

    CodePoints intersect(CodePoints codePoints);

    Set<Integer> getSet();

    public static class Wrapper implements CodePoints {
        private final Set<Integer> set;

        public Wrapper(Integer... codePoints) {
            this.set = new HashSet<>(codePoints.length);
            for (Integer codePoint : codePoints) {
                set.add(codePoint);
            }
        }

        public Wrapper(Collection<Integer> codePoints) {
            this.set = new HashSet<>();
            this.set.addAll(codePoints);
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

        @Override
        public boolean containsAny(String s) {
            if (s == null) {
                return false;
            }
            // http://www.ibm.com/developerworks/jp/ysl/library/java/j-unicode_surrogate/
            int len = s.length();
            for (int i = 0; i < len; i = s.offsetByCodePoints(i, 1)) {
                Integer codePoint = s.codePointAt(i);
                if (set.contains(codePoint)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public CodePoints union(CodePoints codePoints) {
            Set<Integer> set = new HashSet<>(this.set);
            set.addAll(codePoints.getSet());
            return new Wrapper(set);
        }

        @Override
        public CodePoints subtract(CodePoints codePoints) {
            Set<Integer> set = new HashSet<>(this.set);
            set.removeAll(codePoints.getSet());
            return new Wrapper(set);
        }

        @Override
        public CodePoints intersect(CodePoints codePoints) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> target = codePoints.getSet();
            for (Integer s : this.set) {
                if (target.contains(s)) {
                    set.add(s);
                }
            }
            return new Wrapper(set);
        }

        @Override
        public Set<Integer> getSet() {
            return Collections.unmodifiableSet(this.set);
        }
    }
}
