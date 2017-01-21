package cn.nevertiree.common;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lance on 17-1-21.
 */
public class RegexUtilTest {

    @Test
    public void correctEmail() throws Exception {
        // right
        assertEquals(true,RegexUtil.correctEmail("nevertiree@wlx.com"));
        assertEquals(true,RegexUtil.correctEmail("nevertiree@bjfu.edu.cn"));
        assertEquals(true,RegexUtil.correctEmail("lance.wang@wlx.com"));
        assertEquals(true,RegexUtil.correctEmail("lance.wang@bjfu.edu.cn"));
        //false
        assertEquals(false,RegexUtil.correctEmail("@bjfu.edu.cn"));
        assertEquals(false,RegexUtil.correctEmail("lance.wang@"));
        assertEquals(false,RegexUtil.correctEmail("lance.wang.bjfu.edu.cn"));

    }


    @Test
    public void correctMobile() throws Exception {
        // right
        assertEquals(true,RegexUtil.correctMobile("18912345678"));
        // wrong
        assertEquals(false,RegexUtil.correctMobile(""));
        assertEquals(false,RegexUtil.correctMobile("1891234567"));
        assertEquals(false,RegexUtil.correctMobile("189123456789"));
        assertEquals(false,RegexUtil.correctMobile("189123456789"));
        assertEquals(false,RegexUtil.correctMobile("abc"));
        assertEquals(false,RegexUtil.correctMobile("010"));
        assertEquals(false,RegexUtil.correctMobile("asdffda"));

    }

}