package am.ik.codepoints.collection;

import am.ik.codepoints.CodePoints;
import am.ik.codepoints.CodePointsHolder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class 全角ひらがなコードポイント集Test {

    @Test
    public void testSet_全部全角ひらがな() throws Exception {
        CodePoints cp = CodePointsHolder.get(全角ひらがなコードポイント集.class);
        assertThat(cp.containsAll("あいうえおかきくけこ"), is(true));
    }

    @Test
    public void testSet_全角ひらがなと全角カタカナ() throws Exception {
        CodePoints cp = CodePointsHolder.get(全角ひらがなコードポイント集.class);
        assertThat(cp.containsAll("あいうえおカキクケコ"), is(false));
    }

    @Test
    public void testSet_全角ひらがな全種() throws Exception {
        CodePoints cp = CodePointsHolder.get(全角ひらがなコードポイント集.class);
        for (int i = 0x3041; i <= 0x3093; i++) {
            String s = new String(new int[]{i}, 0, 1);
            assertThat(cp.containsAll(s), is(true));
        }
    }

    @Test
    public void testSet_全角ひらがな以外の境界() throws Exception {
        CodePoints cp = CodePointsHolder.get(全角ひらがなコードポイント集.class);

        assertThat(cp.containsAll(new String(new int[]{0x3040}, 0, 1)), is(false));
        assertThat(cp.containsAll(new String(new int[]{0x3094}, 0, 1)), is(false));

    }
}