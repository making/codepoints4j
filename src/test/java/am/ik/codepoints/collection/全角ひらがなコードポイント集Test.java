package am.ik.codepoints.collection;

import am.ik.codepoints.CodePoints;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class 全角ひらがなコードポイント集Test {
    CodePoints cp = new 全角ひらがなコードポイント集();

    @Test
    public void testSet_全部全角ひらがな() throws Exception {
        assertThat(cp.containsAll("あいうえおかきくけこ"), is(true));
    }

    @Test
    public void testSet_全角ひらがなと全角カタカナ() throws Exception {
        assertThat(cp.containsAll("あいうえおカキクケコ"), is(false));
    }
}