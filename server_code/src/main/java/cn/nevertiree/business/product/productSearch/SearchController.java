package cn.nevertiree.business.product.productSearch;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lance on 8/8/16.
 */
@Scope("prototype")
@Controller
@RequestMapping(value = "/search",method = RequestMethod.GET)
public class SearchController {
}
