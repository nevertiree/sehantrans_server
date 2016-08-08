package cn.nevertiree.business.product;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lance on 8/8/16.
 */

@Scope("prototype")
@Controller
@RequestMapping("/product")
public class ProductController {
}
