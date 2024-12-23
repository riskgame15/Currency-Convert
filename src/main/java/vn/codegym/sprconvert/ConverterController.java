package vn.codegym.sprconvert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;

@Controller
public class ConverterController {

    @RequestMapping("/converter")
    public ModelAndView convert(@ModelAttribute("usd") String usd) {    // All from form are strings!
        final int rate = 25000;
        int usdInt;
        if (usd == null || usd.isEmpty()) {
            usdInt = 0;
        } else {
            usdInt = Integer.parseInt(usd);
        }
        ModelAndView mv = new ModelAndView("index");
        long value = (long) usdInt * rate;
        DecimalFormat formatter = new DecimalFormat("#,###");
        mv.addObject("value", formatter.format(value));
        mv.addObject("usd", usd);
        return mv;
    }
}
