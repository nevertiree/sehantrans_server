package cn.nevertiree.business.order;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lance on 8/7/16.
 */

@Scope("prototype")
@Controller
@RequestMapping("/order")
public class OrderController {
}
