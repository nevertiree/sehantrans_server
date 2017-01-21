package cn.nevertiree.common;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lance on 17-1-21.
 */
public class RegexUtilTest {

    @Test
    public void correctEmail() throws Exception {
        // right
        assertEquals(true,RegexUtil.checkEmail("nevertiree@wlx.com"));
        assertEquals(true,RegexUtil.checkEmail("nevertiree@bjfu.edu.cn"));
        assertEquals(true,RegexUtil.checkEmail("lance.wang@wlx.com"));
        assertEquals(true,RegexUtil.checkEmail("lance.wang@bjfu.edu.cn"));
        //false
        assertEquals(false,RegexUtil.checkEmail(""));
        assertEquals(false,RegexUtil.checkEmail("@bjfu.edu.cn"));
        assertEquals(false,RegexUtil.checkEmail("lance.wang@"));
        assertEquals(false,RegexUtil.checkEmail("lance.wang.bjfu.edu.cn"));

    }


    @Test
    public void correctMobile() throws Exception {
        // right
        assertEquals(true,RegexUtil.checkMobile("18912345678"));
        // wrong
        assertEquals(false,RegexUtil.checkMobile(""));
        assertEquals(false,RegexUtil.checkMobile("1891234567"));
        assertEquals(false,RegexUtil.checkMobile("189123456789"));
        assertEquals(false,RegexUtil.checkMobile("189123456789"));
        assertEquals(false,RegexUtil.checkMobile("abc"));
        assertEquals(false,RegexUtil.checkMobile("010"));
        assertEquals(false,RegexUtil.checkMobile("asdffda"));
    }

    @Test
    public void correctPassword() throws Exception {
        // right
        assertEquals(true,RegexUtil.checkPassword("server123"));
        assertEquals(true,RegexUtil.checkPassword("123server"));
        // too short
        assertEquals(false,RegexUtil.checkPassword(""));
        assertEquals(false,RegexUtil.checkPassword("123"));
        // too long
        assertEquals(false,RegexUtil.checkPassword("server123456789123456789"));
        assertEquals(false,RegexUtil.checkPassword("qwerrtyuuiopasdffgjh12349"));
        // not digit
        assertEquals(false,RegexUtil.checkPassword("qwerrtyuh"));
        assertEquals(false,RegexUtil.checkPassword("qwerrti"));
        // not char
        assertEquals(false,RegexUtil.checkPassword("123456"));
        assertEquals(false,RegexUtil.checkPassword("123456789"));
        // have special
        assertEquals(false,RegexUtil.checkPassword("wlx$123456"));
        assertEquals(false,RegexUtil.checkPassword("wlx*123456"));

    }
}