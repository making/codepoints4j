package am.ik.codepoints.collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import am.ik.codepoints.CodePoints;
import am.ik.codepoints.CodePointsHolder;

public class HiraganaLetter_JISX0208CodePointsTest {

    @Test
    public void testContainsAll_AllFullWidthHiragana() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);
        assertThat(cp.containsAll("あいうえおかきくけこ"), is(true));
    }

    @Test
    public void testContainsAll_FullWidthHiraganaAndFullWidthKatakana() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);
        assertThat(cp.containsAll("あいうえおカキクケコ"), is(false));
    }

    @Test
    public void testContainsAll_FullWidthHiraganaWhole() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);
        for (int i = 0x3041; i <= 0x3093; i++) {
            String s = new String(new int[] { i }, 0, 1);
            assertThat(s + " -> NG", cp.containsAll(s), is(true));
        }
    }

    @Test
    public void testContainsAll_BoundariesOtherThaFullWidthHiragana() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);

        assertThat(cp.containsAll(new String(new int[] { 0x3040 }, 0, 1)),
                is(false));
        assertThat(cp.containsAll(new String(new int[] { 0x3094 }, 0, 1)),
                is(false));

    }

    @Test
    public void testContainsAny_AllFullWidthHiragana() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);
        System.out.println(cp);
        assertThat(cp.containsAny("あいうえおかきくけこ"), is(true));
    }

    @Test
    public void testContainsAny_AllFullWidthKatakana() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);
        assertThat(cp.containsAny("アイウエオカキクケコ"), is(false));
    }

    @Test
    public void testContainsAny_FullWidthHiraganaAndFullWidthKatakana() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);
        assertThat(cp.containsAny("あいうえおカキクケコ"), is(true));
    }

    @Test
    public void testContainsAny_FullWidthHiraganaWhole() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);
        for (int i = 0x3041; i <= 0x3093; i++) {
            String s = new String(new int[] { i }, 0, 1);
            assertThat(cp.containsAny(s), is(true));
        }
    }

    @Test
    public void testContainsAny_BoundariesOtherThanFullWidthHiragana() throws Exception {
        CodePoints cp = CodePointsHolder.get(HiraganaLetter_JISX0208CodePoints.class);

        assertThat(cp.containsAny(new String(new int[] { 0x3040 }, 0, 1)),
                is(false));
        assertThat(cp.containsAny(new String(new int[] { 0x3094 }, 0, 1)),
                is(false));

    }
}
