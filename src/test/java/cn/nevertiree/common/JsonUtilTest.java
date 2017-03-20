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
        list.add("05daf383cbf59f21acca63110392002411b32736143cf4a795ff5afa4d56b3a");
        list.add("0a8be87e9e6ef0b785dd8f72948460c7c30f90d830289a7240d4d669c6c3059");
        list.add("e198e99554d298c4c8c1e6938c70b835cab488e78313a5ea52dee43629971a0");
        assertEquals("[\"05daf383cbf59f21acca63110392002411b32736143cf4a795ff5afa4d56b3a\",\"0a8be87e9e6ef0b785dd8f72948460c7c30f90d830289a7240d4d669c6c3059\",\"e198e99554d298c4c8c1e6938c70b835cab488e78313a5ea52dee43629971a0\"]",JsonUtil.toJson(list));
    }

    @Test
    public void fromJson() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("05daf383cbf59f21acca63110392002411b32736143cf4a795ff5afa4d56b3a");
        list.add("0a8be87e9e6ef0b785dd8f72948460c7c30f90d830289a7240d4d669c6c3059");
        list.add("e198e99554d298c4c8c1e6938c70b835cab488e78313a5ea52dee43629971a0");
        assertEquals(list,JsonUtil.fromJson("[\"05daf383cbf59f21acca63110392002411b32736143cf4a795ff5afa4d56b3a\",\"0a8be87e9e6ef0b785dd8f72948460c7c30f90d830289a7240d4d669c6c3059\",\"e198e99554d298c4c8c1e6938c70b835cab488e78313a5ea52dee43629971a0\"]","java.util.ArrayList"));
    }

}