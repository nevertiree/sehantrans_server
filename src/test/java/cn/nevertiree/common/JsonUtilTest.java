package cn.nevertiree.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lance on 17-3-20.
 */
public class JsonUtilTest {
    @Test
    public void toJson() throws Exception {
        List<String> list = new ArrayList<String>();
        String id = "01";
        list.add(id);
        assertEquals("[\"01\"]",JsonUtil.toJson(list));
    }

    @Test
    public void fromJson() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("01");
        assertEquals(list,JsonUtil.fromJson("[\"01\"]","java.util.ArrayList"));
    }

}