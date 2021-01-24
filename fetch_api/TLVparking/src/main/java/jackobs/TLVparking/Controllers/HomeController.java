package jackobs.TLVparking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public static String home() {
        return "views/Main.html";
    }
}
