package cn.nevertiree.business.order;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lance on 17-1-23.
 */
@Scope("prototype")
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    // TODO: 17-1-23 订单生成

}
