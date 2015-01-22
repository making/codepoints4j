package am.ik.codepoints.collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import am.ik.codepoints.CodePoints;
import am.ik.codepoints.CodePointsHolder;

public class FullWidthHiraganaCodePointsTest {

    @Test
    public void testContainsAll_AllFullWidthHiragana() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);
        assertThat(cp.containsAll("あいうえおかきくけこ"), is(true));
    }

    @Test
    public void testContainsAll_FullWidthHiraganaAndFullWidthKatakana() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);
        assertThat(cp.containsAll("あいうえおカキクケコ"), is(false));
    }

    @Test
    public void testContainsAll_FullWidthHiraganaWhole() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);
        for (int i = 0x3041; i <= 0x3093; i++) {
            String s = new String(new int[] { i }, 0, 1);
            assertThat(s + " -> NG", cp.containsAll(s), is(true));
        }
    }

    @Test
    public void testContainsAll_BoundariesOtherThaFullWidthHiragana() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);

        assertThat(cp.containsAll(new String(new int[] { 0x3040 }, 0, 1)),
                is(false));
        assertThat(cp.containsAll(new String(new int[] { 0x3094 }, 0, 1)),
                is(false));

    }

    @Test
    public void testContainsAny_AllFullWidthHiragana() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);
        System.out.println(cp);
        assertThat(cp.containsAny("あいうえおかきくけこ"), is(true));
    }

    @Test
    public void testContainsAny_AllFullWidthKatakana() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);
        assertThat(cp.containsAny("アイウエオカキクケコ"), is(false));
    }

    @Test
    public void testContainsAny_FullWidthHiraganaAndFullWidthKatakana() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);
        assertThat(cp.containsAny("あいうえおカキクケコ"), is(true));

        System.out.println(new String(new int[] {0x3093}, 0, 1));
        System.out.println(new String(new int[] {0x3094}, 0, 1));
        System.out.println(new String(new int[] {0x3095}, 0, 1));
        System.out.println(new String(new int[] {0x3096}, 0, 1));
        System.out.println(new String(new int[] {0x3097}, 0, 1));
        System.out.println(new String(new int[] {0x3098}, 0, 1));
        System.out.println(new String(new int[] {0x3099}, 0, 1));
        System.out.println(new String(new int[] {0x3100}, 0, 1));
        System.out.println(new String(new int[] {0x3101}, 0, 1));
        System.out.println(new String(new int[] {0x3102}, 0, 1));
        System.out.println(new String(new int[] {0x3103}, 0, 1));
        System.out.println(new String(new int[] {0x3104}, 0, 1));
        System.out.println(new String(new int[] {0x3105}, 0, 1));
        System.out.println(new String(new int[] {0x3106}, 0, 1));
    }

    @Test
    public void testContainsAny_FullWidthHiraganaWhole() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);
        for (int i = 0x3041; i <= 0x3093; i++) {
            String s = new String(new int[] { i }, 0, 1);
            assertThat(cp.containsAny(s), is(true));
        }
    }

    @Test
    public void testContainsAny_BoundariesOtherThanFullWidthHiragana() throws Exception {
        CodePoints cp = CodePointsHolder.get(FullWidthHiraganaCodePoints.class);

        assertThat(cp.containsAny(new String(new int[] { 0x3040 }, 0, 1)),
                is(false));
        assertThat(cp.containsAny(new String(new int[] { 0x3094 }, 0, 1)),
                is(false));

    }
}
